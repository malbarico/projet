package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlateauTerrain {

	private char[][] tab = new char[20][20];
	private int numLignes = 0;
	private int numCol = 0;
	
	public PlateauTerrain() {
		lireMap();
	}
	public void lireMap() {
		try {
			BufferedReader br=new BufferedReader(new FileReader("src/vue/map.csv"));
			String line=br.readLine();
			while(line!=null){
				numLignes++;
				StringTokenizer st=new StringTokenizer(line,",");
				numCol=0;
				while(st.hasMoreTokens()) {
					char carLu=st.nextToken().charAt(0);
					numCol++;
					tab[numLignes-1][numCol-1] = '0';
					if(carLu=='1') {
						tab[numLignes-1][numCol-1] = '1';
					}
				}
				line=br.readLine();
			}
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
	public char valCase(int x, int y) {
		return tab[x][y];
	}

	public int getNumLignes() {
		return numLignes;
	}

	public int getNumCol() {
		return numCol;
	}
	
	
	
	
	
}
