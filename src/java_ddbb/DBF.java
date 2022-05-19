package java_ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import Modelo.DetallesEnvio;
import Modelo.Empleados;
import Modelo.Factura;
import controlador.Controlador;
import controlador.Programa;

public class DBF {
	//	private Controlador con;
	private static DBF instance;
	private String url="jdbc:oracle:thin:@192.168.100.196:49161:xe";
	private Connection konexioa;
	private Statement statement;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public String user, passw;

	//	public String user = "33504173K";

	/* gestion de multi instancias*/
	public static DBF instance()
	{
		if (instance == null)
			instance = new DBF();    
		return instance;
	}

	//METODOS

	/**
	 * Inserta una nueva fila en la base de datos.
	 */
	public void insertEnvioDetalle(DetallesEnvio datos) throws SQLException {
		var con = new Controlador();
		konexioa = DriverManager.getConnection(url, "jace", "jace123");
		statement = konexioa.createStatement();
		var empleado = sacarDatosEmpleado(con.buscarElementoXml("usuario", "nomUsuario"));
		String cod = ultimoCodEnvio();

		var stmtEnvio = konexioa.prepareStatement
			("INSERT INTO ENVIO_PAQUETE (COD_ENVIO, TIPO_ENVIO, DNI_EMPLEADO, ID_TERMINAL, COD_SEGURO, DNI_CLIENTE) VALUES (?,?,?,?,?,?)");

		stmtEnvio.setString(1, cod);
		stmtEnvio.setString(2, datos.getTipoEnvio());
		stmtEnvio.setString(3, empleado.getDni());
		stmtEnvio.setString(4, empleado.getTerminal());
		stmtEnvio.setString(5, datos.getCodigoSeguro());
		stmtEnvio.setString(6, datos.getDniCliente());
		stmtEnvio.executeUpdate();

		var stmtDetalle = konexioa.prepareStatement
			("INSERT INTO DETALLES_ENVIO (COD_ENVIO, FECHA_ENVIO, FECHA_ENTREGA, ORIGEN, DESTINO, ESTADO, NUM_BULTOS, PESO, DESTINATARIO, COD_POSTAL) VALUES (?,?,?,?,?,?,?,?,?,?)");

		stmtDetalle.setString(1, cod);
		stmtDetalle.setString(2, datos.getFechaEnvio());
		stmtDetalle.setString(3, datos.getFechaEntrega());
		stmtDetalle.setString(4, empleado.getTerminal());
		stmtDetalle.setString(5, datos.getDestino());
		stmtDetalle.setString(6, datos.getEstado());
		stmtDetalle.setInt(7, datos.getNumBultos());
		stmtDetalle.setFloat(8, datos.getPeso());
		stmtDetalle.setString(9, datos.getDestinatario());
		stmtDetalle.setString(10, datos.getCodPostal());
		stmtDetalle.executeUpdate();


		konexioa.close();
		statement.close();
		JOptionPane.showMessageDialog(null, "Envio creado correctamente");
	}


	/**
	 * Modifica los datos de un paquete que añn no ha sido enviado
	 */
	public void modificarEnvio(String codEnvio, String direccion, String destinatario, String tipoEnvio, String codPostal) throws SQLException {
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		ResultSet resultSet = null;
		String query;

		query = "SELECT ESTADO FROM DETALLES_ENVIO WHERE COD_ENVIO = '"+codEnvio+"'";
		resultSet = statement.executeQuery(query);
		resultSet.next();

		if(resultSet.getString(1).equalsIgnoreCase("Stand By")) {
			query = "UPDATE DETALLES_ENVIO SET DESTINO ='"+direccion+"' ,DESTINATARIO ='"+destinatario+"' ,COD_POSTAL ='"+codPostal+"'  "
					+ "WHERE COD_ENVIO = '"+codEnvio+"'";
			
			statement.executeQuery(query);

			query = "UPDATE ENVIO_PAQUETE SET TIPO_ENVIO ='"+tipoEnvio+"'  WHERE COD_ENVIO = '"+codEnvio+"'";
			statement.executeQuery(query);

			JOptionPane.showMessageDialog(null, "El envio fue modificado satisfactoriamente");
		}else
			JOptionPane.showMessageDialog(null, "No se puede modificar el envio porque ya ha sido enviado");


		konexioa.close();
		statement.close();
	}



	/**
	 * Comprueba si el envio ha sido entregado o cancelado, y si no es asi, lo cancela
	 */
	public void cancelarEnvio(String codEnvio) throws SQLException {
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		ResultSet resultSet = null;
		String query;

		query = "SELECT ESTADO FROM DETALLES_ENVIO WHERE COD_ENVIO = '"+codEnvio+"'";
		resultSet = statement.executeQuery(query);
		resultSet.next();

		if(resultSet.getString(1).equalsIgnoreCase("Entregado") || resultSet.getString(1).equalsIgnoreCase("Cancelado")) 
			JOptionPane.showMessageDialog(null, "No se puede cancelar el envio porque ya ha sido entregado o cancelado");
		else {
			query = "UPDATE DETALLES_ENVIO SET ESTADO = 'Cancelado' WHERE COD_ENVIO = '"+codEnvio+"'";
			statement.executeQuery(query);
			JOptionPane.showMessageDialog(null, "El envio fue cancelado satisfactoriamente");
		}



		konexioa.close();
		statement.close();
	}



	/**
	 * Busca un paquete y sus detalles en la base de datos.
	 */
	public void buscarDetalleEnvio(String codEnvio) throws SQLException {
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		String query;

		query = "SELECT * FROM ENVIO_PAQUETE WHERE COD_ENVIO = '"+codEnvio+"'";
		resultSet1 = statement.executeQuery(query);
		query = "SELECT * FROM DETALLES_ENVIO WHERE COD_ENVIO = '"+codEnvio+"'";
		resultSet2 = statement.executeQuery(query);

		konexioa.close();
		statement.close();
	}


/**
 * Comprueba si el usuario y la contraseña estan en la base de datos.
 */
	public boolean comprobarLogin(String user, String passw) throws SQLException  {
		try {
		konexioa = DriverManager.getConnection(url, "D"+user, passw);
		statement = konexioa.createStatement();
		}catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		this.user = user;
		this.passw = passw;

		konexioa.close();
		statement.close();
		return true;
	}

	/**
	 * Toma como parametro un DNI y devuelve un objeto de tipo Empleados con los datos del empleado con
	 * ese DNI
	 */
	public Empleados sacarDatosEmpleado(String dni) throws SQLException {
		String query="SELECT * FROM EMPLEADO WHERE DNI = '"+dni+"'";
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		ResultSet resultSet = null;
		String valores[] = new String[11];


		resultSet = statement.executeQuery(query);
		var rsmd = resultSet.getMetaData();

		while(resultSet.next()) {
			for(int i =1; i <= rsmd.getColumnCount(); i++) 
				valores[i-1] = resultSet.getString(i);

		}

		konexioa.close();
		statement.close();

		return new Empleados(valores[1], valores[2], valores[6], valores[9], valores[0], valores[4], valores[3], valores[10], valores[8], valores[7]);
	}

	/**
	 * Devuelve el ultimo codigo de la tabla ENVIO_PAQUETE, y le suma 1
	 */
	public String ultimoCodEnvio() throws SQLException {
		String query = "SELECT COD_ENVIO FROM ENVIO_PAQUETE ORDER BY COD_ENVIO ASC";
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		ResultSet resultSet = null;
		int cod=0;

		resultSet = statement.executeQuery(query);

		while(resultSet.next()) 
			cod = resultSet.getInt(1);

		return (cod+1) +"" ;	
	}


	
	public DetallesEnvio buscarEnvio(String codEnvio) throws SQLException {
		String query2 = "SELECT * FROM DETALLES_ENVIO WHERE COD_ENVIO = '"+codEnvio+"'";
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		
		ResultSet resultSet2 = null;

		
		resultSet2 = statement.executeQuery(query2);
		var rsmd = resultSet2.getMetaData();
		float peso = 0;

		String val[] = new String[20];

		while(resultSet2.next()) {
			for(int i =1; i <= rsmd.getColumnCount(); i++) 
				val[i-1] = resultSet2.getString(i);
			peso = resultSet2.getFloat(8);
		}

		konexioa.close();
		statement.close();
		return new DetallesEnvio(null, null, val[0], null, null, val[3], val[5], Integer.parseInt(val[6]),peso, val[4], null, val[8], val[3], val[1], val[2]);
	}

	public void insertFactura(Factura factura) throws SQLException {
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();

		var stmtFactura = konexioa.prepareStatement("INSERT INTO FACTURA (NUM_FACTURA, COD_ENVIO, FECHA_EMISION, METODo_PAGO, PRECIO) VALUES (?,?,?,?,?)");

		stmtFactura.setString(1, factura.getNum_factura());
		stmtFactura.setString(2, factura.getCod_envio());
		stmtFactura.setString(3, dtf.format(LocalDateTime.now()));
		stmtFactura.setString(4, null);
		stmtFactura.setFloat(5, factura.getPrecio());
		stmtFactura.executeUpdate();

		konexioa.close();
		statement.close();
	}

	public void insertEmpleado(Empleados empleado, String passw) throws SQLException {
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		String query1 = "CREATE USER D"+empleado.getDni()+" IDENTIFIED BY "+passw+
				" DEFAULT TABLESPACE ADMINISTRADOR TEMPORARY tablespace TEMP";
		String query11 = "GRANT ADMINISTRADOR TO D"+empleado.getDni();
		String query2 = "CREATE USER D"+empleado.getDni()+" IDENTIFIED BY "+passw
				+" DEFAULT TABLESPACE CAJERO TEMPORARY tablespace TEMP PASSWORD NOTEXPIRE";
		String query22 = "GRANT CAJERO TO D"+empleado.getDni();

		var stmtEmpleado = konexioa.prepareStatement("INSERT INTO EMPLEADO (DNI, NOMBRE, APELLIDOS, DIRECCION, COD_POSTAL, PASSWORD, TELEFONO, ENCARGADO, CARGO, EMAIL, TERMINAL) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

		stmtEmpleado.setString(1, empleado.getDni());
		stmtEmpleado.setString(2, empleado.getNombre());
		stmtEmpleado.setString(3, empleado.getApellido());
		stmtEmpleado.setString(4, empleado.getDireccion());
		stmtEmpleado.setString(5, empleado.getCod_postal());
		stmtEmpleado.setString(6, passw);
		stmtEmpleado.setString(7, empleado.getTelefono());
		stmtEmpleado.setString(8, empleado.getEncargado());
		stmtEmpleado.setString(9, empleado.getCargo());
		stmtEmpleado.setString(10, empleado.getEmail());
		stmtEmpleado.setString(11, empleado.getTerminal());
		stmtEmpleado.executeUpdate();
		
		if(empleado.getCargo().equals("Cajero")) {
			statement.executeQuery(query2);
			statement.executeQuery(query22);
		}else {
			statement.executeQuery(query1);
			statement.executeQuery(query11);
		}
			
		konexioa.close();
		statement.close();
	}

	public void bajaEmpleado(String dni) throws SQLException {
		String query = "DROP USER D"+dni+" CASCADE";
		konexioa = DriverManager.getConnection(url,  "jace", "jace123");
		statement = konexioa.createStatement();
		ResultSet resultSet = null;
		int i = 0;
		boolean correcto = true;

		
		try {
			statement.executeQuery(query);
			}catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "El empleado con DNI -> "+dni+" no existe");
				correcto = false;
			}

		if(correcto)
			JOptionPane.showMessageDialog(null, "El empleado fue dado de baja satisfactoriamente");

		konexioa.close();
		statement.close();
	} 
}