package fr.eni.reversi;

public class JoueurHumain implements Joueur {
	private String nom;
	
	public JoueurHumain(Pion pion) {
		this.setNom(pion);
	}
	
	private void setNom(Pion pion) {
		this.nom = Outils.getInputString("un nom pour le joueur " + pion.getSymbole(), 30).toUpperCase();
	}

	@Override
	public int[] jouer(Plateau plateau, Pion pion) {
		int y = -1, x = -1;
		boolean coupValide = false;
		
		do {
			if(y >= 0 || x >= 0) System.out.println("ERREUR : Vous ne pouvez pas poser votre pion à la case indiquée, réessayez !");
			y = Outils.getInputInt("le numéro de la ligne sur laquelle vous voulez placer votre pion", 1, plateau.getTAILLE()) - 1;
			x = Outils.getInputInt("le numéro de la colonne sur laquelle vous voulez placer votre pion", 1, plateau.getTAILLE()) - 1;
			coupValide = (plateau.tester(pion, y, x) > 0);
		} while(!coupValide);
		
		return new int[] { y, x };
	}

	@Override
	public String getNom() {
		return this.nom;
	}

}
