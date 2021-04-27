package fr.eni.reversi;

public class JoueurMachine implements Joueur {

	private String nom;

	public JoueurMachine() {
		this.nom = "DEUS EX MACHINA";
	}
	@Override
	public int[] jouer(Plateau plateau, Pion pion) {
		Case meilleurCoup = plateau.getBestMove();
		return meilleurCoup == null ? new int[] {-1,-1}: meilleurCoup.getXY();
	}

	@Override
	public String getNom() {
		return this.nom;
	}

}
