import dao.ServiceDAO;
import modele.Vaisseau;
import vue.VaisseauVue;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //VaisseauVue vaisseauVue = new VaisseauVue();
        //vaisseauVue.launch(VaisseauVue.class, args);
        ServiceDAO serviceDAO = new ServiceDAO();
        List<Vaisseau> lv = serviceDAO.listerVaisseaux();
        for (Vaisseau v : lv) {
            System.out.println(v.getNom());
        }
    }
}
