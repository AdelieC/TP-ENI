package fr.eni.reversi;

public class Plateau {
	private static final int TAILLE = 8;
	private int mode;
	private Pion[][] plateau;
	
	
	public Plateau() {
		this.mode = this.choisirMode();
		this.initialiser();
	}
	
	private void initialiser() {
		Pion.setJoueur(this.mode);
		this.plateau = new Pion[TAILLE][TAILLE];
		
		//1) remplissage avec des cases vides
		for(Pion[] ligne : plateau) {
			for(Pion chaqueCase : ligne) {
				chaqueCase = Pion.LIBRE;
			}
		}
		
		//2) positionnement des 4 premiers pions
		this.plateau[TAILLE / 2][TAILLE / 2] = Pion.BLANC;
		this.plateau[TAILLE / 2 - 1][TAILLE / 2 - 1] = Pion.BLANC;
		this.plateau[TAILLE / 2][TAILLE / 2 - 1] = Pion.NOIR;
		this.plateau[TAILLE / 2 - 1][TAILLE / 2] = Pion.NOIR;
	}
	
	private int choisirMode() {
		int tmp = 0;
		System.out.println("Choisissez le mode de jeu :");
		System.out.println("- 1 = un seul joueur contre l'ordinateur");
		System.out.println("- 2 = deux joueurs humains");
		tmp = Outils.getInputInt("votre choix", 1);
		return tmp;
	}
	
	public void afficher() {
		for(Pion[] ligne : plateau) {
			for(Pion chaqueCase : ligne) {
				System.out.print(chaqueCase.getSymbole());
			}
			System.out.println();
		}
	}
	
	public int tester(Pion pion, int colonne, int ligne) {
		int nbDePionsAChanger = 0;
		
		return nbDePionsAChanger;
	}
	
	public boolean peutJouer(Pion pion) {
		boolean peutJouer = false;
		
		return peutJouer;
	}
	
	public void poser(Pion pion, int colonne, int ligne) {
		
	}
	
	public void jouer(Joueur joueur) {
		
	}
}
