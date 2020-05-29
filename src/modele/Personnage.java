package modele;

import java.util.Random;

public class Personnage {

	private String nom;
	private int ptVie;
	private int ptAttaque;
	private int ptDefense;
	private Arme arme;
	private int x,y;
	private int v; // vitesse de deplacement
	private int dx,dy ;// direction 
	protected Environnement environnement;
	public static int compteur=0;
	private String id;

	public Personnage(int x, int y, Environnement environnement, String nom, int ptVie, int ptAttaque, int ptDefense, Arme arme) {
		this.nom=nom;
		this.ptVie=ptVie;
		this.ptAttaque=ptAttaque;
		this.ptDefense=ptDefense;
		this.arme=arme;
		this.x = ((int)(Math.random()*(192-128)+1)+128);
		this.y = 2;
		this.environnement=environnement;	
	}

	public Personnage(int v,Environnement environnement,int ptVie) {
		this.ptVie=ptVie;
		Random random=new Random();
		int x = random.nextInt(environnement.getLongueur()-1);
		int y=random.nextInt(environnement.getHauteur()-1);
		this.x=x;
		this.y = y;
		this.v = v;
		this.environnement=environnement;	
		this.id="A"+compteur;
		compteur++;
//		this.tirerDirection();
		System.out.println("y" + y + "x" +x);
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

	//début de chemin
	public double getCheminX() {
		return 32*4;
	}

	public String getId() {
		return id;
	}
/*
	private void tirerDirection(){
		Random random=new Random();
		int randomInt = random.nextInt(3);
		dx=randomInt-1;
		if(dx==0){
			randomInt=random.nextInt(2)-1;
			if(randomInt==0){
				dy=-1;
			}
			else{
				dy=1;
			}
		}
		else{
			dy=random.nextInt(3)-1;
		}
	}

	//permet de savoir si une action probabiliste se réalise 
	public static boolean reussitProba(double pourcent){
		double x= Math.random();
		double pp=pourcent/100;
		return (x<=pp);
	}


	public void seDeplace(){
		// 20% de chance de changer de direction
		// if(Math.random()*100< pourentageRepro )

		int nposX=this.getX()+(this.v*dx);
		int nposY=this.getY()+(this.v*dy);
		while(!environnement.dansTerrain(nposX, nposY)){
			tirerDirection();
			nposX=this.getX()+(this.v*dx);
			nposY=this.getY()+(this.v*dy);
		}
		this.x=nposX;
		this.y=nposY;		
	}
*/
	
	/*public void deplacer() {
		v = 5; //exemple
		vue.DecorGazon.surLaRoute(this.x, this.y);
		
	}*/

	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", ptVie=" + ptVie + ", ptAttaque=" + ptAttaque + ", ptDefense=" + ptDefense
				+ ", arme=" + arme + "]";
	}



}

