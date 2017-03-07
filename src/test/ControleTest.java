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
		
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),1);
		Demande d2=new Demande(3,Sens.MONTEE);
		c.doublureIUG().demander(d2);
		c.doublureIUG().allumerBouton(d2);
		c.doublureCabine().monter();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),3);
		c.doublureIUG().eteindreBouton(d2);
		
	}

	@Test
	public void testAppelsAscenseurMemeSensCabineEnCoursDeplacement(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		Demande d=new Demande(1,Sens.INDEFINI);
		c.doublureIUG().allumerBouton(d);
		c.doublureCabine().descendre();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),3);
		Demande d1=new Demande(2,Sens.DESCENTE);
		c.doublureIUG().allumerBouton(d1);
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureIUG().eteindreBouton(d1);
		c.doublureCabine().descendre();
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),1);

	}
	
	@Test
	public void testAppelAscenseurSensInverseCabineEnCoursDeplacement(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		Demande d = new Demande(1,Sens.INDEFINI);
		c.doublureIUG().allumerBouton(d);
		c.doublureCabine().descendre();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureCabine().areterProchainNiveau();
		Demande d1=new Demande(3,Sens.MONTEE);
		c.doublureIUG().allumerBouton(d1);
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),1);
		c.doublureIUG().eteindreBouton(d1);
		c.doublureCabine().monter();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),3);
		c.doublureIUG().eteindreBouton(d1);
	}
	
	@Test
	public void testAppelAscenseurDeuxChangementsSens(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		Demande d=new Demande(1,Sens.INDEFINI);
		c.doublureIUG().allumerBouton(d);
		c.doublureCabine().descendre();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),3);
		Demande d1=new Demande(5,Sens.DESCENTE);
		c.doublureIUG().allumerBouton(d1);
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(), 2);
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),1);
		c.doublureCabine().monter();
		c.doublureCabine().signalerChangementDEtage();
		c.doublureCabine().signalerChangementDEtage();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),4);
		Demande d2 = new Demande(4,Sens.DESCENTE);
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),5);
		c.doublureCabine().descendre();
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),4);
	}
	
	
	@Test
	public void testDeuxAppelsAPartirMemePalier(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		Demande d = new Demande(2,Sens.DESCENTE);
		Demande d1 = new Demande(2,Sens.MONTEE);
		c.doublureIUG().allumerBouton(d);
		c.doublureCabine().descendre();
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureIUG().eteindreBouton(d);
		
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		Demande d2 = new Demande(2,Sens.DESCENTE);
		Demande d3 = new Demande(2,Sens.DESCENTE);
		c.doublureIUG().allumerBouton(d2);
		c.doublureCabine().descendre();
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureIUG().eteindreBouton(d2);
	}
	
	@Test
	public void testDeuxAppelsMemeEtage(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),2);
		Demande d = new Demande(1,Sens.INDEFINI);
		Demande d1 = new Demande(1,Sens.INDEFINI);
		c.doublureIUG().allumerBouton(d1);
		c.doublureCabine().descendre();
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),1);
		c.doublureIUG().eteindreBouton(d1);
	}
	
	@Test
	public void testArretUrgence(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		Demande d=new Demande(1,Sens.MONTEE);
		c.doublureIUG().allumerBouton(d);
		c.doublureCabine().descendre();
		c.doublureIUG().arretUrgence();
		assertEquals(c.getPosition(),2);
		c.doublureIUG().eteindreBouton(d);
	}
	
	@Test
	public void testRepriseArretDurgence(){
		c=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		Demande d=new Demande(1,Sens.MONTEE);
		c.doublureIUG().allumerBouton(d);
		c.doublureCabine().descendre();
		c.doublureIUG().arretUrgence();//doit eteindre les boutons
		assertEquals(c.getPosition(),2);
		Demande d1=new Demande(7,Sens.DESCENTE);
		c.doublureIUG().arretUrgence();
		Demande d2=new Demande(1,Sens.MONTEE);
		c.doublureIUG().allumerBouton(d2);
		c.doublureCabine().descendre();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),2);
		c.doublureCabine().areterProchainNiveau();
		c.doublureCabine().signalerChangementDEtage();
		assertEquals(c.getPosition(),1);
		c.doublureIUG().eteindreBouton(d2);
	}
	
	
	
	
	
	
}
