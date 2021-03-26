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
		
		//2) It's 7am, and I feel like unverdoing it... :
		max = initMaxNum(SIZE);
		//1) Ask for random num between 0 and MAX (since we can't use Math, can't use random...what a shaaame :-D!)
		num = askForNum(max);
		
		//2) modulo each digit with 2?
		
		

	}

	private static int initMaxNum(int size) {
		//ok so I don't see how I can avoid using strings here... Minor infringement, right? Forgive me?
		int[] max = new int[SIZE];
		for(int i = 0; i<SIZE; i++) {
			max[i] = 1;
		}
		return unBinarize(max) + 1;
	}

	private static int unBinarize(int[] num) {
		int dec = 0;
		for(int i = 0; i<num.length; i++) {
			dec += num[i]*TABLE[i];
		}
		return dec;
	}

	private static int askForNum(int max) {
		int input = 0;
		do {
			if(input > 0) System.out.println("La valeur " + input + " n'est pas autorisée, rééssayez :");
			System.out.println("Entrez un nombre compris entre 0 et " + max + " :");
			input = Integer.parseInt(SCAN.next()); SCAN.nextLine();
		} while(input < 0 || input >= max);
		return 0;
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
