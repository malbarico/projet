package modele;

import vue.TowerVue;

public class Tower extends Personnage{
	
	int x;
	int y;
	int dx, dy;
	private Environnement e;

	public Tower(Environnement e, String nom) {
		super(((int)(Math.random()*(640-1)+1)+1), ((int)(Math.random()*(640-1)+1)+1), e, nom, 100, 20, 20, new Arc());
	}
	
	public Tower(int x, int y, Environnement e, String nom) {
		super(x, y, e, nom, 100, 15, 15, new Arc());
	}
	
	public void bienPlacer(int x,int y, TowerVue td) {
		do{
			td.creerSprite();
		}while(e.surLaRoute(y, x)==false);
	}
	
}
