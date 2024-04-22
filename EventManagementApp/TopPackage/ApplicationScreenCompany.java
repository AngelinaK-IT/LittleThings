package TopPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Beim dem Applicationscreen kann der User entscheiden ob er tickets ohne registrierung kaufen, sich registrieren, 
 * oder anmelden m�chte.
 * 
 * @version 1.0.
 * @author xxx
 * 
 * @see KaufenohneRegistrierungScreen
 * @see AnmeldeScreen
 * @see RegistrierungsScreen
 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
 * 
 * Es gibt keinen Rueckgabewert
 */
//ApplicationScreenCompany GUIStartCompany
public class ApplicationScreenCompany extends JFrame implements ActionListener {

	
	JPanel panel= new JPanel();
	JFrame frame = null;
	JLabel label;
	JButton an, re, ab;
	

	Color c2=new Color(20, 26, 50);
	Color cwhite= new Color(210, 210, 215);
	Color ctop=new Color(128, 156, 245);
	Color cyellow= new Color(207, 180, 94);
	Color cblue= new Color(62, 101, 251);
	  
	//Main f�r Tests
//	public static void main(String[] args){
//		Applicationscreen start = new Applicationscreen();
//		start.GUIStart();
//	}
	  
	
	public void GUIStartCompany() {
		
		frame = new JFrame ("Ultimate-events");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Gr��e
		frame.setSize(500,400);
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
		
/*
		buywr = new JButton("Kaufen ohne Registration");
		buywr.setBounds(45,80,400,60);
		buywr.addActionListener(this);
		buywr.setBackground(cblue);
		buywr.setForeground(Color.white);
*/		
		
		re = new JButton("Registrierung");
		re.setBounds(45,60,400,60);
		re.setBackground(cblue);
		re.setForeground(Color.WHITE);
		re.addActionListener(this);
		
		an = new JButton("Anmeldung");
		an.setBounds(45,140,400,60);
		an.setOpaque(true);
		an.addActionListener(this);
		an.setBackground(cblue);
		an.setForeground(Color.white);
		
		ab = new JButton("End program");
		ab.setBounds(45,220,400,60);
		ab.setBackground(cblue);
		ab.setForeground(Color.WHITE);
		ab.addActionListener(this);
		
		panel.add(label);
		panel.add(an);
		panel.add(re);
		//panel.add(buywr);
		panel.add(ab);
		    
		frame.setVisible(true);
	        
	}
	
  /* 
   * ActionListener Events
   * 
   * Hier wird, abhaegig vom Buttondruck auf der Startseite die jeweilige Funktion aufgerufen.
   * Entweder darf der User sich regestrieren oder anmelden.
   * Oder Kaufen ohne sich zu registrieren.
   */ 
	
	public void actionPerformed(ActionEvent e){
		/*
		if(e.getSource() == buywr) {
			KaufenOhneRegScreen kaufen = new KaufenOhneRegScreen();
			kaufen.GUIKaufenOhneRegScreen();
			frame.setVisible(false);
		}// end of if
		*/
		if (e.getSource() == an) {
			
			AnmeldeScreen anmeldung = new AnmeldeScreen();
			anmeldung.GUIAnmeldung();
			frame.setVisible(false);
			
		} // end of if
		if (e.getSource() == re) {
			
			//TopRegistrationScreen GUITopRegistrierung
			TopRegistrationScreen registrierung = new TopRegistrationScreen();
			registrierung.GUITopRegistrierung();
			frame.setVisible(false);     
		
		}// end of if
		if (e.getSource() == ab) {
			
			System.exit(0);
			
		}
	}     
}
