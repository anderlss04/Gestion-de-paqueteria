package java_ddbb;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import Modelo.Factura;

public class XML {
	File archivo = new File("C:/datos/tarifas.xml");
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


	public String buscarElementoXml(String busca, String dato ) {
		try {
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			NodeList listaTarifas = document.getElementsByTagName(busca);
			for (int temp = 0; temp < listaTarifas.getLength(); temp++) {
				Node nodo = listaTarifas.item(temp);
//				System.out.println("Elemento:" + nodo.getNodeName());
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					return element.getElementsByTagName(dato).item(0).getTextContent();
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void modificarElementoXml(int elegido,String nodoPrincipal, String elemento, String mod) {
		try {
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			NodeList listaTarifas = document.getElementsByTagName(nodoPrincipal);

			for (int i = 0; i < listaTarifas.getLength(); i++) {
				Node tarifa = listaTarifas.item(i);
				if (tarifa.getNodeType() == Node.ELEMENT_NODE) {
					if(i+1 == elegido) {

						Element element = (Element) tarifa;
						Node propiedad = element.getElementsByTagName(elemento).item(0);

						Element contes = (Element) propiedad;
						contes.setTextContent(mod);
					}
				}
			}
			guardarXml(document);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void borrarTarifa(String id) {
		try {
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			NodeList listaTarifas = document.getElementsByTagName("tarifa");

			for (int i = 0; i < listaTarifas.getLength(); i++) {
				Element element = (Element) listaTarifas.item(i);

				if (element.getAttribute("id").equalsIgnoreCase(id)) {

					element.getParentNode().removeChild(element);
				}
			}
			guardarXml(document);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crearTarifa(String id, String valPrecio, String valPesoMin, String valPesoMax ) {
		try {
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			Node root = document.getDocumentElement();

			Element tarifa = document.createElement("tarifa");
			root.appendChild(tarifa);

			Attr attr = document.createAttribute("id");
			attr.setValue(id);
			tarifa.setAttributeNode(attr);

			Element precio = document.createElement("precio");
			precio.setTextContent(valPrecio);

			Element pesoMin = document.createElement("pesoMin");
			pesoMin.setTextContent(valPesoMin);

			Element pesoMax = document.createElement("pesoMax");
			pesoMax.setTextContent(valPesoMax);

			tarifa.appendChild(precio);
			tarifa.appendChild(pesoMin);
			tarifa.appendChild(pesoMax);



			guardarXml(document);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guardarXml(Document document) throws TransformerFactoryConfigurationError, TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Result output = new StreamResult(new File("C:/datos/tarifas.xml"));
		Source input = new DOMSource(document);
		transformer.transform(input, output);
	}

	public Factura generarFactura(Float peso, int codEnvio, String seguro, String tipo) {
		float precio = 0;
		try {
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			NodeList listaTarifas = document.getElementsByTagName("tarifa");
			NodeList listaSeguro = document.getElementsByTagName("tarifaSeguro");
			NodeList listaTipo = document.getElementsByTagName("tarifaTipo");

			for (int temp = 0; temp < listaTarifas.getLength(); temp++) {
				Node nodo = listaTarifas.item(temp);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					if(peso > Float.parseFloat(element.getElementsByTagName("pesoMin").item(0).getTextContent()) && peso < Float.parseFloat(element.getElementsByTagName("pesoMax").item(0).getTextContent()))
						precio += Float.parseFloat(element.getElementsByTagName("precio").item(0).getTextContent());
				}
			}
			for (int temp = 0; temp < listaSeguro.getLength(); temp++) {
				Node nodo = listaSeguro.item(temp);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					if(seguro.equals(element.getElementsByTagName("nomSeguro").item(0).getTextContent()))
						precio += Float.parseFloat(element.getElementsByTagName("precio").item(0).getTextContent());
				}
			}
			for (int temp = 0; temp < listaTipo.getLength(); temp++) {
				Node nodo = listaTipo.item(temp);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					if(tipo.equals(element.getElementsByTagName("tipo").item(0).getTextContent()))
						precio += Float.parseFloat(element.getElementsByTagName("precio").item(0).getTextContent());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Factura(""+codEnvio, ""+(codEnvio+4000), precio, null, null);
	}




}
