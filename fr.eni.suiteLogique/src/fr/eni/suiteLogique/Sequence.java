package fr.eni.suiteLogique;

public class Sequence {

	public static void main(String[] args) {
		final int DEPTH = 40;
		String sequence = "1";
		
		long start = System.nanoTime();
		for(int i = 0; i<DEPTH; i++) {
			System.out.println(sequence);
			sequence = nextLevel(sequence) + ".";
		}
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Durée d'exécution pour une profondeur de " + DEPTH + " = " + time/1000000 + " millisecondes");
	}

	private static String nextLevel(String sequence) {
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
