package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.Controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import java.awt.Panel;
import java.awt.Label;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.awt.event.MouseWheelEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class MenuPrincipal {
	Controlador control = new Controlador();
	private LineBorder br = new LineBorder(Color.BLACK,2, true);
	private JFrame frmMenu;

	public MenuPrincipal(boolean b){
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmMenu.getContentPane().setForeground(Color.WHITE);
		frmMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMenu.setBounds(100, 100, 665, 473);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		frmMenu.setVisible(true);

		JButton btnEnvios = new JButton("Envios");

		btnEnvios.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnEnvios.setBackground(Color.GREEN);
		btnEnvios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					control.envioVista();
					frmMenu.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEnvios.setBounds(130, 102, 133, 120);
		btnEnvios.setBorder(br);
		frmMenu.getContentPane().add(btnEnvios);

		JButton btnTarifas = new JButton("Tarifas");
		btnTarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.tarifasVistas();
				frmMenu.setVisible(false);
			}
		});
		btnTarifas.setBackground(new Color(51, 255, 0));
		btnTarifas.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnTarifas.setBounds(395, 103, 133, 120);
		btnTarifas.setBorder(br);
		frmMenu.getContentPane().add(btnTarifas);

		JButton btnFacturas = new JButton("Facturas");
		btnFacturas.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnFacturas.setBackground(new Color(51, 255, 0));
		btnFacturas.setBounds(130, 258, 133, 120);
		btnFacturas.setBorder(br);
		frmMenu.getContentPane().add(btnFacturas);

		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.personalVistas();
				frmMenu.setVisible(false);
			}
		});
		btnPersonal.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnPersonal.setBackground(new Color(51, 255, 0));
		btnPersonal.setBounds(395, 258, 133, 120);
		btnPersonal.setBorder(br);
		if(b)
			btnPersonal.setEnabled(true);
		else
			btnPersonal.setEnabled(false);
		frmMenu.getContentPane().add(btnPersonal);

		JLabel lblEnunciado = new JLabel("MENU");
		lblEnunciado.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		lblEnunciado.setBackground(new Color(102, 0, 0));
		frmMenu.getContentPane().add(lblEnunciado);
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setBounds(10, 10, 631, 57);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.login();
				frmMenu.setVisible(false);
			}
		});
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnCerrarSesion.setBorder(new LineBorder(Color.BLACK,1, true));
		btnCerrarSesion.setBackground(SystemColor.activeCaption);
		btnCerrarSesion.setBounds(555, 10, 86, 10);
		frmMenu.getContentPane().add(btnCerrarSesion);

	}
}
