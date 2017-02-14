/**
 * Classes et interfaces de la partie commande de l'ascenseurr. 
 * @author Lucile Torres-Gerardin
 *
 */
package commande;

/**
 * Une IListeCirculaire représente une liste circulaire triée. 
 * @author Lucile Torres-Gerardin
 *
 */
public interface IListeTrieeCirculaire<E> {		
	/** 
	 * Renvoie la taille de la liste circulaire triée.
	 * @return la taille de la liste.
	 */
	int taille();

	/** 
	 * Teste si la liste circulaire triée est vide.
	 * @return true si la liste est vide, false sinon.
	 */
	boolean estVide();
	
	/**
	 * Vide la liste triée circulaire.
	 */
	void vider();
	
	/**
	 * Teste si la liste circulaire triée contient un element.
	 * @param e l'element pour lequel on teste la presence.
	 * @return true si l'element e est contenu par la
	 * liste, false sinon.
	 */
	boolean contient(E e);

	/**
	 * Insère un element dans la liste circulaire triée si l'element
	 * n'est pas déjà contenu par la liste.
	 * @param e l'element a insérer
	 * @throws IllegalArgumentException si l'element est dejà dans la liste 
	 */
	void inserer(E e);
	
	
	/**
	 * Supprime un element de la liste circulaire triée.
	 * @param e l'element a supprimer
	 * @throws IllegalArgumentException si l'element n'est pas 
	 * dans la liste.
	 */
	void supprimer(E e);
	
	/**
	 * Recherche l'element suivant dans la liste triée circulaire,
	 * de l'element donne en paramètre. L'element donne en paramètre 
	 * n'est pas nécessairement present dans la liste.
	 * @param l'element courant (present ou non dans la liste)
	 * @return l'element suivant de l'element courant dans la liste
	 * ou null si la liste est vide.
	 * 
	 */
	E suivantDe( E courant);	
}
