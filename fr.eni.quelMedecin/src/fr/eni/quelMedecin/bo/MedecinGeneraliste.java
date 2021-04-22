package fr.eni.quelMedecin.bo;

public class MedecinGeneraliste extends Personne {
	protected final static int MAXCRENEAUX = 15;
	protected int tarif;
	protected Creneau[] creneaux = new Creneau[MAXCRENEAUX];
	protected int nombreCreneaux = 0;
	
	
	/**
	 * @param nom
	 * @param prenom
	 * @param num
	 * @param adresse
	 */
	public MedecinGeneraliste(String nom, String prenom, String num, Adresse adresse) {
		super(nom, prenom, num, adresse);
		this.tarif = 25;
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
		return this.tarif;
	}
	
	/**
	 * @param tarif the tarif to set
	 */
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	
	
	public void afficher() {
		super.afficher();
		System.out.println("Tarif : " + this.tarif + " euros");
		System.out.println("Créneaux :");
		for(Creneau creneau : this.creneaux)
			if(creneau != null) creneau.afficher();
	}
	
}
