package ca.qc.cgmatane.informatique.action;

import ca.qc.cgmatane.informatique.dao.ServiceDAO;
import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.modele.Voyage;
import ca.qc.cgmatane.informatique.vue.VaisseauVue;

import java.util.ArrayList;
import java.util.List;

public class Controleur {
    protected ServiceDAO serviceDAO;
    protected VaisseauVue vue;

    public Controleur(VaisseauVue vue) {
        this.vue = vue;

        serviceDAO = new ServiceDAO();
        List<Vaisseau> listeVaisseaux = serviceDAO.listerVaisseaux();
        List<Voyage> listeVoyages = serviceDAO.listerVoyages();

        vue.afficherVaisseaux(listeVaisseaux);
        vue.afficherVoyages(listeVoyages);
    }

    public void chargerInformationsVaisseau(int idVaisseau){
        Vaisseau vaisseau = serviceDAO.recupererVaisseau(idVaisseau);
        List<Voyage> voyageVaisseau = serviceDAO.recupererVoyagesSelonVaisseau(idVaisseau);

        List<String> informations = new ArrayList<String>();
        informations.add("ID : "  + vaisseau.getId());
        informations.add("Nom : "  + vaisseau.getNom());
        informations.add("Description : "  + vaisseau.getDescription());
        informations.add("Capacité : "  + vaisseau.getCapaciter() + " personne(s)");
        informations.add("Porter : "  + vaisseau.getPorter() + " km");

        vue.afficherInformationsVaisseau(informations);
    }
}
