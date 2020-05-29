package modele;

import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Soldat extends Personnage{


	public Soldat(int x, int y, Environnement e, String nom) {
		super(x, y, e, nom, 80, 15, 15, new Epee());
	}
	/*
	public void setCoord(int x, int y) {
		//pour placer un acteur sur le bord haut du décor
		Soldat soldat=new Soldat("soldat");
		Random rand=new Random();
		int coordX=0;
		do {
			coordX=rand.nextInt(this.environnement.getLongueur());
		}
		while(!monDecor.surLaRoute(coordX,0));
		Soldat.setCoord(coordX, 0);
		this.env.ajouterActeur(fourmi);
		Shape c=fourmi.dessiner();
		this.terrainDeJeu.getChildren().add(c);
	}
	

	*/
	

	
}
