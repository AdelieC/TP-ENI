package fr.eni.locationCycles;

import java.time.LocalDate;

public class Gyroroue extends Cycle implements Gyro {
	private int autonomie;

	/**
	 * @param dateAchat
	 * @param modele
	 * @param marque
	 * @param autonomie
	 */
	public Gyroroue(LocalDate dateAchat, String modele, String marque, int autonomie) {
		super(dateAchat, marque, modele, tarif);
		this.autonomie = autonomie;
		this.addInfos(Integer.toString(autonomie) + " km d'autonomie");
	}
	
	public void setAutonomie(int autonomie) {
		this.autonomie = autonomie;
		
	}

	public int getAutonomie() {
		return this.autonomie;
	}
	public void afficher() {
		System.out.print("Gyroroue ");
		super.afficher();
	}
}
