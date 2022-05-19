package controlador;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Programa {
	public String user="";
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		var f = new Controlador();
		boolean correcto = false;
		
//		f.generarXML();
		
//		while(!f.correcto) {
			f.login();

//			if(f.correcto)
//				f.vistaMenu();
//			else
//				JOptionPane.showMessageDialog(null, "El usuario o la contraseña no coinciden \nRevise bien los datos porfavor");
//		}


	}

}
