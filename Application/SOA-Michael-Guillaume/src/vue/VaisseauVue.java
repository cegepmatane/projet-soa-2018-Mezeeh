package vue;

import action.Controleur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class VaisseauVue extends Application{
    protected Controleur controleur;

    protected String nomFenetre = "Service Voyage";
    protected int largeurFenetre = 600,
            hauteurFenetre = 400;

    protected TextFlow racine;

    @Override
    public void start(Stage scenePrincipal) throws Exception {
        racine = new TextFlow();
        scenePrincipal.setScene(new Scene(racine,largeurFenetre, hauteurFenetre));
        scenePrincipal.setTitle(nomFenetre);
        scenePrincipal.show();
        controleur = new Controleur(this);
    }
}
