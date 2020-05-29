package vue;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modele.*;

public class PersonnageVue {

	private Pane terrainDeJeu;
	
	public PersonnageVue(Pane terrainDeJeu, Personnage p) {
		this.terrainDeJeu=terrainDeJeu;
		creerSprite(p);
	}
	
	public void creerSprite(Personnage a) {
		Circle r;
		if( a instanceof Soldat){
			r= new Circle(3);
			r.setFill(Color.RED);
		}
		else{
			r= new Circle(2);
			r.setFill(Color.WHITE);
		}
		// ils ont le meme identifiant
		r.setId(a.getId());
		r.setTranslateX(a.getX());
		r.setTranslateY(a.getY());
		r.setOnMouseClicked(e-> System.out.println("clic sur acteur"+ e.getSource()));		
		terrainDeJeu.getChildren().add(r);
	}
	
}
