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
	{}
	
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
		if(this.sens == Sens.MONTEE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Test si le sens de la demande est une descente
	 * @return <code>true</code> si le sens de la demande est une <b>descente</b>, sinon <code>false</code>
	 */
	public boolean enDescente()
	{
		if(this.sens == Sens.DESCENTE)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Test si le sens de la demande est ind�fini
	 * @return <code>true</code> si le sens de la demande est <b>ind�fini</b>, sinon <code>false</code>
	 */
	public boolean estIndefini()
	{
		if(this.sens == Sens.INDEFINI)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Incr�mente ou d�cr�mente le num�ro de l'�tage en fonction du sens de la demande
	 */
	public void passeEtageSuivant()
	{
		if(this.sens == Sens.MONTEE)
		{
			numero_etage++;
		}
		else if(this.sens == Sens.DESCENTE)
		{
			numero_etage--;
		}
	}
	
	/**
	 * Modifie le sens de la demande en fonction du sens pass� en param�tre
	 * @param sens_param
	 */
	public void changeSens(Sens sens_param)
	{
		if(sens_param != sens.INDEFINI)
		{
			this.sens = sens_param;
		}
	}

	/**
	 * D�crit l'objet demande
	 */
	@Override
	public String toString() {
		return "Demande [numero_etage=" + numero_etage + ", sens=" + sens + "]";
	}	
}
