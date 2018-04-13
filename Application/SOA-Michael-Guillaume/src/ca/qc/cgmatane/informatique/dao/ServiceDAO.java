package ca.qc.cgmatane.informatique.dao;

import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.modele.Voyage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceDAO {

    protected List<Vaisseau> listeVaisseaux;
    protected List<Voyage> listeVoyages;

    public ServiceDAO() {
        listeVaisseaux = new ArrayList<Vaisseau>();
        listeVoyages = new ArrayList<Voyage>();
    }

    public List<Vaisseau> listerVaisseaux(){
    	
      String xml = this.recupererXML("http://localhost/Service/vaisseau/liste.php", "</vaisseaux>");

        if(null == xml) return null;

        try {
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parseur.parse(new StringBufferInputStream(xml));
            //System.out.println(racine);

            NodeList listeNoeudVaisseaux = document.getElementsByTagName("vaisseau");
            for(int iterateur = 0; iterateur < listeNoeudVaisseaux.getLength(); iterateur++){
                Element noeudVaisseau = (Element) listeNoeudVaisseaux.item(iterateur);

                int id = Integer.parseInt(noeudVaisseau.getElementsByTagName("id").item(0).getTextContent());
                String nom = noeudVaisseau.getElementsByTagName("nom").item(0).getTextContent();
                String description = noeudVaisseau.getElementsByTagName("description").item(0).getTextContent();
                int capaciter = Integer.parseInt(noeudVaisseau.getElementsByTagName("capaciter").item(0).getTextContent());
                int porter = Integer.parseInt(noeudVaisseau.getElementsByTagName("porter").item(0).getTextContent());

                /*System.out.println("id = " + id);
                System.out.println("nom = " + nom);
                System.out.println("description = " + description);
                System.out.println("capaciter = " + capaciter);
                System.out.println("porter = " + porter);*/

                listeVaisseaux.add(new Vaisseau(id, nom, description, capaciter, porter));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        System.out.println(this.recupererVoyage(1).getDestination());
        return listeVaisseaux;
    }
    public List<Voyage> listerVoyages(){
    	
        String xml = this.recupererXML("http://localhost/Service/voyage/liste.php", "</voyages>");
        //System.out.println(xml);
          if(null == xml) return null;

          try {
              DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
              Document document = parseur.parse(new StringBufferInputStream(xml));
              NodeList listeNoeudVoyages = document.getElementsByTagName("voyage");
              for(int iterateur = 0; iterateur < listeNoeudVoyages.getLength(); iterateur++){
                  Element noeudVoyage = (Element) listeNoeudVoyages.item(iterateur);

                  int id = Integer.parseInt(noeudVoyage.getElementsByTagName("id").item(0).getTextContent());
                  String nom = noeudVoyage.getElementsByTagName("nom").item(0).getTextContent();
                  String destination = noeudVoyage.getElementsByTagName("destination").item(0).getTextContent();
                  String description = noeudVoyage.getElementsByTagName("description").item(0).getTextContent();
                  int distance = Integer.parseInt(noeudVoyage.getElementsByTagName("distance").item(0).getTextContent());
                  int idVaisseau = Integer.parseInt(noeudVoyage.getElementsByTagName("idvaisseau").item(0).getTextContent());
                  
                  listeVoyages.add(new Voyage(id, nom, destination, description, distance, idVaisseau));
              }
          } catch (ParserConfigurationException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          } catch (SAXException e) {
              e.printStackTrace();
          }

          return listeVoyages;
      }
    public Vaisseau recupererVaisseau(int id)
    {
    	Vaisseau vaisseau = null;
    	String xml = this.recupererXML("http://localhost/Service/vaisseau/vaisseau.php?id="+id, "</vaisseau>");
    	if(null == xml) return null;
    	 try {
             DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
             Document document = parseur.parse(new StringBufferInputStream(xml));
             NodeList listeNoeudVaisseaux = document.getElementsByTagName("vaisseau");
             Element noeudVaisseau = (Element) listeNoeudVaisseaux.item(0);
             
             String nom = noeudVaisseau.getElementsByTagName("nom").item(0).getTextContent();
             String description = noeudVaisseau.getElementsByTagName("description").item(0).getTextContent();
             int capaciter = Integer.parseInt(noeudVaisseau.getElementsByTagName("capaciter").item(0).getTextContent());
             int porter = Integer.parseInt(noeudVaisseau.getElementsByTagName("porter").item(0).getTextContent());
             
             vaisseau = new Vaisseau(id, nom, description, capaciter, porter);

    	 } catch (ParserConfigurationException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (SAXException e) {
             e.printStackTrace();
         }
    	 
    	return vaisseau;
    }
    public Voyage recupererVoyage(int id)
    {
    	Voyage voyage = null;
    	String xml = this.recupererXML("http://localhost/Service/voyage/voyage.php?id="+id, "</voyage>");
    	if(null == xml) return null;
    	 try {
             DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
             Document document = parseur.parse(new StringBufferInputStream(xml));
             NodeList listeNoeudVoyages = document.getElementsByTagName("voyage");
             Element noeudVoyage = (Element) listeNoeudVoyages.item(0);
             
             String nom = noeudVoyage.getElementsByTagName("nom").item(0).getTextContent();
             String destination = noeudVoyage.getElementsByTagName("destination").item(0).getTextContent();
             String description = noeudVoyage.getElementsByTagName("description").item(0).getTextContent();
             int distance = Integer.parseInt(noeudVoyage.getElementsByTagName("distance").item(0).getTextContent());
             int idVaisseau = Integer.parseInt(noeudVoyage.getElementsByTagName("idvaisseau").item(0).getTextContent());
             
             voyage = new Voyage(id, nom, destination, description, distance, idVaisseau);

    	 } catch (ParserConfigurationException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (SAXException e) {
             e.printStackTrace();
         }
    	 
    	return voyage;
    }
    private String recupererXML( String stringUrlXML,String delimiteur)
    {
    	String xml = "";
    	  try{
    		  URL urlXML = new URL(stringUrlXML);
              InputStream flux = urlXML.openConnection().getInputStream();
              Scanner lecteur = new Scanner(flux).useDelimiter(delimiteur);
              xml = lecteur.next() + delimiteur;
              //System.out.println(xml);
          } catch (IOException e) {
              e.printStackTrace();
          }
    	  return xml;
    }
}
