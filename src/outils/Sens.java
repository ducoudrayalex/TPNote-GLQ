package outils;
/**
 * Enumération des sens d'une demande (MONTEE="^",DESCENT="v",INDEFINI="-")
 * @author Léo, Marion et Alexandre
 * @version 1.0
 */
public enum Sens 
{
	MONTEE("^"),
	DESCENTE("v"),
	INDEFINI("-");
	
	/**
	 * Caractère représentant le sens
	 */
	private String logo;

	/**
	 * Constructeur de l'énumération
	 * @param logo : caractère du sens
	 */
	private Sens(String logo) {
		this.logo = logo;
	}
	
	/**
	 * Retourne le caractère du sens	   
	 */
	@Override
	public String toString()
	{
	    return logo;
	}

}
