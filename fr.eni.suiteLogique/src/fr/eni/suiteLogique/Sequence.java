package fr.eni.suiteLogique;

public class Sequence {

	public static void main(String[] args) {
		final int DEPTH = 40;
		String sequence = "1";
		StringBuilder sequenceB = new StringBuilder("1");
		
		//1) First method where sequence is a string :
		long start1 = System.nanoTime();
		for(int i = 0; i<DEPTH; i++) {
			System.out.println(sequence);
			sequence = nextLevel1(sequence) + ".";
		}
		long end1 = System.nanoTime();
		
		//2) Second method where sequence is a StringBuilder :
		long start2 = System.nanoTime();
		for(int i = 0; i<DEPTH; i++) {
			System.out.println(sequenceB);
			sequenceB = nextLevel2(sequenceB).append(".");
		}
		long end2 = System.nanoTime();
		
		long time1 = end1 - start1;
		long time2 = end2 - start2;
		System.out.println("Durée d'exécution pour une profondeur de " + DEPTH + " :");
		System.out.println("Méthode avec String : " + time1/1000000 + " millisecondes");
		System.out.println("Méthode avec StringBuilder : " + time2/1000000 + " millisecondes");
	}

	private static StringBuilder nextLevel2(StringBuilder sequenceB) {
		StringBuilder builder = new StringBuilder();
		if(sequenceB.length() > 1) {
			for(int i = 1, count = 1; i<sequenceB.length(); i++) {
				if(sequenceB.charAt(i) != sequenceB.charAt(i-1)) {
					builder.append(count);
					builder.append(sequenceB.charAt(i-1));
					count = 1;
				} else {
					count++;
				}
			}
		} else {
			builder.append("11");
		}
		return builder;
	}

	private static String nextLevel1(String sequence) {
		String newSequence = "";
		if(sequence != "1") {
			for(int i = 1, count = 1; i<sequence.length(); i++) {
				if(sequence.charAt(i) != sequence.charAt(i-1)) {
					newSequence += count + 0;
					newSequence += sequence.charAt(i-1);
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
