package fr.eni.reversi;

public class Reversi {

	public static void main(String[] args) {
		Plateau plateau;
		Joueur joueur1, joueur2;
		boolean gagne = false, quitter = false;
		
		do {
			plateau = new Plateau();
			do {
				plateau.jouer(joueur1);
				
				plateau.jouer(joueur2);
			} while(!gagne);
			quitter = demanderSiOnContinue();
		} while(!quitter);

	}

}
