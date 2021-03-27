package fr.eni.pendu;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
	public final static Scanner SC = new Scanner(System.in);
	public final static String[] HANGING_QUOTE = {"IL", "NE", "FAUT", "PAS", "PARLER", "DE", "MORT", "DEVANT", "UN", "PENDU"};
	public final static String[] RANDOM = {"JAVASCRIPT", "INTERFACE", "COMPILATEUR", "PROGRAMMATION", "DEVELOPPEUR", "CONSOLE", "CONCEVOIR", "STRUCTURER", "INCREMENTER"};
	
	public static void main(String[] args) {
		boolean quit = true, random, won;
		String word = "", hiddenWord = "", letter = "", lettersGiven = "";
		int dead;
		
		do {
			dead = 0;
			won = random = false;
			
			//1) Ask if 2 players or "random" word
			random = askForRandom();
			
			//2) Get the word to guess, and create hidden version of it
			word = random ? getRandomWord() : askForWord();
			hiddenWord = hide(word);
			
			//3) Magically erase console (with messages to explain what happened!)
			if(!random) magicalEraser();
			
			//4) Show initial state of the game
			showStateOfGame(hiddenWord, dead, lettersGiven);
			
			//5) doWhile loop
			do {
				//a) Ask player 2 for a letter until we get a valid one
				letter = askForLetter(lettersGiven);
				lettersGiven += letter;
				//b) If it's a lucky guess, we update hiddenWord, else we increment dead
				if(word.contains(letter)) {
					hiddenWord = update(hiddenWord, word, letter.charAt(0));
				} else {
					dead++;
				}
				
				//c) If updated hiddenWord is the same as the word to guess, it's victory!
				won = (hiddenWord.equals(word));
				
				//d) We show player the state of the game : updated hiddenWord and how dead he is.
				showStateOfGame(hiddenWord, dead, lettersGiven);
			} while(!won && dead < 10);
			
			//6) Show final message to user depending on the outcome (won or dead) and ask continue/quit
			quit = finalMessage(won);
		} while(!quit);
		
		System.out.println("Merci d'avoir joué à ce petit jeu pas vraiment passionnant :-) À bientôt!");
		SC.close();
	}
	
	/**
	 * Generates random word
	 * @return String random word taken in collection RANDOM
	 */
	private static String getRandomWord() {
		Random rd = new Random();
		return RANDOM[rd.nextInt(RANDOM.length-1)];
	}

	/**
	 * Asks the user if he wants a "randomly generated" word to guess or if he wants to play with someone
	 * @return boolean random true if user chooses to play alone
	 */
	private static boolean askForRandom() {
		String input = "";
		System.out.println("Choisis le nombre de joueurs :");
		System.out.println("1 - Un seul joueur");
		System.out.println("2 - Deux joueurs");
		input = SC.nextLine();
		if(!input.matches("1|2")) {
			System.out.println("Tu as entré un choix erroné. Réessaie :");
			askForRandom();
		}
		System.out.println();
		return input.contains("1");
	}

	/**
	 * Prints out appropriate message according to outcome given as param, and returns choice to quit or keep playing
	 * @param boolean won
	 * @return boolean quit
	 */
	private static boolean finalMessage(boolean won) {
		String input = "";
		System.out.println(won?"Bravooo tu as trouvé le mot!!" : "Awwww désolé, tu es pendu!");
		do {
			System.out.println("Est-ce que tu veux rejouer?");
			System.out.println("1 - REJOUER");
			System.out.println("2 - QUITTER");
			input = SC.nextLine();
		} while(!input.matches("1|2"));
		return input.contains("2");
	}

	/**
	 * Prints out letters found, word to find, chances left, how far advanced the player is in the "death" sentence etc..
	 * @param String hiddenWord
	 * @param int dead counter of failures
	 * @param String letters given in previous attempts
	 */
	private static void showStateOfGame(String hiddenWord, int dead, String lettersGiven) {
		if(!lettersGiven.isBlank()) {
			System.out.println("Voici où tu en es dans la phrase du pendu (trop compliqué de coder un vrai dessin de pendu) :");
			System.out.println("\"");
			for(int i = 0; i<dead; i++) {
				System.out.print(HANGING_QUOTE[i] + " ");
			}
			System.out.println();
			System.out.println("\"");
			System.out.println("Tu as déjà donné les lettres suivantes : " + lettersGiven);
			System.out.println("Il te reste encore " + (HANGING_QUOTE.length - dead) + " chances pour trouver les autres lettres!");
			System.out.println();
		}
		System.out.println("Le mot que tu dois trouver :");
		for(int j = 0; j<hiddenWord.length(); j++) {
			System.out.print(hiddenWord.charAt(j) + " ");
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * Updates hiddenWord with new letter
	 * @param String hiddenWord
	 * @param String word
	 * @param char letter
	 * @return String hiddenWord
	 */
	private static String update(String hiddenWord, String word, char letter) {
		char[] temp = hiddenWord.toCharArray();
		for(int i = 0; i<word.length(); i++) {
			if(word.charAt(i) == letter) temp[i] = letter;
		}
		return String.valueOf(temp);
	}

	/**
	 * Asks player to give a letter until he gives a valid one
	 * @param String letters given previously
	 * @return String new letter
	 */
	private static String askForLetter(String lettersGiven) {
		String letter = "";
		System.out.println("Tentes ta chance et entre une lettre de l'alphabet (sans accents stp) :");
		letter = SC.nextLine();
		if(!letter.matches("[a-zA-Z]{1}")) {
			System.out.println("Ce que tu as saisi n'est pas une lettre valide. Réessaie.");
			askForLetter(lettersGiven);
		}
		if(lettersGiven.contains(letter)) {
			System.out.println("Tu as déjà donné cette lettre. Réessaie.");
			askForLetter(lettersGiven);
		}
		System.out.println();
		return letter.toUpperCase();
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
		System.out.println("Merci ! Maintenant nous allons effacer l'écran pour que le mot reste secret.");
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
		return word.toUpperCase();
	}

}
