package action;

import dao.ServiceDAO;
import vue.VaisseauVue;

public class Controleur {
    protected ServiceDAO serviceDAO;
    protected VaisseauVue vue;

    public Controleur(VaisseauVue vue) {
        this.vue = vue;
        serviceDAO = new ServiceDAO();
    }
}
