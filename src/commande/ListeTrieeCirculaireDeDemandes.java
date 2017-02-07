package commande;

import java.util.ArrayList;

import outils.Demande;
import outils.Sens;

public class ListeTrieeCirculaireDeDemandes implements IListeTrieeCirculaire<Demande> 
{

	public ArrayList listeTrieeCirculaire;

	
	public ListeTrieeCirculaireDeDemandes(int taille_liste) 
	{
		this.listeTrieeCirculaire = new Demande[taille_liste];
		this.montee = new Demande[taille_liste];
		this.descente = new Demande[taille_liste];
	}
	
	
	
	@Override
	public int taille() 
	{
		return listeTrieeCirculaire.length;
	}

	@Override
	public boolean estVide() 
	{
		return (listeTrieeCirculaire[0] == null);
	}

	public boolean estPleine() 
	{
		return (listeTrieeCirculaire[listeTrieeCirculaire.length-1] != null);
	}
	
	@Override
	public void vider() 
	{
		for(int i =0;i<listeTrieeCirculaire.length;i++)
		{
			listeTrieeCirculaire[i] = null;
		}
	}

	@Override
	public boolean contient(Demande d) 
	{
		int i = 0;
		int j = 0;
		/*
		 * On crée une boucle qui s'arrête dès lors que l'on trouve une correspondance.
		 * A défaut la boucle s'arrête à la fin du tableau.
		 * */
		while(i<listeTrieeCirculaire.length && j<1)
		{
			if(listeTrieeCirculaire[i] == d)
			{
				j++;
			}
			i++;
		}
		return j>0;
		
	}

	@Override
	public void inserer(Demande d) throws IllegalArgumentException
	{
		if(!estPleine())
		{
			if(!contient(d))
			{
				if(d.sens() == Sens.MONTEE)
				{
					if(estVide())
					{
						montee[0]=d;
					}
					else
					{
						montee[montee.length-1]=d;
						Demande tampon = null;
						boolean permut;
				 
						do 
						{
							// hypothèse : le tableau est trié
							permut = false;
							for (int i = 0; i < montee.length-1; i++) 
							{
								// Teste si 2 éléments successifs sont dans le bon ordre ou non
								if (montee[i].etage() > montee[i+1].etage()) 
								{
									// s'ils ne le sont pas, on échange leurs positions
									tampon = montee[i];
									montee[i] = montee[i + 1];
									montee[i + 1] = tampon;
									permut = true;
								}
							}
						} while (permut);
					}
				}
				
				else if(d.sens() == Sens.DESCENTE)
				{
					if(estVide())
					{
						descente[0]=d;
					}
					else
					{
						descente[descente.length-1]=d;
						Demande tampon = null;
						boolean permut;
				 
						do 
						{
							// hypothèse : le tableau est trié
							permut = false;
							for (int i = 0; i < descente.length-1; i++) 
							{
								// Teste si 2 éléments successifs sont dans le bon ordre ou non
								if (descente[i].etage() < descente[i+1].etage()) 
								{
									// s'ils ne le sont pas, on échange leurs positions
									tampon = descente[i];
									descente[i] = descente[i + 1];
									descente[i + 1] = tampon;
									permut = true;
								}
							}
						} while (permut);
					}
				}
			}
		}
	}

	@Override
	public void supprimer(Demande d) 
	{	
		if(!estVide())
		{
			if(!contient(d))
			{
				for(int i =0;i<listeTrieeCirculaire.length;i++)
				{
					if(listeTrieeCirculaire[i].etage() == d.etage())
					{
						listeTrieeCirculaire[i]= null;
						break;
					}
				}
				
				int i=0;
				while(listeTrieeCirculaire[i+1] == listeTrieeCirculaire[i])
				{
					listeTrieeCirculaire[i] = listeTrieeCirculaire[i+1];
					i++;
				}
			}
		}
		
	}

	@Override
	public Demande suivantDe(Demande courant) 
	{
		return null;
	}

}
