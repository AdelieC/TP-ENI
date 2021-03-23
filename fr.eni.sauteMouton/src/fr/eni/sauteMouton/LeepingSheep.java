package fr.eni.sauteMouton;

public class LeepingSheep {
	final char LEAPING_LEFT = '<';
	final char LEAPING_RIGHT = '>';
	final char FREE_SPOT = ' ';
	
	public static void main(String[] args) {
		char[] gameBoard;
		final String[] LEVELS = {"facile", "moyen", "difficile"};
		final int[] SIZES = {3, 5, 7};
		int size = '3';
		
		System.out.println("Bienvenue au jeu du saute-mouton! Essayez de faire passer les moutons de chaque équipe de l'autre côté.");
		size = chooseLevel(LEVELS, SIZES);
		init(gameBoard, size);
		play(gameBoard);
		
	}

	private static int chooseLevel(String[] lEVELS, int[] sIZES) {
		
		return 0;
	}

}
