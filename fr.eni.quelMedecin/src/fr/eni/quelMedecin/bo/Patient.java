package fr.eni.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient {
	private String nom = "",
			prenom = "",
			num = "",
			commentaires = "";
	private char sexe;
	private long numSecu = 0l;
	private LocalDate dateNaissance;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param num
	 * @param sexe
	 * @param numSecu
	 * @param dateNaissance
	 */
	public Patient(String nom, String prenom, String num, char sexe, long numSecu, LocalDate dateNaissance, String commentaires) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.num = num;
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
		this.commentaires = commentaires;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom + " " + this.prenom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return this.num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
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
		System.out.println(this.getNom());
		System.out.println("Téléphone : " + this.getNum());
		System.out.println("Sexe : " + (this.getSexe() == 'F'? "Féminin" : "Masculin"));
		System.out.println("Numéro de sécurité sociale : : " + this.getNumSecu());
		System.out.println("Date de naissance : " + this.dateNaissanceToString());
		System.out.println(this.commentaires != null ? this.commentaires : "[aucun commentaire]");
	}
}
