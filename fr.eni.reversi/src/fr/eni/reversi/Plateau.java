package fr.eni.reversi;

public class Plateau {
	private static final int TAILLE = 8;
	private static final int[][] DIRECTIONS = {
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	};
	private boolean modeIA;
	private Pion[][] plateau;
	private Pion pionCourant;
	
	
	public Plateau() {
		this.modeIA = this.choisirMode();
		this.pionCourant = Pion.NOIR;
		this.initialiser();
	}
	
	private void initialiser() {
		Pion.setJoueur(this.modeIA);
		this.plateau = new Pion[TAILLE][TAILLE];
		
		//1) remplissage avec des cases vides
		for(int i = 0; i<TAILLE; i++) {
			for(int j = 0; j<TAILLE; j++) {
				this.plateau[i][j] = Pion.LIBRE;
			}
		}
		
		//2) positionnement des 4 premiers pions
		this.plateau[TAILLE / 2][TAILLE / 2] = Pion.BLANC;
		this.plateau[TAILLE / 2 - 1][TAILLE / 2 - 1] = Pion.BLANC;
		this.plateau[TAILLE / 2][TAILLE / 2 - 1] = Pion.NOIR;
		this.plateau[TAILLE / 2 - 1][TAILLE / 2] = Pion.NOIR;
	}
	
	private boolean choisirMode() {
		int tmp = -1;
		do {
		if(tmp > 0) System.err.println("Le choix entré n'existe pas! Réessayez!");
			System.out.println("Choisissez le mode de jeu :");
			System.out.println("1 = un seul joueur contre l'ordinateur");
			System.out.println("2 = deux joueurs humains");
			tmp = Outils.getInputInt("votre choix", 1);
		} while(tmp != 1 && tmp != 2);
		return tmp == 1;
	}
	
	public boolean afficher() {
		System.out.println();
		System.out.println("******************");
		System.out.println("  VOTRE PLATEAU");
		System.out.println("******************");
		for(int i = 0; i<=TAILLE; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0; i<TAILLE; i++) {
			System.out.print((i + 1) + " ");
			for(int j = 0; j<TAILLE; j++) {
				System.out.print(this.plateau[i][j].getSymbole() + " ");
			}
			System.out.println();
		}
		System.out.println();
		return this.partieFinie();
	}
	
	private boolean partieFinie() {
		return Pion.LIBRE.getNombreDePions() == 0;
	}
	
	public int tester(Pion pion, int colonne, int ligne) {
		int nbDePionsAChanger = 0;
		for(int i = 0; i<DIRECTIONS.length; i++) {
			testerDir(pion.autrePion(), colonne, ligne, i);
		}
		return nbDePionsAChanger;
	}
	public int testerDir(Pion adverse, int colonne, int ligne, int indiceDirection) {
		int nbPions = 0;
		
		return nbPions;
	}
	
	public boolean peutJouer(Pion pion) {
		boolean peutJouer = false;
		
		return peutJouer;
	}
	
	public void poser(Pion pion, int colonne, int ligne) {
		
	}
	
	public void jouer() {
		
		
		this.joueurSuivant();
	}
	public void joueurSuivant() {
		this.pionCourant = this.pionCourant.autrePion();
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("C'est maintenant au joueur qui possède les pions " + this.pionCourant.getSymbole() + " de jouer!");
	}
}
