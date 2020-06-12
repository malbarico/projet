package modele;

import java.util.Random;

import com.sun.prism.Surface;

public class Personnage {

	private String nom;
	private int ptVie;
	private int ptAttaque;
	private int ptDefense;
	private Arme arme;
	private int x,y;
	private int v = 30; // vitesse de deplacement
	private int dx,dy ;// direction 
	protected Environnement environnement;
	private String id;
	private static int compteur;

	public Personnage(int x, int y, Environnement environnement, String nom, int ptVie, int ptAttaque, int ptDefense, Arme arme) {
		this.nom=nom;
		this.ptVie=ptVie;
		this.ptAttaque=ptAttaque;
		this.ptDefense=ptDefense;
		this.arme=arme;
		this.x = x;
		this.y = y;
		this.environnement=environnement;
		this.compteur++;
		this.id ="#p"+compteur;
	}

	public String getNom() {
		return this.nom;
	}

	public int getPtVie() {
		return this.ptVie;
	}

	public int getPtAttaque() {
		return this.ptAttaque;
	}

	public int getPtDefense() {
		return this.ptDefense;
	}

	public void attaque(Personnage p) {
		int ptD=this.ptAttaque;

		ptD+=this.arme.getPtAttaque();
		ptD=ptD-p.getPtDefense();
		p.ptVie=p.getPtVie()-ptD;
	}

	public  int getX() {
		return x;
	}

	public  int getY() {
		return y;
	}
	
	public  int setX(int n) {
		return x = n;
	}

	public  int setY(int n) {
		return y = n;
	}

	public String getId() {
		return id;
	}
	
	public void directionBas() {
		this.dx = Math.round(this.x/32);
		this.dy = Math.round((this.y+v)/32);
		if(this.environnement.surLaRoute(dy, dx)==true) {
			this.y+=v;
		}
	}
	
	public void directionDeGaucheADroite() {
		this.dx = Math.round((this.x+v)/32);
		this.dy = Math.round(this.y/32);
		if(this.environnement.surLaRoute(dy, dx)==true) {
			this.x+=v;
		}
	}
	
	public void directionDroiteAGauche() {
		this.dx = Math.round((this.x-v)/32);
		this.dy = Math.round(this.y/32);
		if(this.environnement.surLaRoute(dy, dx)==true) {
			this.x-=v;
		}
	}


	public void deplacer() {
		System.out.println("x:" + this.x + " y: " + this.y);
		if((this.x>=4*32 && this.x<=6*32) && (this.y>=1 && this.y<=3*32)) { //first : down
			directionBas(); // les parametres sont pour placer aléatoire la perso: x , vertical
		}
		else if((this.x>=4*32 && this.x<=15*32) && (this.y>=3*32 && this.y<=5*32)) { //second : left to right
			directionDeGaucheADroite(); // y : horizontal
		}
		else if((this.x>=15*32 && this.x<=17*32) && (this.y>=3*32 && this.y<=7*32)) { //third : down
			directionBas();
		}
		else if ((this.x>=4*32 && this.x<=17*32) && (this.y>=7*32 && this.y<=9*32)) { //fourth : right to left
			directionDroiteAGauche();
		}
		else if ((this.x>=2*32 && this.x<=4*32) && (this.y>=7*32 && this.y<=12*32)) { //fifth : down
			directionBas();
		}
		else if ((this.x>=2*32 && this.x<=13*32) && (this.y>=12*32 && this.y<=14*32)) { //sixth : left to right
			directionDeGaucheADroite();
		}
		else if ((this.x>=13*32 && this.x<=15*32) && (this.y>=12*32 && this.y<=17*32)) { //seventh : down
			directionBas();
		}
		else { //last : right to left
			if(this.x>=1 && this.x<7*32) {
				//devant chateau
				System.out.println("terminé : devant chateau");
			}
			else {
				directionDroiteAGauche();
			}
		}

	}

	public boolean estVivant() {
		if(this.ptVie <=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void meurt() {
		this.ptVie = 0;
	}
	
	public void setCoord(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	
	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", ptVie=" + ptVie + ", ptAttaque=" + ptAttaque + ", ptDefense=" + ptDefense
				+ ", arme=" + arme + "]";
	}



}

