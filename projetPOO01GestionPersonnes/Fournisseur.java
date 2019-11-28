package projetPOO01GestionPersonnes;

import java.util.Dictionary;
import projetPOO01Enumerations.EPersonne;

public class Fournisseur extends Personne implements IClient, IFournisseur {
	private String nFournisseur;
	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String nFournisseur) {
		super(nom, prenom, adresse, ville, codepostal); 
		this.nFournisseur = nFournisseur;
	}

	public Fournisseur(Dictionary<EPersonne, String> dico) {
		super(dico.get(EPersonne.nom),dico.get(EPersonne.prenom),
				dico.get(EPersonne.adresse) , dico.get(EPersonne.ville) 
				, dico.get(EPersonne.codepostal));
		this.nFournisseur =  String.valueOf(dico.get(EPersonne.nFour));
	}

	@Override
	public void achete() {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur achète");

	}

	@Override
	public void paie() {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur paie");
	}

	@Override
	public void livre() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void commande() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return super.toString() + ", nFournisseur=" + nFournisseur ;
	}

	public String getnFournisseur() {
		return nFournisseur;
	}

	public void setnFournisseur(String nFournisseur) {
		this.nFournisseur = nFournisseur;
	}

}
