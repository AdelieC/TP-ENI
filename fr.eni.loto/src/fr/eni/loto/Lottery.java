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
		
		//1) Initialize main grid size 50 + complementary grid size 10
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

	private static String getMsg(boolean won, boolean jackpot) {
		return jackpot? "INCROYABLE!! Vous remportez le jackpot!!!": (won ? "Bravo! Vous avez gagné!" : "Pas de chance, c'est PERDU.");		
	}

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

	private static void askForDraw() {
		System.out.println("Appuyez sur ENTRÉÉ pour effectuer le tirage au sort.");
		SC.nextLine();
	}

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

	private static int[] generate(int[] grid) {
		Random x = new Random();
		for(int i = 0; i<grid.length; i++) {
			grid[i] = x.ints(100, 200).findFirst().getAsInt();
		}
		return grid;
	}
	

}
