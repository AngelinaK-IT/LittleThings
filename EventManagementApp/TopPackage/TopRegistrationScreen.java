package TopPackage;

/*
 * @see Startscreen
 * Diese Klasse wird geöffnet wenn von dem Startscreen der Button Registrierung gewählt wird.
 * Da sie mit GUIs aufgebaut wird, wird sie mit der vordefinierten Klasse JFrame erweitert und die vordefinierte Klasse. 
 * ActionListener wird implementiert.
 * 
 * @version 1.0.
 * @author xxx
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Diese Funktion erstellt das Fenster in dem der User auswählen kann, ob er eine Firma oder sich bzw. einen anderen User erstellen möchte.
 * 
 * es gibt keine Ein- & Ausgabeparameter.
 */
//TopRegistrationScreen GUITopRegistrierung
public class TopRegistrationScreen extends JFrame implements ActionListener{
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame frame = null;
	JPanel panel = new JPanel();
	JLabel label;
	JLabel label2;
	JButton be, fi, ba;
	
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);

	public void GUITopRegistrierung() {
		
		frame = new JFrame ("Ultimate-events ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setBackground(c2);
		panel.setLayout(null);
		//frame.setLayout(new GridLayout(4, 1, 10, 10));
		frame.setResizable(false);
		label2= new JLabel("Registration",0);
		label2.setOpaque(true);
		label2.setBounds(0,0,500,30);
		label2.setBackground(ctop);
		label2.setForeground(c2);
    
		be = new JButton("User registration");
		be.setBounds(45,80,400,60);
		be.setOpaque(true);
		be.addActionListener(this);
		be.setBackground(cblue);
		be.setForeground(Color.white);
    
		fi = new JButton("Company registration");
		fi.setBounds(45,160,400,60);
		fi.setBackground(cblue);
		fi.setForeground(Color.WHITE);
		fi.addActionListener(this);
		
		ba = new JButton("Back");
		ba.setBounds(45, 240, 400, 60);
		ba.setBackground(cblue);
		ba.setForeground(Color.WHITE);
		ba.addActionListener(this);
			
		panel.add(label2);
		panel.add(be);
		panel.add(fi);
		panel.add(ba);
	
		frame.setVisible(true);
		
	} 
	
	/*
	 * Diese Methode übernimmt die Buttonauswahl und öffnet den entsprechenden Registrierungsscreen.
	 * 
	 * @see Nutzerregistrierung
	 * @see Firmenregistrierung
	 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
	 * 
	 * Es gibt keinen Rückgabewert
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == be) {

			//RegistrationScreenEmployee GUIEmployeeReg
			RegistrationScreenEmployee nure = new RegistrationScreenEmployee();
			nure.RegistrationScreenEmployee();
			
			frame.setVisible(false);
			
		} // end of if
		if (e.getSource() == fi) {
			
			//RegistrationScreenCompany GUICompanyReg
			RegistrationScreenCompany fire = new RegistrationScreenCompany();
			fire.GUICompanyReg();
			
			frame.setVisible(false);
			
		} // end of if
		if (e.getSource() == ba) {
			
			//ApplicationScreenCompany GUIStartCompany
			ApplicationScreenCompany go = new ApplicationScreenCompany();
			go.GUIStartCompany();
			
			frame.setVisible(false);
			
		}
		
	}
	
}
