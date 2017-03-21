package commande;

import operative.ICabine;

public class DoublureDeCabine implements ICabine {

	public void signalerChangementDEtage() {
		System.out.println("Signal de franchissement d'étage");
		
	}

	@Override
	public void monter() {
		System.out.println("monter");
	}

	@Override
	public void descendre() {
		System.out.println("descendre");
		
	}

	@Override
	public void arreterProchainNiveau() {
		System.out.println("arrêter prochain étage");
		
	}

	@Override
	public void arreter() {
		System.out.println("arreter");	
	}
	
	@Override
	public void assignerControleur(IControleur ic){	
		
	}
}
