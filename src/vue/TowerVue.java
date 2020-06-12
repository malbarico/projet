package vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modele.Personnage;
import modele.Soldat;
import modele.Tower;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TowerVue extends ImageView{

	private Personnage t;
	
	public TowerVue(Personnage t) {
		super();
		this.t = t;
	}

	public void creerSprite() {
		if( this.t instanceof Tower){
			Image image = null;
			try {
				image = new Image(new FileInputStream("src/img/tower1.png"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			this.setImage(image);
			initialize();
		}
		else{
			Image image = null;
			try {
				image = new Image(new FileInputStream("src/img/monstre.png"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			this.setImage(image);
			initialize();
		}
		
		this.setOnMouseClicked(e-> System.out.println("clic sur acteur"+ e.getSource()));		
	}
	
	public void initialize() {
		this.setId(t.getId());	
		this.setTranslateX(t.getX()-30);
		this.setTranslateY(t.getY()-30);
	}
	
	
	
	
}
