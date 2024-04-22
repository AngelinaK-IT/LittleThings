package TopPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlatzAuswahlScreen extends JFrame implements ActionListener {
		/*
		 * 
		 * Beim dem Applicationscreen kann der User entscheiden ob er tickets ohne registrierung, sich registrieren, 
		 * oder anmelden m�chte.
		 * 
		 * @version 1.0.
		 * @author Gruppe 22.
		 * 
		 * @see KaufenohneRegistrierungScreen
		 * @see AnmeldeScreen
		 * @see RegistrierungsScreen
		 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
		 * 
		 * Es gibt keinen Rueckgabewert
		 */
		//Einzelnenobjekte
		JPanel panel = new JPanel();
		
		JFrame frame = null;
		JLabel label, label2;
		JButton an, re, buywr; 
		
		JRadioButton radio, radio2;
		//Farben
		Color c2=new Color(20, 26, 50);
		Color cwhite= new Color(210, 210, 215);
		Color ctop=new Color(128, 156, 245);
		Color cyellow= new Color(207, 180, 94);
		Color cblue= new Color(62, 101, 251);
		//Weitere Elemente
		
		//Main f�r Tests
		public static void main(String[] args){
			PlatzAuswahlScreen start = new PlatzAuswahlScreen ();
			start.PlatzAuswahlGUI();
		}
		  
		//GUI Aussehen
		public void PlatzAuswahlGUI(){
			
			frame = new JFrame ("Ultimate-events");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Gr��e
			frame.setSize(750,750);
			frame.setLocationRelativeTo(null);
			frame.add(panel);
			
			panel.setBackground(c2);
			panel.setLayout(null);
			frame.setResizable(false);
			
			//Jeweilige Aussehen der Objekte der GUI
			label = new JLabel("Herzlich Willkommen!", SwingConstants.CENTER);
			label.setBounds(0,0,500,30);
			label.setOpaque(true);
			label.setBackground(ctop);
			label.setForeground(c2);
			
			//Jeweilige Aussehen der Objekte der GUI
			label2 = new JLabel("Herzlich Willkommen!", SwingConstants.CENTER);
			label2.setBounds(400,0,500,30);
			label2.setOpaque(true);
			label2.setBackground(ctop);
			label2.setForeground(c2);
			
			//label.setBounds(0,0,500,30);
			//label.setOpaque(true);
			//label.setBackground(ctop);
			//label.setForeground(c2);
			
			buywr = new JButton("Kaufen ohne Registration");
			buywr.setBounds(45,80,400,60);
			buywr.addActionListener(this);
			buywr.setBackground(cblue);
			buywr.setForeground(Color.white);
			
			re = new JButton("Registrierung");
			re.setBounds(45,160,400,60);
			re.setBackground(cblue);
			re.setForeground(Color.WHITE);
			re.addActionListener(this);
			
			an = new JButton("Anmeldung");
			an.setBounds(45,240,400,60);
			an.setOpaque(true);
			an.addActionListener(this);
			an.setBackground(cblue);
			an.setForeground(Color.white);
		
			radio = new JRadioButton("", true);
			radio.setBounds(45,310,20,20);
			radio2 = new JRadioButton("", true);
			radio2.setBounds(45,330,20,20);
			
			panel.add(label);
			panel.add(radio);
			panel.add(radio2);
			panel.add(an);
			panel.add(re);
			panel.add(buywr);
			panel.add(label2);
			
			
			frame.setVisible(true);
			
		}
	  /*
	   * Hier wird, abhaegig vom Buttondruck auf der Startseite die jeweilige Funktion aufgerufen.
	   * Entweder darf der User sich regestrieren oder anmelden.
	   * 
	   * 
	   */ 
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == an) {
				AnmeldeScreen anmeldung = new AnmeldeScreen();
				anmeldung.GUIAnmeldung();
				frame.setVisible(false);
			} // end of if
			if (e.getSource() == re) {
				/*
				RegistrierungsScreen registrierung = new RegistrierungsScreen();
				registrierung.GUIRegistrierung();
				frame.setVisible(false); 
				*/      
			}// end of if
			if(e.getSource() == buywr) {
				//KaufenOhneRegScreen kaufen = new KaufenOhneRegScreen();
				//kaufen.GUIKaufenOhneRegScreen();
				frame.setVisible(false);
			}// end of if
		}     
}



