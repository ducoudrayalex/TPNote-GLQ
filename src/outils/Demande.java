package outils;
/**
 * Classe matérialisant la demande d'un étage à l'ascenseur dans une direction donnée
 * @author Léo, Marion et Alexandre
 * @version 1.1
 */
public class Demande 
{
	/**
	 * Numéro de l'étage demandé
	 */
	private int numero_etage;
	
	/**
	 * Sens de navigation de l'ascenseur pour une demande
	 * @return <code>Sens</code>
	 * @see Sens
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
	{
		this.numero_etage = 0;
		this.sens = Sens.INDEFINI;
	}
	
	
	/**
	 * Récupère l'étage demandé
	 * @return int numéro d'étage
	 */
	public int etage()
	{
		return this.numero_etage;
	}

	
	/**
	 * Récupère le sens de navigation de la demande
	 * @return <code>Sens</code> sens de navigation
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
	 * Test si le sens de la demande est indéfini
	 * @return <code>true</code> si le sens de la demande est <b>indéfini</b>, sinon <code>false</code>
	 */
	public boolean estIndefini()
	{
		return sens == Sens.INDEFINI;
	}
	
	/**
	 * Incrémente ou décrémente le numéro de l'étage en fonction du sens de la demande
	 * @throws ExceptionCabineArretee
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
	 * Modifie le sens de la demande en fonction du sens passé en paramètre
	 * @param Sens sens de la demande
	 */
	public void changeSens(Sens sens_param)
	{
		this.sens = sens_param;
	}

	/**
	 * Décrit l'objet demande par son numéro d'étage suivi du sens de navigation
	 * @return String concaténation de l'étage + du sens
	 */
	@Override
	public String toString() {
		return numero_etage + sens.toString();
	}	
	
	
	@Override
	/**
	 * Fonction equals redéfinie pour comparer les objets Demande
	 * @param Object l'objet demande à tester
	 * @return <code>true</code> si le sens de la demande et le numéro d'étage sont égales aux propriétés de l'objet en paramètre, sinon <code>false</code>
	 */
    public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}else if (obj == null) {
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
	
	@Override
	/**
	 * @return int Un numéro constant
	 */
	public int hashCode() {
		  assert false : "hashCode not designed";
		  return 42; // any arbitrary constant will do 
	}
}
