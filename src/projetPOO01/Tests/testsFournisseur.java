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
import projetPOO01.GestionPersonnes.Fournisseur;
import projetPOO01.Methodes.Achat;
import projetPOO01.Methodes.Commande;

public class testsFournisseur {
	private Fournisseur op;	
	private final String onom = "Baumont";
	private final String oprenom = "Marie";
	private final String oadresse = "15b rue géneral André";
	private final String oville="Lyon";
	private final String ocodepostal="69008";
	private final String oclientoupas="non";
	private final String onClient=null;
	private final String onFour="2";
	private final String setnFour = "5";
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
		op = new Fournisseur(onom,oprenom,oadresse,oville,ocodepostal,onFour);
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
		dico.put(EPersonne.nFour,onFour);
		dico.put(EPersonne.nClient,onClient);
	}

	@Test
	public void testFournisseurConst1() {
		Fournisseur op1 = new Fournisseur(onom,oprenom,oadresse,oville,ocodepostal,onFour);
		assertNotNull(op1);
	}

	@Test
	public void testFournisseurConst2() {
		Fournisseur op2 = new Fournisseur(onom,oprenom,oadresse,oville,ocodepostal,onFour,onClient);
		assertNotNull(op2);
	}

	@Test
	public void testFournisseurConstDico() {
		Fournisseur op3 = new Fournisseur(dico);
		assertNotNull(op3);
	}

	@Test
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
	public void testGetnFour() {
		assertEquals(onFour,op.getnFournisseur());	
		testSetnFour();
	}

	@Test
	public void testSetnFour() {
		op.setnFournisseur(setnFour);
		assertEquals(setnFour,op.getnFournisseur());
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
	@Test
	public void testFournisseurOuPas() {
		assertTrue(op.fournisseurOuPas());
	}
	@Test
	public void testClientOuPas() {
		assertTrue(!op.clientOuPas());
	}
	@Test
	public void testLivre() {
		assertFalse(op.livre());
	}
	@Test
	public void testPaie() {
		assertEquals(true,op.paie());
		
	}	
	@Test
	public void testAfficheNClient() {
		assertEquals(onClient,op.afficheNClient());
	} 
	@Test
	public void testAfficheNFournisseur() {
		assertEquals(onFour,op.afficheNFournisseur());
	} 
	@Test
	public void testAcheteListOfCommande() {
		 op.achete(listAchats);
		 assertEquals(listAchats,op.getListAchats());
	}
	/**


		@Test
	public void testToString() {
		fail("Not yet implemented");
	}




	 **/
}
