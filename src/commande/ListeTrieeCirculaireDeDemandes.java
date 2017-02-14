package commande;


import outils.Demande;
import outils.Sens;

/**
 * Classe repr�sentant une liste des demandes d'�tage qui sera tri�e
 * en fonction de l'�tage et du sens de navigation
 * Cette classe impl�mente l'interface IListeTrieeCirculaire
 * @author L�o et Vincent
 * @version 1.0
 */
public class ListeTrieeCirculaireDeDemandes implements IListeTrieeCirculaire<Demande> 
{
	/**
	 * Tableau contenant les demandes de mont�e, <code>true</code> si il y a une demande, <code>false</code> sinon
	 */
	public boolean[] montee;
	
	/**
	 * Tableau contenant les demandes de descente, <code>true</code> si il y a une demande, <code>false</code> sinon
	 */
	public boolean[] descente;
	
	/**
	 * Tableau de l'ensemble des demandes tri�es par sens et �tage
	 */
	public Demande[] listeTrieeFinale; // tableau final de demandes tri�es
	
	/**
	 * Constructeur, Instancie les tableaux <code>montee</code> et <code>descente</code> de taille <code>taille_liste/2</code>
	 * Chaque case du tableau sera initialis�e � false;
	 * @param taille_liste
	 */
	public ListeTrieeCirculaireDeDemandes(int taille_liste) 
	{
		this.montee = new boolean[taille_liste/2];
		for(int i=0;i<montee.length;i++) montee[i]=false; 
		this.descente = new boolean[taille_liste/2];
		for(int i=0;i<descente.length;i++) descente[i]=false; 
		this.listeTrieeFinale=new Demande[taille_liste];
	}
	
	
	@Override
	/**
	 * Renvoie la taille de la liste finale
	 * @return <code>int</code> listeTrieeFinal.length
	 */
	public int taille() 
	{
		return listeTrieeFinale.length;
	}
	
	@Override
	/**
	 * D�fini si la liste finale est vide <code>true</code> ou non <code>false</code>
	 * @return <code>boolean</code> [listeTrieeFinale == null]
	 */
	public boolean estVide() 
	{
		return (listeTrieeFinale == null);
	}

	/**
	 * D�fini si la liste finale est pleine
	 * @return <code>boolean</code> [listeTrieeFinale[listeTrieeFinale.length-1] != null]
	 */
	public boolean estPleine() 
	{
		return (listeTrieeFinale[listeTrieeFinale.length-1] != null);
	}
	
	@Override
	/**
	 * Vide la liste finale
	 */
	public void vider() 
	{
		for(int i =0;i<listeTrieeFinale.length;i++)
		{
			listeTrieeFinale[i] = null;
		}
	}

	/**
	 * D�fini si la liste finale contient la <code>Demande</code> pass�e en param�tre
	 * @param Demande d , Demande a rechercher
	 * @return <code>boolean</code> <code>true</code> si la demande est trouv�e, <code>false</code> sinon
	 */
	@Override
	public boolean contient(Demande d) 
	{
		int i = 0;
		/*
		 * On cr�e une boucle qui s'arr�te d�s lors que l'on trouve une correspondance.
		 * A d�faut la boucle renvoie faux.
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
	/**
	 * Ins�re la demande sp�cifi�e en param�tre dans le tableau de mont�e si la demande est une mont�e, dans le tableau de descente sinon
	 * @exception <code>IllegalArgumentException</code>, si le sens de la demande est <code>INDEFINI</code>
	 * @param Demande d, demande a ins�rer
	 */
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
	/**
	 * Supprime la demande sp�cifi�e en param�tre puis trie la liste
	 * @exception <code>IllegalArgumentException</code> si le sens de la demande est <code>INDEFINI</code>
	 * @param Demande d, demande a supprimer
	 */
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
		else if(!contient(d) || estVide())
		{
			throw new IllegalArgumentException();
		}
	}

	@Override
	/**
	 * Renvoie la demande suivante de la demande sp�cifi�e en param�tre dans la liste finale
	 * @param Demande courant, Demande pour laquelle on veut conna�tre la demande suivante
	 * @return <code>Demande</code>
	 */
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
	
	/**
	 * Fonction de trie de la liste finale en fonction des tableaux de mont�e et de descente
	 */
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