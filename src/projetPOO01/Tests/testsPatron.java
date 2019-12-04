package projetPOO01.Tests;

import static org.junit.Assert.*;

import java.util.Dictionary;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import projetPOO01.Enumerations.EPersonne;
import projetPOO01.GestionPersonnes.Patron;
import projetPOO01.GestionPersonnes.Salarie;

public class testsPatron {
	private Patron op;	
	private final String onom = "Baumont";
	private final String oprenom = "Marie";
	private final String oadresse = "15b rue géneral André";
	private final String oville="Lyon";
	private final String ocodepostal="69008";
	private final String oclientoupas="non";
	private final String onSecu = "1234567891234";
	private final String osalaire="2000,12";
	private final String onClient="1";
	public final Dictionary<EPersonne, String> dico = new Hashtable<EPersonne, String>();
	@Before
	public void init() {
		op = new Patron(onom,oprenom,oadresse,oville,ocodepostal,onSecu,osalaire);
		op.setClientOuPas(oclientoupas);
		

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
	
	public void testPatronConst1() {
		Salarie op1 = new Salarie(onom,oprenom,oadresse,oville,ocodepostal,onSecu,osalaire);
		assertNotNull(op1);
	}

	@Test
	public void testPatronConstDico() {
		fillDico(dico);
		Salarie op3 = new Patron(dico);
		assertNotNull(op3);
	}

/**

	@Test
	public void testEmbauche() {
		fail("Not yet implemented");
	}

	@Test
	public void testLicencie() {
		fail("Not yet implemented");
	}

	@Test
	public void testPaieSalarie() {
		fail("Not yet implemented");
	}
**/
}
