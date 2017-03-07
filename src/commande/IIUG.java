package commande;
import outils.*;

public interface IIUG {

	/**
	 * Interroge si une demande précise existe ou non dans le stock.
	 * @param d <code>Demande</code> : Demande en question 
	 */
	void demander(Demande d);
	
	/**
	 * Enclenche l'arrêt d'urgence sur demande.
	 */
	void arretUrgence();
	
	/**
	 * Allume le bouton de la demande ajoutée.
	 * @param d <code>Demande</code> : Demande qui a été ajoutée dans le stock des demandes. 
	 */
	void allumerBouton(Demande d);
	
	/**
	 * Éteint le bouton de la demande traitée.
	 * @param d <code>Demande</code> : Demande qui a été supprimée du stock des demandes. 
	 */
	void eteindreBouton(Demande d);
	
	/**
	 * Affiche un message visible à l'utilisateur.
	 * @param message <code>String</code> : Message d'information qui sera affiché à l'utilisateur
	 */
	void ajouterMessage(String message);
	
	/**
	 * Equivalent de MAJPosition.
	 * @param i <code>int</code>
	 */
	void changerPosition(int i);
}
