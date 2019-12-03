package projetPOO01.GestionPersonnes;

import projetPOO01.Exceptions.ErreurSaisie;

public class Personne {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String codepostal;
	private String clientOuPas;

/**	
	public Personne() {
		 Constructeur par défaut 
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
		this.setClientOuPas("non");
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


	public void achete() {
		// TODO Auto-generated method stub
		
	}
	
	public static void checkCodePostal(String codepostal) throws ErreurSaisie {
		if(codepostal.length() !=5) {
			throw new ErreurSaisie("Attention le code postal doit être composé de 5 chiffres");
		}
		try {
			Integer.parseInt(codepostal);
		}
		catch(Exception e) {
			throw new ErreurSaisie("Attention il faut insérer des chiffres");
		}
	}
	

	public static void checkOuiNon(String clientOuPas) throws ErreurSaisie {
		if(!clientOuPas.equals("oui")&&!clientOuPas.equals("non")) {
			throw new ErreurSaisie("Attention taper oui ou non");
		}
	}


	public String getClientOuPas() {
		return clientOuPas;
	}


	public void setClientOuPas(String clientOuPas) {
		this.clientOuPas = clientOuPas;
	}

	

}
