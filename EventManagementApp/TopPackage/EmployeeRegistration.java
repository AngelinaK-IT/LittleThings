package TopPackage;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.border.LineBorder;  

/*
 * Die Klasse, welche den Bildschirm f�r die Nutzerregistrierung eines Mitarbeiters einer vorhanden Firma erstellt und die Daten aufnimmt.
 * Da sie mit GUIs aufgebaut wird, wird sie mit der vordefinierten Klasse JFrame erweitert und die vordefinierte Klasse. 
 * ActionListener wird implementiert.
 * 
 * @version 1.0.
 * @author xxx
 */
//EmployeeRegistration GUINuReg
public class EmployeeRegistration extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = null;
	JPanel panel = new JPanel();
	
	JLabel label, pwlabel, abtlabel, vnlabel, nnlabel, emaillabel, comBoxlabel;
	JTextField email, vn, nn, pw, littleHelper;
	JButton re;
	String mail, vorname, nachname, passwort, abt, domain, status;
	JComboBox<String> comBox;
	
	Color c2 = new Color(20, 26, 50);
	Color cwhite= new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
	Color c1 = new Color(55, 63, 93);
	LineBorder line = new LineBorder(c1, 1, true);
	
	public static Scanner x;
	
	/*
	 * Diese Funktion erstellt das Fenster in dem die Eingaben zur Nutzerregistrierung eines Mitarbeiters get�tigt werden k�nnen.
	 * 
	 * @param firma ist die Firma des Nutzers, welche mit der Domain bestimmt wird.
	 */
	public void GUINuReg(String firma) {
		
		frame = new JFrame("Ultimate-events");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,330);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setBackground(c2);
		panel.setLayout(null);
		frame.setResizable(false);
    
		label = new JLabel("User registration", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBounds(0,0,500,30);
		label.setBackground(ctop);
		label.setForeground(c2);
    
		littleHelper = new JTextField(firma);
    
		emaillabel= new JLabel("Email address",0);
		emaillabel.setOpaque(true);
		emaillabel.setBackground(ctop);
		emaillabel.setForeground(c2);
		emaillabel.setBounds(40, 50, 140, 30);
		
		email = new JTextField();
		email.setOpaque(true);
		email.setBackground(c1);
		email.setForeground(Color.WHITE);
		email.setBorder(line);
		email.setBounds(190, 50, 260, 30);
    
		vnlabel= new JLabel("First name",0);  
		vnlabel.setOpaque(true);
		vnlabel.setBackground(ctop);
		vnlabel.setForeground(c2);
		vnlabel.setBounds(40, 90, 140, 30);
		
		vn = new JTextField();
		vn.setBounds(190, 90, 260, 30);
		vn.setOpaque(true);
		vn.setBackground(c1);
		vn.setForeground(Color.white);
		vn.setBorder(line);
    
		nnlabel= new JLabel("Last name",0);
		nnlabel.setOpaque(true);
		nnlabel.setBackground(ctop);
		nnlabel.setForeground(c2);
		nnlabel.setBounds(40, 130, 140, 30);
		
		nn = new JTextField();
		nn.setBounds(190, 130, 260, 30);
		nn.setOpaque(true);
		nn.setBackground(c1);
		nn.setForeground(Color.white);
		nn.setBorder(line);
    
		pwlabel = new JLabel("Enter password",0);
		pwlabel.setOpaque(true);
		pwlabel.setBackground(ctop);
		pwlabel.setForeground(c2);
		pwlabel.setBounds(40, 210, 140, 30);
    
		pw = new JTextField("");
		pw.setBounds(190, 210, 260, 30);
		pw.setOpaque(true);
		pw.setBackground(c1);
		pw.setForeground(Color.white);
		pw.setBorder(line);    
    
		String[] abteil = getAbteilungen(firma);                                   
		comBoxlabel = new JLabel("Department",0);
		comBoxlabel.setOpaque(true);
		comBoxlabel.setBackground(ctop);
		comBoxlabel.setForeground(c2);
		comBoxlabel.setBounds(40, 170, 140, 30);
		
		comBox = new JComboBox<>(abteil);                                          
		comBox.setBackground(ctop);
		comBox.setForeground(c2);
		comBox.setBounds(190, 170, 260, 30); 
        
		re = new JButton("Finalize registration");
		re.setBounds(40, 250, 410, 30);
		re.setBackground(cblue);
    	re.setForeground(Color.WHITE);
    	re.addActionListener(this);
      
    	panel.add(label);
    	panel.add(email);
    	panel.add(vn);
    	panel.add(nn);
    	panel.add(comBox);
    	panel.add(pwlabel);
    	panel.add(pw);
    	panel.add(re);
    	panel.add(emaillabel);
    	panel.add(vnlabel);
    	panel.add(nnlabel);
    	panel.add(comBoxlabel);
    
    	frame.setVisible(true);
    	
    }
	
	/*
	 * Diese Methode �bernimmt alle Eingaben welche in das Fenster eingetragen wurden und ruft damit  UserRegister auf.
	 * 
	 * @see UserRegister
	 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
	 * 
	 * Es gibt keinen R�ckgabewert
	 */
	public void actionPerformed(ActionEvent e){

		domain = littleHelper.getText();
		mail = email.getText();
		vorname = vn.getText();
		nachname = nn.getText();
		passwort = pw.getText();
		status = RegistrationScreenEmployee.statusString;
		abt = comBox.getSelectedItem().toString();               
		
		//FuncEmployeeRegister UserRegister
		FuncEmployeeRegister ure = new FuncEmployeeRegister();
		ure.UserRegister(nachname, vorname, passwort, mail, abt, domain, status);
		
		frame.setVisible(false);    

	}
	
	/*
	 * Hiermit werden alle vorhanden Abteilungen zur�ckgegeben, damit sie vom User ausgew�hlt werden k�nnen.
	 * 
	 * @param firma anhand der Firma wird �berpr�ft, welche Abteilungen diese Firma hat.
	 * 
	 * @return r�ckgabe sind die Abteilungen der Firma.
	 */
	public static String[] getAbteilungen(String firma){                             

		boolean found = false;
		String tempFirm = "";
		String tempA = "";
		String tempAb = "";
		String tempAbt = "";
		String[] rueckgabe = {" ", " "," "};
		try {
			x = new Scanner(new File("FirmData.txt"));
			x.useDelimiter("[,\n]");
			while (x.hasNext() && !found) { 
				tempFirm = x.next();
				tempA = x.next();
				tempAb = x.next();
				tempAbt = x.next();
				if (tempFirm.trim().equals(firma.trim())) {
					found = true;
				} // end of if
			} // end of while                                                        
			rueckgabe[0] = tempA;
			rueckgabe[1] = tempAb;
			rueckgabe[2] = tempAbt;                         
             
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rueckgabe;
    }  
	
}
