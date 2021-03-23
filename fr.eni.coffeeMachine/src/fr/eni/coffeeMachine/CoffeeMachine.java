package fr.eni.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	final static int[] POSSIBLE_COINS = {200, 100, 50, 20, 10, 5};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int PRICE = 60;
		int choice = 0;
		int paid = 0;
		int changeDue = 0;
		
		//1) Loop to get coins input(s) from user
		do {
			System.out.println("Prix du café : " + (float)PRICE/100 + " euros");
			if(paid < PRICE) {
				System.out.println("Vous avez mis " + (float)paid/100 + " euros. Il vous reste " + (float)(PRICE - paid)/100 + " euros à payer.");
			}
			showChoices(POSSIBLE_COINS);
			choice = scan.nextInt();
			if(choice > 0 && choice < 7) {
				paid = paid + POSSIBLE_COINS[choice - 1];
			} else {
				System.out.println("Choix de pièce incorrect : entrez un chiffre compris entre 1 et 6");
			}
		} while(paid < PRICE);
		
		//2) If there's change to be given back, show infos + calculate change and show result
		changeDue = paid - PRICE;
		if(changeDue == 0){
			System.out.println("Le compte est bon. Pas de monnaie à rendre. Voici votre café!");
		} else {
			System.out.println("Vous avez mis "+ (float)paid/100 + " euros. Je vous rends donc " + (float)changeDue/100 +" euros. Voici votre monnaie :");
			showChange(changeDue);
		}
		System.out.println("Merci pour votre achat! À bientôt!");
		scan.close();
	}

	private static void showChange(int changeDue) {
		//Show number of coins (> 0) of each possible coin value by looping through both arrays
		int[] numberOfCoins = numberOfCoins(changeDue);
		for(int i = 0; i < POSSIBLE_COINS.length; i++) {
			if(numberOfCoins[i] > 0) {
				System.out.println(numberOfCoins[i] + " pièce(s) de " + (float)POSSIBLE_COINS[i]/100 + " euros");
			}
		}
	}

	private static int[] numberOfCoins(int changeDue) {
		//Put numbers of coins of each possible coin value into an array which is exactly the same length as POSSIBLE_COINS
		int[] numberOfCoins = new int[POSSIBLE_COINS.length];
		while(changeDue > 0){
			for(int i = 0; i < POSSIBLE_COINS.length; i++) {
				if((changeDue/POSSIBLE_COINS[i]) >= 1) {
					numberOfCoins[i] = changeDue/POSSIBLE_COINS[i];
					changeDue = changeDue%POSSIBLE_COINS[i];
				} else {
					numberOfCoins[i] = 0;
				}
			}
		}
		return numberOfCoins;
	}

	private static void showChoices(int[] POSSIBLE_COINS) {
		//Loop through POSSIBLE_COINS array to show the list of possible choices for coins
		System.out.println("Entrez une pièce dans la machine :");
		for(int i = 0; i<POSSIBLE_COINS.length; i++) {
			System.out.println((i+1) + " - Une pièce de " + (float)POSSIBLE_COINS[i]/100 + " euros");
		}
	}

}
