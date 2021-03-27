package fr.eni.loto;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
	final static Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] mainGrid = new int[50], chceGrid = new int[10], mainDraw = new int[5], chceDraw = new int[1];
		String msgMainG = "Voici votre grille :", msgChceG = "Votre grille CHANCE :";
		String msgMainD = "Le tirage gagnant est :", msgChceD = "Le numéro complémentaire est le :";
		boolean won = false, jackpot = false;
		
		//1) Initialize main grid size 50 + complementary grid size 10 (osef the rules!)
		mainGrid  = generate(mainGrid);
		chceGrid = generate(chceGrid);
		
		//3) Show player his main grid and chance grid
		show(mainGrid, msgMainG);
		show(chceGrid, msgChceG);
		
		//3) Ask player to press enter to continue program
		askForDraw();
		
		//2) Draw 5 main numbers + 1 chance and put those inside arrays of int
		mainDraw = generate(mainDraw);
		chceDraw = generate(chceDraw);
		
		//4) Show the draws
		show(mainDraw, msgMainD);
		show(chceDraw, msgChceD);
		
		//6) Get results of searches for draws in grids
		won = findInside(mainGrid, mainDraw);
		jackpot = findInside(chceGrid, chceDraw) && won;
		
		//7) Show message depending on result
		System.out.println(getMsg(won, jackpot));
		
		SC.close();
	}

	/*
	 * Depending on outcomes taken in as params, this method gives back a string message to show the user
	 * @param won boolean
	 * @param jackpot boolean
	 * @return msg string
	 */
	private static String getMsg(boolean won, boolean jackpot) {
		return jackpot? "INCROYABLE!! Vous remportez le jackpot!!!": (won ? "Bravo! Vous avez gagné!" : "Pas de chance, c'est PERDU.");		
	}

	/*
	 * Tells you if all integers of a small array can be found in a bigger array
	 * @param grid big array of integers we want to search for all the integers in smaller one
	 * @param draw small array of integers we want to find in array "grid"
	 * @return boolean true if every integer of small array was found in big array
	 */
	private static Boolean findInside(int[] grid, int[] draw) {
		boolean found = false;
		int i=0, j=0;
		do {
			do {
				found = (draw[i] == grid[j]);
				j++;
			} while(j<grid.length && !found);
			j=0;
			i++;
		} while(i<draw.length && found);
		return found;
	}
	
	/*
	 * Asks user to press enter to continue main method (mimics gaming machines button)
	 */
	private static void askForDraw() {
		System.out.println("Appuyez sur ENTRÉÉ pour effectuer le tirage au sort.");
		SC.nextLine();
	}
	
	/*
	 * Shows array of integers with corresponding string description. Max num of ints on each line is 10 and each int is separated with |.
	 * @param grid array of integers to show
	 * @param msg string description corresponding to the array
	 */
	private static void show(int[] grid, String msg) {
		System.out.println(msg);
		System.out.print("| ");
		for(int i = 0; i<grid.length; i++) {
			if(i>=7 && i%10 == 0) {
				System.out.println();
				System.out.print("| ");
			}
			System.out.print(grid[i] + " | ");
		}
		System.out.println();
		System.out.println();
	}
	
	/*
	 * Fills initialized arrays with random integers between 100 and 200
	 * @param grid empty array of integers
	 * @return array of random integers
	 */
	private static int[] generate(int[] grid) {
		Random x = new Random();
		for(int i = 0; i<grid.length; i++) {
			grid[i] = x.ints(100, 200).findFirst().getAsInt();
		}
		return grid;
	}
	

}
