package fr.eni.quelMedecin.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Creneau {
	private LocalTime debut;
	private int duree = 0;
	private MedecinGeneraliste medecin;
	
	public Creneau(LocalTime debut, int duree, MedecinGeneraliste medecin) {
		this.debut = debut;
		this.duree = duree;
		this.medecin = medecin;
		medecin.ajouterCreneau(this);
	}

	public void afficher() {
		System.out.println(this.debut.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)) + " - "
				+ this.debut.plusMinutes(this.duree).format( DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
				+ " ( "
				+ this.duree
				+ " minutes )");
	}

	public MedecinGeneraliste getMedecin() {
		return this.medecin;
	}
	
}
