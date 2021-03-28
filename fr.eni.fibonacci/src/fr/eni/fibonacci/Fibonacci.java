package fr.eni.fibonacci;

import java.util.Scanner;

public class Fibonacci {
	public final static Scanner SC = new Scanner(System.in);
	
	/**
	 * Different methods to get fibonacci sequence, with time of execution for each method
	 * @param args
	 */
	public static void main(String[] args) {
		final int MAX = 1000;
		int length = 0;
		
		//1) Ask user for a number between 0 and max :
		length = askForLength(MAX);
		
		//2) Show fib sequence until depth = length given by user
		showFibonacci(length);
		

	}

	private static void showFibonacci(int length) {
		System.out.print(0 + ", ");
		for(int i = 0, a=1, b=1, tmp=0; i<length; i++) {
			tmp = b;
			b += a;
			a = tmp;
			System.out.print(a + " ");
		}
	}

	private static int askForLength(int MAX) {
		String input = "";
		System.out.println("Bienvenue sur le générateur de suites de Fibonacci! Quelle profondeur de suite souhaitez-vous?");
		do {
			System.out.println("Entrez un nombre strictement compris entre 0 et " + MAX + " :");
			input = SC.nextLine();
		} while(!input.matches("\\d{1,3}"));
		
		return Integer.parseInt(input);
	}

}
