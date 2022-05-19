package controlador;

import java_ddbb.DBF;
import java_ddbb.XML;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import Modelo.DetallesEnvio;
import Modelo.Empleados;
import Modelo.Factura;
import Vistas.AltaEmpleadoVista;
import Vistas.BajaEmpleado;
import Vistas.BuscarEnvio;
import Vistas.CancelarEnvioVista;
import Vistas.CrearEnviosVista;
import Vistas.EnvioVista;
import Vistas.Login;
import Vistas.MenuPrincipal;
import Vistas.ModificarEnvio;
import Vistas.PersonalVistas;
import Vistas.TarifasVista;

public class Controlador {
	protected boolean correcto;
	protected DBF bd = new DBF();
	protected XML xml = new XML();




	public void comprobarLogin(String user, String passw) throws SQLException {
		if(bd.comprobarLogin(user, passw)) {
			modXml(1,"usuario","nomUsuario",user);
			menuJefeCajero();
		}else if(bd.comprobarLogin(user, passw)) {
			modXml(1,"usuario","nomUsuario",user);
			menuJefeCajero();
		}else {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña no son correctos vuelva a intentarlo");
			new Login();
		}
	}
	
	public void comprobarCampos(JTextField text, int i, JButton btn) {
		if(text.getText().trim().length() < i) {
			btn.setEnabled(false);
			text.setBorder(new LineBorder(Color.RED));
		}else {
			btn.setEnabled(true);
			text.setBorder(new LineBorder(Color.GREEN));
		}

	}
	
	public void menuJefeCajero() throws SQLException {
		if(bd.sacarDatosEmpleado(buscarElementoXml("usuario", "nomUsuario")).getCargo().equals("00001000")) 
			new MenuPrincipal(true);
		else 
			new MenuPrincipal(false);
	}

	public Factura generarFactura( Float peso, String seguro, String tipo) throws NumberFormatException, SQLException {
		return xml.generarFactura(peso, Integer.parseInt(bd.ultimoCodEnvio()), seguro, tipo);
	}

	public void insertFactura(Factura factura) throws SQLException {
		bd.insertFactura(factura);
	}
	
	public String buscarElementoXml(String nodoPrincipal, String elemento) {
		return xml.buscarElementoXml(nodoPrincipal, elemento);
	}
	
	public void modXml(int id, String nodoPrincipal, String nodoSecun, String mod) {
		xml.modificarElementoXml(id, nodoPrincipal, nodoSecun, mod);
	}

	public void generarXML() throws SAXException, IOException, ParserConfigurationException {
		//		xml.buscarElementoXml();
		//		xml.modificarElementoXml(15,"nomUsuario", "5");
		//		xml.borrarTarifa("1");
		//		xml.crearTarifa("1", "11.82", "0", "1");
			}

	public void insertarEnvioDetalle(DetallesEnvio detalles) throws SQLException {
		bd.insertEnvioDetalle(detalles);
	}
	
	public void buscarEnvio(String codEnvio) throws SQLException {
		var envio = bd.buscarEnvio(codEnvio);
		JOptionPane.showMessageDialog(null, envio);
	}
	
	public boolean modificarBuscarEnvio(String codEnvio) throws SQLException {
		var envio = bd.buscarEnvio(codEnvio);

		if(envio.getCodigoEnvio() != null)
			return true;
		else 
			return false;
	}

	public void modificarEnvioDatos(String codEnvio, String destinatario, String direccion, String codPostal, String tipoEnvio) throws SQLException {
		bd.modificarEnvio(codEnvio, direccion, destinatario, tipoEnvio, codPostal);
	}

	public void cancelarEnvio(String codEnvio) throws SQLException {
		bd.cancelarEnvio(codEnvio);
	}
	
	public void insertEmpleado(Empleados empleado, String passw) throws SQLException {
		bd.insertEmpleado(empleado, passw);
	}
	
	public void bajaEmpleado(String dni) throws SQLException {
		bd.bajaEmpleado(dni);
	}



	//VISTAS
	public void login() {
		new Login();

	}

	public void envioVista() throws IOException{
		new EnvioVista();
	}

	public void crearEnvioVista() {
		new CrearEnviosVista();
	}

	public void modificarEnvioVista() {
		new ModificarEnvio();
	}

	public void cancelarEnvioVista() {
		new CancelarEnvioVista();
	}

	public void vistaMenu(boolean b) {
		new MenuPrincipal(b);
	}

	public void tarifasVistas() {
		new TarifasVista();

	}

	public void personalVistas() {
		new PersonalVistas();
	}

	public void altaEmpleadoVista() {
		new AltaEmpleadoVista();
	}
	
	public void bajaEmpleadoVista() {
		new BajaEmpleado();
	}
	
	public void buscarEnvioVista() {
		new BuscarEnvio();
	}






}
