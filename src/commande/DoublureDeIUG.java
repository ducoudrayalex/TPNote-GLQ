package commande;

import operative.IIUG;
import outils.Demande;

public class DoublureDeIUG implements IIUG{

	public void demander(Demande d) {
		System.out.println("APPEL " + d.toString());
		
	}

	public void arretUrgence() {
		System.out.println("Arret d'urgence");		
	}

	@Override
	public void allumerBouton(Demande d) {
System.out.println("allumer bouton "+ d.toString());		
	}

	@Override
	public void eteindreBouton(Demande d) {
		System.out.println("Eteindre bouton "+ d.toString());
		
	}

	@Override
	public void ajouterMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changerPosition(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignerControleur(IControleur ic){
		
	}
}
