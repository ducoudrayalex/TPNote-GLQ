package commande;


import outils.Demande;
import outils.Sens;

public class ListeTrieeCirculaireDeDemandes implements IListeTrieeCirculaire<Demande> 
{
	private int taille_liste = 0;
	public boolean[] montee;
	public boolean[] descente;
	public Demande[] listeTrieeFinale; // tableau final de demandes triées
	
	public ListeTrieeCirculaireDeDemandes(int taille_liste) 
	{
		this.montee = new boolean[taille_liste];
		for(int i=0;i<montee.length;i++) montee[i]=false; 
		this.descente = new boolean[taille_liste];
		for(int i=0;i<descente.length;i++) descente[i]=false; 
		this.listeTrieeFinale=new Demande[taille_liste*2];
		this.taille_liste = taille_liste;
	}
	
	
	
	@Override
	public int taille() 
	{
		int vrai_taille =0;
		for(int i=0;i<listeTrieeFinale.length;i++)
		{
			if(listeTrieeFinale[i]!= null)
			{
				vrai_taille++;
			}
		}
		return vrai_taille;
	}

	@Override
	public boolean estVide() 
	{
		return (listeTrieeFinale[0] == null);
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
				if(d.etage() >= taille_liste-1 || d.etage() <0)
				{
					throw new IllegalArgumentException();
				}
				else
				{
					for(int i=0;i<montee.length;i++)
					{
						if(d.etage() == i)
						{
							montee[i]=true;
						}
					}
				}
			}
			
			else if(d.sens() == Sens.DESCENTE)
			{
				if(d.etage()<=0 || d.etage()>taille_liste-1)
				{
					throw new IllegalArgumentException();
				}
				else
				{
					for(int i=0;i<descente.length;i++)
					{
						if(d.etage() == i)
						{
							descente[i]=true;
						}	
					}	
				}
			}
			else throw new IllegalArgumentException();
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
			
			else if(d.sens() == Sens.DESCENTE)
			{
				for(int i=0;i<descente.length;i++)
				{
					if(d.etage() == i)
					{
						descente[i]=false;
					}	
				}	
			}
			else throw new IllegalArgumentException();
			triTabFinal();
		}
		else if(!contient(d) || estVide())
		{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Demande suivantDe(Demande courant) 
	{
		int bonneDemande = 0;
		boolean flag= false;
		for(int i=0;i<taille();i++)
		{
			if(flag == false)
			{
				if(courant.sens() == Sens.MONTEE)
				{
					if(listeTrieeFinale[i].etage() > courant.etage())
					{
						bonneDemande= i;
						flag= true;
					}
				}
				else if(courant.sens() == Sens.DESCENTE)
				{
					if(listeTrieeFinale[i].etage() < courant.etage())
					{
						bonneDemande= i;
						flag= true;
					}
				}
				
			}	
		}
		return listeTrieeFinale[bonneDemande];
	}
	
	public String toString()
	{
		String phraseFinale = "";
		if(estVide())
		{
			phraseFinale = "[]";
		}
		else
		{
			phraseFinale = "[" + listeTrieeFinale[0];
			for(int i=1;i<taille();i++)
			{
				if(listeTrieeFinale[i]!=null)
				{
					phraseFinale += "," + listeTrieeFinale[i].toString();
				}
				else
				{
					phraseFinale += "";
				}
			}
			phraseFinale += "]";
		}
		
		return phraseFinale;
	}
	
	private void triTabFinal()
	{
		vider();
		int i = 0;
		for(int j=0;j<montee.length;j++) 
		{
			if(montee[j] == true)
			{
				listeTrieeFinale[i]= new Demande(j,Sens.MONTEE);
				i++;
			}
		}
			
		for(int k=descente.length-1;k>=0;k--)
		{
			if(descente[k] == true)
			{
				listeTrieeFinale[i]= new Demande(k,Sens.DESCENTE);
				i++;
			}
		}	
	}
	
}