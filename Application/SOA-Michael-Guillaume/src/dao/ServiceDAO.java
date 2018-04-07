package dao;

import modele.Vaisseau;
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

    protected String xml;
    protected List<Vaisseau> listeVaisseaux;

    public ServiceDAO() {
        xml = "";
        listeVaisseaux = new ArrayList<Vaisseau>();
    }

    public List<Vaisseau> listerVaisseaux(){

        try{
            URL urlListeVaisseaux = new URL("http://localhost/Service/listeComplete.php");
            InputStream flux = urlListeVaisseaux.openConnection().getInputStream();
            String derniereBalise = "</servicevoyage>";
            Scanner lecteur = new Scanner(flux).useDelimiter(derniereBalise);
            xml = lecteur.next() + derniereBalise;
            //System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(null == xml) return null;

        try {
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parseur.parse(new StringBufferInputStream(xml));
            String racine = document.getDocumentElement().getNodeName();
            //System.out.println(racine);

            NodeList listeNoeudVaisseaux = document.getElementsByTagName("vaisseau");
            //for(Iterator<Vaisseau> iterateur = listeVaisseaux.iterator(); iterateur.hasNext();){
            //for (Vaisseau v : listeVaisseaux) {
            for(int i = 0; i < listeNoeudVaisseaux.getLength(); i++){
                Element noeudVaisseau = (Element) listeNoeudVaisseaux.item(i);

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

        return listeVaisseaux;
    }
}
