package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import outils.Demande;
import outils.Sens;

public class ControleurTest {

	private Demande d1,d2,d3,d4;
		
	@Before
	public void setUp()  {
		d1 = new Demande();
		d2 = new Demande(4, Sens.MONTEE);
		d3 = new Demande(3, Sens.DESCENTE);
		d4 = new Demande(1, Sens.INDEFINI);
	}
	
	@After
	public void tearDown() {
		d1 = d2 = d3 = d4 = null;
	}

}
