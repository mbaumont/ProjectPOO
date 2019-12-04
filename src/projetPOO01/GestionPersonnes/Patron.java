package projetPOO01.GestionPersonnes;

import java.util.Dictionary;

import projetPOO01.Enumerations.EPersonne;


public class Patron extends Salarie implements IClient, IPatron {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean clientOuPas = false;
	@SuppressWarnings("unused")
	private String nClient;
	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String nSecu,
			String salaire) {
		super(nom, prenom, adresse, ville, codepostal, nSecu, salaire);
		this.nClient = null;
		// TODO Auto-generated constructor stub
	}
	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String nSecu,
			String salaire,String nClient) {
		super(nom, prenom, adresse, ville, codepostal, nSecu, salaire);
		this.nClient = nClient;
		// TODO Auto-generated constructor stub
	}
	
	public Patron(Dictionary<EPersonne, String> dico) {
		this(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal),dico.get(EPersonne.nSecu),
				dico.get(EPersonne.salaire),dico.get(EPersonne.nClient));
		
	

	}



	@Override
	public void embauche() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void licencie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paieSalarie() {
		// TODO Auto-generated method stub
		
	}

}
