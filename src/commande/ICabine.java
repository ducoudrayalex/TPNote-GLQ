package commande;
import outils.*;

public interface ICabine {

	void signalerChangementDEtage();
	
	void monter();
	
	void descendre();
	
	void areterProchainNiveau();
	
	void arreter();
}
