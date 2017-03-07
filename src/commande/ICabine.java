/**
 * Classes et interfaces de la partie cabine de l'ascenseur 
 * @author Vincent
 *
 */
package commande;
import outils.*;

public interface ICabine {

	/**
	 * Signale un changement d'étage. 
	 */
	void signalerChangementDEtage();
	
	/**
	 * Déclenche l'action de monter pour la cabine.
	 */
	void monter();
	
	/**
	 * Déclenche l'action de descendre pour la cabine.
	 */
	void descendre();
	
	/**
	 * Signale que la cabine s'arrête au prochain étage (due à une demande)
	 */
	void areterProchainNiveau();
	
	/**
	 * Fait arrêter la cabine en mouvement.
	 */
	void arreter();
}
