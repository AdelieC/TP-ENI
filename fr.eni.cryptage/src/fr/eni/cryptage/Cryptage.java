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
				
		sentence = crypt(sentence, key);
		System.out.println(sentence);
		scan.close();
	}

	private static String crypt(String sentence, String key) {
		String az = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String fullKey = fitKeyToSentence(key, sentence);
		String encrypted = "";
		
		//Il faut trouver le char de az dont l'index est égal à l'index d'az du char de sentence + l'index d'az du char de fullKey
		for(int i = 0; i<sentence.length(); i++) {
			//a) Checking if char at index i is a whitespace
			if(sentence.charAt(i) == ' ') {
				encrypted += " ";
			} else {
				
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
