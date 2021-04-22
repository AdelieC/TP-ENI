package fr.eni.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient extends Personne {
	private String commentaires = "";
	private char sexe;
	private long numSecu = 0l;
	private LocalDate dateNaissance;
	

	/**
	 * @param nom
	 * @param prenom
	 * @param num
	 * @param adresse
	 * @param commentaires
	 * @param sexe
	 * @param numSecu
	 * @param dateNaissance
	 */
	public Patient(String nom, String prenom, String num, char sexe, long numSecu, LocalDate dateNaissance, String commentaires, Adresse adresse) {
		super(nom, prenom, num, adresse);
		this.commentaires = commentaires;
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
	}
	
	/**
	 * @return the sexe
	 */
	public char getSexe() {
		return this.sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the numSecu
	 */
	public long getNumSecu() {
		return this.numSecu;
	}

	/**
	 * @param numSecu the numSecu to set
	 */
	public void setNumSecu(long numSecu) {
		this.numSecu = numSecu;
	}

	/**
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the commentaires
	 */
	public String getCommentaires() {
		return this.commentaires;
	}

	/**
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	public String dateNaissanceToString() {
		return this.dateNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
	}

	public void afficher() {
		super.afficher();
		System.out.println("Sexe : " + (this.sexe == 'F'? "Féminin" : "Masculin"));
		System.out.println("Numéro de sécurité sociale : : " + this.numSecu);
		System.out.println("Date de naissance : " + this.dateNaissanceToString());
		System.out.println(this.commentaires != null ? this.commentaires : "[aucun commentaire]");
	}
}
