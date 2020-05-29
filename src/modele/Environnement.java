package modele;

import java.util.ArrayList;

public class Environnement {

	private int longueur;
	private int hauteur;	
	private ArrayList<Personnage> personnage;
	private int nbTours;
	

	public Environnement(int width, int height) {
		super();
		this.longueur = width;
		this.hauteur = height;
		this.nbTours = 0;
		this.personnage= new ArrayList<>();
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

	public void ajouter(Personnage p){
		personnage.add(p);
	}

	public boolean dansTerrain(int x, int y){
		return (0 <= x && x<this.longueur && 0<=y && y< this.hauteur);
	}

	public void unTour(){

	}



}

