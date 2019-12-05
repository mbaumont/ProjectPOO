package projetPOO01.Tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import projetPOO01.Methodes.Commande;

public class testsCommande {
	private Commande cmd;
	private final Date odate = new Date();
	private final String ointitule = "Commande";
	private final String oquantite = "";
	private final Date setdate = new Date();
	private final String setintitule = "fgh";
	private final String setquantite = "dg";
	
	@Before
	public void init() {
		cmd = new Commande(odate,ointitule,oquantite);
	}
	@Test
	public void testcommande() {
		assertNotNull(cmd);
	}

	@Test
	public void testToString() {
		
	}

	@Test
	public void testGetDate() {
		assertEquals(odate,cmd.getDate());
	}

	@Test
	public void testSetDate() {
		
		cmd.setDate(setdate);
		assertEquals(setdate,cmd.getDate());
	}

	@Test
	public void testGetIntitulecommande() {
		assertEquals(ointitule, cmd.getIntituleCommande());
	}

	@Test
	public void testSetIntitulecommande() {
		cmd.setIntituleCommande(setintitule);
		assertEquals(setintitule,cmd.getIntituleCommande());
	}

	@Test
	public void testGetQuantiteCommande() {
		assertEquals(oquantite,cmd.getQuantiteCommande());
	}

	@Test
	public void testSetQuantiteCommande() {
		cmd.setQuantiteCommande(setquantite);
		assertEquals(setquantite,cmd.getQuantiteCommande());
	}

}
