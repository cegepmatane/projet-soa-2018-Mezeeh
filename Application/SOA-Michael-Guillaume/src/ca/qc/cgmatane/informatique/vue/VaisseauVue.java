package ca.qc.cgmatane.informatique.vue;

import ca.qc.cgmatane.informatique.action.Controleur;
import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.modele.Voyage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
                    contenuOngletVoyages,
                    contenuOngletAjouterVoyage;

    protected TabPane onglets;
    protected Tab ongletVaisseaux,
            ongletVoyages,
            ongletAjouterVoyage;

    protected Stage scenePrincipal;

    @Override
    public void start(Stage scenePrincipal) throws Exception {
        onglets = new TabPane();

        this.scenePrincipal = scenePrincipal;
        scenePrincipal.setScene(new Scene(onglets,largeurFenetre, hauteurFenetre));
        scenePrincipal.setTitle(nomFenetre);
        
        this.ajouterOnglets();

        onglets.getTabs().add(ongletVaisseaux);
        onglets.getTabs().add(ongletVoyages);
        onglets.getTabs().add(ongletAjouterVoyage);
        scenePrincipal.show();
        controleur = new Controleur(this);
    }
    private void ajouterOnglets()
    {
    	 ongletVaisseaux = new Tab("Vaisseaux");
         ongletVaisseaux.setClosable(false);
         contenuOngletVaisseaux = new VBox();
         ongletVaisseaux.setContent(contenuOngletVaisseaux);

         ongletVoyages = new Tab("Voyages");
         ongletVoyages.setClosable(false);
         contenuOngletVoyages = new VBox();
         ongletVoyages.setContent(contenuOngletVoyages);
         
         ongletAjouterVoyage = new Tab("Ajouter un voyage");
         ongletAjouterVoyage.setClosable(false);
         contenuOngletAjouterVoyage = new VBox();
         ongletAjouterVoyage.setContent(contenuOngletAjouterVoyage);
         
    }
    public void afficherAjouterVoyage()
    {
    	HBox nom = new HBox();
    	Label labelNom = new Label("nom : ");
    	TextField champNom = new TextField();
    	nom.getChildren().addAll(labelNom, champNom);
    	
    	HBox destination = new HBox();
    	Label labelDestination = new Label("destination : ");
    	TextField champDestination = new TextField();
    	destination.getChildren().addAll(labelDestination, champDestination);
    	
    	
    	HBox description = new HBox();
    	Label labelDescription = new Label("description : ");
    	TextField champDescription = new TextField();
    	description.getChildren().addAll(labelDescription, champDescription);
    	
    	HBox distance = new HBox();
    	Label labelDistance= new Label("distance : ");
    	TextField champDistance = new TextField();
    	distance.getChildren().addAll(labelDistance, champDistance);
    	
    	HBox idVaisseau = new HBox();
    	Label labelIdVaisseau = new Label("idVaisseau : ");
    	TextField champIdVaisseau = new TextField();
    	idVaisseau.getChildren().addAll(labelIdVaisseau, champIdVaisseau);
    	
    	Button bouttonEnvoyer = new Button("envoyer");
    	bouttonEnvoyer.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controleur.ajouterVoyage(champNom.getText(), champDestination.getText(), champDescription.getText(), champDistance.getText(), champIdVaisseau.getText());
				champNom.setText("");
				champDestination.setText("");
				champDescription.setText("");
				champDistance.setText("");
				champIdVaisseau.setText("");
			}
        });
    	
    	contenuOngletAjouterVoyage.getChildren().addAll(nom, destination, description, distance, idVaisseau, bouttonEnvoyer);
    }
    public void afficherVaisseaux(List<Vaisseau> listeVaisseaux) {
    	contenuOngletVaisseaux.getChildren().clear();
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
            Text texte = new Text(info);
            texte.wrappingWidthProperty().bind(scenePrincipal.widthProperty().subtract(15));
            // contenuOngletVaisseaux.getChildren().add(new Text(info));
            contenuOngletVaisseaux.getChildren().add(texte);
        }
        Button boutton = new Button("retour");
        boutton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controleur.afflicherListeVaisseaux();
			}
        });
        contenuOngletVaisseaux.getChildren().add(boutton);
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
