package fr.eni.pendu;

import java.util.Scanner;

public class Hangman {
	public static Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean quit = true, won, dead;
		String word = "", hiddenWord = "", letter = "";
		
		do {
			won = dead = false;
			
			//1) Ask first player for a word
			word = askForWord();
			
			/*
			//2) Make word disappear magically and init hiddenWord!
			hiddenWord = hide(word);
			
			//3) doWhile loop
			do {
				//a) Ask player 2 for a letter, check if letter is in word, and tell player
				hiddenWord = guessLetterIn(word);
				
				//c) Show player updated word to guess + how "hung" he is
				won = revealed(hiddenWord, word);
				if(!won) count++;
				dead = 
				
			} while(!won && !dead);
			//4) If hung or won, show msg
			
			//5) Replay or quit?
			 
			 */
		} while(!quit);
		
		
		SC.close();
	}
	
	/**
	 * Asks first player for a word until it's a valid one
	 * @return String word
	 */
	private static String askForWord() {
		String word = "";
		System.out.println("JOUEUR 1 : entre un mot de 4 à 25 lettres ET reconnu par l'Académie Française please... :");
		System.out.println("(si le doute t'habite : https://www.dictionnaire-academie.fr/)");
		word = SC.nextLine();
		if(!word.matches("[a-zA-Z]{4,25}")) askForWord();
		return word;
	}

}
