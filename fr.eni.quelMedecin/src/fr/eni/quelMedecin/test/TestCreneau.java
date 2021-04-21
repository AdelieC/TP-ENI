package fr.eni.quelMedecin.test;

import java.time.LocalTime;

import fr.eni.quelMedecin.bo.Adresse;
import fr.eni.quelMedecin.bo.Creneau;
import fr.eni.quelMedecin.bo.MedecinGeneraliste;

/**
 * @date 25 oct. 2018
 * @version POO - V1.0
 * @author hboisgontier
 */
public class TestCreneau {
	public static void main(String[] args) {
		System.out.println("__________________________ Créneaux ______________________________");
		Adresse sh = new Adresse("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800,
				"Saint Herblain");
		MedecinGeneraliste melanie = new MedecinGeneraliste("Malalaniche", "Mélanie", "02.28.03.17.28", sh);
		Creneau c1 = new Creneau(LocalTime.of(9, 0), 15, melanie);
		c1.afficher();
		System.out.println("Médecin associé à ce créneau : Dr " + c1.getMedecin().getNom());
		System.out.println("------------------------------------------------------------------");
		new Creneau(LocalTime.of(9, 15), 15, melanie);
		new Creneau(LocalTime.of(9, 30), 15, melanie);
		new Creneau(LocalTime.of(9, 45), 15, melanie);
		new Creneau(LocalTime.of(10, 30), 15, melanie);
		new Creneau(LocalTime.of(10, 45), 15, melanie);
		new Creneau(LocalTime.of(11, 15), 15, melanie);
		new Creneau(LocalTime.of(11, 30), 15, melanie);
		new Creneau(LocalTime.of(11, 45), 15, melanie);
		melanie.afficher();
		System.out.println("------------------------------------------------------------------");
		new Creneau(LocalTime.of(14, 0), 30, melanie);
		new Creneau(LocalTime.of(14, 30), 30, melanie);
		new Creneau(LocalTime.of(15, 0), 30, melanie);
		new Creneau(LocalTime.of(15, 30), 30, melanie);
		new Creneau(LocalTime.of(16, 0), 30, melanie);
		new Creneau(LocalTime.of(16, 30), 30, melanie);
		melanie.afficher();
	}
}
