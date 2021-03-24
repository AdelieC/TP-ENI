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
				player = change(player);
				won = play(gameBoard, PLAYERS[player]);
				stuck = deadEnd(gameBoard);
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
		boolean full = false;
		int i = 0;
		int j = 0;
		do {
			do {
				full = (gameBoard[i][j] != '_');
				j++;
			} while(full && j < SIZE);
			i++;
		} while(full && i < SIZE);
		return full;
	}

	private static int change(int player) {
		return player == 0 ? 1 : 0;
	}

	private static boolean play(char[][] gameBoard, char player) {
		int col = 0;
		int row = 0;
		
		do {
			col = row = 0;
			
			//1) Ask for the number and the coordinates of the square where the current player wants to put his mark
			System.out.println("C'EST À TON TOUR JOUEUR :" + player);
			System.out.println("Entre les coordonnées où tu souhaites mettre ta couleur :");
			System.out.print("COLONNE n° : "); col = SCAN.nextInt()-1 ;SCAN.nextLine();
			System.out.print("LIGNE n° : "); row = SCAN.nextInt()-1 ;SCAN.nextLine();
			System.out.println();
			System.out.println("Tu as choisi : colonne = " + (col+1) + " et ligne = " + (row+1));
		
		//2) Check for VALIDITY :
		} while(forbidden(gameBoard, col, row));
		
		//3) Change char in square chosen to the char of the player
		gameBoard[row][col] = player;
		
		//4) Check for VICTORY :
		return won(gameBoard, col, row, player);
	}

	private static boolean forbidden(char[][] gameBoard, int col, int row) {
		if(col < 0 || col > SIZE && row < 0 || row > SIZE) {
			return true;
		} else {
			return (gameBoard[row][col] != '_');
		}
	}

	private static boolean won(char[][] gameBoard, int col, int row, char player) {
		boolean won = false;
		//1) loop through rows for column where player made last move
		
		
		//2) loop through columns for row where player made move
		
		
		//3) check for diagonals
		
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
