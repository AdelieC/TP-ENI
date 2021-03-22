package fr.eni.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	final static int[] POSSIBLE_COINS = {200, 100, 50, 20, 10, 5};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int PRICE = 60;
		int paid = 0;
		int due = 0;
		
		do {
			showChoices(POSSIBLE_COINS);
			paid = paid + POSSIBLE_COINS[scan.nextInt()-1];
		} while(paid < PRICE);
		
		due = paid - PRICE;
		System.out.println("Je vous rends donc " + intoCoins(due) + "euros. Votre café est en préparation.");
	}

	private static int[] intoCoins(int due) {
		int[] numberOfCoins = new int[POSSIBLE_COINS.length];
		while(due >= 0){
			for(int i = 0; i<POSSIBLE_COINS.length; i++) {
				if(due <= POSSIBLE_COINS[i]) {
					numberOfCoins[i] = due/POSSIBLE_COINS[i];

				} else {
					
				}
			}
		}
		return coins;
	}

	private static void showChoices(int[] POSSIBLE_COINS) {
		System.out.println("Entrez une pièce dans la machine :");
		for(int i = 0; i<POSSIBLE_COINS.length; i++) {
			System.out.println((i+1) + " - Une pièce de " + (float)POSSIBLE_COINS[i]/100 + " euros");
		}
	}

}
