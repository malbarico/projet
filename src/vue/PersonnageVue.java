package vue;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modele.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  

public class PersonnageVue extends ImageView{

	private Personnage p;
	
	public PersonnageVue(Personnage p) {
		super();
		this.p = p;
		creerSprite();
	}
	
	public void creerSprite() {
		if( this.p instanceof Soldat){
			Image image = null;
			try {
				image = new Image(new FileInputStream("src/img/soldat.png"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			this.setImage(image) ;
			initialize();
			}
		else if(this.p instanceof Monstre){
			Image image = null;
			try {
				image = new Image(new FileInputStream("src/img/monstre.png"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			this.setImage(image) ;
			initialize();
		}
		else {
			Image image = null;
			try {
				image = new Image(new FileInputStream("src/img/geant.png"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			this.setImage(image) ;
			initialize();
		}
		
		this.setOnMouseClicked(e-> System.out.println("clic sur acteur"+ e.getSource()));	
		
	}

	//deplacer sprite
	public void seDeplacer() {
		this.setTranslateX(p.getX());
		this.setTranslateY(p.getY());
	}
	
	public void initialize() {
		this.setId(p.getId());
		this.setFitHeight(32);
		this.setFitWidth(32);
		this.setTranslateX(p.getX());
		this.setTranslateY(p.getY());
	}
	
}
