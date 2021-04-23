package fr.eni.calculatrice;

import java.util.Scanner;

public class Calculatrice {
	public final static Scanner SCAN = new Scanner(System.in);
	public final static char OPERATEURS[] = {'+', '-', '*', '/', '%', 'q'};
	public static void main(String[] args) {
		int a = 0, b = 0;
		char operateur = ' ';
		
		afficherMessageAccueil();
		do {
			try {
				a = demanderNombre(false);
				b = demanderNombre(true);
				operateur = demanderOperateur(b);
				calculer(operateur, a, b);
			} catch(DepassementCapaciteException e) {
				System.err.println(e.getMessage());
			} catch(NumberFormatException e) {
				System.err.println("Le nombre entré est trop grand, Iconoclaste!! Revoyez vos exigences à la baisse.");
			}
		} while(operateur!='q');
		SCAN.close();
	}
	
	private static void afficherMessageAccueil() {
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("*      BIENVENUE SUR LA CALCULATRICE LA PLUS VÉNÈRE AU MONDE !!!           *");
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("*  Vous pouvez additionner, multiplier, diviser (PAS PAR ZERO!!!!)         *");
		System.out.println("*  et moduler? ou modulo?                                                  *");
		System.out.println("*  Suivez ses consignes à la lettre, sinon vous aurez le droit à un savon! *");
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
	}
	
	private static int demanderNombre(boolean deuxieme) throws NumberFormatException {
		String tmp = "";
		boolean valide = false;
		System.out.print("Choisissez la " + (deuxieme ? "seconde" : "première") + " opérande : ");
		do {
			System.out.print(tmp.isBlank()? "entrez un nombre entier (inférieur à 2 147 483 648)-> " : "Saisie invalide, Zigomar!! Entrez un VRAI nombre entier (CETTE FOIS!!) -> ");
			tmp = SCAN.nextLine();
			valide = tmp.matches("\\d+");
		} while(!valide);
		return Integer.parseInt(tmp);
	}
	
	private static void calculer(char operateur, int a, int b) throws DepassementCapaciteException {
		int resultat = 0;
		switch(operateur) {
			case 'q' :
				break;
			case '+' :
				resultat = Operation.additionner(a,b);
				break;
			case '-' :
				resultat = Operation.soustraire(a,b);
				break;
			case '*' :
				resultat = Operation.multiplier(a,b);
				break;
			case '/' :
				resultat = a/b;
				break;
			case '%' :
				resultat = a%b;
				break;
		}
		System.out.println(operateur == 'q' ? "À bientôt pour des supers calculs inutiles!" : a + " " + operateur + " " + b + " = " + resultat + " !! Allez c'est reparti pour un tour!!");
	}
	
	private static char demanderOperateur(int b) {
		String tmp = "";
		boolean valide = false;
		do {
			System.out.print(tmp.isBlank()? "Choisissez un opérateur dans la liste suivante : * / - + % . Sinon tapez q pour quitter -> " : "Saisie invalide, Bachibouzouk! Entrez un opérateur QUI EXISTE!!!s-> ");
			tmp = SCAN.nextLine();
			valide = tmp.matches("[\\+/\\*\\-%q]{1}");
			if(tmp.matches("/") && b == 0) {
				System.err.println("Impossible de diviser par 0!! Revoyez vos maths...");
				valide = false;
			}
		} while(!valide);
		return tmp.charAt(0);
	}

}
