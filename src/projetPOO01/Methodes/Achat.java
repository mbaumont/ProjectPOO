package projetPOO01.Methodes;
import java.text.SimpleDateFormat;
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
	@Override
	public String toString() {
		return "Achat [Date:" + date + ", Intitulé=" + intituleAchat + ", Quantité=" + quantiteAchat + "]";
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
	
	public static Date checkDate(String date) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd/MM/yyyy");
		format.setLenient(false);
		Date dateOb = format.parse(date);
		return dateOb;
	}
	
	

}
