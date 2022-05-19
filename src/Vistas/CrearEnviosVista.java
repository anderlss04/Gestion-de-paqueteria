package Vistas;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Modelo.DetallesEnvio;
import controlador.Controlador;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class CrearEnviosVista {
	private JFrame frmCrearEnvio;
	private Controlador con = new Controlador();
	private JTextField textFieldDniCliente;
	private JTextField textFieldDestinatario;
	private JTextField textFieldDireccion;
	private JTextField textFieldNumBultos;
	private JTextField textFieldPeso;
	private JTextField textFieldCodPostal;
	private JComboBox comboBoxTipoEnvio = new JComboBox();
	private JComboBox comboBoxSeguros = new JComboBox();
	JButton btnEnvio = new JButton("Enviar");
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");



	public CrearEnviosVista() {

		frmCrearEnvio = new JFrame();
		frmCrearEnvio.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCrearEnvio.setTitle("JACE");
		frmCrearEnvio.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmCrearEnvio.setBounds(100, 100, 776, 482);
		frmCrearEnvio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearEnvio.getContentPane().setLayout(null);
		frmCrearEnvio.setVisible(true);

		JLabel lblCrearEnvio = new JLabel("Crear Envio");
		lblCrearEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearEnvio.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		lblCrearEnvio.setBounds(10, 10, 742, 50);
		frmCrearEnvio.getContentPane().add(lblCrearEnvio);

		textFieldDniCliente = new JTextField();
		
		// Verificando la longitud del campo de texto y luego verificando si la tecla presionada es un numero
		// o una letra.
		textFieldDniCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				int opcion = -1;
				boolean numeros = key >= 48 && key <= 57;
				boolean letras = key >= 65 && key <= 90;

				if (textFieldDniCliente.getText().trim().length() < 8)
					opcion = 0;
				else if(textFieldDniCliente.getText().trim().length() > 7)
					opcion = 1;

				switch(opcion) {
				case 0:
					if(!numeros)
						e.consume();
					break;
				case 1:
					if(!letras || textFieldDniCliente.getText().trim().length() == 9)
						e.consume();
					break;
				}
				con.comprobarCampos(textFieldDniCliente, 8, btnEnvio);
				
			}
		});
		textFieldDniCliente.setBackground(SystemColor.info);
		textFieldDniCliente.setBounds(189, 131, 96, 19);
		frmCrearEnvio.getContentPane().add(textFieldDniCliente);
		textFieldDniCliente.setColumns(10);

		textFieldDestinatario = new JTextField();
		textFieldDestinatario.setBackground(SystemColor.info);
		textFieldDestinatario.setBounds(189, 182, 96, 19);
		frmCrearEnvio.getContentPane().add(textFieldDestinatario);
		textFieldDestinatario.setColumns(10);

		textFieldDireccion = new JTextField();
		textFieldDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				con.comprobarCampos(textFieldDireccion, 5, btnEnvio);
			}
		});
		textFieldDireccion.setBackground(SystemColor.info);
		textFieldDireccion.setBounds(515, 131, 96, 19);
		frmCrearEnvio.getContentPane().add(textFieldDireccion);
		textFieldDireccion.setColumns(10);

		JLabel lblNewLabel = new JLabel("DNI Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(106, 131, 73, 19);
		frmCrearEnvio.getContentPane().add(lblNewLabel);

		JLabel lblDestinatario = new JLabel("Destinatario:");
		lblDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestinatario.setBounds(106, 182, 73, 19);
		frmCrearEnvio.getContentPane().add(lblDestinatario);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(432, 131, 73, 19);
		frmCrearEnvio.getContentPane().add(lblDireccion);

		JLabel lblTipoEnvio = new JLabel("Tipo Envio:");
		lblTipoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoEnvio.setBounds(106, 299, 73, 19);
		frmCrearEnvio.getContentPane().add(lblTipoEnvio);

		JLabel lblSeguro = new JLabel("Seguro:");
		lblSeguro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeguro.setBounds(432, 299, 73, 19);
		frmCrearEnvio.getContentPane().add(lblSeguro);

		JLabel lblNumeroDeBultos = new JLabel("N\u00BA Bultos:");
		lblNumeroDeBultos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumeroDeBultos.setBounds(432, 182, 73, 19);
		frmCrearEnvio.getContentPane().add(lblNumeroDeBultos);

		JLabel lblPesokg = new JLabel("Peso(Kg):");
		lblPesokg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPesokg.setBounds(432, 240, 73, 19);
		frmCrearEnvio.getContentPane().add(lblPesokg);

		textFieldNumBultos = new JTextField();
		textFieldNumBultos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if (!numeros || textFieldNumBultos.getText().trim().length() >= 3 )
					e.consume();
			}
		});
		textFieldNumBultos.setBackground(SystemColor.info);
		textFieldNumBultos.setColumns(10);
		textFieldNumBultos.setBounds(515, 182, 96, 19);
		frmCrearEnvio.getContentPane().add(textFieldNumBultos);

		textFieldPeso = new JTextField();
		textFieldPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar(), lugar;
				boolean numeros = (key >= 48 && key <= 57) || key == 46;

				if(textFieldPeso.getText().indexOf(".") == -1)
					lugar = 0;
				else
					lugar = textFieldPeso.getText().indexOf(".");

				if (!numeros || ((textFieldPeso.getText().length() - lugar) == 4) || textFieldPeso.getText().trim().length() >= 6)
					e.consume();

			}
		});
		textFieldPeso.setBackground(SystemColor.info);
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(515, 240, 96, 19);
		frmCrearEnvio.getContentPane().add(textFieldPeso);

		comboBoxSeguros.setToolTipText("");
		comboBoxSeguros.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Basico", "Certificado", "Premium"}));
		comboBoxSeguros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSeguros.setBackground(SystemColor.info);
		comboBoxSeguros.setBounds(515, 299, 96, 19);
		frmCrearEnvio.getContentPane().add(comboBoxSeguros);

		comboBoxTipoEnvio.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Exprees"}));
		comboBoxTipoEnvio.setToolTipText("");
		comboBoxTipoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxTipoEnvio.setBackground(SystemColor.info);
		comboBoxTipoEnvio.setBounds(189, 299, 96, 19);
		frmCrearEnvio.getContentPane().add(comboBoxTipoEnvio);

		JLabel lblCodPostal = new JLabel("Codigo Postal:");
		lblCodPostal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodPostal.setBounds(106, 240, 85, 19);
		frmCrearEnvio.getContentPane().add(lblCodPostal);

		textFieldCodPostal = new JTextField();
		textFieldCodPostal.setColumns(10);
		textFieldCodPostal.setBackground(SystemColor.info);
		textFieldCodPostal.setBounds(189, 240, 96, 19);
		textFieldCodPostal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if (!numeros || textFieldCodPostal.getText().trim().length() >= 5 )
					e.consume();
				
				con.comprobarCampos(textFieldCodPostal, 4, btnEnvio);
			}
		});
		frmCrearEnvio.getContentPane().add(textFieldCodPostal);

		JLabel lblNota = new JLabel("Es obligartorio llenar todos los campos**");
		lblNota.setEnabled(true);
		lblNota.setForeground(Color.RED);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNota.setBounds(80, 70, 333, 19);
		lblNota.setVisible(false);
		frmCrearEnvio.getContentPane().add(lblNota);
		
		btnEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comprobarNull()) {
					var detalles = 
							new DetallesEnvio(codSeguros((String) comboBoxSeguros.getSelectedItem()),
									null,
									null,
									textFieldDniCliente.getText(),
									(String) comboBoxTipoEnvio.getSelectedItem(),
									null,
									"Stand by",
									Integer.parseInt( textFieldNumBultos.getText()),
									Float.parseFloat(textFieldPeso.getText()),
									textFieldDireccion.getText(),
									textFieldCodPostal.getText(),
									textFieldDestinatario.getText(),
									null,
									dtf.format(LocalDateTime.now()),
									null);

					try {
						var factura = con.generarFactura(Float.parseFloat(textFieldPeso.getText()),
								(String) comboBoxSeguros.getSelectedItem(),
								(String) comboBoxTipoEnvio.getSelectedItem());
						con.insertarEnvioDetalle(detalles);
						con.insertFactura(factura);
						con.envioVista();
						frmCrearEnvio.setVisible(false);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else
					lblNota.setVisible(true);

			}
		});
		btnEnvio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnvio.setBackground(new Color(255, 250, 205));
		btnEnvio.setBounds(230, 396, 85, 21);
		frmCrearEnvio.getContentPane().add(btnEnvio);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.envioVista();
					frmCrearEnvio.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setBackground(new Color(255, 250, 205));
		btnAtras.setBounds(432, 396, 85, 21);
		frmCrearEnvio.getContentPane().add(btnAtras);

	}

	public boolean comprobarNull() {
		if(textFieldNumBultos.getText().equals("") ||
				textFieldPeso.getText().equals("") ||
				textFieldDireccion.getText().equals("") ||
				textFieldCodPostal.getText().equals("") ||
				textFieldDestinatario.getText().equals("") ||
				textFieldDniCliente.getText().equals("") ||
				comboBoxTipoEnvio.getActionCommand().equals("") )
			return true;
		else 
			return false;
	}

	public String codSeguros(String name) {
		switch (name) {
		case "Ninguno":
			return "00000001";
		case "Basico":
			return "00000011";
		case "Premium":
			return "00001111";
		case "Certificado":
			return "00000111";
		}

		return "";
	}

}
