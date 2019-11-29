package projetPOO01.GestionPersonnes;

import java.util.Dictionary;

import projetPOO01.Enumerations.EPersonne;


public class Patron extends Salarie implements IClient, IPatron {
	public boolean clientOuPas = false;
	
	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String nSecu,
			String salaire) {
		super(nom, prenom, adresse, ville, codepostal, nSecu, salaire);
		// TODO Auto-generated constructor stub
	}

	public Patron(Dictionary<EPersonne, String> dico) {
		super(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal),dico.get(EPersonne.nSecu),dico.get(EPersonne.salaire));
	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
