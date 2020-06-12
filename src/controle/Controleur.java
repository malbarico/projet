package controle;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import modele.*;
import vue.*;


public class Controleur implements Initializable{

	private Environnement env;
	private ChateauVue chateauVue;	
	private Timeline gameLoop;
	private int temps;
	private Soldat soldat1;
	private Monstre monstre2;
	private Geant geant3;
	private boolean poseTour;
	private int typeEnnemis;

	@FXML
	private StackPane calques;

	@FXML
	private TilePane plateauDeJeu;

	@FXML
	private Pane terrainDeJeu;

	@FXML
	private BorderPane borderPane;

	public Controleur() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PlateauTerrain pt = new PlateauTerrain();
		this.env=new Environnement(640,640, pt);
		DecorGazon monDecor=new DecorGazon(plateauDeJeu, pt);
		this.chateauVue = new ChateauVue();
		this.terrainDeJeu.getChildren().addAll(chateauVue);
		initAnimation();
		// demarre l'animation
		gameLoop.play();
		this.terrainDeJeu.setOnMouseClicked(ev -> {

            if(this.poseTour) {//on vérifie qu'on a cliqué sur le bouton de création de tour
                Tower t=new Tower(this.env, "TD");
                t.setCoord((int)ev.getX(),(int)ev.getY());
                this.env.ajouterTD(t);
                TowerVue tdvue = new TowerVue(t);
                this.terrainDeJeu.getChildren().add(tdvue);
                t.bienPlacer(t.getY(),t.getX(), tdvue);
                System.out.println(t.getX() + " "+ t.getY());
                this.poseTour=false;//je remets poseTour à false car sinon en cliquant on va recréer des tours sans le vouloir
            }
        });
       
	}
		
	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.5), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					for(int i=0;i<this.env.getActeurs().size();i++) {
						this.env.getActeurs().get(i).deplacer();
						PersonnageVue persovue = (PersonnageVue) this.terrainDeJeu.lookup("#"+this.env.getActeurs().get(i).getId());
						persovue.setX(this.env.getActeurs().get(i).getX());
						persovue.setY(this.env.getActeurs().get(i).getY());
					}
				})
				);
		gameLoop.getKeyFrames().add(kf);
	}

	@FXML
	void addSoldat(ActionEvent event) {
		for(int i =0; i<5; i++) {
			typeEnnemis = ((int)(Math.random()*3)+1);
			if(typeEnnemis==1) {
				soldat1 = new Soldat(env, "soldat1");
				this.env.ajouter(soldat1);
				PersonnageVue persovue = new PersonnageVue(soldat1);
				this.terrainDeJeu.getChildren().add(persovue);
			}
			else if(typeEnnemis==2) {
				monstre2 = new Monstre(env, "soldat2");
				this.env.ajouter(monstre2);
				PersonnageVue persovue = new PersonnageVue(monstre2);
				this.terrainDeJeu.getChildren().add(persovue);
			}
			else if(typeEnnemis==3) {
				geant3 = new Geant(env, "geant3");
				this.env.ajouter(geant3);
				PersonnageVue persovue = new PersonnageVue(geant3);
				this.terrainDeJeu.getChildren().add(persovue);
			}
			else {
				System.out.println("ERREUR: typeEnnemis: " + typeEnnemis);
			}
			
		}
		
	}
	
	 @FXML
	 void ajouteTD(ActionEvent event) {
		 Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Pour ajouter TD, cliquez sur la place vous voulez le mettre");
			alert.showAndWait();
			poserTour();
		
	 }

	@FXML
	void Start(ActionEvent event) {
		
	}

	void poserTour() {
		poseTour = true;
	}


}
