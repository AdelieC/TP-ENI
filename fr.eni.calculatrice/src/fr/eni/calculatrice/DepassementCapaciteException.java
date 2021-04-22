package fr.eni.calculatrice;

public class DepassementCapaciteException extends ArithmeticException {

	private static final long serialVersionUID = 1L;
	public DepassementCapaciteException() {
		super("Le résultat dépasse la capacité de la calculatrice");
	}

}
