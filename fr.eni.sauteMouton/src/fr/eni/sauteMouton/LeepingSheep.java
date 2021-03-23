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
		
		//1) Checking if the user won
		if(won(gameBoard)) {
			
		//2) Checking if the user is stuck
		} else if(stuck(gameBoard)) {
		
		//3) Otherwise, enter continue recursion to play!
		} else {
			
			
			
			play(gameBoard);
		}
		show(gameBoard);
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
