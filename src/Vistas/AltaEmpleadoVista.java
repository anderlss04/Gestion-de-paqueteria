package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import Modelo.Empleados;
import controlador.Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class AltaEmpleadoVista {

	private Controlador con = new Controlador();
	private JFrame frmAltaEmpleado;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombre;
	private JTextField textFieldDni;
	private JTextField textFieldDireccion;
	private JTextField textFieldCodPostal;
	private JTextField textFieldTelefono;
	private JTextField textFieldContraseña;
	private JTextField textFieldEmail;
	private JTextField textFieldEncargado;

	public AltaEmpleadoVista() {
		frmAltaEmpleado = new JFrame();
		frmAltaEmpleado.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmAltaEmpleado.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmAltaEmpleado.setTitle("JACE");
		frmAltaEmpleado.setBounds(100, 100, 665, 550);
		frmAltaEmpleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaEmpleado.setVisible(true);
		frmAltaEmpleado.getContentPane().setLayout(null);
		
		JButton btnAlta = new JButton("Alta");
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(87, 108, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(87, 162, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {	
				int key = e.getKeyChar();
				boolean letras = (key >= 65 && key <= 90) || (key >= 97 && key <= 122);
				
				if(!letras)
					e.consume();
				
				con.comprobarCampos(textFieldApellidos, 1, btnAlta);
			}
		});
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBackground(SystemColor.info);
		textFieldApellidos.setBounds(170, 162, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldApellidos);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {	
				int key = e.getKeyChar();
				boolean letras = (key >= 65 && key <= 90) || (key >= 97 && key <= 122);
				
				if(!letras)
					e.consume();
				
				con.comprobarCampos(textFieldNombre, 1, btnAlta);
			}
		});
		textFieldNombre.setColumns(10);
		textFieldNombre.setBackground(SystemColor.info);
		textFieldNombre.setBounds(170, 108, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldNombre);
		
		textFieldDni = new JTextField();
		textFieldDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				int opcion = -1;
				boolean numeros = key >= 48 && key <= 57;
				boolean letras = key >= 65 && key <= 90;

				if (textFieldDni.getText().trim().length() < 8)
					opcion = 0;
				else if(textFieldDni.getText().trim().length() > 7)
					opcion = 1;

				switch(opcion) {
				case 0:
					if(!numeros)
						e.consume();
					break;
				case 1:
					if(!letras || textFieldDni.getText().trim().length() == 9)
						e.consume();
					break;
				}
				con.comprobarCampos(textFieldDni, 8, btnAlta);
			}
		});
		textFieldDni.setColumns(10);
		textFieldDni.setBackground(SystemColor.info);
		textFieldDni.setBounds(421, 108, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldDni);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				con.comprobarCampos(textFieldDireccion, 4, btnAlta);
			}
		});
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBackground(SystemColor.info);
		textFieldDireccion.setBounds(421, 162, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldDireccion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(338, 162, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblDireccion);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(338, 108, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblDni);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAltaEmpleado.setVisible(false);
				con.personalVistas();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setBackground(new Color(255, 250, 205));
		btnAtras.setBounds(394, 447, 85, 21);
		frmAltaEmpleado.getContentPane().add(btnAtras);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(87, 271, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblCargo);
		
		JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"Gerente", "Cajero"}));
		comboBoxCargo.setToolTipText("");
		comboBoxCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxCargo.setBackground(SystemColor.info);
		comboBoxCargo.setBounds(170, 271, 96, 19);
		frmAltaEmpleado.getContentPane().add(comboBoxCargo);
		
		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoPostal.setBounds(338, 271, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblCodigoPostal);
		
		textFieldCodPostal = new JTextField();
		textFieldCodPostal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if (!numeros || textFieldCodPostal.getText().trim().length() >= 5 )
					e.consume();
				
				con.comprobarCampos(textFieldCodPostal, 4, btnAlta);
			}
		});
		textFieldCodPostal.setColumns(10);
		textFieldCodPostal.setBackground(SystemColor.info);
		textFieldCodPostal.setBounds(421, 271, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldCodPostal);
		
		JLabel lblAltaEmpleado = new JLabel("Alta Empleado");
		lblAltaEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaEmpleado.setForeground(Color.BLACK);
		lblAltaEmpleado.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		lblAltaEmpleado.setBackground(Color.LIGHT_GRAY);
		lblAltaEmpleado.setBounds(10, 10, 631, 57);
		frmAltaEmpleado.getContentPane().add(lblAltaEmpleado);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(87, 217, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if (!numeros || textFieldTelefono.getText().trim().length() >= 8 )
					e.consume();
				
				con.comprobarCampos(textFieldTelefono, 7, btnAlta);
			}
		});
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBackground(SystemColor.info);
		textFieldTelefono.setBounds(170, 217, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldTelefono);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasea.setBounds(338, 217, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblContrasea);
		
		textFieldContraseña = new JPasswordField();
		textFieldContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				con.comprobarCampos(textFieldContraseña, 6, btnAlta);
			}
		});
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBackground(SystemColor.info);
		textFieldContraseña.setBounds(421, 217, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldContraseña);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(87, 327, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(textFieldEmail.getText().indexOf("@") != -1 && textFieldEmail.getText().indexOf(".") != -1) {
					btnAlta.setEnabled(true);
					textFieldEmail.setBorder(new LineBorder(Color.GREEN));
					con.comprobarCampos(textFieldEmail, 9, btnAlta);
				}
				else {
					btnAlta.setEnabled(false);
					textFieldEmail.setBorder(new LineBorder(Color.RED));
				}
			}
		});
		textFieldEmail.setColumns(10);
		textFieldEmail.setBackground(SystemColor.info);
		textFieldEmail.setBounds(170, 327, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldEmail);
		
		JLabel lblTerminal = new JLabel("Terminal:");
		lblTerminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerminal.setBounds(338, 327, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblTerminal);
		
		JLabel lblEncargado = new JLabel("Encargado:");
		lblEncargado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEncargado.setBounds(224, 372, 73, 19);
		frmAltaEmpleado.getContentPane().add(lblEncargado);
		
		textFieldEncargado = new JTextField();
		textFieldEncargado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				int opcion = -1;
				boolean numeros = key >= 48 && key <= 57;
				boolean letras = key >= 65 && key <= 90;

				if (textFieldEncargado.getText().trim().length() < 8)
					opcion = 0;
				else if(textFieldEncargado.getText().trim().length() > 7)
					opcion = 1;

				switch(opcion) {
				case 0:
					if(!numeros)
						e.consume();
					break;
				case 1:
					if(!letras || textFieldEncargado.getText().trim().length() == 9)
						e.consume();
					break;
				}
				con.comprobarCampos(textFieldEncargado, 8, btnAlta);
			}
		});
		textFieldEncargado.setColumns(10);
		textFieldEncargado.setBackground(SystemColor.info);
		textFieldEncargado.setBounds(307, 372, 96, 19);
		frmAltaEmpleado.getContentPane().add(textFieldEncargado);
		
		JComboBox comboBoxCargoTerminal = new JComboBox();
		comboBoxCargoTerminal.setModel(new DefaultComboBoxModel(new String[] {"00110001"}));
		comboBoxCargoTerminal.setToolTipText("");
		comboBoxCargoTerminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxCargoTerminal.setBackground(SystemColor.info);
		comboBoxCargoTerminal.setBounds(421, 327, 96, 19);
		frmAltaEmpleado.getContentPane().add(comboBoxCargoTerminal);
		
		btnAlta.addActionListener(e -> {
				var empleado = new Empleados(textFieldNombre.getText(),
						textFieldApellidos.getText(),
						textFieldTelefono.getText(),
						textFieldEmail.getText(),
						textFieldDni.getText(),
						textFieldCodPostal.getText(),
						textFieldDireccion.getText(),
						(String)comboBoxCargoTerminal.getSelectedItem(),
						codCargo((String)comboBoxCargo.getSelectedItem()),
						textFieldEncargado.getText());
			
			try {
				con.insertEmpleado(empleado, textFieldContraseña.getText());
				frmAltaEmpleado.setVisible(false);
				con.personalVistas();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlta.setBackground(new Color(255, 250, 205));
		btnAlta.setBounds(192, 447, 85, 21);
		frmAltaEmpleado.getContentPane().add(btnAlta);
		
	}
	
	public String codCargo(String cargo) {
		switch(cargo) {
		case "Gerente":
			return "00001000";
		case "Cajero":
			return "00011000";
		}
		return null;
	}
}
