package modele;

import java.util.ArrayList;

public class Environnement {

	private int longueur;
	private int hauteur;	
	private ArrayList<Personnage> personnage;
	private ArrayList<Tower> towers;
	private int nbTours;
	private PlateauTerrain pt;
	

	public Environnement(int width, int height, PlateauTerrain pt) {
		super();
		this.longueur = width;
		this.hauteur = height;
		this.pt = pt;
		this.nbTours = 0;
		this.personnage= new ArrayList<>();
		this.towers=new ArrayList<>();
	}

	public  int getNbTours(){
		return this.nbTours;	
	}

	public  void setNbTours(int n){
		this.nbTours=n;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public ArrayList<Personnage> getActeurs() {
		return personnage;
	}
	
	public ArrayList<Tower> getTowers() {
		return towers;
	}
	
	public int numPersonnages() {
		return this.personnage.size();
	}

	public void ajouter(Personnage p){
		personnage.add(p);
	}
	
	public void ajouterTD(Tower t){
		towers.add(t);
	}

	public boolean dansTerrain(int x, int y){
		return (0 <= x && x<this.longueur && 0<=y && y< this.hauteur);
	}
	
	public boolean surLaRoute(int x, int y) {
		System.out.println(this.pt.valCase(x, y) + " dx:" + x + " dy: " + y);
		if(this.pt.valCase(x, y)=='0') {
			return false;
		}
		else {
			return true;
		}
	}



}

