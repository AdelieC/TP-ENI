package fr.eni.calculatrice;

public class DepassementCapaciteException extends Exception {

	private static final long serialVersionUID = 1L;
	public DepassementCapaciteException() {
		super("Navré, mais le résultat dépasse la capacité de cette calculatrice. Essayez avec vos neuronnes personnels, vous verrez ce que c'est!");
	}
}
