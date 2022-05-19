package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import controlador.Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CancelarEnvioVista {

	private Controlador con = new Controlador();
	private JFrame frmCancelarEnvio;
	private JTextField textFieldCodEnvio;
	
	public CancelarEnvioVista() {
		frmCancelarEnvio = new JFrame();
		frmCancelarEnvio.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCancelarEnvio.setTitle("JACE");
		frmCancelarEnvio.setBackground(Color.DARK_GRAY);
		frmCancelarEnvio.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmCancelarEnvio.setBounds(100, 100, 450, 300);
		frmCancelarEnvio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCancelarEnvio.setVisible(true);
		frmCancelarEnvio.getContentPane().setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.envioVista();
					frmCancelarEnvio.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtras.setBackground(new Color(255, 250, 205));
		btnAtras.setBounds(229, 182, 91, 21);
		frmCancelarEnvio.getContentPane().add(btnAtras);
		
		JButton btnCancelarEnvio = new JButton("Cancelar");
		btnCancelarEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.cancelarEnvio(textFieldCodEnvio.getText());
					frmCancelarEnvio.setVisible(false);
					con.envioVista();
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCancelarEnvio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarEnvio.setBackground(new Color(255, 250, 205));
		btnCancelarEnvio.setBounds(106, 182, 91, 21);
		frmCancelarEnvio.getContentPane().add(btnCancelarEnvio);
		
		JLabel lblCodigoEnvio = new JLabel("Codigo Envio:");
		lblCodigoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoEnvio.setBounds(117, 113, 82, 19);
		frmCancelarEnvio.getContentPane().add(lblCodigoEnvio);
		
		textFieldCodEnvio = new JTextField();
		textFieldCodEnvio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				if(!numeros || textFieldCodEnvio.getText().trim().length() == 8)
					e.consume();
				
				con.comprobarCampos(textFieldCodEnvio, 7, btnCancelarEnvio);
			}
		});
		textFieldCodEnvio.setColumns(10);
		textFieldCodEnvio.setBackground(SystemColor.info);
		textFieldCodEnvio.setBounds(209, 113, 96, 19);
		frmCancelarEnvio.getContentPane().add(textFieldCodEnvio);
		
		JLabel lblCancelarEnvio = new JLabel("CANCELAR ENVIO");
		lblCancelarEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelarEnvio.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 36));
		lblCancelarEnvio.setBackground(new Color(102, 0, 0));
		lblCancelarEnvio.setBounds(10, 10, 416, 57);
		frmCancelarEnvio.getContentPane().add(lblCancelarEnvio);
	}

}
