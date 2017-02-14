package commande;

import outils.Demande;
import outils.Sens;
import static org.junit.Assert.*;

public class Controleur {
	private int nombreEtages;
	private int position;
	private Sens sens;
	private Sens sensPrecedent;
	private Demande demande;
	private ListeTrieeCirculaireDeDemandes stockDeDemandes;
	
	public Controleur(int pNombreEtages,int pPosition,Sens pSens,Sens pSensPrecedent,Demande pDemande,ListeTrieeCirculaireDeDemandes pListeDemande){
		nombreEtages=pNombreEtages;
		position=pPosition;
		sens=pSens;
		sensPrecedent=pSensPrecedent;
		demande=pDemande;
		stockDeDemandes=pListeDemande;
	}
	public void MAJPostion(){
		if(sens==Sens.MONTEE){
			position++;
		}else if(sens==Sens.DESCENTE){
			position--;
		}
	}
	
	public void MAJSens(){
		if(demande.estIndefini()){
			sens=sensPrecedent;
		}else if(demande.enDescente()){
			sens=Sens.DESCENTE;
		}else if(demande.enMontee()){
			sens=Sens.MONTEE;
		}
	}
	
	public void stocker(Demande d){
		stockDeDemandes.inserer(d);
	}
	
	public void eteindreTousBoutons(){
		
	}
	
	public void viderStock(){
		stockDeDemandes.vider();
	}
	
	public Demande interrogerStock(){
		
	}
}
