package fr.eni.suiteLogique;

public class Sequence {

	public static void main(String[] args) {
		final int DEPTH = 40;
		String sequenceStr = "1";
		char[] sequenceArr = {1};
		
		//1) First method where sequenceStr is a string :
		long start1 = System.nanoTime();
		for(int i = 0; i<DEPTH; i++) {
			System.out.println(sequenceStr);
			sequenceStr = nextLevel1(sequenceStr) + ".";
		}
		long end1 = System.nanoTime();
		
		//2) Second method where sequenceStr is a char array :
		long start2 = System.nanoTime();
		for(int i = 0; i<DEPTH; i++) {
			System.out.println(String.valueOf(sequenceArr));
			nextLevel2(sequenceArr);
		}
		long end2 = System.nanoTime();
		
		long time1 = end1 - start1;
		long time2 = end2 - start2;
		System.out.println("Durée d'exécution pour une profondeur de " + DEPTH + " :");
		System.out.println("Méthode avec String : " + time1/1000000 + " millisecondes");
		System.out.println("Méthode avec char[] : " + time2/1000000 + " millisecondes");
	}

	private static void nextLevel2(char[] sequenceArr) {
		// TODO Auto-generated method stub
	}

	private static String nextLevel1(String sequenceStr) {
		String newSequence = "";
		if(sequenceStr != "1") {
			for(int i = 1, count = 1; i<sequenceStr.length(); i++) {
				if(sequenceStr.charAt(i) != sequenceStr.charAt(i-1)) {
					newSequence += count + 0;
					newSequence += sequenceStr.charAt(i-1);
					count = 1;
				} else {
					count++;
				}
			}
		} else {
			newSequence = "11";
		}
		return newSequence;
	}
}
