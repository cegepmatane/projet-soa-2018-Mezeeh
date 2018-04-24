package ca.qc.cgmatane.informatique;

import ca.qc.cgmatane.informatique.dao.ServiceDAO;
import ca.qc.cgmatane.informatique.modele.Voyage;
import ca.qc.cgmatane.informatique.vue.VaisseauVue;

public class App {
    public static void main(String[] args) {
        VaisseauVue vaisseauVue = new VaisseauVue();
        vaisseauVue.launch(VaisseauVue.class, args);
    }
}
