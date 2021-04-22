package fr.eni.calculatrice;

import java.util.Scanner;

public class Calculatrice {
	public final static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int a = 0, b = 0;
		char operateur;
		
		a = demanderNombre();
		b = demanderNombre();
		operateur = demanderOperateur();
		calculer(operateur, a, b);

	}

}
