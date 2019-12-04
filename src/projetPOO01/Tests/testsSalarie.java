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
import projetPOO01.GestionPersonnes.Salarie;
import projetPOO01.Methodes.Achat;

public class testsSalarie {
	private Salarie op;	
	private final String onom = "Baumont";
	private final String oprenom = "Marie";
	private final String oadresse = "15b rue géneral André";
	private final String oville="Lyon";
	private final String ocodepostal="69008";
	private final String oclientoupas="non";
	private final String setsalaire = "10,11";
	private final String setnSecu = "1235467899875";
	private final String onSecu = "1234567891234";
	private final String osalaire="2000,12";
	private final String onClient="1";
	private final Achat achat1 = new Achat(new Date(), "achat1", "2");
	private final Achat achat2 = new Achat(new Date(), "achat2", "3");
	private final Achat achat3 = new Achat(new Date(), "achat3", "4");
	private final List<Achat> listAchats = new  ArrayList<Achat>();
	
	
//////////////////////////////        Dico       /////////////////////////////////////////
	
	public final Dictionary<EPersonne, String> dico = new Hashtable<EPersonne, String>();
	
	
	@Before
	public void init() {
		op = new Salarie(onom,oprenom,oadresse,oville,ocodepostal,onSecu,osalaire,onClient);
		op.setClientOuPas(oclientoupas);
		
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
		dico.put(EPersonne.nSecu,onSecu);
		dico.put(EPersonne.salaire,osalaire);
		dico.put(EPersonne.nClient,onClient);
	}
	

	@Test
	public void testSalarieConst1() {
		Salarie op1 = new Salarie(onom,oprenom,oadresse,oville,ocodepostal,onSecu,osalaire);
		assertNotNull(op1);
	}

	@Test
	public void testSalarieConst2() {
		Salarie op2 = new Salarie(onom,oprenom,oadresse,oville,ocodepostal,onSecu,osalaire,onClient);
		assertNotNull(op2);
	}

	@Test
	public void testSalarieConstDico() {
		fillDico(dico);
		Salarie op3 = new Salarie(dico);
		assertNotNull(op3);
	}


	@Test
	public void testChecknSecu() {

	}
	@Test
	public void testGetnSecu() {
		assertEquals(onSecu,op.getnSecu());
		this.testSetnSecu();
	}
	@Test
	public void testSetnSecu() {
		op.setnSecu(setnSecu);
		assertEquals(setnSecu,op.getnSecu());
	}

	@Test
	public void testGetSalaire() {
		assertEquals(osalaire,op.getSalaire());
		this.testSetSalaire();
	}

	@Test
	public void testSetSalaire() {
		op.setSalaire(setsalaire);
		assertEquals(setsalaire,op.getSalaire());
	}


	@Test
	public void testClientOuPas() {
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
	public void testAfficheNClient() {
		assertEquals(op.getnClient(),op.afficheNClient());
	}
	@Test
	public void testAcheteListOfCommande() {
		 op.achete(listAchats);
		 assertEquals(listAchats,op.getListAchats());
	}
	@Test
	public void testPaie() {
		assertEquals(true,op.paie());
		
	}	
/**
 * 

		@Test
	public void testToString() {
		fail("Not yet implemented");
	}


 */
}
