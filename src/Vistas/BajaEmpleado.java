package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import controlador.Controlador;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BajaEmpleado {

	private Controlador con = new Controlador();
	private JFrame frame;
	private JTextField textFieldDniEmpleado;

	
	public BajaEmpleado() {
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 276);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnBajaEmpleado = new JButton("Baja");
		
		JLabel lblBajaEmpleado = new JLabel("BAJA EMPLEADO");
		lblBajaEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaEmpleado.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 36));
		lblBajaEmpleado.setBackground(new Color(102, 0, 0));
		lblBajaEmpleado.setBounds(10, 10, 413, 57);
		frame.getContentPane().add(lblBajaEmpleado);
		
		JLabel lblDniEmpleado = new JLabel("DNI Empleado:");
		lblDniEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDniEmpleado.setBounds(117, 113, 82, 19);
		frame.getContentPane().add(lblDniEmpleado);
		
		textFieldDniEmpleado = new JTextField();
		textFieldDniEmpleado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				int opcion = -1;
				boolean numeros = key >= 48 && key <= 57;
				boolean letras = key >= 65 && key <= 90;

				if (textFieldDniEmpleado.getText().trim().length() < 8)
					opcion = 0;
				else if(textFieldDniEmpleado.getText().trim().length() > 7)
					opcion = 1;

				switch(opcion) {
				case 0:
					if(!numeros)
						e.consume();
					break;
				case 1:
					if(!letras || textFieldDniEmpleado.getText().trim().length() == 9)
						e.consume();
					break;
				}
				con.comprobarCampos(textFieldDniEmpleado, 8, btnBajaEmpleado);
			}
		});
		textFieldDniEmpleado.setColumns(10);
		textFieldDniEmpleado.setBackground(SystemColor.info);
		textFieldDniEmpleado.setBounds(209, 113, 96, 19);
		frame.getContentPane().add(textFieldDniEmpleado);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.personalVistas();
				frame.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setBackground(new Color(255, 250, 205));
		btnAtras.setBounds(229, 182, 91, 21);
		frame.getContentPane().add(btnAtras);
		
		btnBajaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.personalVistas();
					frame.setVisible(false);
					con.bajaEmpleado(textFieldDniEmpleado.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBajaEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBajaEmpleado.setBackground(new Color(255, 250, 205));
		btnBajaEmpleado.setBounds(106, 182, 91, 21);
		frame.getContentPane().add(btnBajaEmpleado);
	}

}
