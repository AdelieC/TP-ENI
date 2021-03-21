package fr.eni.melangeur;

import java.util.Arrays;
import java.util.Scanner;


public class Melangeur {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input;
		String newSentence = "";
		
		System.out.println("Saisir la phrase que vous souhaitez transformer :");
		input = scan.nextLine().split(" ");
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
		System.out.println("La phrase transformée : " + newSentence);
		scan.close();
	}

	private static String mixLetters(char[] word) {
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
