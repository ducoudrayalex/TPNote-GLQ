package outils;

public enum Sens 
{
	MONTEE("^"),
	DESCENTE("v"),
	INDEFINI("-");
	
	private String logo;

	private Sens(String logo) {
		this.logo = logo;
	}
	
		   
	public String toString()
	{
	    return logo;
	}

}
