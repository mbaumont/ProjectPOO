package projetPOO01.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projetPOO01.Enumerations.EPersonne;
import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.Salarie;
import projetPOO01.Methodes.Achat;
import projetPOO01.Methodes.Commande;


public class testsClient {
	private Client op;	
	private final String onom = "Baumont";
	private final String oprenom = "Marie";
	private final String oadresse = "15b rue géneral André";
	private final String oville="Lyon";
	private final String ocodepostal="69008";
	private final String oclientoupas="non";
	private final String onClient="1";
	private final String onFournisseur="3";
	private final String setnClient = "5";
	private final Commande Commande1 = new Commande(new Date(), "Commande1", "2");
	private final Commande Commande2 = new Commande(new Date(), "Commande2", "3");
	private final Commande Commande3 = new Commande(new Date(), "Commande3", "4");
	private final Achat achat1 = new Achat(new Date(), "achat1", "2");
	private final Achat achat2 = new Achat(new Date(), "achat2", "3");
	private final Achat achat3 = new Achat(new Date(), "achat3", "4");
	private final List<Achat> listAchats = new  ArrayList<Achat>();
	private final List<Commande> listCommandes = new  ArrayList<Commande>();	
	public final Dictionary<EPersonne, String> dico = new Hashtable<EPersonne, String>();
	
	
	@Before
	public void init() {
		op = new Client(onom,oprenom,oadresse,oville,ocodepostal,onClient,onFournisseur);
		op.setClientOuPas(oclientoupas);	
		listCommandes.add(Commande1);
		listCommandes.add(Commande2);
		listCommandes.add(Commande3);
		op.setListCommandes(listCommandes);
		listAchats.add(achat1);
		listAchats.add(achat2);
		listAchats.add(achat3);
		op.setListAchats(listAchats);
	}
	public void fillDico(Dictionary<EPersonne,String> dico) {
		dico.put(EPersonne.prenom,oprenom);
		dico.put(EPersonne.adresse,oadresse);
		dico.put(EPersonne.ville,oville);
		dico.put(EPersonne.codepostal,ocodepostal);
		dico.put(EPersonne.nFour,onFournisseur);
		dico.put(EPersonne.nClient,onClient);
	}

	@Test
	public void testClientConst1() {
		Client op1 = new Client(onom,oprenom,oadresse,oville,ocodepostal,onClient);
		assertNotNull(op1);
	}

	@Test
	public void testSalarieConst2() {
		Client op2 = new Client(onom,oprenom,oadresse,oville,ocodepostal,onClient,onFournisseur);
		assertNotNull(op2);
	}

	@Test
	public void testSalarieConstDico() {
		fillDico(dico);
		Salarie op3 = new Salarie(dico);
		assertNotNull(op3);
	}



	@Test
	public void testGetnClient() {
		assertEquals(onClient,op.getnClient());		
	}

	@Test
	public void testSetnClient() {
		op.setnClient(setnClient);
		assertEquals(setnClient,op.getnClient());
	}



	@Test
	public void testGetListAchats() {
		assertEquals(listAchats,op.getListAchats());
	}

	@Test
	public void testSetListAchats() {
		List<Achat> setListAchat = new  ArrayList<Achat>();
		Achat setachat1 = new Achat(new Date(), "achat1", "2");
		setListAchat.add(setachat1);
		op.setListAchats(setListAchat);
		assertEquals(setListAchat,op.getListAchats());
	}




	public void testGetListCommandes() {
		assertEquals(listCommandes,op.getListCommandes());

	}

	@Test
	public void testSetListCommandes() {
		List<Commande> setListCommandes = new  ArrayList<Commande>();
		Commande setcommande1 = new Commande(new Date(), "Commande 1", "2");
		setListCommandes.add(setcommande1);
		op.setListCommandes(setListCommandes);
		assertEquals(setListCommandes,op.getListCommandes());
	}
	@Test
	public void testPaie() {
		assertEquals(true,op.paie());
		
	}	
	@Test
	public void testFournisseurOuPas() {
		assertTrue(op.fournisseurOuPas());
	}
	@Test
	public void testClientOuPas() {
		assertTrue(op.clientOuPas());
	}
	@Test
	public void testAcheteListOfCommande() {
		 op.achete(listAchats);
		 assertEquals(listAchats,op.getListAchats());
	}
	@Test
	public void testAfficheNClient() {
		assertEquals(onClient,op.afficheNClient());
	} 
	@Test
	public void testLivre() {
		assertTrue(op.livre());
	}
	@Test
	public void testAfficheNFournisseur() {
		assertEquals(onFournisseur,op.afficheNFournisseur());
	} 

/**


		@Test
	public void testToString() {
		fail("Not yet implemented");
	}



	 */

}
