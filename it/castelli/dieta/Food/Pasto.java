package it.castelli.dieta.Food;
import java.util.Vector;

/**
 * @author Claudio Togni 4CI
 * @version 1.0
 * @see Vector
 * @see it.castelli.dieta.Window
 * @see Piatto
 * @see it.castelli.dieta.Food.Infos.Type
 * @see it.castelli.dieta.Food.Infos.InfoNutriz
 */
public class Pasto {
	private Vector<Piatto> Piatti = new Vector<Piatto>(0);
	
	public Pasto(){
		
	}
	
	/**
	 * Restituisce <b>true</b> se puoi aggiungere il piatto <b>P</b>
	 * oppure false se non puoi inserirlo.<br>
	 * La decisione sull'inserimento del piatto dipende
	 * dal <b>tipo</b> del piatto inserito:<br>
	 * Se esiste già un piatto con lo stesso <b>tipo</b>, il valore
	 * di <b>canAdd</b> sarà <b>false</b>, altrimenti sarà <b>true</b>.
	 * @param P : Piatto
	 * @return canAdd : boolean
	 * @see Vector
	 * @see Piatto
	 */
	public boolean addPiatto(int type) {
		boolean canAdd = true;
		for(int i = 0; i < Piatti.size(); i++) {
			if(Piatti.elementAt(i).getTipo() == type) {
				canAdd = false;
				i = Piatti.size();
			}		
		}
		return canAdd;
	}
	
	/**
	 * Aggiunge un piatto al pasto se viene restituito <b>true</b> da:<br>
	 * <b>addPiatto(int type)</b>
	 * @param P : Piatto
	 * @param type : int
	 * @see Vector
	 * @see Piatto
	 */
	public void adderPiatto(Piatto P, int type) {
		if(addPiatto(type)) {
			Piatti.add(P);
		}
	}
	
	/**
	 * Restituisce le informazioni del piatto in 
	 * posizione <b>'index'</b> dell'array contenente
	 * i piatti del Pasto
	 * @param index : int
	 * @return Piatto.toString() : String
	 * @see Vector
	 * @see Piatto
	 */
	public String getPiatto(int index) {
		return Piatti.elementAt(index).toString();
	}
	
	/**
	 * Restituisce la <b>somma dei valori nutrizionali</b> dei piatti
	 * presenti nel pasto sotto forma di stringa
	 * @return ValoriNutrizTot : String
	 * @see Vector
	 * @see it.castelli.dieta.Food.Infos.InfoNutriz
	 * @see Piatto
	 */
	public String getInfoNutriz() {
		float sommaCarbs = 0;
		float sommaFat = 0;
		float sommaProteins = 0;
		
		for(int i = 0; i < Piatti.size(); i++) {
			sommaCarbs += Piatti.elementAt(i).getCarbs();
			sommaFat += Piatti.elementAt(i).getFat();
			sommaProteins += Piatti.elementAt(i).getProteins();
		}
		return "Carbs=" + sommaCarbs + ", Fat=" + sommaFat + ", Proteins=" + sommaProteins;
	}
	
	/**
	 * Restituisce <b>true</b> se il pasto è equilibrato, oppure <b>false</b>.<br>
	 * Per stabilire se il piatto è equilibrato si controlla il <b>tipo</b>
	 * di ogni piatto presente nel pasto.<br>
	 * Un pasto è equilibrato se sono presenti un contorno e un frutto e
	 * <b>almeno uno</b> tra primo e secondo.
	 * @return eq : boolean
	 * @see Vector
	 * @see it.castelli.dieta.Food.Infos.Type
	 * @see Piatto
	 */
	public boolean equilibrato() {
		boolean eq;
		int enumPrimo = -1;
		int enumSecondo = -1;
		int enumContorno = -1;
		int enumFrutta = -1;
		for(int i = 0; i < Piatti.size(); i++) {
			if(Piatti.elementAt(i).getTipo() == 0) {
				enumPrimo = 0;
			}else {
				if(Piatti.elementAt(i).getTipo() == 1) {
					enumSecondo = 1;
				}else {
					if(Piatti.elementAt(i).getTipo() == 2) {
						enumContorno = 2;
					}else {
						enumFrutta = 3;
					}
				}
			}
		}
		if((enumContorno == 2) && (enumFrutta == 3) && ((enumPrimo == 0) || (enumSecondo == 1))) {
			eq = true;
		}else {
			eq = false;
		}
		return eq;
	}
	
	/**
	 * Restituisce la quantità di piatti presenti nel pasto
	 * @return Piatti.size() : int
	 * @see Vector
	 */
	public int returnElements() {
		return Piatti.size();
	}
	
	/**
	 * Restituisce una stringa contenente i nomi dei piatti
	 * presenti nel pasto.
	 * @return s : String
	 * @see Vector
	 * @see Piatto
	 */
	@Override
	public String toString() {
		String s = "Nome Piatti: ";
		for(int i = 0; i < Piatti.size(); i++) {
			s += Piatti.elementAt(i).getNome() + ";";
		}
		return s;
	}
	//--------------------------------------------------------------
}
