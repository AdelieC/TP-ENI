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
		
		do {
			if(paid < PRICE) {
				System.out.println("Vous avez mis " + (float)paid/100 + " euros. Il vous reste " + (float)(PRICE - paid)/100 + " euros à payer.");
			}
			showChoices(POSSIBLE_COINS);
			choice = scan.nextInt();
			paid = paid + POSSIBLE_COINS[choice - 1];
		} while(paid < PRICE);
		scan.close();
		changeDue = paid - PRICE;
		if(paid == PRICE){
			System.out.println("Le compte est bon. Pas de monnaie à rendre. Voici votre café!");
		} else {
			System.out.println("Vous avez mis "+ (float)paid/100 + " euros. Je vous rends donc " + (float)changeDue/100 +" euros. Voici votre monnaie :");
			showChange(changeDue);
		}
		
		System.out.println("Merci pour votre achat! À bientôt!");
	}

	private static void showChange(int changeDue) {
		int[] numberOfCoins = numberOfCoins(changeDue);
		for(int i = 0; i < POSSIBLE_COINS.length; i++) {
			if(numberOfCoins[i] > 0) {
				System.out.println(numberOfCoins[i] + " pièce(s) de " + (float)POSSIBLE_COINS[i]/100 + " euros");
			}
		}
		
	}

	private static int[] numberOfCoins(int changeDue) {
		int[] numberOfCoins = new int[POSSIBLE_COINS.length];
		while(changeDue >= 0){
			//TODO revoir ma logique mdr : trop de fatigue...
			for(int i = 1; i < POSSIBLE_COINS.length; i++) {
				if(changeDue <= POSSIBLE_COINS[i]) {
					numberOfCoins[i-1] = POSSIBLE_COINS[i-1]/changeDue;
					changeDue -= POSSIBLE_COINS[i-1]%changeDue;
				} else {
					numberOfCoins[i] = 0;
				}
			}
		}
		return numberOfCoins;
	}

	private static void showChoices(int[] POSSIBLE_COINS) {
		System.out.println("Entrez une pièce dans la machine :");
		for(int i = 0; i<POSSIBLE_COINS.length; i++) {
			System.out.println((i+1) + " - Une pièce de " + (float)POSSIBLE_COINS[i]/100 + " euros");
		}
	}

}
