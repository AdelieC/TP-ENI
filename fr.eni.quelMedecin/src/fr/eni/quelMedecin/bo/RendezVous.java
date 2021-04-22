package fr.eni.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RendezVous {
	private Creneau creneau;
	private Patient patient;
	private LocalDate date;
	
	/**
	 * @param creneau
	 * @param patient
	 * @param date
	 */
	public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
		this.creneau = creneau;
		this.patient = patient;
		this.date = date;
	}
	
	public void afficher() {
		System.out.print("Rendez-vous le "
					+ this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
					+ " à ");
		this.creneau.afficher();
		System.out.println("Avec le Docteur "
					+ this.creneau.getMedecin().getNom());
		System.out.print("Pour ");
		this.patient.afficher();
	}
	
}
