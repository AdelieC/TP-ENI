package fr.eni.morpion;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[][] gameBoard = new char[3][3];
		
		init(gameBoard);
		play(gameBoard);
		
	}

}
