package projetPOO01.GestionPersonnes;

import java.util.List;

import projetPOO01.Methodes.Achat;

public interface IClient {
	public void achete(List<Achat> achat);
	public boolean paie();	
	public boolean clientOuPas();
	public String afficheNClient();
	
}
