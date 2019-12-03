package projetPOO01.Methodes;


import java.util.Date;

public class Commande {

	private Date date;
	private String intituleCommande;
	private String quantiteCommande;
	public Commande(Date date, String intituleCommande,String quantiteCommande) {
		this.date = date;
		this.intituleCommande = intituleCommande;
		this.quantiteCommande = quantiteCommande;	
	}
	@Override
	public String toString() {
		return "Commande [Date:" + date + ", Intitulé=" + intituleCommande + ", Quantité=" + quantiteCommande + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIntituleAchat() {
		return intituleCommande;
	}
	public void setIntituleAchat(String intituleCommande) {
		this.intituleCommande = intituleCommande;
	}
	public String getQuantiteAchat() {
		return quantiteCommande;
	}
	public void setQuantiteAchat(String quantiteAchat) {
		this.quantiteCommande = quantiteAchat;
	}
	

	
	

}

