package projetPOO01GestionPersonnes;

import java.util.Dictionary;


import projetPOO01Enumerations.EPersonne;


public class Salarie extends Personne implements IClient {
	private String nSecu;
	private String salaire;
	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String nSecu, String salaire) {
		super(nom, prenom, adresse, ville, codepostal); 
		this.nSecu = nSecu;
		this.salaire = salaire;
	}
	public Salarie(Dictionary<EPersonne, String> dico) {
		super(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal));
		this.nSecu = String.valueOf(dico.get(EPersonne.nSecu));
		this.salaire = String.valueOf(dico.get(EPersonne.salaire));	
	}


	@Override
	public void achete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paie() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return super.toString() + ", nSecu= " + nSecu+  ", Salaire= " + salaire;
	}
	
	
	
}
