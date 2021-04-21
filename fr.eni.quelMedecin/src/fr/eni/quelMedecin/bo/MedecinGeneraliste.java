package fr.eni.quelMedecin.bo;

public class MedecinGeneraliste {
	private final static int MAXCRENEAUX = 15;
	private static int tarif = 25;
	private String nom = "", prenom = "", num = "";
	private Adresse adresse;
	private Creneau[] creneaux = new Creneau[MAXCRENEAUX];
	private int nombreCreneaux = 0;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param num
	 */
	public MedecinGeneraliste(String nom, String prenom, String num, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.num = num;
		this.adresse = adresse;
	}
	
	public void afficher() {
		System.out.println(this.nom + " " + this.prenom);
		System.out.println("Téléphone : " + this.num);
		System.out.println("Tarif : " + MedecinGeneraliste.tarif + " euros");
		System.out.println("Adresse :");
		this.adresse.afficher();
		System.out.println("Créneaux :");
		for(Creneau creneau : this.creneaux)
			if(creneau != null) creneau.afficher();
	}
	
	public void ajouterCreneau(Creneau creneau) {
		if(this != creneau.getMedecin()) {
			System.err.println("Erreur : le médecin ne correspond pas au créneau que vous souhaitez ajouter.");
		} else if(this.nombreCreneaux > 14) {
			System.err.println("Ce médecin n'a plus de créneaux disponibles.");
		} else {
			this.creneaux[this.nombreCreneaux] = creneau;
			this.nombreCreneaux++;
		}
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
		return this.nom;
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
