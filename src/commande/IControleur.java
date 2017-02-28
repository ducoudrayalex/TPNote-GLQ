package commande;
import outils.*;

public interface IControleur {

	void MAJSens();
	
	void stocker();
	
	void MAJPosition() throws ExceptionCabineArretee;
	
	void eteindreTousBoutons();
	
	void viderStock();
	
	void interrogerStock();
	
	void enleverDuStock(Demande d);
	
}
