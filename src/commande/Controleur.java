package commande;
import outils.*;

public class Controleur implements IControleur{
	private int position;
	private int nombreEtages;
	private Sens sens;
	private Sens sensPrecedent;
	private Demande demande;
	private ListeTrieeCirculaireDeDemandes stockDeDemandes;
	private IIUG diug;
	private ICabine dc;
	
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

	public int getPosition(){
		return position;
	}
	public Controleur(IIUG diug,ICabine dc,int position){
		this.diug=diug;
		this.dc=dc;
		this.position=position;
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
	
	public void MAJSens()
	{
		
	}
	
	public void stocker()
	{
		
	}

	@Override
	public void eteindreTousBoutons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viderStock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interrogerStock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enleverDuStock(Demande d) {
		// TODO Auto-generated method stub
		
	}
	
}
