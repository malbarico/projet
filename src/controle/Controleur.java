package controle;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import modele.*;
import vue.*;


public class Controleur implements Initializable{
	
	private Environnement env;
	
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
		this.env=new Environnement(640,640);
		PlateauTerrain pt = new PlateauTerrain();
		DecorGazon monDecor=new DecorGazon(plateauDeJeu, pt);
	}
	
	@FXML
    void addSoldat(ActionEvent event) {
		Soldat soldat1 = new Soldat(180, 0, env, "soldat1");
		this.env.ajouter(soldat1);
		PersonnageVue persovue = new PersonnageVue(terrainDeJeu, soldat1);
    }



}
