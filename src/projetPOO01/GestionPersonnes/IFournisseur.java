package projetPOO01.GestionPersonnes;
import java.util.List;

import projetPOO01.Methodes.Commande;
public interface IFournisseur {
	public boolean livre();
	public void commande(List<Commande> commandes);
	public boolean fournisseurOuPas();
	public String afficheNFournisseur();

	
}
