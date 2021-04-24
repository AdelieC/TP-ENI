package fr.eni.reversi;

import java.util.Scanner;

public abstract class Outils {
	private final static Scanner SCAN = new Scanner(System.in);
	
	public static String getInputString(String msg) {
		String tmp = "";
		boolean valide = false;
		do {
			System.out.print(tmp.isBlank()? "Entrez " + msg + " -> " : "Saisie invalide, réessayez svp -> ");
			tmp = SCAN.nextLine();
			valide = tmp.matches("\\w+");
		} while(!valide);
		return tmp;
	}
	
	public static String getInputString(String msg, int nbDeLettres) {
		String tmp = "";
		boolean valide = false;
		do {
			System.out.print(tmp.isBlank()? "Entrez " + msg + " -> " : "Saisie invalide, réessayez svp -> ");
			tmp = SCAN.nextLine();
			valide = tmp.matches("\\w{" + nbDeLettres + "}");
		} while(!valide);
		return tmp;
	}
	
	public static char getInputChar(String msg) {
		String tmp = "";
		boolean valide = false;
		do {
			System.out.print(tmp.isBlank()? "Entrez " + msg + " -> " : "Saisie invalide, réessayez svp -> ");
			tmp = SCAN.nextLine();
			valide = tmp.matches("[a-zA-Z]{1}");
		} while(!valide);
		return tmp.charAt(0);
	}
	
	public static int getInputInt(String msg) {
		String tmp = "";
		boolean valide = false;
		do {
			System.out.print(tmp.isBlank()? "Entrez " + msg + " -> " : "Saisie invalide, réessayez svp -> ");
			tmp = SCAN.nextLine();
			valide = tmp.matches("\\d+");
		} while(!valide);
		return Integer.parseInt(tmp);
	}
	
	public static int getInputInt(String msg, int nbDeChiffres) {
		String tmp = "";
		boolean valide = false;
		do {
			System.out.print(tmp.isBlank()? "Entrez " + msg + " -> " : "Saisie invalide, réessayez svp -> ");
			tmp = SCAN.nextLine();
			valide = tmp.matches("\\d{" + nbDeChiffres + "}");
		} while(!valide);
		return Integer.parseInt(tmp);
	}
	
	public static boolean quitter() {
		int input = 0;
		System.out.println("Souhaitez-vous rejouer ou quitter?");
		System.out.println("1 = rejouer");
		System.out.println("2 = quitter");
		input = Outils.getInputInt("votre choix", 1);
		return input == 2;
	}
	
	public static void closeScan() {
		SCAN.close();
	}

	
}
