package projetPOO01.GestionPersonnes;

import java.util.Dictionary;
import java.util.List;

import projetPOO01.Enumerations.EPersonne;
import projetPOO01.Exceptions.ErreurSaisie;
import projetPOO01.Methodes.Achat;


public class Salarie extends Personne implements IClient {
	private String nSecu;
	private String salaire;
	private String nClient;
	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String nSecu, String salaire) {
		super(nom, prenom, adresse, ville, codepostal); 
		this.nSecu = nSecu;
		this.salaire = salaire;
		this.nClient = null;
	}
	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String nSecu, String salaire,String nClient) {
		super(nom, prenom, adresse, ville, codepostal); 
		this.nSecu = nSecu;
		this.salaire = salaire;
		this.nClient = nClient;
	}
	public Salarie(Dictionary<EPersonne, String> dico) {
		this(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal),String.valueOf(dico.get(EPersonne.nSecu)),
				String.valueOf(dico.get(EPersonne.salaire)),dico.get(EPersonne.nClient));
	}




	@Override
	public boolean paie() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		
		if (this.nClient!=null) {
			return super.toString() + ", nSecu= " + nSecu+  ", Salaire= " + salaire+" €"+", nClient="+ nClient;
		}
		else {
			return super.toString() + ", nSecu= " + nSecu+  ", Salaire= " + salaire+" €";
		}
	}

	
	public static void checkSalaire(String salaire) throws ErreurSaisie {
		if (!salaire.matches("\\d{0,5},\\d{2}")) { 
			throw new ErreurSaisie("Attention il faut insérer au format XXXX,XX");
		}
	}
	// Les mettre dans une autre classe pour plus de lisibilité
	public static void checknSecu(String nSecu) throws ErreurSaisie {
		
		if (!nSecu.matches("\\d{13}")) {
			throw new ErreurSaisie("Il faut insérer 13 chiffres");		
		}
	}
	@Override
	public void achete(List<Achat> achat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean clientOuPas() {
		if (nClient != null) {
			return true;
		}
		return false;
	}
	@Override
	public String afficheNClient() {
		
		return nClient;
	}
	
	
}
