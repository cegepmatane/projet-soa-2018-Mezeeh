package ca.qc.cgmatane.informatique.dao;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.modele.Voyage;

public class BuilderVaisseau implements TypeParseur{
	 protected int id, capaciter, porter, nombreVoyages;
	 protected String nom, description;
	 protected String typeParseur;
	 public BuilderVaisseau(){}
	 public BuilderVaisseau SetParseur(String type){
		this.typeParseur = type;
		return this;
	 }
	 public BuilderVaisseau parse(String contenu){
		if(typeParseur == null || typeParseur == XML){
			DocumentBuilder parseur;
			try {
				parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = parseur.parse(new StringBufferInputStream(contenu));
				
				id = Integer.parseInt(document.getElementsByTagName("id").item(0).getTextContent());
                nom = document.getElementsByTagName("nom").item(0).getTextContent();
                description = document.getElementsByTagName("description").item(0).getTextContent();
                capaciter = Integer.parseInt(document.getElementsByTagName("capaciter").item(0).getTextContent());
                porter = Integer.parseInt(document.getElementsByTagName("porter").item(0).getTextContent());
                nombreVoyages = Integer.parseInt(document.getElementsByTagName("nombreVoyages").item(0).getTextContent());
                
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			//non implementer
		}
		return this;
	 }
	 public Vaisseau build(){
		 return new Vaisseau(id, nom, description, capaciter, porter, nombreVoyages);
	 }
}
