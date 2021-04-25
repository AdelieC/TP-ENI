package fr.eni.reversi;

public class Reversi {

	public static void main(String[] args) {
		Plateau plateau;
		boolean partieFinie = false, quitter = false;
		
		Outils.welcomeMsg("REVERSI", "poser le plus de pions possible de votre couleur.",
				"Il faut poser 2 de vos pions de chaques côtés d'un alinement de pions adverses.",
				"Si vous ne pouvez pas poser de pion, passez votre tour.",
				"Une fois le plateau rempli, celui qui a posé le plus de pions a gagné.");
		do {
			plateau = new Plateau();
			plateau.afficher();
			do {
				plateau.jouer();
				partieFinie = plateau.afficher();
			} while(!partieFinie);
			quitter = Outils.quitter();
		} while(!quitter);
		Outils.closeScan();

	}

}
