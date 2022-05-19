package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PersonalVistas {

	private Controlador con = new Controlador();
	private JFrame frmPersonal;


	public PersonalVistas() {
		frmPersonal = new JFrame();
		frmPersonal.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmPersonal.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmPersonal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ander\\OneDrive\\Im\u00E1genes\\Saved Pictures\\SSASDWDQ.png"));
		frmPersonal.setTitle("JACE");
		frmPersonal.setBounds(100, 100, 628, 458);
		frmPersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPersonal.getContentPane().setLayout(null);
		frmPersonal.setVisible(true);

		JButton btnBajaTrabajador = new JButton("Baja trabajador");
		btnBajaTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPersonal.setVisible(false);
				con.bajaEmpleadoVista();
			}
		});
		btnBajaTrabajador.setForeground(Color.DARK_GRAY);
		btnBajaTrabajador.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnBajaTrabajador.setBackground(new Color(51, 255, 0));
		btnBajaTrabajador.setBounds(379, 90, 133, 120);
		frmPersonal.getContentPane().add(btnBajaTrabajador);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmPersonal.setVisible(false);
					con.menuJefeCajero();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnAtras.setBorder(new LineBorder(Color.BLACK,1, true));
		btnAtras.setBackground(SystemColor.activeCaption);
		btnAtras.setBounds(275, 392, 85, 21);
		frmPersonal.getContentPane().add(btnAtras);

		JButton btnBuscarTrabajador = new JButton("Buscar trabajador");
		btnBuscarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarTrabajador.setForeground(Color.DARK_GRAY);
		btnBuscarTrabajador.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnBuscarTrabajador.setBackground(new Color(51, 255, 0));
		btnBuscarTrabajador.setBounds(379, 241, 133, 120);
		frmPersonal.getContentPane().add(btnBuscarTrabajador);

		JButton btnModificarTrabajador = new JButton("Mod \r\ntrabajador");
		btnModificarTrabajador.setForeground(Color.DARK_GRAY);
		btnModificarTrabajador.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnModificarTrabajador.setBackground(new Color(51, 255, 0));
		btnModificarTrabajador.setBounds(116, 241, 133, 120);
		frmPersonal.getContentPane().add(btnModificarTrabajador);

		JButton btnAltaPersonal = new JButton("Alta trabajador");
		btnAltaPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.altaEmpleadoVista();
				frmPersonal.setVisible(false);
			}
		});
		btnAltaPersonal.setForeground(Color.DARK_GRAY);
		btnAltaPersonal.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnAltaPersonal.setBackground(new Color(51, 255, 0));
		btnAltaPersonal.setBounds(116, 90, 133, 120);
		frmPersonal.getContentPane().add(btnAltaPersonal);

		JLabel lblPersonal = new JLabel("Personal");
		lblPersonal.setForeground(Color.BLACK);
		lblPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonal.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		lblPersonal.setBackground(new Color(192, 192, 192));
		lblPersonal.setBounds(10, 10, 594, 57);
		frmPersonal.getContentPane().add(lblPersonal);
	}

}
