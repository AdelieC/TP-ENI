package fr.eni.palindrome;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word = "";
		
		//1) Ask the user for a word to validate as a palindrome or not
		System.out.println("Bonjour! Vous voulez vérifier si un mot ou une phrase est un palindrome? Écrivez-le/la ici :");
		word = scan.nextLine().toUpperCase().replaceAll(" ", "");
		if(isPalin(word)) {
			System.out.println("\"" + word + "\" est bien un palindrome!");
		} else {
			System.out.println("\"" + word + "\" n'est pas un palindrome.");
		}
		scan.close();
	}

	private static boolean isPalin(String word) {
		int i = 0;
		boolean palin = false;
		do {
			palin = (word.charAt(i) == word.charAt(word.length()-1 -i));
			i++;
		} while (palin && i<word.length()/2);
		return palin;
	}
}
