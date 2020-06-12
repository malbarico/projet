package vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChateauVue extends ImageView{

	public ChateauVue() {
		super(new Image("img/castlepng.png"));
		this.initialisationChateauVue();
	}
	
	public void initialisationChateauVue(){
		this.setFitHeight(170);
		this.setFitWidth(150);
		this.setFocusTraversable(false);
		this.setX(70);
		this.setY(470);
	}
	
}
