package fr.eni.locationCycles;

import java.time.LocalDate;

public class Gyropode extends Cycle implements Gyro {
	private int autonomie;
	private float tailleMin;
	
	/**
	 * @param marque
	 * @param modele
	 * @param dateAchat
	 * @param autonomie
	 */
	public Gyropode(String marque, String modele, LocalDate dateAchat, int autonomie, float tailleMin) {
		super(marque, modele, dateAchat, tarif);
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
}
