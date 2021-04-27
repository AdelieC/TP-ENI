package fr.eni.reversi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau {
	private static final int TAILLE = 8;
	private boolean modeIA;
	private Pion[][] plateau;
	private Pion pionCourant;
	private int nbTours = 0;
	
	
	public Plateau() {
		this.modeIA = this.choisirMode();
		this.pionCourant = Pion.NOIR;
		this.initialiser();
	}
	
	private void initialiser() {
		Pion.setJoueurs(this.modeIA);
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
			tmp = Outils.getInputInt("votre choix", 1, 2);
		} while(tmp != 1 && tmp != 2);
		return tmp == 1;
	}
	
	public boolean afficheEtat() {
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
		System.out.println("JOUEUR " + this.pionCourant.getJoueur().getNom() + "(" + this.pionCourant.getSymbole() + "), C'EST À VOUS!");
		return this.partieFinie();
	}
	
	private boolean partieFinie() {
		return Pion.LIBRE.getNombreDePions() == 0;
	}
	
	public int tester(Pion pion, int ligne, int colonne) {
		int nbPionsAChanger = 0;
		//1) position == libre?
		if(plateau[ligne][colonne] == Pion.LIBRE) {
		
			//2) il faut qu'il y ait un acoloment de pions adverses à côté de la position actuelle PUIS 1 pion à soi
			for(int i = -1; i<=1; i++) {
				for(int j = -1; j<=1; j++) {
					if(i != 0 || j != 0) nbPionsAChanger += testerDir(pion.autrePion(), ligne + i, colonne + j, i, j);
				}
			}
		}
		return nbPionsAChanger;
	}
	
	public int testerDir(Pion adverse, int ligneDir, int colDir, int i, int j) {
		int nbPions = 0;
		
		while(ligneDir < TAILLE && colDir < TAILLE
				&& ligneDir >= 0 && colDir >= 0
				&& this.plateau[ligneDir][colDir] == adverse) {
			nbPions++;
			ligneDir += i;
			colDir += j;
		}
		return (ligneDir < TAILLE && colDir < TAILLE
				&& ligneDir >= 0 && colDir >= 0
				&& this.plateau[ligneDir][colDir] == adverse.autrePion()) ? nbPions : 0;
	}
	
	public boolean peutJouer(Pion pion) {
		int nbPions = 0;
		for(int i = 0; i<TAILLE; i++) {
			for(int j = 0; j<TAILLE; j++) {
				nbPions += tester(pion, i, j);
			}
		}
		return nbPions > 0;
	}
	
	public boolean poser(Pion pion, int ligne, int colonne) {
		int nbPionsAChanger = 0;
		boolean pionPose = false;
		//1) position == libre et jouable ?
		if(plateau[ligne][colonne] == Pion.LIBRE) {
			
			//a) alors je pose le pion sur la case concernée
			plateau[ligne][colonne] = pion;
			
			//b) puis je change de couleur tous les pions possibles
			for(int i = -1; i<=1; i++) {
				for(int j = -1; j<=1; j++) {
					nbPionsAChanger = 0;
					if(i != 0 || j != 0) {
						nbPionsAChanger += testerDir(pion.autrePion(), ligne + i, colonne + j, i, j);
						for(int n = 1; n<=nbPionsAChanger; n++) this.plateau[ligne + n*i][colonne + n*j] = pion;
						
						//d) enfin je mets à jour le nombre de pions de chaques couleurs
						this.pionCourant.updateNbPions(nbPionsAChanger);
					}
				}
			}
			pionPose = true;
		}
		return pionPose;
	}
	
	public boolean coupJoueur() {
		int[] coordonnees = {-1, -1};
		int joueursCoinces = 0;
		
		if(this.peutJouer(this.pionCourant)) {
			coordonnees = this.pionCourant.getJoueur().jouer(this, this.pionCourant);
		}
		if(coordonnees[0] < 0 || coordonnees[1] < 0 ) {
			joueursCoinces++;
			System.out.println("Le joueur " + this.pionCourant.getJoueur().getNom() + " n'a pas pu jouer. Il passe son tour.");
		} else {
			this.poser(pionCourant, coordonnees[0], coordonnees[1]);
		}
		this.joueurSuivant();
		return joueursCoinces == 2;
	}
	
	public void joueurSuivant() {
		this.pionCourant = this.pionCourant.autrePion();
	}

	public void afficherResultats(boolean partieFinie, boolean joueursCoinces) {
		if(partieFinie) this.afficherScores();
		if(joueursCoinces) this.afficherCoinces();
	}

	private void afficherCoinces() {
		System.out.println("Uhoh...il semblerait que les 2 joueurs soient coincés! La partie doit donc prendre fin, désolé!");
	}

	private void afficherScores() {
		System.out.println("Partie terminée, l'heure du verdict a sonné!");
		System.out.println(Pion.NOIR.getJoueur().getNom() + ", VOUS AVEZ POSÉ " + Pion.NOIR.getNombreDePions() + " PIONS.");
		System.out.println(Pion.BLANC.getJoueur().getNom() + ", VOUS AVEZ POSÉ " + Pion.BLANC.getNombreDePions() + " PIONS.");
		System.out.println("BRAVO AU JOUEUR " + Pion.getGagnant().getJoueur().getNom() + " QUI A GAGNÉ CETTE PARTIE!!!");
	}

	public int getTAILLE() {
		return TAILLE;
	}
	
	public Case getBestMove() {
		List <Case> casesJouables = new ArrayList<>();
		int score = 0;
		for(int i = 0; i<TAILLE; i++) {
			for(int j = 0; j<TAILLE; j++) {
				score = this.tester(this.pionCourant, i, j);
				if(score > 0) casesJouables.add(new Case(i, j, score));
			}
		}
		return casesJouables.isEmpty() ? null : Collections.max(casesJouables);
	}
}
