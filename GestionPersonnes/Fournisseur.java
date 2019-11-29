package projetPOO01.GestionPersonnes;

import java.util.Dictionary;
import java.util.List;

import projetPOO01.Enumerations.EPersonne;
import projetPOO01.Exceptions.ErreurSaisie;
import projetPOO01.Methodes.Achat;
import projetPOO01.Methodes.Commande;

public class Fournisseur extends Personne implements IClient, IFournisseur {
	private String nFournisseur;
	public boolean clientOuPas = false;
	private String nClient;
	
	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String nFournisseur) {
		super(nom, prenom, adresse, ville, codepostal); 
		this.nFournisseur = nFournisseur;
		this.nClient = null;
	}
	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String nFournisseur, String nClient) {
		super(nom, prenom, adresse, ville, codepostal); 
		this.nFournisseur = nFournisseur;
		this.nClient = nClient;

	}

	public Fournisseur(Dictionary<EPersonne, String> dico) {
		this(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal),String.valueOf(dico.get(EPersonne.nFour)),
				dico.get(EPersonne.nClient));
	}

	@Override
	public void achete() {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur achète");

	}



	@Override
	public void commande(List<Commande> commandes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		if (this.nClient!=null) {
			return super.toString() + ", nFournisseur=" + nFournisseur +", nClient=" + nClient ;
		}
		else {
			return super.toString() + ", nFournisseur=" + nFournisseur  ;
		}
	}

	public String getnFournisseur() {
		return nFournisseur;
	}

	public void setnFournisseur(String nFournisseur) {
		this.nFournisseur = nFournisseur;
	}

	@Override
	public void achete(List<Achat> achat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean livre() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fournisseurOuPas() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean paie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clientOuPas() {
		if (nClient != null) {
			return true;
		}
		return false;
	}
	
	public static void testNFournisseur(String nFournisseur,List<String> listNFournisseur) throws ErreurSaisie {
		for (String f:listNFournisseur) {
			if (f.equals(nFournisseur)) {
				throw new ErreurSaisie("Attention le numéro fournisseur existe déjà");
				}
			}
		}
	@Override
	public String afficheNClient() {

		return nClient;
	}	

}
