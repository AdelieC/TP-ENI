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
		int length = 0, count = 0;
		double start, end;
		long a = 1, b = 1;
		//1) Ask user for a number between 0 and max :
		length = askForLength(MAX);
		
		//2) Show fib sequence until depth = length given by user
		//a) Method 1 with for loop and long
		start = System.nanoTime();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		longFibonacci(length);
		end = System.nanoTime();
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("Temps d'exécution avec for loop et longs : " + (end - start) / 1000000 + " millisecondes");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		
		//b) Method 2 with recursion and long (bigints = dumb choice cause they're not supposed to change values)
		start = System.nanoTime();
		System.out.print(0);
		recursFibonacci(a, b, count, length);
		end = System.nanoTime();
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("Temps d'exécution avec récursion et longs : " + (end - start) / 1000000 + " millisecondes");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	private static void recursFibonacci(long a, long b, int count, int length) {
		long tmp = 0;
		System.out.print(", ");
		if(count>9 && count%10 == 0) System.out.println();
		System.out.print(a);
		tmp = b;
		b += a;
		a = tmp;
		count++;
		if(count < length) recursFibonacci(a, b, count, length);
	}

	private static void longFibonacci(int length) {
		long a = 1, b = 1, tmp = 0;
		System.out.print(0);
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
