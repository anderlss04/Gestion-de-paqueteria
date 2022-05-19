package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import controlador.Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TarifasVista {

	private Controlador con = new Controlador();
	private JFrame frmJace;

	
	public TarifasVista() {
		frmJace = new JFrame();
		frmJace.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmJace.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmJace.setTitle("JACE");
		frmJace.setBounds(100, 100, 687, 457);
		frmJace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJace.setVisible(true);
		frmJace.getContentPane().setLayout(null);
		
		JLabel lblTarifas = new JLabel("TARIFAS");
		lblTarifas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarifas.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 36));
		lblTarifas.setBackground(new Color(102, 0, 0));
		lblTarifas.setBounds(10, 10, 653, 57);
		frmJace.getContentPane().add(lblTarifas);
		
		JButton btnBorrarTarifa = new JButton("Borrar Tarifa");
		btnBorrarTarifa.setForeground(Color.DARK_GRAY);
		btnBorrarTarifa.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnBorrarTarifa.setBackground(new Color(51, 255, 0));
		btnBorrarTarifa.setBounds(139, 228, 133, 120);
		frmJace.getContentPane().add(btnBorrarTarifa);
		
		JButton btnCrearTarifa = new JButton("Crear Tarifa");
		btnCrearTarifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrearTarifa.setForeground(Color.DARK_GRAY);
		btnCrearTarifa.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnCrearTarifa.setBackground(new Color(51, 255, 0));
		btnCrearTarifa.setBounds(139, 77, 133, 120);
		frmJace.getContentPane().add(btnCrearTarifa);
		
		JButton btnBuscarTarifa = new JButton("Buscar Tarifa");
		btnBuscarTarifa.setForeground(Color.DARK_GRAY);
		btnBuscarTarifa.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnBuscarTarifa.setBackground(new Color(51, 255, 0));
		btnBuscarTarifa.setBounds(402, 228, 133, 120);
		frmJace.getContentPane().add(btnBuscarTarifa);
		
		JButton btnModificarTarifa = new JButton("Modificar Tarifa");
		btnModificarTarifa.setForeground(Color.DARK_GRAY);
		btnModificarTarifa.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnModificarTarifa.setBackground(new Color(51, 255, 0));
		btnModificarTarifa.setBounds(402, 77, 133, 120);
		frmJace.getContentPane().add(btnModificarTarifa);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.menuJefeCajero();
					frmJace.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnAtras.setBorder(new LineBorder(Color.BLACK,1, true));
		btnAtras.setBackground(SystemColor.activeCaption);
		btnAtras.setBounds(298, 379, 85, 21);
		frmJace.getContentPane().add(btnAtras);
	}

}
