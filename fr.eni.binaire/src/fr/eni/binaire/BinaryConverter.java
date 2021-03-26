package fr.eni.binaire;

import java.util.Scanner;

public class BinaryConverter {
	final static Scanner SCAN = new Scanner(System.in);
	final static int SIZE = 8;
	final static int[] TABLE = initTable(SIZE);
	
	public static void main(String[] args) {
		int num = 0, max = 0;
		
		//1) Show initialized binary conversion table TABLE:
		show(TABLE);
		
		//2) It's 7am, and I feel like overdoing it... :
		max = initMaxNum(SIZE);
		
		//3) Ask for random num between 0 and MAX (since we can't use Math, can't use random...what a shaaame :-D!)
		num = askForNum(max);
		
		//4) binarize num and show it
		showBinary(num);
	}
	/*
	 * Prints out binary value of an integer
	 */
	private static void showBinary(int num) {
		int[] bin = new int[SIZE];
		for(int i = 0; i<SIZE; i++) {
			bin[i] = 0;
			if(num/TABLE[i] > 0) {
				bin[i]++;
				num -= TABLE[i];
			}
			System.out.print(bin[i]);
		}
	}
	/*
	 * Initializes maximum number the user can ask to show as a binary, based on the size we specified in SIZE
	 */
	private static int initMaxNum(int size) {
		int[] max = new int[SIZE];
		for(int i = 0; i<SIZE; i++) {
			max[i] = 1;
		}
		return unBinarize(max);
	}
	/*
	 * Converts an array of integers into a decimal integer
	 */
	private static int unBinarize(int[] num) {
		int dec = 0;
		for(int i = 0; i<num.length; i++) {
			dec += num[i]*TABLE[i];
		}
		return dec;
	}
	/*
	 * @param max maximum int the user can give as input
	 * Asks the user for input until he enters an int within the specified range between zero and max value.
	 * @return the int given as input by user if valid.
	 */
	private static int askForNum(int max) {
		int input = 0;
		String tmp = "";
		do {
			if(input >= 0) System.out.println("La valeur " + input + " n'est pas autorisée, rééssayez :");
			System.out.println("Entrez un nombre strictement compris entre 0 et " + (max + 1) + " :");
			tmp = SCAN.next(); SCAN.nextLine();
			input = tmp.matches("[0-9]")? Integer.parseInt(tmp) : 0;
		} while(input <= 0 || input > max);
		return input;
	}

	private static void show(int[] table) {
		System.out.println("Table de conversion binaire :");
		System.out.print("| ");
		for(int pow : table) {
			System.out.print(pow + " | ");
		}
		System.out.println();
	}

	private static int[] initTable(int size) {
		int[] table = new int[size];
		//no cheating this time... not even with Math class!
		for(int i = 0; i<SIZE; i++) {
			table[i]=1;
			if(i != SIZE-1) {
				for(int pow = SIZE-2; pow>=i; pow--) {
					table[i] *= 2;
				}
			}
		}
		return table;
	}

}
