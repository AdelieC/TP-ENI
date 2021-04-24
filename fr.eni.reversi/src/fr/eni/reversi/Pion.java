package fr.eni.reversi;

public enum Pion {
	NOIR('●', 2),
	BLANC('o', 2),
	LIBRE('·', 60);
	
	private int nombre;
	private char symbole;
	private Joueur joueur;
	
	private Pion(char symbole, int nombre) {
		this.symbole = symbole;
		this.nombre = nombre;
	}
	
	public int getNombreDePions() {
		return this.nombre;
	}
	
	public char getSymbole() {
		return this.symbole;
	}
	
	public Pion autrePion() {
		return this == BLANC ? Pion.NOIR : Pion.BLANC;
	}
	
	public void coup(int nbDePionsAChanger) {
		this.nombre += nbDePionsAChanger;
		this.autrePion().nombre -= nbDePionsAChanger;
		Pion.LIBRE.nombre--;
	}
	
	public static void setJoueur(int mode) {
		switch(mode) {
			case 1:
				Pion.NOIR.joueur = new JoueurHumain();
				Pion.BLANC.joueur = new JoueurHumain();
				break;
			case 2:
				Pion.NOIR.joueur = new JoueurHumain();
				Pion.BLANC.joueur = new JoueurMachine();
				break;
			default:
				System.err.println("Erreur : le mode choisi n'est pas reconnu...");
				break;
		}
	}
}
