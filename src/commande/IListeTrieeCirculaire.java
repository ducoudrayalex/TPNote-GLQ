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
	 * Teste si la liste circulaire triée contient un élément.
	 * @param e l'élément pour lequel on teste la presence.
	 * @return true si l'élément e est contenu par la
	 * liste, false sinon.
	 */
	boolean contient(E e);

	/**
	 * Insère un élément dans la liste circulaire triée si l'élément
	 * n'est pas déjà contenu par la liste.
	 * @param e l'élément a insérer
	 * @throws IllegalArgumentException si l'élément est déjà dans la liste 
	 */
	void inserer(E e);
	
	
	/**
	 * Supprime un élément de la liste circulaire triée.
	 * @param e l'élément a supprimer
	 * @throws IllegalArgumentException si l'élément n'est pas 
	 * dans la liste.
	 */
	void supprimer(E e);
	
	/**
	 * Recherche l'élément suivant dans la liste triée circulaire,
	 * de l'élément donne en paramètre. L'élément donne en paramètre 
	 * n'est pas nécessairement présent dans la liste.
	 * @param l'élément courant (présent ou non dans la liste)
	 * @return l'élément suivant de l'élément courant dans la liste
	 * ou null si la liste est vide.
	 * 
	 */
	E suivantDe( E courant);	
}
