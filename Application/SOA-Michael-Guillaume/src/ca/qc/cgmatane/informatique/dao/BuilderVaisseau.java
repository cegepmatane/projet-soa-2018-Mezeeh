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
	 public BuilderVaisseau parse(Element noeudVaisseau){
		if(typeParseur == null || typeParseur == XML){
			id = Integer.parseInt(noeudVaisseau.getElementsByTagName("id").item(0).getTextContent());
            nom = noeudVaisseau.getElementsByTagName("nom").item(0).getTextContent();
            description = noeudVaisseau.getElementsByTagName("description").item(0).getTextContent();
            capaciter = Integer.parseInt(noeudVaisseau.getElementsByTagName("capaciter").item(0).getTextContent());
            porter = Integer.parseInt(noeudVaisseau.getElementsByTagName("porter").item(0).getTextContent());
            nombreVoyages = Integer.parseInt(noeudVaisseau.getElementsByTagName("nombreVoyages").item(0).getTextContent());
		}else{
			//non implementer
		}
		return this;
	 }
	 public Vaisseau build(){
		 return new Vaisseau(id, nom, description, capaciter, porter, nombreVoyages);
	 }
}
