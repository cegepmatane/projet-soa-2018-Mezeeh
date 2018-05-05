package ca.qc.cgmatane.informatique.dao;

import ca.qc.cgmatane.informatique.modele.Voyage;
import org.w3c.dom.Element;

public class BuilderVoyage implements TypeParseur{
    protected int id = -1,
                distance,
                idVaisseau;

    protected String nom,
                destination,
                description;

    protected String typeParseur;

    public BuilderVoyage() {}

    public BuilderVoyage setTypeParseur(String typeParseur) {
        this.typeParseur = typeParseur;
        return this;
    }

    public BuilderVoyage setId(int id) {
        this.id = id;
        return this;
    }

    public BuilderVoyage parse(Element noeudVoyage){
        if(typeParseur == XML) {

            if(-1 == this.id)
                this.id = Integer.parseInt(noeudVoyage.getElementsByTagName("id").item(0).getTextContent());

            this.nom = noeudVoyage.getElementsByTagName("nom").item(0).getTextContent();
            this.destination = noeudVoyage.getElementsByTagName("destination").item(0).getTextContent();
            this.description = noeudVoyage.getElementsByTagName("description").item(0).getTextContent();
            this.distance = Integer.parseInt(noeudVoyage.getElementsByTagName("distance").item(0).getTextContent());
            this.idVaisseau = Integer.parseInt(noeudVoyage.getElementsByTagName("idvaisseau").item(0).getTextContent());
        }
        else
            System.out.println("Format non supporté pour le moment");

        return this;
    }

    public Voyage build(){
        return new Voyage(this.id, this.nom, this.destination, this.description, this.distance, this.idVaisseau);
    }
}
