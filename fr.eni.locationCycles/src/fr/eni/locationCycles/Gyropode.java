package fr.eni.locationCycles;

import java.time.LocalDate;

public class Gyropode extends Cycle implements Gyro {
	private int autonomie;
	private float tailleMin;
	
	/**
	 * @param dateAchat
	 * @param modele
	 * @param marque
	 * @param autonomie
	 */
	public Gyropode(LocalDate dateAchat, String modele, String marque, int autonomie, float tailleMin) {
		super(dateAchat, marque, modele, tarif);
		this.autonomie = autonomie;
		this.addInfos(Integer.toString(autonomie) + " km d'autonomie");
		this.addInfos("[" + Float.toString(tailleMin) + " minimum]");
	}

	public void setAutonomie(int autonomie) {
		this.autonomie = autonomie;
		
	}

	public int getAutonomie() {
		return this.autonomie;
	}
	public void afficher() {
		System.out.print("Gyropode ");
		super.afficher();
	}
}
