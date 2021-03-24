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
		System.out.println("À bientôt!");
		SCAN.close();
	}

	private static boolean askRestart() {
		System.out.println("Souhaitez-vous refaire une partie?");
		System.out.println("1 - REJOUER");
		System.out.println("2 - QUITTER");
		return SCAN.nextInt() == 1? true : false;
	}

	private static boolean deadEnd(char[][] gameBoard) {
		//TODO : can do better if we check if there's both X and O on the same row/col/diagonal
		boolean full = false;
		int i = 0;
		int j = 0;
		
		//Lazy way : checking if gameboard is full of O and X
		do {
			do {
				full = (gameBoard[i][j] != '_');
				j++;
			} while(full && j < SIZE);
			j = 0;
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
		
		System.out.println("C'EST À TON TOUR JOUEUR " + player);
		System.out.println("Entre les coordonnées où tu souhaites mettre ta couleur :");
		do {
			col = row = 0;
			
			//1) Ask for the number and the coordinates of the square where the current player wants to put his mark
			System.out.print("COLONNE n° : "); col = SCAN.nextInt()-1 ;SCAN.nextLine();
			System.out.print("LIGNE n° : "); row = SCAN.nextInt()-1 ;SCAN.nextLine();
			System.out.println();
		//2) Check for VALIDITY :
		} while(forbidden(gameBoard, col, row));
		
		//3) Change char in square chosen to the char of the player
		gameBoard[row][col] = player;
		
		//4) Check for VICTORY :
		return won(gameBoard, col, row, player);
	}

	private static boolean forbidden(char[][] gameBoard, int col, int row) {
		//1) Check if the coordinates given are whithin the gameboard
		if(col < 0 || col > SIZE || row < 0 || row > SIZE) {
			System.out.println("Nope, tu es hors du tableau là! ESSAIE ENCORE :");
			return true;
		
		//2) Check if it's a free spot
		} else if (gameBoard[row][col] != '_') {
			System.out.println("Tu ne peux pas mettre ton pion là où il y a déjà un pion enfin! ESSAIE ENCORE :");
			return true;
		}
		return false;
	}

	private static boolean won(char[][] gameBoard, int col, int row, char player) {
		boolean won = false;
		int i = 0;
		
		//1) Check diagonals
		if( gameBoard[1][1] == player) {
			won = (gameBoard[0][0] == player 
					&& gameBoard[2][2] == player
					||
					gameBoard[2][0] == player 
					&& gameBoard[0][2] == player);
		} else {
			//2) Check rows for column where player made last move
			do {
				won = (gameBoard[i][col] == player);
				i++;
			} while(won && i<SIZE);
			i=0;
			
			//3) If no win in rows, check columns for row where player made move
			do {
				won = (gameBoard[row][i] == player);
				i++;
			} while(won && i<SIZE);
		}
		return won;
	}

	private static void init(char[][] gameBoard) {
		// Fill gameboard with _ as delimeters until we replace them throughout the game
		for(int i = 0; i<SIZE; i++) {
			for(int j = 0; j<SIZE; j++) {
				gameBoard[i][j] = '_';
			}
		}
	}

	private static void show(char[][] gameBoard) {
		//1) Print absciss with tabulation to be in alignment with the rest
		System.out.print("  ");
		for(int i = 0; i<SIZE; i++) {
			System.out.print("_" + (i + 1) + "_ ");
		}
		System.out.println();
		
		//2) Print content of gameboard with | as delimeters
		for(int i = 0; i<SIZE; i++) {
			System.out.print(i + 1 + "| ");
			for(int j = 0; j<SIZE; j++) {
				System.out.print(gameBoard[i][j]);
				System.out.print(" | ");
			}
			System.out.println();
		}
		System.out.println();
	}


}
