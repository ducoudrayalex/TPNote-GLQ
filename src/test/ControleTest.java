package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import commande.Controleur;
import commande.DoublureDeCabine;
import commande.DoublureDeIUG;
import outils.Demande;
import outils.Sens;

/**
 * Classe de test unitaire pour la classe {@link outils.Controleur}
 * @author Alexandre et Marion
 *@see Demande
 *@see Controleur
 *@see Sens
 */
public class ControleTest {


	private Controleur c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
	private Demande d1, d2, d3, d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19;
	
	@Before
	public void setUp()  {
		d1=new Demande(1,Sens.MONTEE);
		d2=new Demande(3,Sens.MONTEE);
		d3=new Demande(1,Sens.INDEFINI);
		d4=new Demande(2,Sens.DESCENTE);
		d5=new Demande(1,Sens.INDEFINI);
		d6=new Demande(3,Sens.MONTEE);
		d7=new Demande(1,Sens.INDEFINI);
		d8=new Demande(5,Sens.DESCENTE);
		d9 = new Demande(4,Sens.DESCENTE);
		d10 = new Demande(2,Sens.DESCENTE);
		d11 = new Demande(2,Sens.MONTEE);
		d12 = new Demande(2,Sens.DESCENTE);
		d13 = new Demande(2,Sens.DESCENTE);
		d14 = new Demande(1,Sens.INDEFINI);
		d15 = new Demande(1,Sens.INDEFINI);
		d16=new Demande(1,Sens.MONTEE);
		d17=new Demande(1,Sens.MONTEE);
		d18=new Demande(7,Sens.DESCENTE);
		d19=new Demande(1,Sens.MONTEE);
		
		c1=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		c2=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),1);
		c3=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		c4=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		c5=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		c6=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		c7=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		c8=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),2);
		c9=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		c10=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
	}

	@After
	public void tearDown() {
		d1 = d2 = d3 = d4 = d5 = d6 = d7 = d8 = d9 = d10 = d11 = d12 = d13 = d14 = d15 = d16 = d17 = d18 = d19 = null;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = c8 = c9 = c10 = null;
	}
	
	@Test
	public void testAppelApresArretProlonge(){
		//c1=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d1=new Demande(1,Sens.MONTEE);
		c1.doublureIUG().demander(d1);
		c1.doublureIUG().allumerBouton(d1);
		c1.doublureCabine().descendre();
		c1.doublureCabine().signalerChangementDEtage();
		assertSame(2,c1.getPosition());
		c1.doublureCabine().areterProchainNiveau();
		c1.doublureCabine().signalerChangementDEtage();
		assertSame(1,c1.getPosition());
		c1.doublureIUG().eteindreBouton(d1);
		
		//c2=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),1);
		//Demande d2=new Demande(3,Sens.MONTEE);
		c2.doublureIUG().demander(d2);
		c2.doublureIUG().allumerBouton(d2);
		c2.doublureCabine().monter();
		c2.doublureCabine().signalerChangementDEtage();
		assertSame(2,c2.getPosition());
		c2.doublureCabine().areterProchainNiveau();
		c2.doublureCabine().signalerChangementDEtage();
		assertSame(3,c2.getPosition());
		c2.doublureIUG().eteindreBouton(d2);
		
	}

	@Test
	public void testAppelsAscenseurMemeSensCabineEnCoursDeplacement(){
		//c3=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		//Demande d3=new Demande(1,Sens.INDEFINI);
		c3.doublureIUG().allumerBouton(d3);
		c3.doublureCabine().descendre();
		c3.doublureCabine().signalerChangementDEtage();
		assertSame(3,c3.getPosition());
		//Demande d4=new Demande(2,Sens.DESCENTE);
		c3.doublureIUG().allumerBouton(d4);
		c3.doublureCabine().areterProchainNiveau();
		c3.doublureCabine().signalerChangementDEtage();
		assertSame(2,c3.getPosition());
		c3.doublureIUG().eteindreBouton(d4);
		c3.doublureCabine().descendre();
		c3.doublureCabine().areterProchainNiveau();
		c3.doublureCabine().signalerChangementDEtage();
		assertSame(1,c3.getPosition());

	}
	
	@Test
	public void testAppelAscenseurSensInverseCabineEnCoursDeplacement(){
		//c4=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d5 = new Demande(1,Sens.INDEFINI);
		c4.doublureIUG().allumerBouton(d5);
		c4.doublureCabine().descendre();
		c4.doublureCabine().signalerChangementDEtage();
		assertSame(2,c4.getPosition());
		c4.doublureCabine().areterProchainNiveau();
		//Demande d6=new Demande(3,Sens.MONTEE);
		c4.doublureIUG().allumerBouton(d6);
		c4.doublureCabine().signalerChangementDEtage();
		assertSame(1,c4.getPosition());
		c4.doublureIUG().eteindreBouton(d6);
		c4.doublureCabine().monter();
		c4.doublureCabine().signalerChangementDEtage();
		assertSame(2,c4.getPosition());
		c4.doublureCabine().areterProchainNiveau();
		c4.doublureCabine().signalerChangementDEtage();
		assertSame(3,c4.getPosition());
		c4.doublureIUG().eteindreBouton(d6);
	}
	
	@Test
	public void testAppelAscenseurDeuxChangementsSens(){
		//c5=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		//Demande d7=new Demande(1,Sens.INDEFINI);
		c5.doublureIUG().allumerBouton(d7);
		c5.doublureCabine().descendre();
		c5.doublureCabine().signalerChangementDEtage();
		assertSame(3,c5.getPosition());
		//Demande d8=new Demande(5,Sens.DESCENTE);
		c5.doublureIUG().allumerBouton(d8);
		c5.doublureCabine().signalerChangementDEtage();
		assertSame(2,c5.getPosition());
		c5.doublureCabine().areterProchainNiveau();
		c5.doublureCabine().signalerChangementDEtage();
		assertSame(1,c5.getPosition());
		c5.doublureCabine().monter();
		c5.doublureCabine().signalerChangementDEtage();
		c5.doublureCabine().signalerChangementDEtage();
		c5.doublureCabine().signalerChangementDEtage();
		assertSame(4,c5.getPosition());
		//Demande d9 = new Demande(4,Sens.DESCENTE);
		c5.doublureIUG().allumerBouton(d9);
		c5.doublureCabine().areterProchainNiveau();
		c5.doublureCabine().signalerChangementDEtage();
		assertSame(5,c5.getPosition());
		c5.doublureCabine().descendre();
		c5.doublureCabine().areterProchainNiveau();
		c5.doublureCabine().signalerChangementDEtage();
		assertSame(4,c5.getPosition());
	}
	
	
	@Test
	public void testDeuxAppelsAPartirMemePalier(){
		//c6=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d10 = new Demande(2,Sens.DESCENTE);
		//Demande d11 = new Demande(2,Sens.MONTEE);
		c6.doublureIUG().allumerBouton(d10);
		c6.doublureCabine().descendre();
		c6.doublureCabine().areterProchainNiveau();
		c6.doublureCabine().signalerChangementDEtage();
		assertSame(2,c6.getPosition());
		c6.doublureIUG().eteindreBouton(d10);
		
		//c7=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d12 = new Demande(2,Sens.DESCENTE);
		//Demande d13 = new Demande(2,Sens.DESCENTE);
		c7.doublureIUG().allumerBouton(d12);
		c7.doublureCabine().descendre();
		c7.doublureCabine().areterProchainNiveau();
		c7.doublureCabine().signalerChangementDEtage();
		assertSame(2,c7.getPosition());
		c7.doublureIUG().eteindreBouton(d12);
	}
	
	@Test
	public void testDeuxAppelsMemeEtage(){
		//c8=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),2);
		//Demande d14 = new Demande(1,Sens.INDEFINI);
		//Demande d15 = new Demande(1,Sens.INDEFINI);
		c8.doublureIUG().allumerBouton(d15);
		c8.doublureCabine().descendre();
		c8.doublureCabine().areterProchainNiveau();
		c8.doublureCabine().signalerChangementDEtage();
		assertSame(1,c8.getPosition());
		c8.doublureIUG().eteindreBouton(d15);
	}
	
	@Test
	public void testArretUrgence(){
		//c9=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d16=new Demande(1,Sens.MONTEE);
		c9.doublureIUG().allumerBouton(d16);
		c9.doublureCabine().descendre();
		c9.doublureIUG().arretUrgence();
		assertSame(2,c9.getPosition());
		c9.doublureIUG().eteindreBouton(d16);
	}
	
	@Test
	public void testRepriseArretDurgence(){
		c10=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d17=new Demande(1,Sens.MONTEE);
		c10.doublureIUG().allumerBouton(d17);
		c10.doublureCabine().descendre();
		c10.doublureIUG().arretUrgence();//doit eteindre les boutons
		assertSame(2,c10.getPosition());
		//Demande d18=new Demande(7,Sens.DESCENTE);
		c10.doublureIUG().arretUrgence();
		//Demande d19=new Demande(1,Sens.MONTEE);
		c10.doublureIUG().allumerBouton(d19);
		c10.doublureCabine().descendre();
		c10.doublureCabine().signalerChangementDEtage();
		assertSame(2,c10.getPosition());
		c10.doublureCabine().areterProchainNiveau();
		c10.doublureCabine().signalerChangementDEtage();
		assertSame(1,c10.getPosition());
		c10.doublureIUG().eteindreBouton(d19);
	}
	
	
	
	
	
	
}
