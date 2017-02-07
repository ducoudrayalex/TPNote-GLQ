package outils;

import commande.IListeTrieeCirculaire;

public class ListeTrieeCirculaireDeDemandes implements IListeTrieeCirculaire
{
	int taille_liste;

	public ListeTrieeCirculaireDeDemandes(int taille_liste) 
	{
		this.taille_liste = taille_liste;
	}
	
	public void inserer(Demande d)
	{
		
	}

	@Override
	public int taille() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void vider() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contient(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserer(Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object suivantDe(Object courant) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
