package outils;
/**
 * Classe mat�rialisant la demande d'un �tage � l'ascenseur dans une direction donn�e
 * @author L�o Marion et Alexandre
 * @version 1.0
 */
public class Demande 
{
	/**
	 * Num�ro de l'�tage demand�
	 */
	private int numero_etage;
	
	/**
	 * Sens de navigation de l'ascenseur pour une demande
	 */
	private Sens sens;
	
	/**
	 * Cr�er une nouvelle demande pour l'ascenseur
	 * @param numero_etage
	 * @param sens
	 */
	public Demande(int numero_etage, Sens sens)
	{
		this.numero_etage = numero_etage;
		this.sens = sens;
	}
	
	/**
	 * Demande par d�faut
	 */
	public Demande() 
	{
		this.numero_etage = 0;
		this.sens = sens.INDEFINI;
	}
	
	/**
	 * R�cup�re l'�tage demand�
	 * @return num�ro d'�tage
	 */
	public int etage()
	{
		return this.numero_etage;
	}
	
	/**
	 * R�cup�re le sens de navigation de la demande
	 * @return sens de navigation
	 */
	public Sens sens()
	{
		return this.sens;
	}
	
	/**
	 * Test si le sens de la demande est une mont�e
	 * @return <code>true</code> si le sens de la demande est une <b>mont�e</b>, sinon <code>false</code>
	 */
	public boolean enMontee()
	{	
		return sens == Sens.MONTEE;
	}
	
	/**
	 * Test si le sens de la demande est une descente
	 * @return <code>true</code> si le sens de la demande est une <b>descente</b>, sinon <code>false</code>
	 */
	public boolean enDescente()
	{
		return sens == Sens.DESCENTE;
	}
	
	/**
	 * Test si le sens de la demande est ind�fini
	 * @return <code>true</code> si le sens de la demande est <b>ind�fini</b>, sinon <code>false</code>
	 */
	public boolean estIndefini()
	{
		return sens == Sens.INDEFINI;
	}
	
	/**
	 * Incr�mente ou d�cr�mente le num�ro de l'�tage en fonction du sens de la demande
	 */
	public void passeEtageSuivant() throws ExceptionCabineArretee
	{
		if(this.sens == Sens.MONTEE)
		{
			numero_etage++;
		}
		else if(this.sens == Sens.DESCENTE)
		{
			numero_etage--;
		}
		else
		{
			throw new ExceptionCabineArretee();
		}
	}
	
	/**
	 * Modifie le sens de la demande en fonction du sens pass� en param�tre
	 * @param sens_param
	 */
	public void changeSens(Sens sens_param)
	{
		this.sens = sens_param;
	}

	/**
	 * D�crit l'objet demande
	 */
	@Override
	public String toString() {
		return numero_etage + sens.toString();
	}	
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (getClass() != obj.getClass()) {
            return false;
        }
        else if (this.numero_etage == ((Demande)obj).numero_etage && this.sens == ((Demande)obj).sens) {
            return true;
        }
        else
        {
        	return false;
        }  
    }
}