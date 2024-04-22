package TopPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import Language.LanguageModul_English;
import Language.LanguageModul_France;
import Language.LanguageModul_German;
import Language.LanguageSettings;

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
public class ApplicationScreenCustomer extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 
	 */
	// *** FRAME COMPONENTEN *** //
	static JFrame frame = null;
	JPanel panel= new JPanel();
	JLabel label;
	JButton an, re, buywr; 
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem engItem, gerItem, frenItem;
	
	// *** COLOR VARIABLES *** //
	Color c2=new Color(20, 26, 50);
	Color cwhite= new Color(210, 210, 215);
	Color ctop=new Color(128, 156, 245);
	Color cyellow= new Color(207, 180, 94);
	Color cblue= new Color(62, 101, 251);
	 
	public static ArrayList<String> tempAppStartArrayList = LanguageModul_English.getAppStartLanguage();
	public static ArrayList<String> tempRegList = LanguageModul_English.getRegLanguage();
	// *** FOR TEST PURPOSE *** //
	/*
	public static void main(String[] args) {
		ApplicationScreenCustomer start = new ApplicationScreenCustomer();
		start.GUIStartCustomer();
	}
	*/
	// *** END OF MAIN *** //
	  
	/***********
	 *** GUI ***
	 ***********/
	void GUIStartCustomer(ArrayList<String> tempAppStart, ArrayList<String> regList) {
		
		// *** WINDOW SETTINGS *** //
		frame = new JFrame ("Ultimate-events");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(500,400);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setBackground(c2);
		panel.setLayout(null);
		frame.setResizable(false);
		
		// tempAppStart->(languageString, englishMain, germanMain, franceMain, 
		// 				  welcomeString, buyWithoutReg, registration, login);
		label = new JLabel(tempAppStart.get(4), SwingConstants.CENTER);
		label.setBounds(0,0,500,30);
		label.setOpaque(true);
		label.setBackground(ctop);
		label.setForeground(c2);
		
		/***************
		 *** MENUBAR ***
		 ***************/
		menuBar = new JMenuBar();
		fileMenu = new JMenu(tempAppStart.get(0));
		engItem = new JMenuItem(tempAppStart.get(1));
		gerItem = new JMenuItem(tempAppStart.get(2));
		frenItem = new JMenuItem(tempAppStart.get(3));
        
		// *** MENUITEMS ACTIONLISTENER *** //
        engItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String selectedLanguage = "English";
            	LanguageSettings.setSelectedLanguage(selectedLanguage);
                
    			JFrame tempMainFrame = ApplicationScreenCustomer.frame;
    	        tempMainFrame.dispose();
    	        
    	        ArrayList<String> appStart = LanguageModul_English.getAppStartLanguage();
    	        ArrayList<String> regList = LanguageModul_English.getRegLanguage();
    	        System.out.println(appStart);
    	        System.out.println(regList);
    	        
    			ApplicationScreenCustomer restart = new ApplicationScreenCustomer();
    			restart.GUIStartCustomer(appStart, regList);
    			
            }
        });

        gerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String selectedLanguage = "Deutsch";
            	LanguageSettings.setSelectedLanguage(selectedLanguage);
               
    			JFrame tempMainFrame = ApplicationScreenCustomer.frame;
    	        tempMainFrame.dispose();
    	        
    	        ArrayList<String> appStart = LanguageModul_German.getAppStartLanguage();
    	        ArrayList<String> regList = LanguageModul_German.getRegLanguage();
    	        
    			ApplicationScreenCustomer restart = new ApplicationScreenCustomer();
    			restart.GUIStartCustomer(appStart, regList);
    		
            }
        });

        frenItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String selectedLanguage = "Français";
            	LanguageSettings.setSelectedLanguage(selectedLanguage);
               
    			JFrame tempMainFrame = ApplicationScreenCustomer.frame;
    	        tempMainFrame.dispose();
    	        
    	        ArrayList<String> appStart = LanguageModul_France.getAppStartLanguage();
    	        ArrayList<String> regList = LanguageModul_France.getRegLanguage();
    	        
    			ApplicationScreenCustomer restart = new ApplicationScreenCustomer();
    			restart.GUIStartCustomer(appStart, regList);
    		
            }
        });
		
		fileMenu.add(engItem);
		fileMenu.add(gerItem);
		fileMenu.add(frenItem);
		menuBar.add(fileMenu);
		
		buywr = new JButton(tempAppStart.get(5));
		buywr.setBounds(45,80,400,60);
		buywr.setOpaque(true);
		buywr.setBackground(cblue);
		buywr.setForeground(Color.white);
		buywr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyWithoutRegistration kaufen = new BuyWithoutRegistration();
				kaufen.GUIBuyWithoutRegistration(tempAppStart, tempRegList);
				frame.setVisible(false);
			}
		});
		
		re = new JButton(tempAppStart.get(6));
		re.setBounds(45,160,400,60);
		re.setOpaque(true);
		re.setBackground(cblue);
		re.setForeground(Color.WHITE);
		re.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationScreenCustomer registrierung = new RegistrationScreenCustomer();
				registrierung.GUIRegistrationCustomer(tempAppStart, tempRegList);
				frame.setVisible(false);  
			}
		});
		
		an = new JButton(tempAppStart.get(7));
		an.setBounds(45,240,400,60);
		an.setOpaque(true);
		an.setBackground(cblue);
		an.setForeground(Color.white);
		an.addActionListener(this);
		
		panel.add(label);
		panel.add(an);
		panel.add(re);
		panel.add(buywr);
		frame.setJMenuBar(menuBar);
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
		
		if(e.getSource() == buywr) {
			/*
			BuyWithoutRegistration kaufen = new BuyWithoutRegistration();
			kaufen.GUIBuyWithoutRegistration();
			frame.setVisible(false);
			*/
		}// end of if
		if (e.getSource() == an) {
			AnmeldeScreen anmeldung = new AnmeldeScreen();
			anmeldung.GUIAnmeldung();
			frame.setVisible(false);
		} // end of if
		if (e.getSource() == re) {
			
			RegistrationScreenCustomer registrierung = new RegistrationScreenCustomer();
			registrierung.GUIRegistrationCustomer(null, null);
			frame.setVisible(false);  
			    
		}// end of if
	}     
}
