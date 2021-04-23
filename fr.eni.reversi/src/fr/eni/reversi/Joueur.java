package fr.eni.reversi;

public interface Joueur {
	public int[] jouer(Plateau plateau, Pion pion);
	public String getNom();
}
