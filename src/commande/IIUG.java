package commande;
import outils.*;

public interface IIUG {

	void demander(Demande d);
	
	void arretUrgence();
	
	void allumerBouton(Demande d);
	
	void eteindreBouton(Demande d);
	
	void ajouterMessage(String message);
	
	void changerPosition(int i);
}
