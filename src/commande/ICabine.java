/**
 * Classes et interfaces de la partie cabine de l'ascenseur 
 * @author Vincent
 *
 */
package commande;
import outils.*;

public interface ICabine {

	/**
	 * Signale un changement d'�tage. 
	 */
	void signalerChangementDEtage();
	
	/**
	 * D�clenche l'action de monter pour la cabine.
	 */
	void monter();
	
	/**
	 * D�clenche l'action de descendre pour la cabine.
	 */
	void descendre();
	
	/**
	 * Signale que la cabine s'arr�te au prochain �tage (due � une demande)
	 */
	void areterProchainNiveau();
	
	/**
	 * Fait arr�ter la cabine en mouvement.
	 */
	void arreter();
}
