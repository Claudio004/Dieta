package it.castelli.dieta.Food;

import it.castelli.dieta.Food.Infos.InfoNutriz;
import it.castelli.dieta.Food.Infos.Type;

/**
 * @author Claudio Togni 4CI
 * @version 1.0
 * @see it.castelli.dieta.Window
 * @see Pasto
 * @see it.castelli.dieta.Food.Infos.InfoNutriz
 * @see it.castelli.dieta.Food.Infos.Type
 */
public class Piatto {
	private String Nome;
	private Type Tipo;
	private InfoNutriz Info;
	
	public Piatto(){
		
	}
	
	public Piatto(String Nome, Type Tipo, InfoNutriz Info){
		this.Nome = Nome;
		this.Tipo = Tipo;
		this.Info = Info;
	}
	
	/**
	 * Restituisce il nome del piatto
	 * @return Nome : String
	 */
	public String getNome() {
		return Nome;
	}

	/**
	 * Imposta il nome del piatto
	 * @param Nome : String
	 */
	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	/**
	 * Restituisce il tipo del piatto sotto forma di int:<br>
	 * <b>0: Primo</b><br>
	 * <b>1: Secondo</b><br>
	 * <b>2: Contorno</b><br>
	 * <b>3: Frutta</b>
	 * @return Tipo.ordinal() : int
	 * @see it.castelli.dieta.Food.Infos.Type
	 */
	public int getTipo() {
		return Tipo.ordinal();
	}

	/**
	 * Imposta il tipo del piatto.
	 * @param Type : int
	 * @see it.castelli.dieta.Food.Infos.Type
	 */
	public void setTipo(int Type) {
		Tipo = new Type(Type);
	}

	/**
	 * Restituisce i valori nutrizionali del piatto
	 * sotto forma di stringa.
	 * @return Info.toString() : String
	 * @see it.castelli.dieta.Food.Infos.InfoNutriz
	 */
	public String getInfo() {
		return Info.toString();
	}

	/**
	 * Imposta i valori nutrizionali del piatto
	 * @param c : float
	 * @param f : float
	 * @param p : float
	 * @see it.castelli.dieta.Food.Infos.InfoNutriz
	 */
	public void setInfo(float c, float f, float p) {
		Info = new InfoNutriz(c, f, p);
	}
	
	/**
	 * Restituisce il valore dei carboidrati
	 * @return Info.getCarbs() : float
	 * @see it.castelli.dieta.Food.Infos.InfoNutriz
	 */
	public float getCarbs() {
		return Info.getCarbs();
	}
	
	/**
	 * Restituisce il valore dei grassi
	 * @return Info.getFat() : float
	 * @see it.castelli.dieta.Food.Infos.InfoNutriz
	 */
	public float getFat() {
		return Info.getFat();
	}
	
	/**
	 * Restituisce il valore delle proteine
	 * @return Info.getProteins() : float
	 * @see it.castelli.dieta.Food.Infos.InfoNutriz
	 */
	public float getProteins() {
		return Info.getProteins();
	}

	/**
	 * Restituisce le informazioni del piatto
	 * sottoforma di stringa
	 * @return Infos : String
	 */
	@Override
	public String toString() {
		return "Nome=" + getNome() + ", Tipo=" + getTipo() + ", Info:" + getInfo();
	}
}