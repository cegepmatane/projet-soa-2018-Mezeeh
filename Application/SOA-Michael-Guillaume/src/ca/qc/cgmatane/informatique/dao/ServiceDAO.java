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
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class ServiceDAO implements VoyageURL, VaisseauURL, TypeParseur{

    protected HashMap<Integer, Vaisseau> listeVaisseaux;
    protected HashMap<Integer, Voyage> listeVoyages;
    protected String xml;

    public ServiceDAO() {
        listeVaisseaux = null;
        listeVoyages = null;
    }

    public Vaisseau recupererInformationsVaisseau(int idVaisseau){
        Vaisseau vaisseau = recupererVaisseau(idVaisseau);
        List<Voyage> voyagesDuVaisseau = recupererVoyagesSelonVaisseau(idVaisseau);

        for(Voyage voyage : voyagesDuVaisseau) {
            vaisseau.ajouterVoyage(voyage);
        }

        return vaisseau;
    }

    public List<Vaisseau> listerVaisseaux(){

        if(null == listeVaisseaux){
            listeVaisseaux = new HashMap<Integer, Vaisseau>();
            xml = this.recupererXML(URL_LISTER_VAISSEAUX, "</vaisseaux>");

            if(null == xml) return null;
            BuilderVaisseau builderVaisseau = new BuilderVaisseau();
            try {
                DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = parseur.parse(new StringBufferInputStream(xml));
                //System.out.println(racine);
                NodeList listeNoeudVaisseaux = document.getElementsByTagName("vaisseau");
                for(int iterateur = 0; iterateur < listeNoeudVaisseaux.getLength(); iterateur++){
                    Element noeudVaisseau = (Element) listeNoeudVaisseaux.item(iterateur);
                    
                    /*int id = Integer.parseInt(noeudVaisseau.getElementsByTagName("id").item(0).getTextContent());
                    String nom = noeudVaisseau.getElementsByTagName("nom").item(0).getTextContent();
                    String description = noeudVaisseau.getElementsByTagName("description").item(0).getTextContent();
                    int capaciter = Integer.parseInt(noeudVaisseau.getElementsByTagName("capaciter").item(0).getTextContent());
                    int porter = Integer.parseInt(noeudVaisseau.getElementsByTagName("porter").item(0).getTextContent());
                    int nombreVoyages = Integer.parseInt(noeudVaisseau.getElementsByTagName("nombreVoyages").item(0).getTextContent());

                    System.out.println("id = " + id);
                    System.out.println("nom = " + nom);
                    System.out.println("description = " + description);
                    System.out.println("capaciter = " + capaciter);
                    System.out.println("porter = " + porter);*/

	               //Vaisseau vaisseau = builderVaisseau.SetParseur(XML).parse((Element) listeNoeudVaisseaux.item(iterateur)).build();

                    Vaisseau vaisseau = new BuilderVaisseau().SetParseur(XML).parse(noeudVaisseau).build();

                    listeVaisseaux.put(vaisseau.getId(), vaisseau);
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
        List<Vaisseau> liste = new ArrayList<>();
        for(Entry<Integer, Vaisseau> entree : listeVaisseaux.entrySet()){
            liste.add(entree.getValue());
        }
        return liste;
    }
    public List<Voyage> listerVoyages(){
        if(null == listeVoyages){
            listeVoyages = new HashMap<Integer, Voyage>();
            xml = this.recupererXML(URL_LISTER_VOYAGES, "</voyages>");
            //System.out.println(xml);
            if(null == xml) return null;

            try {
                DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = parseur.parse(new StringBufferInputStream(xml));
                NodeList listeNoeudVaisseaux = document.getElementsByTagName("voyage");

                Voyage voyage = null;
                for(int iterateur = 0; iterateur < listeNoeudVaisseaux.getLength(); iterateur++) {
                    /*Element noeudVoyage = (Element) listeNoeudVaisseaux.item(iterateur);

                    //System.out.println(noeudVaisseau.getElementsByTagName("nom").item(0).getTextContent());

                    int id = Integer.parseInt(noeudVoyage.getElementsByTagName("id").item(0).getTextContent());
                    String nom = noeudVoyage.getElementsByTagName("nom").item(0).getTextContent();
                    String destination = noeudVoyage.getElementsByTagName("destination").item(0).getTextContent();
                    String description = noeudVoyage.getElementsByTagName("description").item(0).getTextContent();
                    int distance = Integer.parseInt(noeudVoyage.getElementsByTagName("distance").item(0).getTextContent());
                    int idVaisseau = Integer.parseInt(noeudVoyage.getElementsByTagName("idvaisseau").item(0).getTextContent());

                    *//*System.out.println("ID : " + id);
                    System.out.println("Nom : " + nom);
                    System.out.println("Destination : " + destination);
                    System.out.println("Description : " + description);
                    System.out.println("Distance : " + distance);
                    System.out.println("ID du vaisseau : " + idVaisseau);*/

                    voyage = new BuilderVoyage().setTypeParseur(XML).parse((Element) listeNoeudVaisseaux.item(iterateur)).build();

                    listeVoyages.put(voyage.getId(), voyage);
                }

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
        List<Voyage> liste = new ArrayList<>();
        for(Entry<Integer, Voyage> entree : listeVoyages.entrySet()){
            liste.add(entree.getValue());
        }
        return liste;
    }
    public Vaisseau recupererVaisseau(int id)
    {
        if(null == listeVaisseaux.get(id)){
            Vaisseau vaisseau = null;
            xml = this.recupererXML(URL_RECUPERER_VAISSEAU + id, "</vaisseau>");
            if(null == xml) return null;
            try {
                DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = parseur.parse(new StringBufferInputStream(xml));
                NodeList listeNoeudVaisseaux = document.getElementsByTagName("vaisseau");
                Element noeudVaisseau = (Element) listeNoeudVaisseaux.item(0);

                /*String nom = noeudVaisseau.getElementsByTagName("nom").item(0).getTextContent();
                String description = noeudVaisseau.getElementsByTagName("description").item(0).getTextContent();
                int capaciter = Integer.parseInt(noeudVaisseau.getElementsByTagName("capaciter").item(0).getTextContent());
                int porter = Integer.parseInt(noeudVaisseau.getElementsByTagName("porter").item(0).getTextContent());*/

                vaisseau = new BuilderVaisseau().SetParseur(XML).parse(noeudVaisseau).build();

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            listeVaisseaux.put(id, vaisseau);
        }
        return listeVaisseaux.get(id);
    }
    public Voyage recupererVoyage(int id)
    {
        if(null == listeVoyages.get(id)){
            Voyage voyage = null;
            xml = this.recupererXML(URL_RECUPERER_VOYAGE + id, "</voyage>");
            if(null == xml) return null;
            try {
                DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = parseur.parse(new StringBufferInputStream(xml));
                NodeList listeNoeudVoyages = document.getElementsByTagName("voyage");
                /*Element noeudVoyage = (Element) listeNoeudVoyages.item(0);

                String nom = noeudVoyage.getElementsByTagName("nom").item(0).getTextContent();
                String destination = noeudVoyage.getElementsByTagName("destination").item(0).getTextContent();
                String description = noeudVoyage.getElementsByTagName("description").item(0).getTextContent();
                int distance = Integer.parseInt(noeudVoyage.getElementsByTagName("distance").item(0).getTextContent());
                int idVaisseau = Integer.parseInt(noeudVoyage.getElementsByTagName("idvaisseau").item(0).getTextContent());

                voyage = new Voyage(id, nom, destination, description, distance, idVaisseau);*/

                voyage = new BuilderVoyage().setTypeParseur(XML).setId(id).parse((Element) listeNoeudVoyages.item(0)).build();

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            listeVoyages.put(id, voyage);
        }
        return listeVoyages.get(id);
    }
    private String recupererXML( String stringUrlXML,String delimiteur)
    {
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

    public List<Voyage>recupererVoyagesSelonVaisseau(int idVaisseauVoyage){

        List<Voyage> liste = new ArrayList<>();
        for(Entry<Integer, Voyage> entree : listeVoyages.entrySet()){
            if(entree.getValue().getIdVaisseau() == idVaisseauVoyage)
                liste.add(entree.getValue());
        }
        return liste;
    }

    public void ajouterVoyage(Voyage voyage)
    {
        try {
            URL urlAjouterPensee = new URL(URL_AJOUTER_VOYAGE);
            HttpURLConnection connection = (HttpURLConnection) urlAjouterPensee.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("User-Agent", "Java client");
            //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            OutputStream fluxEcriture = connection.getOutputStream();
            OutputStreamWriter envoyeur = new OutputStreamWriter(fluxEcriture);

            envoyeur.write("nom=" + voyage.getNom()
                    +"&destination=" + voyage.getDestination()
                    +"&description=" + voyage.getDescription()
                    +"&distance=" + voyage.getDistance()
                    +"&idvaisseau=" + voyage.getIdVaisseau());
            envoyeur.close();

            InputStream fluxLecture = connection.getInputStream(); // NE PAS RETIRER NECESSAIRE AU FONCTIONNEMENT
            /*Scanner lecteur = new Scanner(fluxLecture);

            String derniereBalise = "</action>";
            lecteur.useDelimiter(derniereBalise);
            xml = lecteur.next() + derniereBalise;
            lecteur.close();
            System.out.println(xml); */
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
