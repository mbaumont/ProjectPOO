package projetPOO01GestionPersonnes;

import java.util.Dictionary;

import projetPOO01Enumerations.EPersonne;

public class Client extends Personne implements IFournisseur, IClient {
	
	private String nClient;
	
	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String nClient) {
		super(nom, prenom, adresse, ville, codepostal); // Obligatoire de donner le constructeur si pas de constructeur par défaut 
		this.nClient = nClient;
	}
	

	public Client(Dictionary<EPersonne, String> dico) {
		super(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal));
		this.nClient =  String.valueOf(dico.get(EPersonne.nClient));
	}


	@Override
	
	public void livre() {
		// TODO Auto-generated method stub

	}

	public String getnClient() {
		return nClient;
	}

	public void setnClient(String nClient) {
		this.nClient = nClient;
	}

	@Override
	public void commande() {
		// TODO Auto-generated method stub

	}

	@Override
	public void achete() {
		// TODO Auto-generated method stub
		System.out.println("Client achète");
		
	}

	@Override
	public void paie() {
		// TODO Auto-generated method stub
		System.out.println("Client paie");
		
	}

	@Override
	public String toString() {
		return super.toString() + ", Numéro Client= "+nClient;
	}



}
