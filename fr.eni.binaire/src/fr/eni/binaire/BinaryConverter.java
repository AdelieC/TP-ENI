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
	 * @param num integer to show as a binary number
	 */
	private static void showBinary(int num) {
		int[] bin = new int[SIZE];
		
		//1) Loop through both binary table AND newly created int array
		for(int i = 0; i<SIZE; i++) {
			
			//2) Fill it with 0 by default
			bin[i] = 0;
			
			//3) Turn 0 to 1 if num is still big enough to contain corresponding value of binary table
			if(num/TABLE[i] > 0) {
				bin[i]++;
				num -= TABLE[i];
			}
			
			//4) Print each binary digit
			System.out.print(bin[i]);
		}
	}
	/*
	 * Initializes maximum number the user can ask to show as a binary, based on the size we specified in SIZE
	 * @param size const SIZE equals max length of future binary number
	 * @return max value of last integer the user can ask to see as a binary
	 */
	private static int initMaxNum(int size) {
		int[] max = new int[SIZE];
		//1) Loop through binary number (array of int) to fill it with 1
		for(int i = 0; i<SIZE; i++) {
			max[i] = 1;
		}
		//2) Convert binary array to int base 10
		return unBinarize(max);
	}
	/*
	 * Converts an array of integers into a decimal integer
	 * @param num array of int representing binary number
	 * @return int corresponding number in base 10
	 */
	private static int unBinarize(int[] num) {
		int dec = 0;
		
		//Loop through both binary table AND array of int in params...
		for(int i = 0; i<num.length; i++) {
			//multiply each int in binary array by corresponding int in binary table, and add result to total
			dec += num[i]*TABLE[i];
		}
		return dec;
	}
	
	/* 
	 * Asks the user for input until he enters an int within the specified range between zero and max value.
	 * @return the int given as input by user if valid.
	 * @param max maximum int the user can give as input
	 */
	private static int askForNum(int max) {
		int input = 0;
		String tmp = "";
		
		//while input not valid, ask for a new one and check if it's valid
		do {
			if(input >= 0) System.out.println("La valeur " + input + " n'est pas autorisée, rééssayez :");
			System.out.println("Entrez un nombre strictement compris entre 0 et " + (max + 1) + " :");
			tmp = SCAN.next(); SCAN.nextLine();
			input = tmp.matches("[0-9]")? Integer.parseInt(tmp) : 0;
		} while(input <= 0 || input > max);
		return input;
	}

	/*
	 * Prints out every int in binary table previously initialized with | as separators
	 * @param table array of integers containing binary table
	 */
	private static void show(int[] table) {
		System.out.println("Table de conversion binaire :");
		
		//1) border of table
		System.out.print("| ");
		
		//2) loop through table, prints out each int + separator
		for(int pow : table) {
			System.out.print(pow + " | ");
		}
		System.out.println();
	}

	/*
	 * Initializes binary table
	 * @param size size of the conversion table we want : const SIZE
	 * @return binary table as an array of integers
	 */
	private static int[] initTable(int size) {
		int[] table = new int[size];
		
		//no cheating this time... not even with Math class!
		
		//1) loop through newly created empty table
		for(int i = 0; i<SIZE; i++) {
			
			//2) making sure we don't begin with multiplying by 0
			table[i]=1;
			
			//3) if not last entry (which is supposed to be 2^0 = 1)...
			if(i != SIZE-1) {
				//4) ...multiply by 2 as many times as necessary each int of array (starting from the top) and stoping BEFORE last)
				for(int pow = SIZE-2; pow>=i; pow--) {
					table[i] *= 2;
				}
			}
		}
		return table;
	}

}
