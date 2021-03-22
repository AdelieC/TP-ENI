package fr.eni.cryptage;

import java.util.Scanner;

public class Cryptage {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sentence;
		String key;
		
		do {
		System.out.println("Saisissez la phrase que vous souhaitez crypter (lettres et espaces uniquement) :");
		sentence = scan.nextLine().toUpperCase();
		} while(!sentence.matches("[A-Z\s]+"));
		do {
		System.out.println("Saisissez une clé de moins de 9 lettres pour crypter votre phrase :");
		key = scan.nextLine().toUpperCase();
		} while(!key.matches("[A-Z]{1,8}"));
		
		System.out.println("La phrase \"" + sentence + "\" cryptée avec la clé \"" + key + "\" est :");		
		sentence = crypt(sentence, key);
		System.out.println(sentence);
		scan.close();
	}

	private static String crypt(String sentence, String key) {
		final String AZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String fullKey = fitKeyToSentence(key, sentence);
		String encrypted = "";
		int correspondingIndex;
		
		for(int i = 0; i<sentence.length(); i++) {
			//a) Checking if char at index i is a whitespace
			if(sentence.charAt(i) == ' ') {
				encrypted += " ";
			//b) If not whitespace, finding index of AZ char to put in encrypted string
			} else {
				correspondingIndex = AZ.indexOf(sentence.charAt(i)) + AZ.indexOf(fullKey.charAt(i));
				//c) If corresponding index is within AZ range, we put corresponding char inside encrypted sentence
				if(correspondingIndex < AZ.length()) {
					encrypted += AZ.charAt(correspondingIndex);
				//d) If corresponding index is greater than AZ's length, we remove AZ's length and start the alphabet again
				} else {
					encrypted += AZ.charAt(correspondingIndex - AZ.length());
				}
			}
		}
		return encrypted;
	}

	private static String fitKeyToSentence(String key, String sentence) {
		String fullKey = "";
		for(int i = 0, j = 0; i<sentence.length(); i++) {
			//a) If char in sentence is a whitespace, put a whitespace in fullKey
			if(sentence.charAt(i) == ' ') {
				fullKey += " ";
			//b) If not, put the corresponding letter of key inside fullKey
			} else {
				//c) Making sure we still have chars from key to put inside fullKey
				if(j < key.length()) {
					fullKey += key.charAt(j);
					j++;
				//d) if we've reached the end of the key...
				} else {
					//... we start again from key's first char...
					j = 0;
					fullKey += key.charAt(j);
					//... and we increment so that we don't get key's first char twice
					j++;
				}
			}
		}
		return fullKey;
	}
}
