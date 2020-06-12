package modele;

import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Soldat extends Personnage{

	public Soldat(Environnement e, String nom) {
		super(((int)(Math.random()*(191-128)+1)+128), ((int)(Math.random()*(20-3)+1)), e, nom, 80, 15, 15, new Epee());
	}

}
