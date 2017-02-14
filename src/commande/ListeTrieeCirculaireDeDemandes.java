package commande;


import outils.Demande;
import outils.Sens;

public class ListeTrieeCirculaireDeDemandes implements IListeTrieeCirculaire<Demande> 
{

	public boolean[] montee;
	public boolean[] descente;
	public Demande[] listeTrieeFinale; // tableau final de demandes triées
	
	public ListeTrieeCirculaireDeDemandes(int taille_liste) 
	{
		this.montee = new boolean[taille_liste/2];
		for(int i=0;i<montee.length;i++) montee[i]=false; 
		this.descente = new boolean[taille_liste/2];
		for(int i=0;i<descente.length;i++) descente[i]=false; 
		this.listeTrieeFinale=new Demande[taille_liste];
	}
	
	
	
	@Override
	public int taille() 
	{
		return listeTrieeFinale.length;
	}

	@Override
	public boolean estVide() 
	{
		return (listeTrieeFinale == null);
	}

	public boolean estPleine() 
	{
		return (listeTrieeFinale[listeTrieeFinale.length-1] != null);
	}
	
	@Override
	public void vider() 
	{
		for(int i =0;i<listeTrieeFinale.length;i++)
		{
			listeTrieeFinale[i] = null;
		}
	}

	@Override
	public boolean contient(Demande d) 
	{
		int i = 0;
		/*
		 * On crée une boucle qui s'arrête dès lors que l'on trouve une correspondance.
		 * A défaut la boucle renvoie faux.
		 * */
		while(i<listeTrieeFinale.length)
		{
			if(listeTrieeFinale[i] == d)
			{
				return true;
			}
			i++;
		}
		return false;
		
	}

	@Override
	public void inserer(Demande d) throws IllegalArgumentException
	{
		if(!estPleine() && !contient(d))
		{
			if(d.sens() == Sens.MONTEE)
			{
				for(int i=0;i<montee.length;i++)
				{
					if(d.etage() == i)
					{
						montee[i]=true;
					}
				}
			}
			
			else
			{
				if(d.sens() == Sens.INDEFINI)
				{
					throw new IllegalArgumentException();
				}
				
				for(int i=0;i<descente.length;i++)
				{
					if(d.etage() == i)
					{
						descente[i]=true;
					}	
				}	
			}
			triTabFinal();
		}
	}

	@Override
	public void supprimer(Demande d) throws IllegalArgumentException
	{	
		if(!estVide() && contient(d))
		{
			if(d.sens() == Sens.MONTEE)
			{
				for(int i=0;i<montee.length;i++)
				{
					if(d.etage() == i)
					{
						montee[i]=false;
					}
				}
			}
			
			else
			{
				if(d.sens() == Sens.INDEFINI)
				{
					throw new IllegalArgumentException();
				}
				
				for(int i=0;i<descente.length;i++)
				{
					if(d.etage() == i)
					{
						descente[i]=false;
					}	
				}	
			}
			triTabFinal();
		}
	}

	@Override
	public Demande suivantDe(Demande courant) 
	{
		int flag = 0;
		for(int i=0;i<listeTrieeFinale.length;i++)
		{
			if(listeTrieeFinale[i].equals(courant))
			{
				flag = i+1;
			}
		}
		return listeTrieeFinale[flag];
	}
	
	
	private void triTabFinal()
	{
		vider();
		for(int i=0;i<listeTrieeFinale.length;i++)
		{
			for(int j=0;j<montee.length;j++) 
			{
				if(montee[j]) listeTrieeFinale[i]= new Demande(j,Sens.MONTEE);
			}
			
			for(int k=descente.length;k>0;k--)
			{
				if(descente[k]) listeTrieeFinale[i]= new Demande(k,Sens.MONTEE);
			}
		}
	}
	
	
	
}