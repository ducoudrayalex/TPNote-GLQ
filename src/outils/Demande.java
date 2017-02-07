package outils;
/**
 * Classe matérialisant la demande d'un étage à l'ascenseur dans une direction donnée
 * @author Léo Marion et Alexandre
 * @version 1.0
 */
public class Demande 
{
	/**
	 * Numéro de l'étage demandé
	 */
	private int numero_etage;
	
	/**
	 * Sens de navigation de l'ascenseur pour une demande
	 */
	private Sens sens;
	
	/**
	 * Créer une nouvelle demande pour l'ascenseur
	 * @param numero_etage
	 * @param sens
	 */
	public Demande(int numero_etage, Sens sens)
	{
		this.numero_etage = numero_etage;
		this.sens = sens;
	}
	
	/**
	 * Demande par défaut
	 */
	public Demande() 
	{}
	
	/**
	 * Récupère l'étage demandé
	 * @return numéro d'étage
	 */
	public int etage()
	{
		return this.numero_etage;
	}
	
	/**
	 * Récupère le sens de navigation de la demande
	 * @return sens de navigation
	 */
	public Sens sens()
	{
		return this.sens;
	}
	
	/**
	 * Test si le sens de la demande est une montée
	 * @return <code>true</code> si le sens de la demande est une <b>montée</b>, sinon <code>false</code>
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
	 * Test si le sens de la demande est indéfini
	 * @return <code>true</code> si le sens de la demande est <b>indéfini</b>, sinon <code>false</code>
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
	 * Incrémente ou décrémente le numéro de l'étage en fonction du sens de la demande
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
	 * Modifie le sens de la demande en fonction du sens passé en paramètre
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
	 * Décrit l'objet demande
	 */
	@Override
	public String toString() {
		return "Demande [numero_etage=" + numero_etage + ", sens=" + sens + "]";
	}	
}
