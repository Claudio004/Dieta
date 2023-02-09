package it.castelli.dieta;
//<--------------------Graphics-------------------->
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
//<---------------------Events--------------------->
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//<-------------------Operations------------------->
import java.util.Vector;
import it.castelli.dieta.Food.Pasto;
import it.castelli.dieta.Food.Piatto;

/**
 * Parte grafica e operazionale del software
 * @version 1.0.2
 * @author Claudio Togni 4CI
 * @see Alert
 * @see Pasto
 * @see Piatto
 * @see it.castelli.dieta.Food.Infos.Type
 * @see it.castelli.dieta.Food.Infos.InfoNutriz
 * @see Vector
 * @see JFrame
 * @see JPanel
 * @see JButton
 * @see JTextField
 * @see JMenuBar
 * @see JMenu
 * @see JMenuItem
 * @see JLabel
 * @see JRadioButton
 * @see ButtonGroup
 * @see ImageIcon
 * @see Color;
 * @see FlowLayout
 * @see Font
 * @see GridLayout
 * @see ActionListener
 * @see ActionEvent
 */
public class Window implements ActionListener{
	private JFrame Frame = new JFrame();
	private JPanel Panel = new JPanel();
	private JButton Buttons[] = new JButton[10];
	private Vector<JButton> ButtonsViewer = new Vector<JButton>(0);
	private Vector<JTextField> ViewerPiatti = new Vector<JTextField>(0);
	private JTextField TextField[] = new JTextField[4];
	private JMenuBar MenuBar = new JMenuBar();
	private JMenu Options = new JMenu("Options");
	private JMenuItem ViewPasti = new JMenuItem("Visualizza Pasti");
	private JMenuItem AddPasto = new JMenuItem("Aggiungi Pasto");
	private JMenuItem Exit = new JMenuItem("Exit");
	private JLabel Label[] = new JLabel[4];
	private JRadioButton Primo;
	private JRadioButton Secondo;
	private JRadioButton Contorno;
	private JRadioButton Frutta;
	private ButtonGroup Type = new ButtonGroup();
	private ImageIcon Icon = new ImageIcon("DietIcon.png");
	private Alert alert = new Alert();
	//-----------------------------------------------------------------> Graphical Elements
	private Vector<Pasto> Pasti = new Vector<Pasto>(0);
	private Piatto piatto = new Piatto();
	//-----------------------------------------------------------------> Foundamental Elements
	
	Window(){
		setButtons();
		setMenuProprieties();
		setLabels();
		setInputAdderFields();
		setRadioButtonsProprieties();
		setButtonGroup();
		setStartPanelProprieties();
		setFrameProprieties();	
	}
	
	/**
	 * Imposta le proprietà del frame
	 * @see JFrame
	 * @see ImageIcon
	 */
	private void setFrameProprieties() {
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(500,489);
		Frame.setLayout(null);
		Frame.setLocationRelativeTo(null);
		Frame.setTitle("Dieta");
		Frame.add(Panel);
		Frame.setJMenuBar(MenuBar);
		Frame.setIconImage(Icon.getImage());
		Frame.setVisible(true);
	}
	
	/**
	 * Imposta le proprietà del panel della
	 * schermata iniziale
	 * @see JPanel
	 * @see Color
	 */
	private void setStartPanelProprieties() {
		Panel.setSize(500, 450);
		Panel.setBackground(Color.orange);
		Panel.setLayout(null);
		Panel.add(Buttons[0]);
		Panel.setVisible(true);
	}
	
	/**
	 * Imposta le proprietà della MenuBar
	 * @see JMenuBar
	 * @see JMenu
	 * @see JMenuItem
	 */
	private void setMenuProprieties() {
		ViewPasti.addActionListener(this);
		ViewPasti.setMnemonic(KeyEvent.VK_W);
		AddPasto.addActionListener(this);
		AddPasto.setMnemonic(KeyEvent.VK_A);
		Exit.addActionListener(this);
		Exit.setMnemonic(KeyEvent.VK_E);
		Options.add(ViewPasti);
		Options.add(AddPasto);
		Options.add(Exit);
		Options.setMnemonic(KeyEvent.VK_O);		
		MenuBar.add(Options);
	}
	
	/**
	 * Imposta le proprietà dei label
	 * @see JLabel
	 */
	private void setLabels() {
		Label[0] = new JLabel("Nome Piatto");
		Label[1] = new JLabel("Carboidrati");
		Label[2] = new JLabel("Grassi");
		Label[3] = new JLabel("Proteine");
	}
	
	/**
	 * Imposta le proprietà dei pulsanti
	 * @see JButton
	 * @see ActionListener
	 * @see ActionEvent
	 */
	private void setButtons() {
		Buttons[0] = new JButton("Inizia");	
		Buttons[0].addActionListener(this);
		Buttons[0].setSize(80, 30);
		Buttons[0].setBounds(210, 210, 80, 30);
		Buttons[0].setVisible(true);
		//<-------------------->
		Buttons[1] = new JButton("Aggiungi");	
		Buttons[1].setSize(80, 30);
		Buttons[1].addActionListener(this);
		Buttons[0].setVisible(true);
		//<-------------------->
		Buttons[2] = new JButton("Fine");
		Buttons[2].setSize(80, 30);
		Buttons[2].addActionListener(this);
		Buttons[0].setVisible(true);
		//<-------------------->
	}
	
	/**
	 * Imposta le proprietà del panel della schermata
	 * di aggiunta di piatti in un pasto
	 * @see JPanel
	 * @see JLabel
	 * @see JButton
	 * @see JRadioButton
	 * @see GridLayout
	 */
	private void setAdderPanelProprieties() {
		Panel.setVisible(false);
		Panel.removeAll();
		Panel.setLayout(new GridLayout(7, 2, 1, 5));
		for(int i = 0; i < 4; i++) {
			if(i == 1) {
				Panel.add(Primo);
				Panel.add(Secondo);
				Panel.add(Contorno);
				Panel.add(Frutta);
			}
			Panel.add(Label[i]);
			Panel.add(TextField[i]);
		}
		Panel.add(Buttons[1]);
		Panel.add(Buttons[2]);
		Panel.setVisible(true);
	}
	
	/**
	 * Imposta le proprietà dei TextFields della schermata
	 * di adder dei piatti in un pasto
	 * @see JTextField
	 * @see Font
	 */
	private void setInputAdderFields() {
		for(int i = 0; i < 4; i++) {
			TextField[i] = new JTextField();
			TextField[i].setSize(200,40);
			TextField[i].setFont(new Font("Arial", 0, 30));
			TextField[i].setEditable(true);
			TextField[i].setVisible(true);
		}
	}
	
	/**
	 * Imposta l'ActionListener ai RadioButtons
	 * @see JRadioButton
	 * @see ActionListener
	 * @see ActionEvent
	 */
	private void setRadioButtonsProprieties() {
		Primo = new JRadioButton("Primo");
		Primo.addActionListener(this);
		Secondo = new JRadioButton("Secondo");
		Secondo.addActionListener(this);
		Contorno = new JRadioButton("Contorno");
		Contorno.addActionListener(this);
		Frutta = new JRadioButton("Frutta");
		Frutta.addActionListener(this);
	}
	
	/**
	 * Aggiunta dei RadioButton al ButtonGroup
	 * @see JRadioButton
	 * @see ButtonGroup
	 */
	private void setButtonGroup() {
		Type.add(Primo);
		Type.add(Secondo);
		Type.add(Contorno);
		Type.add(Frutta);
	}
	
	/**
	 * Imposta i bottoni per la visualizzazione dei pasti inseriti
	 * @see Vector
	 * @see JButton
	 * @see Pasto
	 */
	private void setButtonsViewerProprieties() {
		if(ButtonsViewer.size() != 0) {
			ButtonsViewer.removeAllElements();
		}
		for(int i = 0; i < Pasti.size(); i++) {
			if(Pasti.elementAt(i).returnElements() != 0) {
				ButtonsViewer.add(new JButton(Pasti.elementAt(i).toString()));
				ButtonsViewer.elementAt(ButtonsViewer.size()-1).addActionListener(this);
				ButtonsViewer.elementAt(ButtonsViewer.size()-1).setVisible(true);
			}
		}
	}
	
	/**
	 * Imposta le proprietà del panel della schermata
	 * di view dei pasti inseriti
	 * @see Vector
	 * @see JPanel
	 * @see JButton
	 * @see FlowLayout
	 * @see Pasto
	 */
	private void setViewPastiPanelProprieties() {
		Panel.setVisible(false);
		Panel.removeAll();
		Panel.setLayout(new FlowLayout());
		for(int i = 0; i < ButtonsViewer.size(); i++) {
			Panel.add(ButtonsViewer.elementAt(i));
		}
		Panel.setVisible(true);
	}
	
	/**
	 * Imposta i textfield di visualizzazione dettagliata
	 * degli elementi di un pasto
	 * @param num : int
	 * @see Vector
	 * @see JTextField
	 * @see Pasto
	 */
	private void setViewerPiattiProprieties(int num) {
		if(ViewerPiatti.size() != 0) {
			ViewerPiatti.removeAllElements();
		}
		for(int i = 0; i < Pasti.elementAt(num).returnElements(); i++) {
			ViewerPiatti.add(new JTextField());
			ViewerPiatti.elementAt(ViewerPiatti.size()-1).setText(Pasti.elementAt(num).getPiatto(i));
			ViewerPiatti.elementAt(ViewerPiatti.size()-1).setEditable(false);
		}
		ViewerPiatti.add(new JTextField());
		ViewerPiatti.elementAt(ViewerPiatti.size()-1).setEditable(false);
		if(Pasti.elementAt(num).equilibrato()) {
			ViewerPiatti.elementAt(ViewerPiatti.size()-1).setText("Questo pasto è equilibrato");
		}else {
			ViewerPiatti.elementAt(ViewerPiatti.size()-1).setText("Questo pasto non è equilibrato");
		}
		ViewerPiatti.add(new JTextField());
		ViewerPiatti.elementAt(ViewerPiatti.size()-1).setEditable(false);
		ViewerPiatti.elementAt(ViewerPiatti.size()-1).setText("Info Nutrizionali totali: " + Pasti.elementAt(num).getInfoNutriz());
	}
	
	/**
	 * Imposta le proprietà del panel di view dettagliata
	 * di un pasto
	 * @see Vector
	 * @see JTextField
	 * @see JPanel
	 * @see Pasto
	 */
	private void setViewerPiattiPanelProprieties() {
		Panel.setVisible(false);
		Panel.removeAll();
		for(int i = 0; i < ViewerPiatti.size(); i++) {
			Panel.add(ViewerPiatti.elementAt(i));
		}
		Panel.setLayout(new GridLayout(6, 1, 20, 5));
		Panel.setVisible(true);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Menu Option: Exit ----> Alt+O and E
		if(e.getSource() == Exit) {
			System.exit(0);
		}
		
		//Menu Option: Visualizza Pasti ----> Alt+O and W
		if(e.getSource() == ViewPasti) {
			setButtonsViewerProprieties();
			setViewPastiPanelProprieties();
		}
		
		//Menu Option: Aggiungi Pasto ----> Alt+O and A
		if(e.getSource() == AddPasto) {
			setAdderPanelProprieties();
			Pasti.add(new Pasto());
		}
		
		//Start Button
		if(e.getSource() == Buttons[0]) {
			setAdderPanelProprieties();
			Pasti.add(new Pasto());
		}	
		
		//End Button
		if(e.getSource() == Buttons[2]) {
			Panel.setVisible(false);
			Panel.removeAll();
			setStartPanelProprieties();
		}
		
		//Add Button
		if(e.getSource() == Buttons[1]) {
			int tipo;
			if(TextField[0].getText().equals("")) {
				alert.errorNameResolve();
			}else {
				if((Primo.isSelected() == false) && (Secondo.isSelected() == false) && (Contorno.isSelected() == false) && (Frutta.isSelected() == false)) {
					alert.errorTypeResolve();
				}else {
					if(TextField[1].getText().equals("")) {
						alert.errorCarbsValueResolve();
					}else {
						if(TextField[2].getText().equals("")) {
							alert.errorFatValueResolve();
						}else {
							if(TextField[3].getText().equals("")) {
								alert.errorProteinsValueResolve();
							}else {
								piatto.setNome(TextField[0].getText());
								if(Primo.isSelected()) {
									tipo = 0;
								}else {
									if(Secondo.isSelected()) {
										tipo = 1;
									}else {
										if(Contorno.isSelected()) {
											tipo = 2;
										}else {
											tipo = 3;
										}
									}
								}
								piatto.setTipo(tipo);
								piatto.setInfo(Float.parseFloat(TextField[1].getText()), Float.parseFloat(TextField[2].getText()), 
										Float.parseFloat(TextField[3].getText()));
								if(Pasti.elementAt(Pasti.size()-1).addPiatto(tipo)) {
									alert.adderConfirmAlert();
									Pasti.elementAt(Pasti.size()-1).adderPiatto(piatto, tipo);
								}else {
									alert.adderErrorAlert();
								}
								for(int i = 0; i < 4; i++) {
									TextField[i].setText("");
								}
								piatto = new Piatto();
							}
						}
					}
				}
			}
		}//End Add Button
		
		for(int i = 0; i < ButtonsViewer.size(); i++) {
			if(e.getSource() == ButtonsViewer.elementAt(i)) {
				setViewerPiattiProprieties(i);
				setViewerPiattiPanelProprieties();
			}
		}
	}//end ActionListener
	//---------------------------------------------------
}