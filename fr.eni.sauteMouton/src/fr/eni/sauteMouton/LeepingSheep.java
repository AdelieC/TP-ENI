package fr.eni.sauteMouton;

import java.util.Scanner;

public class LeepingSheep {
	final static char LEAPING_LEFT = '<';
	final static char LEAPING_RIGHT = '>';
	final static char FREE_SPOT = ' ';
	
	public static void main(String[] args) {
		final String[] LEVELS = {"facile", "moyen", "difficile"};
		final int[] SIZES = {3, 5, 7};
		int size = 3;
		
		System.out.println("Bienvenue au jeu du saute-mouton! Essayez de faire passer les moutons de chaque équipe de l'autre côté.");
		size = chooseSize(LEVELS, SIZES);
		char[] gameBoard = init(size);
		play(gameBoard);
		
	}

	private static void play(char[] gameBoard) {
		int input;
		Scanner scan = new Scanner(System.in);
		
		//1) Checking if the user won
		if(won(gameBoard)) {
			System.out.println("Bravo! Vous avez gagné!!");
			
		//2) Checking if the user is stuck
		} else if(stuck(gameBoard)) {
			System.out.println("Vous avez bloqué vos moutons. Désolé mais vous avez perdu.");
			
		//3) Otherwise, enter or continue recursion to play!
		} else {
			//a) showing state of the game :
			show(gameBoard);
			
			//b) asking user to choose a sheep to move
			System.out.println("Choisissez un mouton à faire avancer. Entrez son numéro de case :");
			input = scan.nextInt();
			
			//c) checking if number chosen matches position of a sheep
			if(input < 0 || input > gameBoard.length-1 || gameBoard[input] == FREE_SPOT) {
				System.out.println("Il n'y a pas de mouton à cet endroit... Réessayez.");
				
			//d) moving or not moving sheep :
			} else if(gameBoard[input] == LEAPING_LEFT) {
				tryMove(gameBoard, input, true);
			} else {
				tryMove(gameBoard, input, false);
			}
			play(gameBoard);
		}
		scan.close();
	}

	private static void tryMove(char[] gameBoard, int input, Boolean left) {
		int end = left? 0 : gameBoard.length - 1;
		int next = left? input - 1 : input + 1;
		int jumpable = left? input - 2 : input + 2;
		if(input == end) {
			System.out.println("Impossible d'aller plus loin avec celui-là. Choisissez un autre mouton.");
		} else if(gameBoard[next] == FREE_SPOT) {
			gameBoard[next] = gameBoard[input];
	        gameBoard[input] = FREE_SPOT;
		} else {
			if(gameBoard[jumpable] == FREE_SPOT) {
				gameBoard[jumpable] = gameBoard[input];
	            gameBoard[input] = FREE_SPOT;
			} else {
				System.out.println("Impossible de bouger ce mouton : il n'a pas la place d'avancer");
			}
		}
	}

	private static boolean stuck(char[] gameBoard) {
		// TODO
		return false;
	}

	private static boolean won(char[] gameBoard) {
		// TODO
		return false;
	}

	private static void show(char[] gameBoard) {
		//a) showing numbers of sheep the user can try to move
		System.out.print("| ");
		for(int i = 0; i < gameBoard.length; i++) {
			if(i<10) {
				System.out.print(i);
				System.out.print(" | ");
			} else {
				System.out.print(i);
				System.out.print("| ");
			}
		}
		System.out.println();
		
		//b) showing gameboard
		System.out.print("| ");
		for(char square : gameBoard) {
			System.out.print(square);
			System.out.print(" | ");
		}
	}

	private static char[] init(int size) {
		char[] gameBoard = new char[size*2 + 1];
		//a) Placing free spot on the board
		gameBoard[size] = FREE_SPOT;
		
		//b) Placing sheep who can leap left
		for(int i = 0; i<size; i++) {
			gameBoard[i] = LEAPING_LEFT;
		}
		
		//b) Placing sheep who can leap right
		for(int i = size + 1; i<=size * 2; i++) {
			gameBoard[i] = LEAPING_RIGHT;
		}
		return gameBoard;
	}

	private static int chooseSize(String[] levels, int[] sizes) {
		int size = 3;
		Scanner scan = new Scanner(System.in);
		int input = 0;
		do {
			System.out.println("Choisissez un niveau (entre 1 et 3) :");
			for(int i = 0; i < sizes.length; i++) {
				System.out.println(i+1 + " - " + levels[i]);
			}
			input = scan.nextInt();
		} while(input < 1 || input > 3 );
		size = sizes[input-1];
		System.out.println("Vous avez choisi de jouer avec des équipes de " + size + " moutons! À vous de jouer :");
		scan.close();
		return size;
	}

}
