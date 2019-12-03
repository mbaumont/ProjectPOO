package projetPOO01.GestionPersonnes;

import java.util.Dictionary;
import java.util.List;

import projetPOO01.Enumerations.EPersonne;
import projetPOO01.Exceptions.ErreurSaisie;
import projetPOO01.Methodes.Achat;
import projetPOO01.Methodes.Commande;

public class Client extends Personne implements IFournisseur, IClient {
	
	private String nClient;
	private String nFour;
	private List<Achat> listAchats;
	private List<Commande> listCommandes;

	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String nClient) {
		super(nom, prenom, adresse, ville, codepostal); // Obligatoire de donner le constructeur si pas de constructeur par défaut 
		this.nClient = nClient;
		this.nFour = null;
		this.setListAchats(null);
		
	}
	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String nClient, String nFour) {
		super(nom, prenom, adresse, ville, codepostal); 
		this.nClient = nClient;
		this.nFour = nFour;
		this.setListAchats(null);
		
	}	

	public Client(Dictionary<EPersonne, String> dico) {
		this(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal),String.valueOf(dico.get(EPersonne.nClient)),dico.get(EPersonne.nFour));
		this.setListAchats(null);
	}


	@Override
	
	public boolean livre() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getnClient() {
		return nClient;
	}

	public void setnClient(String nClient) {
		this.nClient = nClient;
	}

	@Override
	public void commande(List<Commande> commandes) {
		setListCommandes(this.listCommandes);
	}

	@Override
	public void achete() {
		// TODO Auto-generated method stub
		System.out.println("Client achète");
		
	}

	@Override
	public boolean paie() {
		// TODO Auto-generated method stub
		System.out.println("Client paie");
		return true;
	}

	@Override
	public String toString() {
		if (this.nFour!=null) return super.toString() + ", Numéro Client= "+nFour+ ", Numéro Fournisseur= "+nFour;
		else return super.toString() + ", Numéro Client= "+nClient;	
	}


	@Override
	public void achete(List<Achat> achat) {
		setListAchats(achat);	
	}
	public boolean fournisseurOuPas() {
		if (nFour != null) {
			return true;
		}
		return false;
	}
	public boolean clientOuPas() {
		return true;
	}

	public static void testNClient(String nClient,List<String> listNClient) throws ErreurSaisie {
		for (String c:listNClient) {
			if (c.equals(nClient)) {
				throw new ErreurSaisie("Attention le numéro client existe déjà");
				}
			}
		}


	@Override
	public String afficheNClient() {
		return nClient;
	}


	public List<Achat> getListAchats() {
		return listAchats;
	}


	public void setListAchats(List<Achat> listAchats) {
		this.listAchats = listAchats;
	}
	@Override
	public String afficheNFournisseur() {

		return nFour;
	}
	public List<Commande> getListCommandes() {
		return listCommandes;
	}
	public void setListCommandes(List<Commande> listFournisseur) {
		this.listCommandes = listFournisseur;
	}



}
