package commande;
import operative.Cabine;
import operative.ICabine;
import operative.IIUG;
import operative.IUG;
import outils.*;

/**
 * Classe impl�mentant les interfaces <code>IControleur</code>, <code>IIUG</code>, <code>ICabine</code>, elle repr�sente le contr�le de la cabine � partir des demandes.
 * @author Vincent
 * @see Demande
 * @see Sens
 * @see ListeTrieeCirculaireDeDemandes
 */
public class Controleur implements IControleur, ICabine, IIUG{
	private int position;
	private int nombreEtages;
	private Sens sens;
	private Sens sensPrecedent;
	private Demande demande;
	private ListeTrieeCirculaireDeDemandes stockDeDemandes;
	private IIUG diug;
	private ICabine cabine;
	
	/**
	 * Constructeur par d�faut de la classe.
	 * @param position <code>int</code> : position � laquelle se trouve la cabine
	 * @param nombreEtages <code>int</code> : Nombre total d'�tages de l'immeuble
	 * @param sens <code>Sens</code> : Sens dans lequel la cabine est en mouvement 
	 * @param sensPrecedent <code>Sens</code> : Sens pr�c�dent que la cabine suivait
	 * @param demande <code>Demande</code> : Demande courante que l'on traite 
	 * @param stockDeDemandes <code>ListeTrieeCirculaireDeDemandes</code> : Liste de toutes les demandes que la cabine doit satisfaire
	 */
	public Controleur(int position, int nombreEtages, Sens sens, Sens sensPrecedent, Demande demande,
			ListeTrieeCirculaireDeDemandes stockDeDemandes) 
	{
		this.position = position;
		this.nombreEtages = nombreEtages;
		this.sens = sens;
		this.sensPrecedent = sensPrecedent;
		this.demande = demande;
		this.stockDeDemandes = stockDeDemandes;
	}

	/**
	 * Met � jour la position de la cabine en fonction de son mouvement.
	 */
	public int getPosition(){
		return position;
	}
	public Controleur(int nbEtages, IIUG diug, ICabine cabine, IListeTrieeCirculaire<Demande> stock){
		//assignerControleur(this);
		this.diug=(IUG)diug;
		this.cabine=(Cabine)cabine;
		nombreEtages = nbEtages;
		stockDeDemandes = (ListeTrieeCirculaireDeDemandes) stock;
	}
	

	public void MAJPosition() throws ExceptionCabineArretee
	{
		if(sens == Sens.MONTEE && position<nombreEtages-1)
		{
			position++;
			monter();
		}
		else if(sens == Sens.DESCENTE && position>0)
		{
			position--;
			descendre();
		}
		else
		{
			throw new ExceptionCabineArretee();
		}
		diug.changerPosition(position);
	}
	
	/**
	 * Met � jour le sens de la cabine en fonction de la demande suivante.
	 */
	public void MAJSens()
	{
		// Cabine arr�t�e, plus de demandes
		if(stockDeDemandes.estVide())	
		{
			sens = Sens.INDEFINI;
		}
		// Si la demande suivante concerne un �tage sup�rieur � celui courant
		else if(stockDeDemandes.suivantDe(new Demande(position,sens)).etage()> position)	
		{
			sens = Sens.MONTEE;
		}
		// Si la demande suivante concerne un �tage inf�rieur � celui courant
		else if(stockDeDemandes.suivantDe(new Demande(position,sens)).etage()< position)	
		{
			sens = Sens.DESCENTE;
		}
	}
	
	/**
	 * Stocke une demande pour qu'elle soit trait�e ult�rieurement.
	 * @param d <code>Demande</code> : Demande que l'on souhaite stocker  
	 */
	public void stocker(Demande d)
	{
		stockDeDemandes.inserer(d);
	}

	/**
	 * Eteint tous les boutons allum�s.
	 */
	public void eteindreTousBoutons() {
		for(int i=0;i<stockDeDemandes.taille();i++) 
		{
			eteindreBouton(stockDeDemandes.listeTrieeFinale[i]);
		}
	}

	/**
	 * Supprime toutes les demandes pr�c�demment stock�es.
	 */
	public void viderStock() {
		stockDeDemandes.vider();
	}

	/**
	 * Retourne la demande suivante du stock � traiter.
	 * @return <code>Demande</code> la demande suivante � traiter
	 */
	public Demande interrogerStock() {
		return stockDeDemandes.suivantDe(new Demande(position,sens));
	}

	/**
	 * Supprime la demande souhait�e du stock.
	 * @param d <code>Demande</code> : Demande que l'on souhaite ne plus traiter (car trait�e au pr�alable).
	 */
	public void enleverDuStock(Demande d) {
		stockDeDemandes.supprimer(d);
	}

	/**
	 * Interroge si une demande pr�cise existe ou non dans le stock.
	 * @param d <code>Demande</code> : Demande en question 
	 */
	@Override
	public void demander(Demande d) {
		diug.allumerBouton(d);
		MAJSens();
		stocker(d);
	}

	/**
	 * Enclenche l'arr�t d'urgence sur demande.
	 */
	@Override
	public void arretUrgence() {
		cabine.arreter();
		eteindreTousBoutons();
	}

	/**
	 * Allume le bouton de la demande ajout�e.
	 * @param d <code>Demande</code> : Demande qui a �t� ajout�e dans le stock des demandes. 
	 */
	@Override
	public void allumerBouton(Demande d) {
		diug.allumerBouton(d);
	}

	/**
	 * �teint le bouton de la demande trait�e.
	 * @param d <code>Demande</code> : Demande qui a �t� supprim�e du stock des demandes. 
	 */
	@Override
	public void eteindreBouton(Demande d) {
		diug.eteindreBouton(d);
	}

	/**
	 * Affiche un message visible � l'utilisateur.
	 * @param message <code>String</code> : Message d'information qui sera affich� � l'utilisateur
	 */
	@Override
	public void ajouterMessage(String message) {
		diug.ajouterMessage(message);
	}

	/**
	 * Equivalent de MAJPosition.
	 * @param i <code>int</code>
	 */
	@Override
	public void changerPosition(int i) {
		diug.changerPosition(i);
	}

	/**
	 * Signale un changement d'�tage. 
	 * @throws ExceptionCabineArretee 
	 */
	@Override
	public synchronized void signalerChangementDEtage() {
		try {
			MAJPosition();
		} catch (ExceptionCabineArretee e) {
			e.printStackTrace();
		}
		if((sens == Sens.MONTEE && position+1 == stockDeDemandes.suivantDe(new Demande(position,sens)).etage())
				|| (sens == Sens.DESCENTE && position-1 == stockDeDemandes.suivantDe(new Demande(position,sens)).etage()) )
		{
			cabine.arreterProchainNiveau();
		}
	}

	/**
	 * D�clenche l'action de monter pour la cabine.
	 */
	@Override
	public void monter() {
		cabine.monter();
	}

	/**
	 * D�clenche l'action de descendre pour la cabine.
	 */
	@Override
	public void descendre() {
		cabine.descendre();
	}

	/**
	 * Signale que la cabine s'arr�te au prochain �tage (due � une demande)
	 */
	@Override
	public void arreterProchainNiveau() {
		cabine.arreterProchainNiveau();
	}

	/**
	 * Fait arr�ter la cabine en mouvement.
	 */
	@Override
	public void arreter() {
		cabine.arreter();
	}
	
	@Override
	public void assignerControleur(IControleur ic){
		cabine.assignerControleur(ic);
		diug.assignerControleur(ic);
	}
	
	@Override
	public void exit(){
		
	}
}
