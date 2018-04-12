package ca.qc.cgmatane.informatique.action;

import ca.qc.cgmatane.informatique.dao.ServiceDAO;
import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.vue.VaisseauVue;

import java.util.List;

public class Controleur {
    protected ServiceDAO serviceDAO;
    protected VaisseauVue vue;

    public Controleur(VaisseauVue vue) {
        this.vue = vue;

        serviceDAO = new ServiceDAO();
        List<Vaisseau> listeVaisseaux = serviceDAO.listerVaisseaux();

        /*String informationsVaisseaux = "";
        for(Vaisseau v : listeVaisseaux){
            informationsVaisseaux += v.getNom() + " | " + v.getDescription() + " | " + v.getCapaciter() + " personnes | " + v.getPorter() + " km\n";
        }*/

        vue.afficherVaisseaux(listeVaisseaux);
    }
}
