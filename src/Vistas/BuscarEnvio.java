package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.Controlador;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BuscarEnvio {

	private JFrame frmBuscarEnvio;
	private JTextField textField;
	private Controlador con = new Controlador();
	
	
	public BuscarEnvio() {
		frmBuscarEnvio = new JFrame();
		frmBuscarEnvio.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmBuscarEnvio.setTitle("JACE");
		frmBuscarEnvio.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmBuscarEnvio.setBounds(100, 100, 595, 308);
		frmBuscarEnvio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscarEnvio.getContentPane().setLayout(null);
		frmBuscarEnvio.setVisible(true);
		
		JButton btnBuscarEnvio = new JButton("Buscar");
		btnBuscarEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.buscarEnvio(textField.getText());
					frmBuscarEnvio.setVisible(false);
					con.envioVista();
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscarEnvio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarEnvio.setBackground(new Color(255, 250, 205));
		btnBuscarEnvio.setBounds(145, 192, 85, 21);
		frmBuscarEnvio.getContentPane().add(btnBuscarEnvio);
		
		JLabel lblBuscarEnvio = new JLabel("BUSCAR ENVIO");
		lblBuscarEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEnvio.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		lblBuscarEnvio.setBackground(new Color(102, 0, 0));
		lblBuscarEnvio.setBounds(10, 10, 561, 57);
		frmBuscarEnvio.getContentPane().add(lblBuscarEnvio);
		
		JLabel lblCodigoEnvio = new JLabel("Codigo Envio:");
		lblCodigoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoEnvio.setBounds(198, 109, 82, 19);
		frmBuscarEnvio.getContentPane().add(lblCodigoEnvio);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if(!numeros || textField.getText().trim().length() == 8)
					e.consume();
				
				con.comprobarCampos(textField, 7, btnBuscarEnvio);
			}
		});
		textField.setColumns(10);
		textField.setBackground(SystemColor.info);
		textField.setBounds(290, 109, 96, 19);
		frmBuscarEnvio.getContentPane().add(textField);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.envioVista();
					frmBuscarEnvio.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setBackground(new Color(255, 250, 205));
		btnAtras.setBounds(361, 192, 85, 21);
		frmBuscarEnvio.getContentPane().add(btnAtras);
	}

}
