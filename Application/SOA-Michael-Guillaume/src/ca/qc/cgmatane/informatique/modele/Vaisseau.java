package ca.qc.cgmatane.informatique.modele;

import java.util.ArrayList;
import java.util.List;

public class Vaisseau {
    protected int id,
                capaciter,
                porter;

    protected String nom,
                    description;

    protected List<Voyage> listeVoyages;

    public Vaisseau(int id, String nom, String description, int capaciter, int porter) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.capaciter = capaciter;
        this.porter = porter;

        this.listeVoyages = new ArrayList<Voyage>();
    }

    public void ajouterVoyage(Voyage voyage){
        if(null != voyage){
            voyage.setVaisseau(this);
            this.listeVoyages.add(voyage);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapaciter() {
        return capaciter;
    }

    public void setCapaciter(int capaciter) {
        this.capaciter = capaciter;
    }

    public int getPorter() {
        return porter;
    }

    public void setPorter(int porter) {
        this.porter = porter;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Voyage> getListeVoyages() {
        return listeVoyages;
    }
}
