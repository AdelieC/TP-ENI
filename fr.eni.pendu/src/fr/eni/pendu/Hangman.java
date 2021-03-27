package fr.eni.pendu;

import java.util.Scanner;

public class Hangman {
	public static Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean quit = true, won, dead;
		String word = "", hiddenWord = "", letter = "";
		
		do {
			won = dead = false;
			
			//1) Ask first player for a word, and create hidden version of it
			word = askForWord();
			hiddenWord = hide(word);
			
			//2) Magically erase console (with messages to explain what happened!)
			magicalEraser();
			
			//3) doWhile loop
			do {
				//a) Ask player 2 for a letter, check if letter is in word, and tell player
				hiddenWord = guessLetterIn(word);
				/*
				//c) Show player updated word to guess + how "hung" he is
				won = revealed(hiddenWord, word);
				if(!won) count++;
				dead = 
				 */
			} while(!won && !dead);
			
			//4) If hung or won, show msg
			
			//5) Replay or quit?
			 
			
		} while(!quit);
		
		
		SC.close();
	}
	
	private static String guessLetterIn(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates hidden version of word to guess + puts enough empty space inside console to hide word entered from view
	 * @param String word to hide
	 * @return String hidden word
	 */
	private static String hide(String word) {
		String hidden = "";
		for(int i = 0; i<word.length(); i++) {
			hidden += "_";
		}
		return hidden;
	}
	
	/**
	 * "Clears" the console by adding loooots of blank lines. And explains what's happening to users.
	 * (in eclipse : sysout multiple blank lines)
	 */
	public static void magicalEraser() {
		System.out.println("Merci ! Maintenant nous allons effacer l'écran pour que vous laissiez la place à votre adversaire en toute sécurité.");
		for(int i = 0; i<15; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("▇▇▇▇");
		}
		for(int i = 0; i<200; i++) System.out.println();
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("Ceci n'est pas un bug (normalement...)! Le but était de cacher le mot à deviner.");
		System.out.println("ATTENTION : SCROLLER C'EST TRICHER!!");
		System.out.println();
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――");
		for(int i = 0; i<5; i++) System.out.println();
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
		System.out.println();
		return word;
	}

}
