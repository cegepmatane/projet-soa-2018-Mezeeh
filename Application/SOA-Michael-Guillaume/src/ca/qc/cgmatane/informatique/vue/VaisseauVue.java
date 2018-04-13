package ca.qc.cgmatane.informatique.vue;

import ca.qc.cgmatane.informatique.action.Controleur;
import ca.qc.cgmatane.informatique.modele.Vaisseau;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.List;

public class VaisseauVue extends Application{
    protected Controleur controleur;

    protected String nomFenetre = "Service Voyage";
    protected int largeurFenetre = 600,
            hauteurFenetre = 400;

    protected VBox racine;

    @Override
    public void start(Stage scenePrincipal) throws Exception {
        racine = new VBox();
        scenePrincipal.setScene(new Scene(racine,largeurFenetre, hauteurFenetre));
        scenePrincipal.setTitle(nomFenetre);
        scenePrincipal.show();
        controleur = new Controleur(this);
    }

    public void afficherVaisseaux(List<Vaisseau> listeVaisseaux) {
        for(Vaisseau vaisseau : listeVaisseaux){
            Button button = new Button(vaisseau.getNom());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    controleur.chargerInformationsVaisseau(vaisseau);
                }
            });
            racine.getChildren().add(button);
        }
    }

    public void afficherInformationsVaisseau(List<String> informations){
        racine.getChildren().clear();

        for(String info : informations){
            racine.getChildren().add(new Text(info));
        }
    }
}
