package modele;

public class Geant extends Personnage{

	public Geant(Environnement e, String nom) {
		super(((int)(Math.random()*(191-128)+1)+128), ((int)(Math.random()*(20-3)+1)), e, nom, 80, 10, 15, new Feu());
	}
}
