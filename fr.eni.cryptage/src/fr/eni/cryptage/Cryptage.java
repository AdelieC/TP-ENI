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
		System.out.println("Votre phrase cryptée avec la clé " + key + " est : " + sentence);
		scan.close();
	}

	private static String crypt(String sentence, String key) {
		char[][] chart = new char[26][26];
		for(int i = 0; i<26; i++) {
			for(int j = 0; j<26; j++) {
				chart[i][j] = 0;
			}
		}
		return null;
	}

}
