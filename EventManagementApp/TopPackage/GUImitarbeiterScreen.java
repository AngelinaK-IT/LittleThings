package TopPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class GUImitarbeiterScreen extends JFrame implements ActionListener {
	//Einzelne Elemente
	JFrame frame = null;
	JLabel label, labelGelb, labelRot;
	JPanel mainpanel = new JPanel();
	JPanel panelVeranstaltungen = new JPanel();
//	JPanel panelMenu = new JPanel();
//	JPanel panelWork = new JPanel();
//	JSplitPane splitpaneVeranstaltungen = new JSplitPane();
//	JTabbedPane tabbedPane = new JTabbedPane();
//	
//	JButton createButton, editButton, deleteButton;
	
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop  =new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
		
	String mitStatus = "Angestellter";
	static String mitStatus2 = "Admin";
	String mitnameString = "Frau Kuschmierz";
	
	public static void main(String[] args) {
		
		GUImitarbeiterScreen mAScreen = new GUImitarbeiterScreen();
		mAScreen.GUImitarbeiterScreen();

	}

	public void GUImitarbeiterScreen(){
		
		frame = new JFrame ("Beabeitungs Modus: " + mitStatus);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);					
		frame.setLocationRelativeTo(null);
		frame.add(mainpanel);
		
		mainpanel.setBackground(c2);
		mainpanel.setLayout(null);
		
		label = new JLabel("Guten Tag: " + mitnameString, SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBounds(0,0,1000,30);
		label.setBackground(ctop);
		label.setForeground(c2);
		
	    JPanel panelBlue = new JPanel();
	    JPanel panelGreen = new JPanel();
	    JPanel panelYellow = new JPanel();
	    JPanel panelPink = new JPanel();
	    JPanel panelBlack = new JPanel();
	    JPanel panelWhite = new JPanel();
	    
        // Hier setzen wir die Hintergrundfarben f�r die JPanels
	    panelBlue.setBackground(c2);
        panelGreen.setBackground(c2);
        panelYellow.setBackground(c2);
        panelPink.setBackground(c2);
        panelBlack.setBackground(c2);
        panelWhite.setBackground(c2);

//        JLabel labelRot = new JLabel("Ich bin auf der roten Seite");
//        labelRot.setOpaque(true);
//        labelRot.setBounds(0,0,200,30);
//        labelRot.setBackground(ctop);
//        labelRot.setForeground(c2);
//        JLabel labelGelb = new JLabel("Ich bin auf der gelben Seite");
//        labelGelb.setSize(200,60);
//        
//        //Buttons des PanelMenu
//        JButton createButton = new JButton("Erstellen v. Ver.");
//        createButton.setOpaque(true);
//        createButton.setBounds(10,65,150,30);
//        createButton.addActionListener(this);
//        createButton.setVisible(true);
//	     
//        JButton editButton = new JButton("Bearbeiten d. Ver.");
//        editButton.setBounds(10,100,150,30);
//        editButton.addActionListener(this);
//        editButton.setVisible(true);
//  
//        JButton deleteButton = new JButton("L�schen d. Ver.");
//        deleteButton.setBounds(10,135,150,30);
//        deleteButton.addActionListener(this);
//        deleteButton.setVisible(true);
//       
//        //PanelMenu vom SplitPane(Left)
//        JPanel panelMenu = new JPanel();
//        panelMenu.setOpaque(true);
//        panelMenu.setBackground(c2);
//        panelMenu.setBounds(10,10,350,350);
//        panelMenu.add(labelRot);
//        panelMenu.add(createButton);
//        panelMenu.add(editButton);
//        panelMenu.add(deleteButton);
//        panelMenu.setLayout(null);
//        
//        //PanelWork vom SplitPane(Right)
//        JPanel panelWork = new JPanel();
//        panelWork.add(labelGelb);
//        panelWork.setBackground(c2);
//        panelWork.setBounds(400,10,350,350);
//        panelWork.setLayout(null);
//        
//
//        // Erzeugung eines JSplitPane-Objektes mit horizontaler Trennung
//        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//        splitpane.setBounds(10,10,930,535);
//        // Hier setzen wir links unser rotes JPanel und rechts das gelbe
//        splitpane.setLeftComponent(panelMenu);
//        splitpane.setRightComponent(panelWork);
//        Dimension minimumSize = new Dimension(170, 50);
//        panelMenu.setMinimumSize(minimumSize);
//        panelWork.setMinimumSize(minimumSize);
//        //splitpane.setLayout(null);
        
       
        // Hier erzeugen wir unsere JPanels
//  		JPanel panelVeranstaltungen = new JPanel();
  		AdmWorkEventPanel admWorkVerScreen = new AdmWorkEventPanel(null, mitStatus);
  		admWorkVerScreen.setBackground(c2);
  		admWorkVerScreen.setVisible(true);
  		admWorkVerScreen.setBounds(0,0,955,560);
  		admWorkVerScreen.setLayout(null);
  		
//  		panelVeranstaltungen.setBackground(c2);
//	    panelVeranstaltungen.setBounds(10,10,955,560);
//	    panelVeranstaltungen.setBorder(BorderFactory.createLineBorder(Color.red));
//	    panelVeranstaltungen.setLayout(null);
	    //panelVeranstaltungen.add(admWorkVerScreen, BorderLayout.CENTER);
	    //panelVeranstaltungen.add(splitpane);
	    
	    
	    
        // Erzeugung eines JTabbedPane-Objektes
        JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
        tabpane.setBounds(10,35,960,575);
        // Hier werden die JPanels als Registerkarten hinzugef�gt
        tabpane.addTab("\\Server\\Veranstaltungen", admWorkVerScreen);
        tabpane.addTab("\\Server\\Kunden", panelBlue);
        //tabpane.addTab("\\Server\\Mitarbeiter", panelGreen);
        //tabpane.addTab("\\E-Mail\\Registrierung", panelYellow);
        tabpane.addTab("\\E-Mail\\Passwort vergessen", panelPink);
        tabpane.addTab("\\E-Mail\\Tickets", panelBlack);
        tabpane.addTab("\\Post\\Tickets", panelWhite);
        admWorkVerScreen.setVisible(true);
        tabpane.setVisible(true);
        mainpanel.add(tabpane);
        
        frame.add(label);
        frame.add(mainpanel);
        
        mainpanel.setVisible(true);
        frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
