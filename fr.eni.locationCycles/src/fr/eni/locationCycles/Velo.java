package fr.eni.locationCycles;

import java.time.LocalDate;

public class Velo extends Cycle {
	private int vitesses;
	
	public Velo(LocalDate dateAchat, String modele, String marque, int vitesses) {
		super(dateAchat, marque, modele, tarif);
		this.vitesses = vitesses;
		this.addInfos(Integer.toString(vitesses) + " vitesses");
		Velo.tarif = 4.9f;
	}
	public void afficher() {
		System.out.print("Velo ");
		super.afficher();
	}
}
