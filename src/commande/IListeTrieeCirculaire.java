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
	 * Teste si la liste circulaire tri�e contient un �l�ment.
	 * @param e l'�l�ment pour lequel on teste la presence.
	 * @return true si l'�l�ment e est contenu par la
	 * liste, false sinon.
	 */
	boolean contient(E e);

	/**
	 * Ins�re un �l�ment dans la liste circulaire tri�e si l'�l�ment
	 * n'est pas d�j� contenu par la liste.
	 * @param e l'�l�ment a ins�rer
	 * @throws IllegalArgumentException si l'�l�ment est d�j� dans la liste 
	 */
	void inserer(E e);
	
	
	/**
	 * Supprime un �l�ment de la liste circulaire tri�e.
	 * @param e l'�l�ment a supprimer
	 * @throws IllegalArgumentException si l'�l�ment n'est pas 
	 * dans la liste.
	 */
	void supprimer(E e);
	
	/**
	 * Recherche l'�l�ment suivant dans la liste tri�e circulaire,
	 * de l'�l�ment donne en param�tre. L'�l�ment donne en param�tre 
	 * n'est pas n�cessairement pr�sent dans la liste.
	 * @param l'�l�ment courant (pr�sent ou non dans la liste)
	 * @return l'�l�ment suivant de l'�l�ment courant dans la liste
	 * ou null si la liste est vide.
	 * 
	 */
	E suivantDe( E courant);	
}
