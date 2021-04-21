package fr.eni.quelMedecin.bo;

public class MedecinGeneraliste {
	private static int tarif = 0;
	private String nom = "", prenom = "", num = "";
	
	/**
	 * @param nom
	 * @param prenom
	 * @param num
	 */
	public MedecinGeneraliste(String nom, String prenom, String num) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.num = num;
	}
	
	public void afficher() {
		System.out.println(this.getNom());
		System.out.println("Téléphone : " + this.getNum());
		System.out.println("Tarif : " + this.getTarif());
	}
	
	/**
	 * @return the tarif
	 */
	public int getTarif() {
		return MedecinGeneraliste.tarif;
	}
	
	/**
	 * @param tarif the tarif to set
	 */
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom + " " + this.prenom;
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
	
	
	
}
