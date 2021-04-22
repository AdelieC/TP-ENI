package fr.eni.quelMedecin.bo;

public class Personne {
	private String nom = "",
			prenom = "",
			num = "";
	private Adresse adresse;

	/**
	 * @param nom
	 * @param prenom
	 * @param num
	 * @param adresse
	 */
	public Personne(String nom, String prenom, String num, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.num = num;
		this.adresse = adresse;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return the nom
	 */
	public String getPrenom() {
		return this.prenom;
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

	public void afficher() {
		System.out.println(this.nom + " " + this.prenom);
		System.out.println("Téléphone : " + this.num);
		System.out.println("Adresse :");
		this.adresse.afficher();
	}
}
