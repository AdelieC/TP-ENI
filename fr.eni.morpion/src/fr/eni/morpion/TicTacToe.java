package fr.eni.morpion;

import java.util.Scanner;

public class TicTacToe {
	final static char[] PLAYERS = {'O', 'X'};
	final static int  SIZE = 3;
	final static Scanner SCAN = new Scanner(System.in);
	
	public static void main(String[] args) {
		char[][] gameBoard = new char[SIZE][SIZE];
		int player = 0;
		boolean won, stuck, restart = false;
		
		do {
			won = stuck = false;
			init(gameBoard);
			show(gameBoard);
			do {
				change(player);
				//stuck = deadEnd(gameBoard);
				won = play(gameBoard, PLAYERS[player]);
				show(gameBoard);
			} while(!won && !stuck);
			System.out.println(won? "Bravo! Le joueur " + PLAYERS[player] + " a gagné!!" : "Match nul!");
			restart = askRestart();
		} while(restart);
		SCAN.close();
	}

	private static boolean askRestart() {
		System.out.println("Souhaitez-vous refaire une partie?");
		System.out.println("1 - OUI");
		System.out.println("2 - NON");
		return SCAN.nextInt() == 1? true : false;
	}

	private static boolean deadEnd(char[][] gameBoard) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void change(int player) {
		// TODO Auto-generated method stub
		
	}

	private static boolean play(char[][] gameBoard, char player) {
		int col = 0;
		int row = 0;
		boolean won = false;
		
		//1) Ask for the number and the coordinates of the square where the current player wants to put his mark
		System.out.println("C'EST À TON TOUR JOUEUR :" + player);
		System.out.println("Entre les coordonnées où tu souhaites mettre ta couleur :");
		System.out.print("COLONNE n° : "); col = SCAN.nextInt();SCAN.nextLine();
		System.out.print("LIGNE n° : "); row = SCAN.nextInt();SCAN.nextLine();
		System.out.println();
		System.out.println("Tu as choisi : colonne = " + col + " et ligne = " + row);
		
		//2) Change char in square chosen to the char of the player
		gameBoard[row -1][col - 1] = player;
		
		return won;
	}

	private static void init(char[][] gameBoard) {
		for(int i = 0; i<SIZE; i++) {
			for(int j = 0; j<SIZE; j++) {
				gameBoard[i][j] = '_';
			}
		}
	}

	private static void show(char[][] gameBoard) {
		System.out.print("  ");
		for(int i = 0; i<SIZE; i++) {
			System.out.print("_" + (i + 1) + "_ ");
		}
		System.out.println();
		for(int i = 0; i<SIZE; i++) {
			System.out.print(i + 1 + "| ");
			for(int j = 0; j<SIZE; j++) {
				System.out.print(gameBoard[i][j]);
				System.out.print(" | ");
			}
			System.out.println();
		}
	}


}
