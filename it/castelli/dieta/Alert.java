package it.castelli.dieta;
import javax.swing.JOptionPane;

/**
 * Alert library for Dieta
 * @see JOptionPane
 * @see it.castelli.dieta.Window
 * @author Claudio Togni 4CI
 * @version 1.0
 */
public class Alert extends JOptionPane{
	
	Alert(){
		
	}
	
	/**
	 * Mostra il messaggio di errore nell'aggiunta<br>
	 * Del piatto ad un pasto
	 * @see JOptionPane
	 */
	@SuppressWarnings("static-access")
	public void adderErrorAlert() {
		this.showMessageDialog(null, "Impossibile aggiungere questo piatto al tuo pasto. Esiste già un piatto dello "
				+ "stesso tipo all'interno di questo pasto!!", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostra il messaggio di conferma nell'aggiunta<br>
	 * Del piatto ad un pasto
	 * @see JOptionPane
	 */
	@SuppressWarnings("static-access")
	public void adderConfirmAlert() {
		this.showMessageDialog(null, "Hai aggiunto questo piatto al tuo pasto", "Done!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Mostra il messaggio di errore nell'aggiunta<br>
	 * Del piatto ad un pasto<br>
	 * <b>Error Type: Name Value not found
	 * @see JOptionPane
	 */
	@SuppressWarnings("static-access")
	public void errorNameResolve() {
		this.showMessageDialog(null, "Devi Inserire il nome del piatto", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostra il messaggio di errore nell'aggiunta<br>
	 * Del piatto ad un pasto<br>
	 * <b>Error Type: Piatto.getTipo() Value not found
	 * @see JOptionPane
	 */
	@SuppressWarnings("static-access")
	public void errorTypeResolve() {
		this.showMessageDialog(null, "Devi Inserire il il tipo del piatto cliccando su una delle quattro caselle di selezione", 
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostra il messaggio di errore nell'aggiunta<br>
	 * Del piatto ad un pasto<br>
	 * <b>Error Type: Carbs Value not found
	 * @see JOptionPane
	 */
	@SuppressWarnings("static-access")
	public void errorCarbsValueResolve() {
		this.showMessageDialog(null, "Devi Inserire il valore per i carboidrati", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostra il messaggio di errore nell'aggiunta<br>
	 * Del piatto ad un pasto<br>
	 * <b>Error Type: Fat Value not found
	 * @see JOptionPane
	 */
	@SuppressWarnings("static-access")
	public void errorFatValueResolve() {
		this.showMessageDialog(null, "Devi Inserire il valore per i grassi", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mostra il messaggio di errore nell'aggiunta<br>
	 * Del piatto ad un pasto<br>
	 * <b>Error Type: Proteins Value not found
	 * @see JOptionPane
	 */
	@SuppressWarnings("static-access")
	public void errorProteinsValueResolve() {
		this.showMessageDialog(null, "Devi Inserire il valore per le proteine", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
