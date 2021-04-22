package fr.eni.locationCycles;

import java.time.LocalDate;

public abstract class Cycle {
	protected String	marque,
						modele,
						infos;
	protected LocalDate dateAchat;
	protected static float tarif;
	/**
	 * @param marque
	 * @param modele
	 * @param dateAchat
	 * @param tarif
	 */
	public Cycle(String marque, String modele, LocalDate dateAchat, float tarif) {
		this.marque = marque;
		this.modele = modele;
		this.dateAchat = dateAchat;
		this.infos = "";
		Cycle.tarif = tarif;
	}
	public int getAge() {
		return dateAchat.until(LocalDate.now()).getYears();
	}
	public void addInfos(String info) {
		this.infos += (" " + info);
	}
	public String toString() {
		return this.marque
				+ " "
				+ this.modele
				+ " ( " + this.getAge() + " ) "
				+ this.infos
				+ "-> "
				+ Cycle.tarif
				+ " euros/H";
	}
	public void afficher() {
		System.out.println(this);
	}
	
	
}
