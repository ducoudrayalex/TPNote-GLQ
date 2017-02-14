/**
 * Classes et interfaces de la partie commande de l'ascenseurr. 
 * @author Lucile Torres-Gerardin
 *
 */
package commande;

/**
 * Une IListeCirculaire repr�sente une liste circulaire tri�e. 
 * @author Lucile Torres-Gerardin
 *
 */
public interface IListeTrieeCirculaire<E> {		
	/** 
	 * Renvoie la taille de la liste circulaire tri�e.
	 * @return la taille de la liste.
	 */
	int taille();

	/** 
	 * Teste si la liste circulaire tri�e est vide.
	 * @return true si la liste est vide, false sinon.
	 */
	boolean estVide();
	
	/**
	 * Vide la liste tri�e circulaire.
	 */
	void vider();
	
	/**
	 * Teste si la liste circulaire tri�e contient un element.
	 * @param e l'element pour lequel on teste la presence.
	 * @return true si l'element e est contenu par la
	 * liste, false sinon.
	 */
	boolean contient(E e);

	/**
	 * Ins�re un element dans la liste circulaire tri�e si l'element
	 * n'est pas d�j� contenu par la liste.
	 * @param e l'element a ins�rer
	 * @throws IllegalArgumentException si l'element est dej� dans la liste 
	 */
	void inserer(E e);
	
	
	/**
	 * Supprime un element de la liste circulaire tri�e.
	 * @param e l'element a supprimer
	 * @throws IllegalArgumentException si l'element n'est pas 
	 * dans la liste.
	 */
	void supprimer(E e);
	
	/**
	 * Recherche l'element suivant dans la liste tri�e circulaire,
	 * de l'element donne en param�tre. L'element donne en param�tre 
	 * n'est pas n�cessairement present dans la liste.
	 * @param l'element courant (present ou non dans la liste)
	 * @return l'element suivant de l'element courant dans la liste
	 * ou null si la liste est vide.
	 * 
	 */
	E suivantDe( E courant);	
}
