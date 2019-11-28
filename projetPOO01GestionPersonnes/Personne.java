package projetPOO01GestionPersonnes;


public class Personne {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String codepostal;
	
/**	
	public Personne() {
		 Constructeur par d�faut 
		this.adresse = "";
		this.codepostal = "";
		this.nom = "";
		this.prenom = "";
		this.ville = "";
		this("","","","","");
	}
**/	
	
	public Personne(String nom, String prenom, String adresse, String ville, String codepostal) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": nom = " + nom + ", prenom = " + prenom + ", adresse = " + adresse + ", ville = " + ville
				+ ", code postal = " + codepostal + " ";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	


	

}
