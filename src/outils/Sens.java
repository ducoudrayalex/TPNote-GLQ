package outils;
/**
 * Enum�ration des sens d'une demande (MONTEE="^",DESCENT="v",INDEFINI="-")
 * @author L�o, Marion et Alexandre
 * @version 1.0
 */
public enum Sens 
{
	MONTEE("^"),
	DESCENTE("v"),
	INDEFINI("-");
	
	/**
	 * Caract�re repr�sentant le sens
	 */
	private String logo;

	/**
	 * Constructeur de l'�num�ration
	 * @param logo : caract�re du sens
	 */
	private Sens(String logo) {
		this.logo = logo;
	}
	
	/**
	 * Retourne le caract�re du sens	   
	 */
	@Override
	public String toString()
	{
	    return logo;
	}

}
