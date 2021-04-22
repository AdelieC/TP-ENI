package fr.eni.quelMedecin.bo;

public class MedecinSpecialiste extends MedecinGeneraliste {
	private String specialite;
	/**
	 * @param nom
	 * @param prenom
	 * @param num
	 * @param adresse
	 */
	public MedecinSpecialiste(String nom, String prenom, String num, Adresse adresse, String specialite, int tarif) {
		super(nom, prenom, num, adresse);
		this.specialite = specialite;
		this.tarif = tarif;
	}
	
	public void afficher() {
		super.afficher();
		System.out.println("Spécialité : " + this.specialite);
		System.out.println("Tarif : " + this.tarif);
	}
	
}
