package TopPackage;

import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

/*
 * Die Klasse, welche den Bildschirm für die Nutzerregistrierung erstellt und die Daten aufnimmt.
 * Da sie mit GUIs aufgebaut wird, wird sie mit der vordefinierten Klasse JFrame erweitert und die vordefinierte Klasse. 
 * ActionListener wird implementiert.
 * 
 * @version 1.0.
 * @author xxx
 */
//RegistrationScreenEmployee GUIEmployeeReg
public class RegistrationScreenEmployee extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = null;
	JPanel panel = new JPanel();
	JLabel label, ldom, lscode, lcstatus;
	JTextField dom, tfscode;
	JButton re, ba, ab, check;
	
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
	Color c1 = new Color(55, 63, 93);
	
	LineBorder line = new LineBorder(c2, 1, true);
	
	static String domain, statusCode, statusString;
	
	private static HashMap<String, String> statusCodeMap;
	
	
	
    /*
     * 
     */
    public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	/*
            	GUImitarbeiterAdminScreen mAScreen = new GUImitarbeiterAdminScreen();
        		mAScreen.GUImitarbeiterAdminScreen();
        		*/
            	startRegistrationScreenEmployee();
            	RegistrationScreenEmployee regemp = new RegistrationScreenEmployee();
        		regemp.RegistrationScreenEmployee();
            }
        }); 
		
		/*
		GUImitarbeiterAdminScreen mAScreen = new GUImitarbeiterAdminScreen();
		mAScreen.GUImitarbeiterAdminScreen();
		*/
	}
    
    /*
	 * 
	 */
    public static void startRegistrationScreenEmployee() {
    	createHashMap();
    }
    
	/*
	 * Diese Funktion erstellt das Fenster in dem die Eingaben zur Nutzerregistrierung getätigt werden können.
	 * 
	 * es gibt keine Ein- & Ausgabeparameter.
	 */
	public void RegistrationScreenEmployee() {
		
		frame = new JFrame("Ultimate-events");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(590,400);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(c2);
		frame.setResizable(false);
    
		label = new JLabel("Employee Registration", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBounds(0,0,590,30);
		label.setBackground(ctop);
		label.setForeground(c2);
    
		ldom = new JLabel("Mail address domain");
		ldom.setOpaque(true);
		ldom.setBounds(55,110,160,30);
		ldom.setBackground(ctop);
		ldom.setForeground(c2);
    
		dom = new JTextField();
		dom.setBounds(225, 110, 200, 30);
		dom.setBackground(c1);
		dom.setBorder(line);
		dom.setForeground(Color.WHITE);
    
		lscode = new JLabel("Code for statis",0);
		lscode.setBounds(55, 150, 160, 30);
		lscode.setOpaque(true);
		lscode.setBackground(ctop);
		lscode.setForeground(c2);
		
		tfscode = new JTextField();
		tfscode.setBounds(225, 150, 200, 30);
		tfscode.setOpaque(true);
		tfscode.setBackground(c1);
		tfscode.setForeground(Color.WHITE);
		tfscode.setBorder(line);
		
		lcstatus = new JLabel("Waiting for result");
		lcstatus.setOpaque(true);
		lcstatus.setBackground(ctop);
		lcstatus.setForeground(c2);
		lcstatus.setBounds(435, 150, 100, 30);
		
		check = new JButton("Check Code");
		check.setBounds(55, 190, 370,30);
		check.setBackground(cblue);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
		
		re = new JButton("Continue registration");
		re.setBounds(55, 230, 370, 30);
		re.setBackground(cblue);
		re.setForeground(Color.WHITE);
		re.addActionListener(this);
		
		ba = new JButton("Back");
		ba.setBounds(55, 270, 370, 30);
		ba.setBackground(cblue);
		ba.setForeground(Color.WHITE);
		ba.addActionListener(this);
		
		ab = new JButton("Back to Main Menu");
		ab.setBounds(55, 310, 370, 30);
		ab.setBackground(cblue);
		ab.setForeground(Color.WHITE);
		ab.addActionListener(this);
		
		panel.add(label);
		panel.add(ldom);
		panel.add(dom);
		panel.add(lscode);
		panel.add(lcstatus);
		panel.add(tfscode);
		panel.add(check);
		panel.add(re);
		panel.add(ba);
		panel.add(ab);
		
		frame.setVisible(true);
		
	}
	
	/*
	 * um die Regestrierung fortzusezen, muss überprüft werden ob die Domain der E-Mailadresse gelistet ist und dafür wird dieser hier an VerifyDomain übergeben.
	 * 
	 * @see VerifyDomain
	 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
	 * 
	 * Es gibt keinen Rückgabewert
	 */
	private static void createHashMap() {
       
        statusCodeMap = new HashMap<>();
        statusCodeMap.put("1234", "CEO");
        statusCodeMap.put("5678", "VizeCEO");
        statusCodeMap.put("9101", "Admin");
        statusCodeMap.put("1121", "Angestellter");
        
    }
	
	/*
	 * 
	 */
	private String checkStatus(HashMap<String, String> statusCodeMap, String statusCode) {
		
		String resultCode;
        if (statusCodeMap.containsKey(statusCode)) {
        	
        	//JOptionPane.showMessageDialog(null, "Code is accepted");
            resultCode = statusCodeMap.get(statusCode);
          
        } else {
        	
            resultCode = "Wrong Status-Code";
           
        }
		return resultCode;
		
	}
	
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check) {
			
			statusCode = tfscode.getText();
			statusString = checkStatus(statusCodeMap, statusCode);
			lcstatus.setText(statusString);
			frame.revalidate();
			
		}
		if (e.getSource() == re) {
			
			//VerifyDomainEmployee verifyDomain ->domain; x->status
			domain = dom.getText();
			
			VerifyDomainEmployee dom = new VerifyDomainEmployee();
			dom.verifyDomain(domain);
			
			frame.setVisible(false);
		
		} // end of if
		if (e.getSource() == ba) {
		
			//TopRegistrationScreen GUITopRegistrierung
			TopRegistrationScreen registrierung = new TopRegistrationScreen();
			registrierung.GUITopRegistrierung();
			
			frame.setVisible(false);
			  
		}
		if (e.getSource() == ab) {
			
			//ApplicationScreenCompany GUIStartCompany
			ApplicationScreenCompany go = new ApplicationScreenCompany();
			go.GUIStartCompany();
			
			frame.setVisible(false);
			
		}
		
    }
	
}
