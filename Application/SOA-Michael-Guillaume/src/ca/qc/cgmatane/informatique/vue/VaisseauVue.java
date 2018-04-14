package ca.qc.cgmatane.informatique.vue;

import ca.qc.cgmatane.informatique.action.Controleur;
import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.modele.Voyage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class VaisseauVue extends Application{
    protected Controleur controleur;

    protected String nomFenetre = "Service Voyage";
    protected int largeurFenetre = 600,
            hauteurFenetre = 400;

    protected VBox contenuOngletVaisseaux,
                    contenuOngletVoyages;

    protected TabPane onglets;
    protected Tab ongletVaisseaux,
            ongletVoyages;

    @Override
    public void start(Stage scenePrincipal) throws Exception {
        onglets = new TabPane();

        scenePrincipal.setScene(new Scene(onglets,largeurFenetre, hauteurFenetre));
        scenePrincipal.setTitle(nomFenetre);

        ongletVaisseaux = new Tab("Vaisseaux");
        ongletVaisseaux.setClosable(false);
        contenuOngletVaisseaux = new VBox();
        ongletVaisseaux.setContent(contenuOngletVaisseaux);

        ongletVoyages = new Tab("Voyages");
        ongletVoyages.setClosable(false);
        contenuOngletVoyages = new VBox();
        ongletVoyages.setContent(contenuOngletVoyages);

        onglets.getTabs().add(ongletVaisseaux);
        onglets.getTabs().add(ongletVoyages);

        scenePrincipal.show();
        controleur = new Controleur(this);
    }

    public void afficherVaisseaux(List<Vaisseau> listeVaisseaux) {
        for(Vaisseau vaisseau : listeVaisseaux){
            Button button = new Button(vaisseau.getNom());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    controleur.chargerInformationsVaisseau(vaisseau.getId());
                }
            });
            contenuOngletVaisseaux.getChildren().add(button);
        }
    }

    public void afficherInformationsVaisseau(List<String> informations){
        contenuOngletVaisseaux.getChildren().clear();

        for(String info : informations){
            contenuOngletVaisseaux.getChildren().add(new Text(info));
        }
    }

    public void afficherVoyages(List<Voyage> listeVoyages) {
        for(Voyage voyage : listeVoyages){
            Button button = new Button(voyage.getNom());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    //controleur.chargerInformationsVoyage(voyage);
                    System.out.println(voyage.getNom());
                }
            });
            contenuOngletVoyages.getChildren().add(button);
        }
    }
}
