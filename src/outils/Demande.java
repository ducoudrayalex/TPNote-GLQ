package outils;

public class Demande 
{
	private int numero_etage;
	private Sens sens;
	
	
	


	public Demande(int numero_etage, Sens sens)
	{
		this.numero_etage = numero_etage;
		this.sens = sens;
	}
	
	public Demande() 
	{}
	//Getter
	public int etage()
	{
		return this.numero_etage;
	}
	//Setter
	public Sens sens()
	{
		return this.sens;
	}
	
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
	
	public void changeSens(Sens sens_param)
	{
		if(sens_param != sens.INDEFINI)
		{
			this.sens = sens_param;
		}
	}

	@Override
	public String toString() {
		return "Demande [numero_etage=" + numero_etage + ", sens=" + sens + "]";
	}
	
	
}
