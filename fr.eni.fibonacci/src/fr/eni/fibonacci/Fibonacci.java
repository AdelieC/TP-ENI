package fr.eni.fibonacci;

import java.util.Scanner;

public class Fibonacci {
	public final static Scanner SC = new Scanner(System.in);
	
	/**
	 * Different methods to get fibonacci sequence, with time of execution for each method
	 * @param args
	 */
	public static void main(String[] args) {
		final int MAX = 92;
		int length = 0;
		
		//1) Ask user for a number between 0 and max :
		length = askForLength(MAX);
		
		//2) Show fib sequence until depth = length given by user
		showFibonacci(length);
		

	}

	private static void showFibonacci(int length) {
		System.out.print(0);
		long a=1, b=1, tmp=0;
		for(int i = 0; i<length; i++) {
			System.out.print(", ");
			if(i>9 && i%10 == 0) System.out.println();
			System.out.print(a);
			tmp = b;
			b += a;
			a = tmp;
		}
	}

	private static int askForLength(int MAX) {
		String input = "";
		System.out.println("Bienvenue sur le générateur de suites de Fibonacci! Quelle profondeur de suite souhaitez-vous?");
		do {
			System.out.println("Entrez un nombre strictement compris entre 0 et " + (MAX + 1) + " :");
			input = SC.nextLine();
		} while(!input.matches("\\d{1,2}") && Integer.parseInt(input) > MAX);
		
		return Integer.parseInt(input);
	}

}
