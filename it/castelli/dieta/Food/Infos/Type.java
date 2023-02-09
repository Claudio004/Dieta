package it.castelli.dieta.Food.Infos;

/**
 * @author Claudio Togni 4CI
 * @see it.castelli.dieta.Window
 * @see it.castelli.dieta.Food.Pasto
 * @see it.castelli.dieta.Food.Piatto
 * @see InfoNutriz
 * @version 1.0
 */
public class Type {
	private int type = 0;
	
	Type(){
		
	}
	
	public Type(int type){
		this.type = type;
	}
	
	public int ordinal() {
		return this.type;
	}
	
	public void setOrdinal(int n) {
		this.type = n;
	}
}