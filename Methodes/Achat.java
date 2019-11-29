package projetPOO01.Methodes;
import java.util.Date;

import projetPOO01.Exceptions.ErreurSaisie;
public class Achat {
	private Date date;
	private String intituleAchat;
	private String quantiteAchat;
	public Achat(Date date, String intituleAchat,String quantiteAchat) {
		this.date = date;
		this.intituleAchat = intituleAchat;
		this.quantiteAchat = quantiteAchat;	
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIntituleAchat() {
		return intituleAchat;
	}
	public void setIntituleAchat(String intituleAchat) {
		this.intituleAchat = intituleAchat;
	}
	public String getQuantiteAchat() {
		return quantiteAchat;
	}
	public void setQuantiteAchat(String quantiteAchat) {
		this.quantiteAchat = quantiteAchat;
	}
	public static void checkDate(String date) throws ErreurSaisie {
		if (!date.matches("\\d{0,1}\\d{0,9}\\\\d{0,3}\\d{0,9}\\\\d{0,9}\\\\d{0,9}")) {
			throw new ErreurSaisie("Il faut insérer la date au format XX/XX/XX.");		
		}
	}
		
	
	

}
