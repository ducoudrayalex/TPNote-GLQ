package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import commande.Controleur;
import commande.DoublureDeCabine;
import commande.DoublureDeIUG;
import outils.Demande;
import outils.ExceptionCabineArretee;
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
	
	public void testDemander(Controleur c,Demande d){
		c.demander(d);
		System.out.println("APPEL " + d.toString());
	}
	
	public void testArretDUrgence(){
		System.out.println("Arret d'urgence");
	}
	
	public void testSignalerChangementEtage(){
		System.out.println("Signal de franchissement de palier");
	}
	
	@Test
	public void testAppelApresArretProlonge() throws ExceptionCabineArretee{
		//c1=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d1=new Demande(1,Sens.MONTEE);
		testDemander(c1,d1);

		c1.signalerChangementDEtage();
		assertSame(2,c1.getPosition());
		//c1.arreterProchainNiveau();
		c1.signalerChangementDEtage();
		assertSame(1,c1.getPosition());
		
		//c2=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),1);
		//Demande d2=new Demande(3,Sens.MONTEE);
		c2.demander(d2);
		c2.MAJPosition();
		c2.signalerChangementDEtage();
		assertSame(2,c2.getPosition());
		//c2.arreterProchainNiveau();
		c2.signalerChangementDEtage();
		assertSame(3,c2.getPosition());
		
		
	}

	@Test
	public void testAppelsAscenseurMemeSensCabineEnCoursDeplacement() throws ExceptionCabineArretee{
		//c3=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		//Demande d3=new Demande(1,Sens.INDEFINI);
		c3.demander(d3);
		
		c3.signalerChangementDEtage();
		assertSame(3,c3.getPosition());
		//Demande d4=new Demande(2,Sens.DESCENTE);
		
		c3.arreterProchainNiveau();
		c3.signalerChangementDEtage();
		assertSame(2,c3.getPosition());
		
		
		c3.arreterProchainNiveau();
		c3.signalerChangementDEtage();
		assertSame(1,c3.getPosition());

	}
	
	@Test
	public void testAppelAscenseurSensInverseCabineEnCoursDeplacement() throws ExceptionCabineArretee{
		//c4=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d5 = new Demande(1,Sens.INDEFINI);
		c4.demander(d5);
		c4.signalerChangementDEtage();
		assertSame(2,c4.getPosition());
		//c4.arreterProchainNiveau();
		//Demande d6=new Demande(3,Sens.MONTEE);
		c4.demander(d6);
		c4.signalerChangementDEtage();
		assertSame(1,c4.getPosition());
		c4.signalerChangementDEtage();
		assertSame(2,c4.getPosition());
		//c4.arreterProchainNiveau();
		c4.signalerChangementDEtage();
		assertSame(3,c4.getPosition());
	}
	
	@Test
	public void testAppelAscenseurDeuxChangementsSens() throws ExceptionCabineArretee{
		//c5=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),4);
		//Demande d7=new Demande(1,Sens.INDEFINI);
		c5.demander(d7);
		c5.signalerChangementDEtage();
		assertSame(3,c5.getPosition());
		//Demande d8=new Demande(5,Sens.DESCENTE);
		c5.demander(d8);
		c5.signalerChangementDEtage();
		assertSame(2,c5.getPosition());
		//c5.arreterProchainNiveau();
		c5.signalerChangementDEtage();
		assertSame(1,c5.getPosition());
		c5.signalerChangementDEtage();
		c5.signalerChangementDEtage();
		c5.signalerChangementDEtage();
		assertSame(4,c5.getPosition());
		//Demande d9 = new Demande(4,Sens.DESCENTE);
		//c5.arreterProchainNiveau();
		c5.signalerChangementDEtage();
		assertSame(5,c5.getPosition());
		//c5.arreterProchainNiveau();
		c5.signalerChangementDEtage();
		assertSame(4,c5.getPosition());
	}
	
	
	@Test
	public void testDeuxAppelsAPartirMemePalier() throws ExceptionCabineArretee{
		//c6=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d10 = new Demande(2,Sens.DESCENTE);
		//Demande d11 = new Demande(2,Sens.MONTEE);
		c6.demander(d10);
		c6.demander(d11);
		//c6.arreterProchainNiveau();
		c6.signalerChangementDEtage();
		assertSame(2,c6.getPosition());
		
		//c7=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d12 = new Demande(2,Sens.DESCENTE);
		//Demande d13 = new Demande(2,Sens.DESCENTE);
		c7.demander(d12);
		c7.demander(d13);
		//c7.arreterProchainNiveau();
		c7.signalerChangementDEtage();
		assertSame(2,c7.getPosition());
	}
	
	@Test
	public void testDeuxAppelsMemeEtage() throws ExceptionCabineArretee{
		//c8=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),2);
		//Demande d14 = new Demande(1,Sens.INDEFINI);
		//Demande d15 = new Demande(1,Sens.INDEFINI);
		c8.arreterProchainNiveau();
		c8.signalerChangementDEtage();
		assertSame(1,c8.getPosition());
	}
	
	@Test
	public void testArretUrgence() throws ExceptionCabineArretee{
		//c9=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d16=new Demande(1,Sens.MONTEE);
		c9.MAJPosition();
		c9.arretUrgence();
		assertSame(2,c9.getPosition());
		c9.eteindreBouton(d16);
	}
	
	@Test
	public void testRepriseArretDurgence() throws ExceptionCabineArretee{
		c10=new Controleur(new DoublureDeIUG(),new DoublureDeCabine(),3);
		//Demande d17=new Demande(1,Sens.MONTEE);
		c10.demander(d17);
		c10.arretUrgence();//doit eteindre les boutons
		assertSame(2,c10.getPosition());
		//Demande d18=new Demande(7,Sens.DESCENTE);
		c10.arretUrgence();
		//Demande d19=new Demande(1,Sens.MONTEE);
		c10.signalerChangementDEtage();
		assertSame(2,c10.getPosition());
		//c10.arreterProchainNiveau();
		c10.signalerChangementDEtage();
		assertSame(1,c10.getPosition());
	}
	
	
	
	
	
	
}
