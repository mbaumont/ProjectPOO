package projetPOO01.Tests;
import projetPOO01.Exceptions.ErreurSaisie;
import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.Fournisseur;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Salarie;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class testsSaisies {
	private String nClient = "2";
	List<String> listNClient = new ArrayList<String>();
	
	private String nFour = "10";
	List<String> listNFournisseur = new ArrayList<String>();
	
	
	public void initListClient() {
		listNClient.add("1");
		listNClient.add("2");
		listNClient.add("3");
	}
	public void initListFournisseur() {
		listNFournisseur.add("4");
		listNFournisseur.add("10");
		listNFournisseur.add("7");
	}
	@Test
	public void testCheckCodePostal() {
		try {
			Personne.checkCodePostal("1234");
		} 
		catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Attention le code postal doit être composé de 5 chiffres"));
		}
		try {
			Personne.checkCodePostal("a1234");
		} 
		catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Attention il faut insérer des chiffres"));
		}
	}
	
	@Test
	public void testcheckOuiNon() {
		try {
			Personne.checkOuiNon("Oui");
			Personne.checkOuiNon("non ");
		} 
		catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Attention taper oui ou non"));
		}
	}
	@Test
	public void testchecknSecu() {
		try {
			Salarie.checknSecu("1234591236");
			Salarie.checknSecu("ab1234561231");
		} 
		catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Il faut insérer 13 chiffres"));
		}
	}
	
	@Test
	public void testnClient() {
		try {
			initListClient();
			Client.testNClient(nClient,listNClient);
		} 
		catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Attention le numéro client existe déjà"));
		}		
	}
	
	
	@Test
	public void testnFournisseur() {
		try {
			initListFournisseur();
			Fournisseur.testNFournisseur(nFour,listNFournisseur);
		} 
		catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Attention le numéro fournisseur existe déjà"));
		}
		
	}
		
	
	
	
	
	

}
