package controlador;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Programa {
	
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		var f = new Controlador();
		boolean correcto = false;

			f.login();

	}

}
