package projetPOO01GestionPersonnes;

import java.util.Dictionary;

import projetPOO01Enumerations.EPersonne;


public class Patron extends Salarie implements IClient, IPatron {

	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String nSecu,
			String salaire) {
		super(nom, prenom, adresse, ville, codepostal, nSecu, salaire);
		// TODO Auto-generated constructor stub
	}

	public Patron(Dictionary<EPersonne, String> dico) {
		super(dico);
		// TODO Auto-generated constructor stub
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

}
