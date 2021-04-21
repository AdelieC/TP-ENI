package fr.eni.quelMedecin.bo;

public class Adresse {
	private String mentionsComplementaires;
	private int numero;
	private String complNumero;
	private String rue;
	private int cp;
	private String ville;
	
	/**
	 * @param mentionsComplementaires
	 * @param numero
	 * @param complNumero
	 * @param rue
	 * @param cp
	 * @param ville
	 */
	public Adresse(String mentionsComplementaires, int numero, String complNumero, String rue, int cp, String ville) {
		this.mentionsComplementaires = mentionsComplementaires;
		this.numero = numero;
		this.complNumero = complNumero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville.toUpperCase();
	}
	
	public Adresse(int numero, String complNumero, String rue, int cp, String ville) {
		this(null, numero, complNumero, rue, cp, ville);
	}
	
	/**
	 * @return the mentionsComplementaires
	 */
	public String getMentionsComplementaires() {
		return this.mentionsComplementaires;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return this.numero;
	}
	/**
	 * @return the complNumero
	 */
	public String getComplNumero() {
		return this.complNumero;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return this.rue;
	}
	/**
	 * @return the cp
	 */
	public int getCp() {
		return this.cp;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return this.ville;
	}
	/**
	 * @param mentionsComplementaires the mentionsComplementaires to set
	 */
	public void setMentionsComplementaires(String mentionsComplementaires) {
		this.mentionsComplementaires = mentionsComplementaires;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @param complNumero the complNumero to set
	 */
	public void setComplNumero(String complNumero) {
		this.complNumero = complNumero;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public void afficher() {
		if(this.mentionsComplementaires != null) System.out.println(this.getMentionsComplementaires());
		System.out.println(this.getNumero() + " "
							+ ((this.complNumero != null) ? this.complNumero : "")
							+ this.getRue());
		System.out.println(this.getCp() + " " + this.getVille());
	}
}
