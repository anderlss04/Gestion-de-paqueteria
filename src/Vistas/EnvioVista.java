package Vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import controlador.Controlador;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class EnvioVista {
	private Controlador con = new Controlador(); 
	private JFrame frmEnvios;
	private LineBorder br = new LineBorder(Color.BLACK,2, true);

	public EnvioVista() throws IOException {
		frmEnvios = new JFrame();
		frmEnvios.setForeground(SystemColor.textHighlight);
		frmEnvios.setOpacity(1.0f);
		frmEnvios.setTitle("JACE");
		frmEnvios.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmEnvios.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmEnvios.setBounds(100, 100, 625, 460);
		frmEnvios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnvios.getContentPane().setLayout(null);
		frmEnvios.setVisible(true);
		
		JLabel lblCrearEnvio = new JLabel("Envios");
		lblCrearEnvio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrearEnvio.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		lblCrearEnvio.setBackground(new Color(102, 0, 0));
		lblCrearEnvio.setBounds(10, 10, 591, 57);
		lblCrearEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		frmEnvios.getContentPane().add(lblCrearEnvio);
		
		JButton btnCrearEnvio = new JButton("Crear Envio");
		btnCrearEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.crearEnvioVista();
				frmEnvios.setVisible(false);
			}
		});
		btnCrearEnvio.setForeground(Color.DARK_GRAY);
		btnCrearEnvio.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCrearEnvio.setBackground(new Color(51, 255, 0));
		btnCrearEnvio.setBounds(116, 90, 133, 120);
		btnCrearEnvio.setBorder(br);
		frmEnvios.getContentPane().add(btnCrearEnvio);
		
		JButton btnModificar = new JButton("Modificar Envio");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.modificarEnvioVista();
				frmEnvios.setVisible(false);
			}
		});
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnModificar.setBackground(new Color(51, 255, 0));
		btnModificar.setBounds(379, 90, 133, 120);
		btnModificar.setBorder(br);
		frmEnvios.getContentPane().add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar Envio");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.cancelarEnvioVista();
				frmEnvios.setVisible(false);
			}
		});
		btnCancelar.setForeground(Color.DARK_GRAY);
		btnCancelar.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCancelar.setBackground(new Color(51, 255, 0));
		btnCancelar.setBounds(116, 241, 133, 120);
		btnCancelar.setBorder(br);
		frmEnvios.getContentPane().add(btnCancelar);
		
		JButton btnBuscarEnvio = new JButton("Buscar Envio");
		btnBuscarEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.buscarEnvioVista();
				frmEnvios.setVisible(false);
			}
		});
		btnBuscarEnvio.setForeground(Color.DARK_GRAY);
		btnBuscarEnvio.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnBuscarEnvio.setBackground(new Color(51, 255, 0));
		btnBuscarEnvio.setBounds(379, 241, 133, 120);
		btnBuscarEnvio.setBorder(br);
		frmEnvios.getContentPane().add(btnBuscarEnvio);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.menuJefeCajero();
					frmEnvios.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnAtras.setBackground(SystemColor.activeCaption);
		btnAtras.setBounds(275, 392, 85, 21);
		btnAtras.setBorder(new LineBorder(Color.BLACK,1, true));
		frmEnvios.getContentPane().add(btnAtras);
		
		
		
	}
}
