package fr.eni.suiteLogique;

public class Sequence {

	public static void main(String[] args) {
		final int DEPTH = 10;
		String sequence = "1211";
		
		/* changement de type (ENCORE.......) -> on va bosser avec des strings!
		*/
		for(int i = 0; i<DEPTH+1; i++) {
			System.out.println(sequence);
			sequence = nextLevel(sequence) + ".";
		}
	}

	private static String nextLevel(String sequence) {
		String tmp = "";
		for(int i = 1, count = 1; i<sequence.length(); i++) {
			if(sequence.charAt(i) != sequence.charAt(i-1)) {
				tmp += count + 0;
				tmp += sequence.charAt(i-1);
				count = 1;
			} else {
				count++;
			}
		}
		return tmp;
	}
}
