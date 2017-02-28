package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import commande.Controleur;
import commande.DoublureDeCabine;
import commande.DoublureDeIUG;
import commande.ListeTrieeCirculaireDeDemandes;
import outils.Demande;
import outils.Sens;

public class ControleTest {


	private Controleur c;
	
	@Test
	public void testAppelApresArretProlonge(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		Demande d1=new Demande(1,Sens.MONTEE);
		c.doublureIUG().demander(d1);
		c.doublureIUG().allumerBouton(d1);
		c.doublureCabine().descendre();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),1);
		c.doublureIUG().eteindreBouton(d1);
		
		
	}

	
}
