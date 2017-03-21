package commande;
import outils.*;

/**
 * Classe impl�mentant les interfaces <code>IControleur</code>, <code>IIUG</code>, <code>ICabine</code>, elle repr�sente le contr�le de la cabine � partir des demandes.
 * @author Vincent
 * @see Demande
 * @see Sens
 * @see ListeTrieeCirculaireDeDemandes
 */
public class Controleur implements IControleur, IIUG, ICabine{
	private int position;
	private int nombreEtages;
	private Sens sens;
	private Sens sensPrecedent;
	private Demande demande;
	private ListeTrieeCirculaireDeDemandes stockDeDemandes;
	private IIUG diug;
	private ICabine dc;
	
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
	public Controleur(IIUG diug,ICabine dc,int position){
		this.diug=diug;
		this.dc=dc;
		this.position=position;
		this.stockDeDemandes=new ListeTrieeCirculaireDeDemandes(10);
	}
	
	public IIUG doublureIUG(){
		return diug;
	}
	
	public ICabine doublureCabine(){
		return dc;
	}
	
	public void MAJPosition() throws ExceptionCabineArretee
	{
		if(sens == Sens.MONTEE && position<nombreEtages-1)
		{
			position++;
		}
		else if(sens == Sens.DESCENTE && position>0)
		{
			position--;
		}
		else
		{
			throw new ExceptionCabineArretee();
		}
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
	@Override
	public void eteindreTousBoutons() {
		for(int i=0;i<stockDeDemandes.taille();i++) 
		{
			eteindreBouton(stockDeDemandes.listeTrieeFinale[i]);
		}
	}

	/**
	 * Supprime toutes les demandes pr�c�demment stock�es.
	 */
	@Override
	public void viderStock() {
		stockDeDemandes.vider();
	}

	/**
	 * Retourne la demande suivante du stock � traiter.
	 * @return <code>Demande</code> la demande suivante � traiter
	 */
	@Override
	public Demande interrogerStock() {
		return stockDeDemandes.suivantDe(new Demande(position,sens));
	}

	/**
	 * Supprime la demande souhait�e du stock.
	 * @param d <code>Demande</code> : Demande que l'on souhaite ne plus traiter (car trait�e au pr�alable).
	 */
	@Override
	public void enleverDuStock(Demande d) {
		stockDeDemandes.supprimer(d);
	}

	/**
	 * Interroge si une demande pr�cise existe ou non dans le stock.
	 * @param d <code>Demande</code> : Demande en question 
	 */
	@Override
	public void demander(Demande d) {
		this.stocker(d);
		this.diug.demander(d);
		MAJSens();
		if(this.getPosition() < d.etage()){
			this.dc.monter();
		}else
			this.dc.descendre();
		
		this.diug.allumerBouton(d);
	}

	/**
	 * Enclenche l'arr�t d'urgence sur demande.
	 */
	@Override
	public void arretUrgence() {
		this.eteindreTousBoutons();
		this.diug.arretUrgence();
		
	}

	/**
	 * Allume le bouton de la demande ajout�e.
	 * @param d <code>Demande</code> : Demande qui a �t� ajout�e dans le stock des demandes. 
	 */
	@Override
	public void allumerBouton(Demande d) {
		this.diug.allumerBouton(d);
		
	}

	/**
	 * �teint le bouton de la demande trait�e.
	 * @param d <code>Demande</code> : Demande qui a �t� supprim�e du stock des demandes. 
	 */
	@Override
	public void eteindreBouton(Demande d) {
		this.diug.eteindreBouton(d);
		
	}

	/**
	 * Affiche un message visible � l'utilisateur.
	 * @param message <code>String</code> : Message d'information qui sera affich� � l'utilisateur
	 */
	@Override
	public void ajouterMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Equivalent de MAJPosition.
	 * @param i <code>int</code>
	 */
	@Override
	public void changerPosition(int i) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Stocke une demande.
	 */
	@Override
	public void stocker() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Signale un changement d'�tage. 
	 * @throws ExceptionCabineArretee 
	 */
	@Override
	public void signalerChangementDEtage() throws ExceptionCabineArretee {
		
		this.dc.signalerChangementDEtage();
		this.MAJPosition();
		System.out.println("Etage : " + this.getPosition());
	}

	/**
	 * D�clenche l'action de monter pour la cabine.
	 */
	@Override
	public void monter() {
		this.dc.monter();
		
	}

	/**
	 * D�clenche l'action de descendre pour la cabine.
	 */
	@Override
	public void descendre() {
		this.dc.descendre();
		
	}

	/**
	 * Signale que la cabine s'arr�te au prochain �tage (due � une demande)
	 */
	@Override
	public void arreterProchainNiveau() {
		this.dc.arreterProchainNiveau();
		
	}

	/**
	 * Fait arr�ter la cabine en mouvement.
	 */
	@Override
	public void arreter() {
		this.dc.arreter();
		
	}
	
}
