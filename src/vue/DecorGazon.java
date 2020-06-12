package vue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.rmi.server.Operation;
import java.util.StringTokenizer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import modele.PlateauTerrain;
import Outils.Operations;

public class DecorGazon {

	private TilePane support;
	private PlateauTerrain pt;
	
	public DecorGazon(TilePane tp, PlateauTerrain pt) {
		this.support=tp;
		this.pt=pt;
		afficherPlateau();
	}
	
	public void afficherPlateau() {
		File gazon=new File("src/img/gazon.png");
		Image imgGazon=new Image(gazon.toURI().toString());
		
		File pierres=new File("src/img/pierres.png");
		Image imgPierres=new Image(pierres.toURI().toString());
		for(int x=0 ; x<pt.getNumCol() ; x++) {
			for (int y=0; y<pt.getNumLignes(); y++) {
			
				Image imageCourante;
				if(pt.valCase(x,y)=='1') {
					imageCourante=imgPierres;
				}
				else {
					imageCourante=imgGazon;
				}
				ImageView imgv = new ImageView(imageCourante);
				this.support.getChildren().add(imgv);
			}
		}	
	}

	
	}
