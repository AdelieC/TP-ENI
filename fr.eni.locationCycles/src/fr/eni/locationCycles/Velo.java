package fr.eni.locationCycles;

import java.time.LocalDate;

public class Velo extends Cycle {
	private int vitesses;
	
	public Velo(String marque, String modele, LocalDate dateAchat, int vitesses) {
		super(marque, modele, dateAchat, tarif);
		this.vitesses = vitesses;
		this.addInfos(Integer.toString(vitesses) + " vitesses");
		Velo.tarif = 4.9f;
	}
}
