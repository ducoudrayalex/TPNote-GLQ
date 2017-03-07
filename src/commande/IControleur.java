/**
 * Classes et interfaces de la partie contr�le de l'ascenseurr. 
 * @author Vincent 
 *
 */
package commande;
import outils.*;

/**
 * Une IControleur repr�sente les actions qui guide la cabine. 
 *
 */
public interface IControleur {
	
	/**
	 * Met � jour le sens de la cabine en fonction de la demande suivante.
	 */
	void MAJSens();
	
	/**
	 * Stocke une demande pour qu'elle soit trait�e ult�rieurement.
	 * @param d <code>Demande</code> : Demande que l'on souhaite stocker  
	 */
	void stocker();
	
	/**
	 * Met � jour la position de la cabine en fonction de son mouvement.
	 */
	void MAJPosition() throws ExceptionCabineArretee;
	
	/**
	 * Eteint tous les boutons allum�s.
	 */
	void eteindreTousBoutons();
	
	/**
	 * Supprime toutes les demandes pr�c�demment stock�es.
	 */
	void viderStock();
	
	/**
	 * Retourne la demande suivante du stock � traiter.
	 * @return <code>Demande</code> la demande suivante � traiter
	 */
	Demande interrogerStock();
	
	/**
	 * Supprime la demande souhait�e du stock.
	 * @param d <code>Demande</code> : Demande que l'on souhaite ne plus traiter (car trait�e au pr�alable).
	 */
	void enleverDuStock(Demande d);
	
}
