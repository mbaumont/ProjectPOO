package projetPOO01.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projetPOO01.GestionPersonnes.Personne;

public class testsPersonne {
	private Personne op;
	private final String onom = "Baumont";
	private final String oprenom = "Marie";
	private final String oadresse = "15b rue géneral André";
	private final String oville="Lyon";
	private final String ocodepostal="69008";
	private final String oclientoupas="non";
	private final String setnom = "";
	private final String setprenom = "";
	private final String setadresse = "";
	private final String setville = "";
	private final String setcodepostal = "00000";
	
	
	@Before
	public void init() {
		op = new Personne(onom,oprenom,oadresse,oville,ocodepostal);
		op.setClientOuPas(oclientoupas);
	}
	@Test
	public void testPersonne() {
		assertNotNull(op);
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNom() {
		assertEquals(onom,op.getNom());
		this.testSetNom();
	}

	@Test
	public void testSetNom() {
		op.setNom(setnom);
		assertEquals(setnom,op.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertEquals(oprenom,op.getPrenom());
		this.testSetPrenom();
	}

	@Test
	public void testSetPrenom() {
		op.setNom(setprenom);
		assertEquals(setprenom,op.getNom());
	}

	@Test
	public void testGetAdresse() {
		assertEquals(oadresse,op.getAdresse());
		this.testSetAdresse();
	}

	@Test
	public void testSetAdresse() {
		op.setAdresse(setadresse);
		assertEquals(setadresse,op.getAdresse());		
	}

	@Test
	public void testGetVille() {
		assertEquals(oville,op.getVille());
		this.testSetVille();
	}

	@Test
	public void testSetVille() {
		op.setVille(setville);
		assertEquals(setville,op.getVille());
	}

	@Test
	public void testGetCodepostal() {
		assertEquals(ocodepostal,op.getCodepostal());
		this.testSetCodepostal();
	}

	@Test
	public void testSetCodepostal() {
		op.setCodepostal(setcodepostal);
		assertEquals(setcodepostal,op.getCodepostal());
	}
	/**

	@Test
	public void testAchete() {
		fail("Not yet implemented");
	}


	@Test
	public void testCheckOuiNon() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClientOuPas() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetClientOuPas() {
		fail("Not yet implemented");
	}
**/
}
