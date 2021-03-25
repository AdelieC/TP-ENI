package fr.eni.melangeur;

import java.util.Arrays;
import java.util.Scanner;

public class Melangeur {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input;
		String newSentence = "";
		
		//1) Getting sentence to transform from user, putting it inside array of strings
		System.out.println("Saisir la phrase que vous souhaitez transformer :");
		input = scan.nextLine().split(" ");
		
		//2) Loop through the array, and if string is long enough to need mixing, get the middle, reverse it, and put everything back together again
		for(int i = 0; i < input.length; i++) {
			char[] word = input[i].toCharArray();
			int taille = word.length;
			if(taille > 3) {
				newSentence = newSentence + String.valueOf(word[0]) + mixLetters(Arrays.copyOfRange(word, 1, taille-1)) + String.valueOf(word[taille-1]);
			} else {
				newSentence += String.valueOf(word);
			}
			newSentence += " ";
		}
		
		//3) Show result
		System.out.println("Votre phrase transformée : " + newSentence);
		scan.close();
	}

	private static String mixLetters(char[] word) {
		//Taking in middle of a word (word param when method is called in main) as array, reversing it and giving the result back as a string
		char temp;
		final int LENGTH = word.length;
		for(int i = 0; i < LENGTH / 2; i++) {
			temp = word[i];
			word[i] = word[LENGTH - (i + 1)];
			word[(LENGTH - 1) - i] = temp;
		}
		return String.valueOf(word);
	}
}
