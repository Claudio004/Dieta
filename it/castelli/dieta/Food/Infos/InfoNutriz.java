package it.castelli.dieta.Food.Infos;

/**
 * @version 1.0
 * @author Claudio Togni 4CI
 * @see it.castelli.dieta.Window
 * @see it.castelli.dieta.Food.Pasto
 * @see it.castelli.dieta.Food.Piatto
 * @see Type
 */
public class InfoNutriz {
	private float Carbs = 0;
	private float Fat = 0;
	private float Proteins = 0;
	
	InfoNutriz(){
		
	}
	
	public InfoNutriz(float Carbs, float Fat, float Proteins){
		this.Carbs = Carbs;
		this.Fat = Fat;
		this.Proteins = Proteins;
	}

	/**
	 * Restituisce il valore dei carboidrati
	 * @return Carbs : float
	 */
	public float getCarbs() {
		return Carbs;
	}

	/**
	 * Imposta il valore dei carboidrati
	 * @param Carbs : float
	 */
	public void setCarbs(float Carbs) {
		this.Carbs = Carbs;
	}

	/**
	 * Restituisce il valore dei grassi
	 * @return Fat : float
	 */
	public float getFat() {
		return Fat;
	}

	/**
	 * Imposta il valore dei grassi
	 * @param Fat : float
	 */
	public void setFat(float Fat) {
		this.Fat = Fat;
	}

	/**
	 * Restituisce il valore delle proteine
	 * @return Proteins : float
	 */
	public float getProteins() {
		return Proteins;
	}

	/**
	 * Imposta il valore delle proteine
	 * @param Proteins : float
	 */
	public void setProteins(float Proteins) {
		this.Proteins = Proteins;
	}

	/**
	 * Restituisce i valori nutrizionali sotto forma di stringa
	 * @return Infos : String
	 */
	@Override
	public String toString() {
		return "Carbs=" + getCarbs() + ", Fat=" + getFat() + ", Proteins=" + getProteins();
	}
	
}
