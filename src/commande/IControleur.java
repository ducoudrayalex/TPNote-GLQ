/**
 * Classes et interfaces de la partie contrôle de l'ascenseurr. 
 * @author Vincent 
 *
 */
package commande;
import outils.*;

/**
 * Une IControleur représente les actions qui guide la cabine. 
 *
 */
public interface IControleur {
	
	/**
	 * Met à jour le sens de la cabine en fonction de la demande suivante.
	 */
	void MAJSens();
	
	/**
	 * Stocke une demande pour qu'elle soit traitée ultérieurement.
	 * @param d <code>Demande</code> : Demande que l'on souhaite stocker  
	 */
	void stocker();
	
	/**
	 * Met à jour la position de la cabine en fonction de son mouvement.
	 */
	void MAJPosition() throws ExceptionCabineArretee;
	
	/**
	 * Eteint tous les boutons allumés.
	 */
	void eteindreTousBoutons();
	
	/**
	 * Supprime toutes les demandes précédemment stockées.
	 */
	void viderStock();
	
	/**
	 * Retourne la demande suivante du stock à traiter.
	 * @return <code>Demande</code> la demande suivante à traiter
	 */
	Demande interrogerStock();
	
	/**
	 * Supprime la demande souhaitée du stock.
	 * @param d <code>Demande</code> : Demande que l'on souhaite ne plus traiter (car traitée au préalable).
	 */
	void enleverDuStock(Demande d);
	
}
