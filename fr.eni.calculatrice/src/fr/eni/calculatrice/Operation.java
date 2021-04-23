package fr.eni.calculatrice;

public class Operation {
	
	public static int additionner(int a, int b) throws DepassementCapaciteException {
		long A = (long)a, B = (long)b;
		if(a+b != A+B) throw new DepassementCapaciteException();
		return a + b;
	}
	public static int soustraire(int a, int b) throws DepassementCapaciteException {
		long A = (long)a, B = (long)b;
		if(a-b != A-B) throw new DepassementCapaciteException();
		return a - b;
	}
	public static int multiplier(int a, int b) throws DepassementCapaciteException {
		long A = (long)a, B = (long)b;
		if(a*b != A*B) throw new DepassementCapaciteException();
		return a * b;
	}
}
