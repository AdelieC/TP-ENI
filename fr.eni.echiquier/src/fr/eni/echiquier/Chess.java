package fr.eni.echiquier;

import java.math.BigInteger;

public class Chess {
		
	public static void main(String[] args) {
		final int SIZE = 8;
		BigInteger total = BigInteger.ONE;
		BigInteger riceGrains = BigInteger.ONE;
		for(int i = 1; i<SIZE*SIZE; i++) {
			riceGrains = riceGrains.add(riceGrains);
			total = total.add(riceGrains);
		}
		System.out.println(total);
	}
}
