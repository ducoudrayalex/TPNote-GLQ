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
<<<<<<< HEAD
	 */
	void signalerChangementDEtage();
=======
	 * @throws ExceptionCabineArretee 
	 */
	void signalerChangementDEtage() throws ExceptionCabineArretee;
>>>>>>> refs/remotes/origin/master
	
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
<<<<<<< HEAD
	void areterProchainNiveau();
=======
	void arreterProchainNiveau();
>>>>>>> refs/remotes/origin/master
	
	/**
	 * Fait arr�ter la cabine en mouvement.
	 */
	void arreter();
}
