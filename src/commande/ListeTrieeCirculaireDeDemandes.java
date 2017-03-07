package commande;


import outils.Demande;
import outils.Sens;
/**
 * Classe implémentant l'interface <code>IListeTrieeCirculaire</code>, elle représente la liste des demandes de l'ascenseur et est capable de trier cette liste en fonction des sens de navigation et des étages demandés.
 * @author Léo, Vincent
 * @version 2.0
 * @see Demande
 * @see Sens
 */
public class ListeTrieeCirculaireDeDemandes implements IListeTrieeCirculaire<Demande> 
{
	private int taille_liste = 0;
	public boolean[] montee;
	public boolean[] descente;
	public Demande[] listeTrieeFinale; // tableau final de demandes triées
	
	/**
	 * Constructeur, créée 3 listes : une liste des demandes en montée, une liste des demandes en descente et une liste finale
	 * @param taille_liste <code>int</code> : taille des listes de montée et de descente.
	 */
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
	/**
	 * Retourne le nombre de demande dans la liste triée
	 * @return <code>int</code> la vrai taille
	 */
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
	/**
	 * Retourne si la liste est vide ou non
	 * @return <code>boolean</code> <code>true</code> si la liste est vide, <code>false</code> sinon.
	 */
	public boolean estVide() 
	{
		return (listeTrieeFinale[0] == null);
	}

	/**
	 * Retourne si la liste est pleine ou non
	 * @return <code>boolean</code> <code>true</code> si la liste est pleine <code>false</code> sinon
	 */
	public boolean estPleine() 
	{
		return (listeTrieeFinale[listeTrieeFinale.length-1] != null);
	}
	
	@Override
	/**
	 * Vide la liste de toutes ses demandes
	 */
	public void vider() 
	{
		for(int i =0;i<listeTrieeFinale.length;i++)
		{
			listeTrieeFinale[i] = null;
		}
	}

	@Override
	/**
	 * Retourne si la liste contient la demande spécifiée en paramètre
	 * @param d <code>Demande</code> la demande à trouver dans la liste
	 * @return <code>boolean</code> <code>true</code> si la liste contient la demande <code>false</code> sinon
	 */
	public boolean contient(Demande d) 
	{
		for(int i=0; i<taille(); i++)
		{
			if(listeTrieeFinale[i].equals(d))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	/**
	 * Insère la demande spécifiée en paramètre dans la liste
	 * @param <code>Demande</code> demande à insérer
	 * @throws <code>IllegalArgumentException</code>
	 */
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
	/**
	 * Supprime la demande spécifiée en paramètre
	 * @param <code>Demande</code> la demande à supprimer
	 * @throws <code>IllegalArgumentException</code> si la demande n'existe pas dans la liste ou si le sens de la demande est <code>INDEFINI</code>
	 */
	public void supprimer(Demande d) throws IllegalArgumentException
	{	
		if(contient(d))
		{
			if(d.sens() == Sens.MONTEE)
			{
				montee[d.etage()]=false;
			}
			
			else if(d.sens() == Sens.DESCENTE)
			{
				descente[d.etage()]=false;
			}
			else throw new IllegalArgumentException();
		}
		else throw new IllegalArgumentException();
		triTabFinal();
	}

	@Override
	/**
	 * Renvoie la demande suivante de la demande spécifiée en paramètre
	 * @return <code>Demande</code> la demande suivante
	 * @param <code>Demande</code> la demande courante
	 */
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
	
	/**
	 * Renvoie une chaîne de caractère représentant le contenu de la liste des demandes
	 * @return <code>String</code>
	 */
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
	
	/**
	 * Trie la liste des demande en fonction des etages et des sens des demandes
	 */
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