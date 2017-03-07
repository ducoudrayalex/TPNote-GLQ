package commande;
import outils.*;

public interface IIUG {

	/**
	 * Interroge si une demande pr�cise existe ou non dans le stock.
	 * @param d <code>Demande</code> : Demande en question 
	 */
	void demander(Demande d);
	
	/**
	 * Enclenche l'arr�t d'urgence sur demande.
	 */
	void arretUrgence();
	
	/**
	 * Allume le bouton de la demande ajout�e.
	 * @param d <code>Demande</code> : Demande qui a �t� ajout�e dans le stock des demandes. 
	 */
	void allumerBouton(Demande d);
	
	/**
	 * �teint le bouton de la demande trait�e.
	 * @param d <code>Demande</code> : Demande qui a �t� supprim�e du stock des demandes. 
	 */
	void eteindreBouton(Demande d);
	
	/**
	 * Affiche un message visible � l'utilisateur.
	 * @param message <code>String</code> : Message d'information qui sera affich� � l'utilisateur
	 */
	void ajouterMessage(String message);
	
	/**
	 * Equivalent de MAJPosition.
	 * @param i <code>int</code>
	 */
	void changerPosition(int i);
}
