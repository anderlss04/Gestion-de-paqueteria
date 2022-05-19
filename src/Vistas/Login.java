package Vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import controlador.Controlador;
import controlador.Programa;



public class Login extends JFrame{
	private PanelLabelConCampo panelUsuario = new PanelLabelConCampo("Usuario");
	private PanelLabelConCampo panelContraseña = new PanelLabelConCampo("Contraseña");
	private Controlador con = new Controlador();
	public boolean correcto;
	public String user;


	private class PanelLabelConCampo extends JPanel {
		JLabel label;
		JTextField campo;

		public PanelLabelConCampo(String textoEtiqueta) {
			setLayout(new FlowLayout(FlowLayout.RIGHT));
			label = new JLabel(textoEtiqueta);
			campo = new JTextField(12);
			add(label);
			add(campo);
		}

	}

	private class PanelTitulo extends JPanel {

		public PanelTitulo() {
			JLabel titulo = new JLabel("LOGIN");
			titulo.setFont(new Font("Verdana", Font.BOLD, 28));
			add(titulo);
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			setBackground(new Color(50,205,50));
		}
	}

	private class PanelFormulario extends JPanel {

		public PanelFormulario() {
			setLayout(new GridLayout(2, 1));
			add(panelUsuario);
			add(panelContraseña);

		}
	}

	public Login() {
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user = panelUsuario.campo.getText();
				String password = panelContraseña.campo.getText();

				try {
					con.comprobarLogin(user, password);
					setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		setLayout(new BorderLayout());

		add(new PanelTitulo(), BorderLayout.NORTH);
		add(new PanelFormulario(), BorderLayout.CENTER);
		add(aceptar, BorderLayout.SOUTH);

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
