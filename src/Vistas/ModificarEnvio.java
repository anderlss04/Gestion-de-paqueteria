package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import controlador.Controlador;

import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ModificarEnvio {

	private JFrame frmModificarEnvio;
	private JTextField textFieldCodEnvio;
	private Controlador con = new Controlador();
	private JTextField textFieldDestinatario;
	private JTextField textFieldDestino;
	private JTextField textFieldCodpostal;

	public ModificarEnvio() {
		frmModificarEnvio = new JFrame();
		frmModificarEnvio.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmModificarEnvio.setTitle("JACE");
		frmModificarEnvio.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmModificarEnvio.setBounds(100, 100, 717, 401);
		frmModificarEnvio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificarEnvio.getContentPane().setLayout(null);
		frmModificarEnvio.setVisible(true);
		
		JButton btnBuscarEnvio = new JButton("Buscar");
		JButton btnModificar = new JButton("Modificar");

		JLabel lblModificarEnvio = new JLabel("MODIFICAR ENVIO");
		lblModificarEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarEnvio.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		lblModificarEnvio.setBackground(new Color(102, 0, 0));
		lblModificarEnvio.setBounds(10, 10, 683, 57);
		frmModificarEnvio.getContentPane().add(lblModificarEnvio);

		JLabel lblCodigoEnvio = new JLabel("Codigo Envio:");
		lblCodigoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoEnvio.setBounds(253, 101, 82, 19);
		frmModificarEnvio.getContentPane().add(lblCodigoEnvio);

		JLabel lblDestinatario = new JLabel("Destinatario:");
		lblDestinatario.setEnabled(false);
		lblDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestinatario.setBounds(113, 141, 82, 19);
		frmModificarEnvio.getContentPane().add(lblDestinatario);

		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
		lblCodigoPostal.setEnabled(false);
		lblCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoPostal.setBounds(113, 184, 82, 19);
		frmModificarEnvio.getContentPane().add(lblCodigoPostal);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setEnabled(false);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(351, 141, 82, 19);
		frmModificarEnvio.getContentPane().add(lblDireccion);

		JLabel lblTipoEnvio = new JLabel("Tipo Envio:");
		lblTipoEnvio.setEnabled(false);
		lblTipoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoEnvio.setBounds(351, 189, 82, 19);
		frmModificarEnvio.getContentPane().add(lblTipoEnvio);
		
		JComboBox comboBoxTipoEnvio = new JComboBox();
		comboBoxTipoEnvio.setEnabled(false);
		comboBoxTipoEnvio.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Exprees"}));
		comboBoxTipoEnvio.setToolTipText("");
		comboBoxTipoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxTipoEnvio.setBackground(SystemColor.info);
		comboBoxTipoEnvio.setBounds(443, 189, 96, 19);
		frmModificarEnvio.getContentPane().add(comboBoxTipoEnvio);

		textFieldCodEnvio = new JTextField();
		textFieldCodEnvio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if(!numeros || textFieldCodEnvio.getText().trim().length() == 8)
					e.consume();
				
				con.comprobarCampos(textFieldCodEnvio, 7, btnBuscarEnvio);
			}
		});

		textFieldCodEnvio.setColumns(10);
		textFieldCodEnvio.setBackground(SystemColor.info);
		textFieldCodEnvio.setBounds(345, 101, 96, 19);
		frmModificarEnvio.getContentPane().add(textFieldCodEnvio);

		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.modificarEnvioDatos(textFieldCodEnvio.getText(), textFieldDestinatario.getText(), textFieldDestino.getText(), textFieldCodpostal.getText(), (String) comboBoxTipoEnvio.getSelectedItem());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setBackground(new Color(255, 250, 205));
		btnModificar.setBounds(432, 268, 107, 21);
		frmModificarEnvio.getContentPane().add(btnModificar);

		btnBuscarEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(con.modificarBuscarEnvio(textFieldCodEnvio.getText())) {
						textFieldCodEnvio.setEnabled(false);
						btnBuscarEnvio.setEnabled(false);
						lblCodigoEnvio.setEnabled(false);
						textFieldDestinatario.setEnabled(true);
						lblDestinatario.setEnabled(true);
						lblCodigoPostal.setEnabled(true);
						lblDireccion.setEnabled(true);
						lblTipoEnvio.setEnabled(true);
						textFieldDestino.setEnabled(true);
						textFieldCodpostal.setEnabled(true);
						comboBoxTipoEnvio.setEnabled(true);
						btnModificar.setEnabled(true);
					}else
						JOptionPane.showMessageDialog(null, "El envio ha modificar no existe");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnBuscarEnvio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarEnvio.setBackground(new Color(255, 250, 205));
		btnBuscarEnvio.setBounds(188, 268, 85, 21);
		frmModificarEnvio.getContentPane().add(btnBuscarEnvio);

		textFieldDestinatario = new JTextField();
		textFieldDestinatario.setEnabled(false);
		textFieldDestinatario.setColumns(10);
		textFieldDestinatario.setBackground(SystemColor.info);
		textFieldDestinatario.setBounds(205, 141, 96, 19);
		frmModificarEnvio.getContentPane().add(textFieldDestinatario);

		textFieldDestino = new JTextField();
		textFieldDestino.setEnabled(false);
		textFieldDestino.setColumns(10);
		textFieldDestino.setBackground(SystemColor.info);
		textFieldDestino.setBounds(443, 141, 96, 19);
		frmModificarEnvio.getContentPane().add(textFieldDestino);

		textFieldCodpostal = new JTextField();
		textFieldCodpostal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if (!numeros || textFieldCodpostal.getText().trim().length() >= 5 )
					e.consume();
				
				con.comprobarCampos(textFieldCodpostal, 4, btnModificar);
			}
		});
		textFieldCodpostal.setColumns(10);
		textFieldCodpostal.setBackground(SystemColor.info);
		textFieldCodpostal.setBounds(205, 184, 96, 19);
		frmModificarEnvio.getContentPane().add(textFieldCodpostal);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.envioVista();
					frmModificarEnvio.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setBackground(new Color(255, 250, 205));
		btnAtras.setBounds(311, 268, 85, 21);
		frmModificarEnvio.getContentPane().add(btnAtras);

	}
}
