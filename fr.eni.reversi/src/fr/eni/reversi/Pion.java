package fr.eni.reversi;

public enum Pion {
	NOIR('●', 2),
	BLANC('o', 2),
	LIBRE('·', 60);
	
	private int nombre;
	private char symbole;
	
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
}
