package fr.eni.locationCycles;

import java.time.LocalDate;

public class Gyroroue extends Cycle implements Gyro {
	private int autonomie;

	/**
	 * @param marque
	 * @param modele
	 * @param dateAchat
	 * @param autonomie
	 */
	public Gyroroue(String marque, String modele, LocalDate dateAchat, int autonomie) {
		super(marque, modele, dateAchat, tarif);
		this.autonomie = autonomie;
		this.addInfos(Integer.toString(autonomie) + " km d'autonomie");
	}
	
	public void setAutonomie(int autonomie) {
		this.autonomie = autonomie;
		
	}

	public int getAutonomie() {
		return this.autonomie;
	}
}
