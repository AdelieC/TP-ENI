package fr.eni.gestionVille;

import java.util.Scanner;

public class City {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] citiesArr = {"Lille", "Lens", "Amiens", "Rouen", "Caen", "Rennes", "Nantes", "Niort", "Bordeaux", "Bayonne"};
		String letter = "";
		
		//1) Asking the user for input 
		System.out.println("Entrez la première lettre de la ou des villes que vous voulez afficher OU 1 pour tout afficher :");
		letter = scan.nextLine();
		
		//2) Checking validity of input given
		while(!letter.matches("[1a-zA-Z]{1}")) {
			System.out.println("Ce que vous avez écrit n'est pas une lettre. Réessayez :");
			letter = scan.nextLine();
		}
		//3) Uppercase all citiesArr in list (cause I'm lazy)
		upper(citiesArr);
		
		//4) Show all citiesArr if input was 1, or just citiesArr beginning with letter in input
		show(citiesArr, letter);
		scan.close();
	}

	private static void upper(String[] citiesArr) {
		for(String city : citiesArr) {
			city = city.toUpperCase();
		}
	}

	private static void show(String[] citiesArr, String letter) {
		if(letter.charAt(0) == '1') {
			for(String city : citiesArr) {
				System.out.print(city + " ");
			}
		} else {
			String result = searchByLetter(citiesArr, letter);
			if(!result.isBlank()) {
				System.out.println("La ou les villes dont le nom commence par " + letter + " est/sont :");
				System.out.println(result);
			} else {
				System.out.println("Il n'y a aucune ville commençant par \"" + letter + "\" dans la liste.");
			}
		}
	}

	private static String searchByLetter(String[] citiesArr, String letter) {
		String result = "";
		for(String city : citiesArr) {
			result += city.charAt(0) == letter.toUpperCase().toCharArray()[0] ? city + " " : "";
		}
		return result;
	}
}
