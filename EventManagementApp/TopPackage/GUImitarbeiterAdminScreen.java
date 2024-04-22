package TopPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GUImitarbeiterAdminScreen extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GUImitarbeiterAdminScreen mAScreen;
	
	// *** FRAME COMPONENTEN *** //
	static JFrame mainframe;
	JPanel mainpanel = new JPanel();
	JPanel panelVeranstaltungen = new JPanel();
	JButton abmeldeButton, platzhalter;
	JLabel label, labelGelb, labelRot;
	
//	JPanel panelMenu = new JPanel();
//	JPanel panelWork = new JPanel();
//	JSplitPane splitpaneVeranstaltungen = new JSplitPane();
//	JTabbedPane tabbedPane = new JTabbedPane();
//	JButton createButton, editButton, deleteButton;
	
	// *** TEMP STRING LOGIN DATA +++ FOR TEST PURPOSE *** //
	static String username = "leader@testCompany14";
	static String name = "Herr Wurst";
	static String path = "\\Server\\testCompany14\\Leader\\leader@testCompany14";
	static String tempStat = "CEO";
	
	// *** COLOR VARIABLES *** //
	Color c1 = new Color(55, 63, 93);
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
	
	// *** MAIN FOR TEST PURPOSE *** //
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	/*
            	GUImitarbeiterAdminScreen mAScreen = new GUImitarbeiterAdminScreen();
        		mAScreen.GUImitarbeiterAdminScreen();
        		*/
            	GUImitarbeiterAdminScreen mAScreen = new GUImitarbeiterAdminScreen();
        		mAScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat);
        		
            }
        }); 
		
		/*
		GUImitarbeiterAdminScreen mAScreen = new GUImitarbeiterAdminScreen();
		mAScreen.GUImitarbeiterAdminScreen();
		*/
	}
	// *** END OF TEST PURPOSE MAIN *** //
	
	/*
	 * 
	 */
	public void GUImitarbeiterAdminScreen(String username, String nameString, String path, String tempStat) {
		mAScreen = this;
		
		// *** WINDOW SETTINGS *** //
		mainframe = new JFrame ("Edit mode: " + tempStat);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setSize(1000,750);					
		mainframe.setLocationRelativeTo(null);
		
		// *** MAINPANEL SETTINGS *** //
		mainpanel.setBackground(c2);
		mainpanel.setLayout(null);
		
		// *************** //
		// *** TOP BAR *** //
		// *************** //
		
		// *** LOGOUT LABEL *** //
		abmeldeButton = new JButton("Logout");
		abmeldeButton.setOpaque(true);
		abmeldeButton.setBounds(30, 0, 150,30);
		abmeldeButton.addActionListener(this);
	    abmeldeButton.setVisible(true);
	    
	    // *** TOP LABEL *** //
		label = new JLabel("Good day: [" + nameString + "]", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBounds(180,0,620,30);
		label.setBackground(ctop);
		label.setForeground(c2);
		
		// *** PLACEHOLDER *** //
		platzhalter = new JButton("");
	    platzhalter.setOpaque(true);
	    platzhalter.setBounds(800, 0, 150,30);
	    platzhalter.addActionListener(this);
	    platzhalter.setVisible(true);
	    // ******************* //
	    // *** END TOP BAR *** //
	    // ******************* //
		
	    // *** PLACEHOLDER PANELS +++ NOC NECESSARY LATER *** //
	    JPanel panelBlue = new JPanel();
	    JPanel panelGreen = new JPanel();
	    JPanel panelYellow = new JPanel();
	    JPanel panelPink = new JPanel();
	    JPanel panelBlack = new JPanel();
	    JPanel panelWhite = new JPanel();
	    
        // *** SET BACKGROUNDCOLOR FOR PANELS *** //
	    panelBlue.setBackground(c2);
        panelGreen.setBackground(c2);
        panelYellow.setBackground(c2);
        panelPink.setBackground(c2);
        panelBlack.setBackground(c2);
        panelWhite.setBackground(c2);

        /*
        JLabel labelRot = new JLabel("Ich bin auf der roten Seite");
        labelRot.setOpaque(true);
        labelRot.setBounds(0,0,200,30);
        labelRot.setBackground(ctop);
        labelRot.setForeground(c2);
       	JLabel labelGelb = new JLabel("Ich bin auf der gelben Seite");
        labelGelb.setSize(200,60);
        
        //Buttons des PanelMenu
       	JButton createButton = new JButton("Erstellen v. Ver.");
        createButton.setOpaque(true);
        createButton.setBounds(10,65,150,30);
        createButton.addActionListener(this);
        createButton.setVisible(true);
	     
        JButton editButton = new JButton("Bearbeiten d. Ver.");
        editButton.setBounds(10,100,150,30);
        editButton.addActionListener(this);
        editButton.setVisible(true);
  
        JButton deleteButton = new JButton("L�schen d. Ver.");
        deleteButton.setBounds(10,135,150,30);
        deleteButton.addActionListener(this);
        deleteButton.setVisible(true);
       
        //PanelMenu vom SplitPane(Left)
        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(true);
        panelMenu.setBackground(c2);
        panelMenu.setBounds(10,10,350,350);
        panelMenu.add(labelRot);
        panelMenu.add(createButton);
        panelMenu.add(editButton);
        panelMenu.add(deleteButton);
        panelMenu.setLayout(null);
        
        //PanelWork vom SplitPane(Right)
        JPanel panelWork = new JPanel();
        panelWork.add(labelGelb);
        panelWork.setBackground(c2);
        panelWork.setBounds(400,10,350,350);
        panelWork.setLayout(null);
        
        // Erzeugung eines JSplitPane-Objektes mit horizontaler Trennung
        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitpane.setBounds(10,10,930,535);
        // Hier setzen wir links unser rotes JPanel und rechts das gelbe
        splitpane.setLeftComponent(panelMenu);
        splitpane.setRightComponent(panelWork);
        Dimension minimumSize = new Dimension(170, 50);
        panelMenu.setMinimumSize(minimumSize);
        panelWork.setMinimumSize(minimumSize);
        //splitpane.setLayout(null);
         */
        
        // ********************** //
        // *** MAIN WORK AREA *** //
        // ********************** //
        
        // *** DEPARTMENT PANELS *** //
        // JPanel panelVeranstaltungen = new JPanel();
  		AdmWorkEventPanel admWorkEveScreen = new AdmWorkEventPanel(mAScreen, tempStat);
  		admWorkEveScreen.setBackground(c2);
  		admWorkEveScreen.setVisible(true);
  		admWorkEveScreen.setBounds(0,0,955,800);
  		admWorkEveScreen.setLayout(null);
  		
  		// JPanel panelKunden = new JPanel();
  		AdmWorkCustPanel admWorkCustScreen = new AdmWorkCustPanel();
  		admWorkCustScreen.setBackground(c2);
  		admWorkCustScreen.setVisible(true);
  		admWorkCustScreen.setBounds(0,0,955,800);
  		admWorkCustScreen.setLayout(null);
  		
  		// JPanel panelMitarbeiter = new JPanel();
  		AdmWorkEmpPanel admWorkEmpScreen = new AdmWorkEmpPanel(tempStat);
  		admWorkEmpScreen.setBackground(c2);
  		admWorkEmpScreen.setVisible(true);
  		admWorkEmpScreen.setBounds(0,0,955,800);
  		admWorkEmpScreen.setLayout(null);
  		
//  	panelVeranstaltungen.setBackground(c2);
//	    panelVeranstaltungen.setBounds(10,10,955,560);
//	    panelVeranstaltungen.setBorder(BorderFactory.createLineBorder(Color.red));
//	    panelVeranstaltungen.setLayout(null);
//		panelVeranstaltungen.add(admWorkVerScreen, BorderLayout.CENTER);
//		panelVeranstaltungen.add(splitpane);
	    
        // *** TOP BAR2 - TABPANE FOR DEPARTMENT PANELS *** //
        JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
        tabpane.setBounds(10,35,960,665);
        // Add all Panels to JTabbedPane //
        tabpane.addTab("\\Server\\Veranstaltungen", admWorkEveScreen);
        tabpane.addTab("\\Server\\Kunden", admWorkCustScreen);
        tabpane.addTab("\\Server\\Mitarbeiter", admWorkEmpScreen);
        tabpane.addTab("\\E-Mail\\Registrierung", panelYellow);
        tabpane.addTab("\\E-Mail\\Passwort vergessen", panelPink);
        tabpane.addTab("\\E-Mail\\Tickets", panelBlack);
        tabpane.addTab("\\Post\\Tickets", panelWhite);
        tabpane.setVisible(true);
        // ****************************** //
        // *** END OF MAIN WORK PANEL *** //
        // ****************************** //
        
        // *** ASSEMBLING ALL COMPONENTS TO FRAME *** //
        mainpanel.add(tabpane);
        mainpanel.add(abmeldeButton);
        mainpanel.add(platzhalter);
        mainframe.add(label);
        mainframe.add(mainpanel);
        
        // *** CREATE VISIBILITES *** //
        mainpanel.setVisible(true);
        mainframe.setVisible(true);
        
        // *** SET WINDOW Z-AXIS *** //
        mainframe.toFront();
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == abmeldeButton) {
			AnmeldeScreen restart = new AnmeldeScreen();
			restart.GUIAnmeldung();
			mainframe.setVisible(false);
		}
//		if(e.getSource() == createButton) {
//			
//		}
//		if(e.getSource() == editButton) {
//			
//		}
//		if(e.getSource() == deleteButton) {
//			
//		}
		
	}

}
