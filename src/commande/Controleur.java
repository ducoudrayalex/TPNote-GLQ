package commande;
import outils.*;

/**
 * Classe implémentant les interfaces <code>IControleur</code>, <code>IIUG</code>, <code>ICabine</code>, elle représente le contrôle de la cabine à partir des demandes.
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
	 * Constructeur par défaut de la classe.
	 * @param position <code>int</code> : position à laquelle se trouve la cabine
	 * @param nombreEtages <code>int</code> : Nombre total d'étages de l'immeuble
	 * @param sens <code>Sens</code> : Sens dans lequel la cabine est en mouvement 
	 * @param sensPrecedent <code>Sens</code> : Sens précédent que la cabine suivait
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
	 * Met à jour la position de la cabine en fonction de son mouvement.
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
	 * Met à jour le sens de la cabine en fonction de la demande suivante.
	 */
	public void MAJSens()
	{
		// Cabine arrêtée, plus de demandes
		if(stockDeDemandes.estVide())	
		{
			sens = Sens.INDEFINI;
		}
		// Si la demande suivante concerne un étage supérieur à celui courant
		else if(stockDeDemandes.suivantDe(new Demande(position,sens)).etage()> position)	
		{
			sens = Sens.MONTEE;
		}
		// Si la demande suivante concerne un étage inférieur à celui courant
		else if(stockDeDemandes.suivantDe(new Demande(position,sens)).etage()< position)	
		{
			sens = Sens.DESCENTE;
		}
	}
	
	/**
	 * Stocke une demande pour qu'elle soit traitée ultérieurement.
	 * @param d <code>Demande</code> : Demande que l'on souhaite stocker  
	 */
	public void stocker(Demande d)
	{
		stockDeDemandes.inserer(d);
	}

	/**
	 * Eteint tous les boutons allumés.
	 */
	@Override
	public void eteindreTousBoutons() {
		for(int i=0;i<stockDeDemandes.taille();i++) 
		{
			eteindreBouton(stockDeDemandes.listeTrieeFinale[i]);
		}
	}

	/**
	 * Supprime toutes les demandes précédemment stockées.
	 */
	@Override
	public void viderStock() {
		stockDeDemandes.vider();
	}

	/**
	 * Retourne la demande suivante du stock à traiter.
	 * @return <code>Demande</code> la demande suivante à traiter
	 */
	@Override
	public Demande interrogerStock() {
		return stockDeDemandes.suivantDe(new Demande(position,sens));
	}

	/**
	 * Supprime la demande souhaitée du stock.
	 * @param d <code>Demande</code> : Demande que l'on souhaite ne plus traiter (car traitée au préalable).
	 */
	@Override
	public void enleverDuStock(Demande d) {
		stockDeDemandes.supprimer(d);
	}

	/**
	 * Interroge si une demande précise existe ou non dans le stock.
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
	 * Enclenche l'arrêt d'urgence sur demande.
	 */
	@Override
	public void arretUrgence() {
		this.eteindreTousBoutons();
		this.diug.arretUrgence();
		
	}

	/**
	 * Allume le bouton de la demande ajoutée.
	 * @param d <code>Demande</code> : Demande qui a été ajoutée dans le stock des demandes. 
	 */
	@Override
	public void allumerBouton(Demande d) {
		this.diug.allumerBouton(d);
		
	}

	/**
	 * Éteint le bouton de la demande traitée.
	 * @param d <code>Demande</code> : Demande qui a été supprimée du stock des demandes. 
	 */
	@Override
	public void eteindreBouton(Demande d) {
		this.diug.eteindreBouton(d);
		
	}

	/**
	 * Affiche un message visible à l'utilisateur.
	 * @param message <code>String</code> : Message d'information qui sera affiché à l'utilisateur
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
	 * Signale un changement d'étage. 
	 * @throws ExceptionCabineArretee 
	 */
	@Override
	public void signalerChangementDEtage() throws ExceptionCabineArretee {
		
		this.dc.signalerChangementDEtage();
		this.MAJPosition();
		System.out.println("Etage : " + this.getPosition());
	}

	/**
	 * Déclenche l'action de monter pour la cabine.
	 */
	@Override
	public void monter() {
		this.dc.monter();
		
	}

	/**
	 * Déclenche l'action de descendre pour la cabine.
	 */
	@Override
	public void descendre() {
		this.dc.descendre();
		
	}

	/**
	 * Signale que la cabine s'arrête au prochain étage (due à une demande)
	 */
	@Override
	public void arreterProchainNiveau() {
		this.dc.arreterProchainNiveau();
		
	}

	/**
	 * Fait arrêter la cabine en mouvement.
	 */
	@Override
	public void arreter() {
		this.dc.arreter();
		
	}
	
}
