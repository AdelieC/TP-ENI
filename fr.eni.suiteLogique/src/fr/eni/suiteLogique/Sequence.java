package fr.eni.suiteLogique;

public class Sequence {

	public static void main(String[] args) {
		final int DEPTH = 40;
		int[] sequence = {1,2,1,1};
		
		/* 1) Commençons par le commencement : on va déjà essayer de passer un niveau en commençant au milieu!
		-> de 1211 à 111221 :
		*/
		for(int i = 0; i<10; i++) {
			sequence = nextLevel(sequence);
			show(sequence);
		}
	}

	private static int[] nextLevel(int[] sequence) {
		for(int i = 0, count = 0; i<sequence.length; i++) {
			if(i>0) {
				if(sequence[i-1] == sequence[i]) {
					count++;
					System.out.println("same digit and count = " + count);
				} else {
					count = 0;
					System.out.println("not same digit and count = " + count);
				}
			} else {
				
			}
		}
		return sequence;
	}

	private static void show(int[] sequence) {
		for(int digit : sequence) {
			System.out.print(digit);
		}
		System.out.println();
	}
}
