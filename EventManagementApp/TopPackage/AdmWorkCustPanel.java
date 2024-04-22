package TopPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Reste.EventPreviewFrame11;

// *** NOT YET READY IMPLEMENTED *** //
public class AdmWorkCustPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel labelright, labelleft;
	static JPanel panelMenu = new JPanel();
	static JPanel panelWork = new JPanel();
	static JSplitPane splitpane = new JSplitPane();
	static JButton createButton, editButton, deleteButton;
	
	// *** COLOR VARIABLES *** //
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);

	static String mitStatus2 = "Admin";
	
	// *** MAIN FOR TEST PURPOSE *** //
	/*
	public static void main(String[] args) {
	
		AdmWorkVerPanel admworkverpanel = new AdmWorkVerPanel();
		admworkverpanel.AdmWorkVerPanel();
		
	}
	*/
	
	public AdmWorkCustPanel() {
		// *** Label ***
		JLabel labelleft = new JLabel("Menu");
        labelleft.setOpaque(true);
        labelleft.setBounds(0,0,200,30);
        labelleft.setBackground(ctop);
        labelleft.setForeground(c2);
        labelleft.setVisible(true);
      
        JLabel labelright = new JLabel("Sie befinden sich als \"" + mitStatus2 + "\" im Kunden Panel");
        labelright.setOpaque(true);
        labelright.setBounds(0,0,400,30);
        labelright.setBackground(ctop);
        labelright.setForeground(c2);
        labelright.setVisible(true);
        
        //Buttons des PanelMenu
        // *** Button ***
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
        // *** JPanel ***
        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(true);
        panelMenu.setBackground(c2);
        panelMenu.setBounds(10,10,350,700);
        panelMenu.add(labelleft);
        panelMenu.add(createButton);
        panelMenu.add(editButton);
        panelMenu.add(deleteButton);
        panelMenu.setLayout(null);
        
        //PanelWork vom SplitPane(Right)
        JPanel panelWork = new JPanel();
        panelWork.add(labelright);
        panelWork.setBackground(c2);
        panelWork.setBounds(400,10,350,700);
        panelWork.setLayout(null);
        
        // Erzeugung eines JSplitPane-Objektes mit horizontaler Trennung
        // *** JSplitPane ***
        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitpane.setBounds(10,10,930,620);
        // Hier setzen wir links unser rotes JPanel und rechts das gelbe
        splitpane.setLeftComponent(panelMenu);
        splitpane.setRightComponent(panelWork);
        Dimension minimumSize = new Dimension(170, 50);
        panelMenu.setMinimumSize(minimumSize);
        panelWork.setMinimumSize(minimumSize);
        //splitpane.setLayout(null);
        createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					createPanel2 createPanel2 = new createPanel2();
					splitpane.setRightComponent(createPanel2);
			}
			
		});
        editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					editPanel2 editPanel2 = new editPanel2();
					splitpane.setRightComponent(editPanel2);
			}
			
		});
        deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					deletePanel2 deletePanel2 = new deletePanel2();
					splitpane.setRightComponent(deletePanel2);
			}
			
		});
        
        
        panelMenu.setVisible(true);
        panelWork.setVisible(true);
  		
        add(splitpane);
        splitpane.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== createButton) {
			createPanel2 createPanel2 = new createPanel2();
			splitpane.setRightComponent(createPanel2);
		}
	}
}

// *** START CREATEPANEL2 *** //
class createPanel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton testButton;
	JLabel labelworkcreate, label3, label2, label1;
	
	static ArrayList<String> placeList = new ArrayList<>();
	static ArrayList<String> dateList = new ArrayList<>();
	static ArrayList<String> timeList = new ArrayList<>();
	
	// Lokaler Path
	static Path currentPathPath1 = PathHandler.complWorkServerCusPath;
	static String currentPathString1 = PathHandler.complWorkServerCusPath.toString();
	//String workPath = System.getProperty("user.dir");
	//String CurrentPath1 = workPath + kompString;
	
	static Color c1= new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	LineBorder line= new LineBorder(c2, 1, true);
	
	public createPanel2() {
		//Aussehen des createPanel
        setBackground(c2);
        setBounds(400,10,350,650);
        setLayout(null);
        System.out.println(currentPathString1);
        // *** LABEL ***
        // Top Label um anzuzeigen in welchem Fenster der User sich gerade befindet
        JLabel labelworkcreate = new JLabel("Working Panel");
        labelworkcreate.setBounds(5,5,100,30);
        labelworkcreate.setBackground(ctop);
        labelworkcreate.setForeground(cwhite);
        labelworkcreate.setLayout(null);
		
        JTextField textfield = new JTextField();
		textfield.setBounds(165,0,700,30);
		textfield.setEditable(false);
		textfield.setText(currentPathString1);
		
        // �bersicht aller Labels um eine Veranstaltung zu erstellen
        // Label-"Veranstaltungsnummer"
		JLabel label0 = new JLabel("Veranstaltungsnummer",SwingConstants.CENTER);
	    label0.setOpaque(true);
	    label0.setBounds(5,35,150,30);
	    label0.setBackground(ctop);
	    label0.setForeground(c2);
	    
	    // Label-"Kategorie"
		JLabel label1 = new JLabel("Kategorie", 0);
	    label1.setOpaque(true);
	    label1.setBounds(5,70,150,30);
	    label1.setBackground(ctop);
	    label1.setForeground(c2);
	    
	    // Label-"Veranstalter"
	    JLabel label2 = new JLabel("Veranstalter", 0);
	    label2.setOpaque(true);
	    label2.setBounds(5, 105, 150, 30);
	    label2.setBackground(ctop);
	    label2.setForeground(c2);
	        
	    // Label-"K�nstler"
	    JLabel label3 = new JLabel("K�nstler", 0);
	    label3.setOpaque(true);
	    label3.setBounds(5, 140, 150, 30);  
	    label3.setBackground(ctop);
	    label3.setForeground(c2);
	                      
	    // *** Button *** 
	    //JButton descrButton = new JButton("Beschreibung");
	    //descrButton.setBounds(5, 175, 150, 30);
	    
	    // ** Nach descrButton **
	    // Label-"Orte"
        JLabel label4 = new JLabel("Orte", 0);
	    label4.setOpaque(true);
	    label4.setBounds(5, 210, 150, 30);
	    label4.setBackground(ctop);
	    label4.setForeground(c2);
	    
        // Label-"Uhrzeiten"
        JLabel label5 = new JLabel("Termine", 0);
	    label5.setOpaque(true);
	    label5.setBounds(5, 245, 150, 30);
	    label5.setBackground(ctop);
	    label5.setForeground(c2);
	  
	    // Label-"Termine"
	    JLabel label6 = new JLabel("Uhrzeiten", 0);
	    label6.setOpaque(true);
	    label6.setBounds(5, 280, 150, 30); 
	    label6.setBackground(ctop);
	    label6.setForeground(c2);
	      
	    // Label-"Kategorisierung"
	    JLabel label7 = new JLabel("Kategorisierung d. Bereiche", 0);
	    label7.setOpaque(true);
	    label7.setBounds(5, 315, 200, 30);     
	    label7.setBackground(ctop);
	    label7.setForeground(c2);
	                   
	    JLabel label812 = new JLabel("Preis/Ticket im Bereich (in �)", 0);
	    label812.setOpaque(true);
	    label812.setBounds(275, 350, 200, 30);  
	    label812.setBackground(ctop);
	    label812.setForeground(c2);
	                      
	    JLabel label813 = new JLabel("Verf. Pl�tze im Bereich", 0);
	    label813.setOpaque(true);
	    label813.setBounds(485, 350, 200, 30);  
	    label813.setBackground(ctop);
	    label813.setForeground(c2);
	                      
	    JLabel label811 = new JLabel("Name 1", 0);
	    label811.setOpaque(true);
	    label811.setBounds(5, 395, 150, 30);   
	    label811.setBackground(ctop);
	    label811.setForeground(c2);
	    
	    JLabel label821 = new JLabel("Name 2", 0);
	    label821.setOpaque(true);
	    label821.setBounds(5, 430, 150, 30);  
	    label821.setBackground(ctop);
	    label821.setForeground(c2);
	                      
	    JLabel label831 = new JLabel("Name 3", 0);
	    label831.setOpaque(true);
	    label831.setBounds(5, 465, 150, 30);     
	    label831.setBackground(ctop);
	    label831.setForeground(c2);
	                   
	    // *** TEXTFELD ***
	    // Textfeld-"Veranstaltungsnummmer"
	    JTextField textField0 = new JTextField(30);
	    textField0.setBounds(165, 35, 200, 30);
	    textField0.setOpaque(true);
	    textField0.setBackground(c1);
	    textField0.setForeground(Color.white);
	    textField0.setBorder(line);
	    
	    // Textfeld-"Kategorie"  
	    JTextField textField1 = new JTextField(30);
	    textField1.setBounds(165, 70, 200, 30);
	    textField1.setOpaque(true);
	    textField1.setBackground(c1);
	    textField1.setForeground(Color.white);
	    textField1.setBorder(line);
	   
	    // Textfeld-"Veranstalter" 
	    JTextField textField2 = new JTextField(30);
	    textField2.setBounds(165, 105, 200, 30);
	    textField2.setOpaque(true);
	    textField2.setBackground(c1);
	    textField2.setForeground(Color.white);
	    textField2.setBorder(line);
	    
	    // Textfeld-"K�nstler" 
	    JTextField textField3 = new JTextField(30);
	    textField3.setBounds(165, 140, 200, 30);
	    textField3.setOpaque(true);
	    textField3.setBackground(c1);
	    textField3.setForeground(Color.white);
	    textField3.setBorder(line);
	    
	    // *** Button *** 
	    //JButton descrButton = new JButton("Beschreibung");
	    //descrButton.setBounds(5, 175, 150, 30);
	    
	    // Textfeld-"Orte"  
	    JTextField textField4 = new JTextField(30);
	    textField4.setBounds(165, 210, 200, 30);
	    textField4.setOpaque(true);
	    textField4.setBackground(c1);
	    textField4.setForeground(Color.white);
	    textField4.setBorder(line);
	    //String[] Orte = textField4.getText().split(" ");
	    
	    // Textfeld-"Termine" 
	    JTextField textField5 = new JTextField(30);
	    textField5.setBounds(165, 245, 200, 30);
	    textField5.setOpaque(true);
	    textField5.setBackground(c1);
	    textField5.setForeground(Color.white);
	    textField5.setBorder(line);
	    
	    // Textfeld-"Uhrzeiten" 
	    JTextField textField6 = new JTextField(30);
	    textField6.setBounds(165, 280, 200, 30);
	    textField6.setOpaque(true);
	    textField6.setBackground(c1);
	    textField6.setForeground(Color.white);
	    textField6.setBorder(line);
        
        // Textfeld-"Name1"  
	    JTextField textField811 = new JTextField(30);
	    textField811.setBounds(165, 395, 100, 30);
	    textField811.setOpaque(true);
	    textField811.setBackground(c1);
	    textField811.setForeground(Color.white);
	    textField811.setBorder(line);
	    
	    // Textfield-"Preis f�r Name1"
	    JTextField textField812 = new JTextField("0");
	    textField812.setBounds(275, 395, 200, 30);
	    textField812.setOpaque(true);
	    textField812.setBackground(c1);
	    textField812.setForeground(Color.white);
	    textField812.setBorder(line);
	 
	    // Textfield-"Pl�tze f�r Name1"
	    JTextField textField813 = new JTextField("0");
	    textField813.setBounds(485, 395, 200, 30);
	    textField813.setOpaque(true);
	    textField813.setBackground(c1);
	    textField813.setForeground(Color.white);
	    textField813.setBorder(line);
	   
	    // Textfeld-"Name2" 
	    JTextField textField821 = new JTextField(30);
	    textField821.setBounds(165, 430, 100, 30);
	    textField821.setOpaque(true);
	    textField821.setBackground(c1);
	    textField821.setForeground(Color.white);
	    textField821.setBorder(line);
	    
	    // Textfield-"Preis f�r Name2"
	    JTextField textField822 = new JTextField("0");
	    textField822.setBounds(275, 430, 200, 30);
	    textField822.setOpaque(true);
	    textField822.setBackground(c1);
	    textField822.setForeground(Color.white);
	    textField822.setBorder(line);
	    
	    // Textfield-"Pl�tze f�r Name2"
	    JTextField textField823 = new JTextField("0");
	    textField823.setBounds(485, 430, 200, 30);
	    textField823.setOpaque(true);
	    textField823.setBackground(c1);
	    textField823.setForeground(Color.white);
	    textField823.setBorder(line);
	    
	    // Textfeld-"Name3" 
	    JTextField textField831 = new JTextField(30);
	    textField831.setBounds(165, 465, 100, 30);
	    textField831.setOpaque(true);
	    textField831.setBackground(c1);
	    textField831.setForeground(Color.white);
	    textField831.setBorder(line);
	     
	    // Textfield-"Preis f�r Name3"
	    JTextField textField832 = new JTextField("0");
	    textField832.setBounds(275, 465, 200, 30);
	    textField832.setOpaque(true);
	    textField832.setBackground(c1);
	    textField832.setForeground(Color.white);
	    textField832.setBorder(line);
	    
	    // Textfield-"Pl�tze f�r Name3"
	    JTextField textField833 = new JTextField("0");
	    textField833.setBounds(485, 465, 200, 30);
	    textField833.setOpaque(true);
	    textField833.setBackground(c1);
	    textField833.setForeground(Color.white);
	    textField833.setBorder(line);
	   
	    //System.out.println(collectedArrayList);
	    
        // *** Button *** 
	    // Button um die Beschreibung der Veranstaltung zu erstellen
        JButton descrButton = new JButton("Beschreibung");
        descrButton.setBounds(5,175, 150, 30);
        descrButton.setBackground(c1);
	    descrButton.setForeground(Color.white);
	    descrButton.addActionListener(new ActionListener() {
	    	/*
	    	 * öffnet ein neues Fenster, in dem der User die Beschreibung der Veranstaltung schreiben kann.
	    	 * Von hier aus kann diese ggf. korrigiert werden. 
	    	 */
			@Override
			public void actionPerformed(ActionEvent e) {
					DescriptionFrame createPanel = new DescriptionFrame();
					
			}	
		});
	    
	    // *** BUTTON FOR PREVIW *** //
	    JButton previewButton = new JButton("Preview");
	    previewButton.setBounds(5,500, 150, 30);
	    previewButton.setBackground(c1);
	    previewButton.setForeground(Color.white);
	    previewButton.addActionListener(new ActionListener() {
	    	/*
	    	 * öffnet ein neues Fenster, in dem der User die Beschreibung der Veranstaltung schreiben kann.
	    	 * Von hier aus kann diese ggf. korrigiert werden. 
	    	 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// *** GET TEXTFIELDS DATA 1 *** //
				String number = textField0.getText();
				String kategoryString = textField1.getText();
				
				// *** GET TEXTFIELDS AND COLLECT IN ARRAYLISTS *** //
				placeList = new ArrayList<>();
				String inputString = textField4.getText();
				String[] parts = inputString.split("[,\\s]+");
				for( String part : parts) {
					placeList.add(part);
				}
				dateList = new ArrayList<>();
				String inputString2 = textField5.getText();
				String[] parts2 = inputString2.split("[,\\s]+");
				for( String part : parts2) {
					dateList.add(part);
				}
				timeList = new ArrayList<>();
				String inputString3 = textField6.getText();
				String[] parts3 = inputString3.split("[,\\s]+");
				for( String part : parts3) {
					timeList.add(part);
				}
				
				// *** GET TEXTFIELDS DATA 2 *** //
				String ZoneName1 = textField811.getText();
				String priceNumber1 = textField812.getText();
				String quantifyNumber1 = textField813.getText();
				
				String ZoneName2 = textField821.getText();
				String priceNumber2 = textField822.getText();
				String quantifyNumber2 = textField823.getText();
				
				String ZoneName3 = textField831.getText();
				String priceNumber3 = textField832.getText();
				String quantifyNumber3 = textField833.getText();
				
				// *** COLLECT ALL TECTFIELDS DATA IN ARRAYLIST *** //
				ArrayList<String> collectedArrayList = VariablenHandler.CollectAndSaveInList(number, kategoryString, ZoneName1, ZoneName2, ZoneName3, quantifyNumber1, quantifyNumber2, quantifyNumber3, priceNumber1, priceNumber2, priceNumber3, quantifyNumber3, quantifyNumber3);
				
				// *** SEND ALL DATALISTS TO PREVIEWFRAME *** //
				/*
				 * @param1 collectedArrayList1 = gesammelte Werte aus den Textfeldern
				 * @param2 collectedArrayList2 = gesammelte Werte aus dem Place_Textfield
				 * @param3 collectedArrayList3 = gesammelte Werte aus dem Date_Textfield
				 * @param4 collectedArrayList4 = gesammelte Werte aus dem time_Textfield
				 * @param5 currentPath1 = aktuelle lokale Pfad im Verzeichnisbaum
				 */
				EventPreviewFrame11 PreviewFrame = new EventPreviewFrame11(collectedArrayList, placeList, dateList, timeList, currentPathPath1);	
			}
			
		});
	    
	    // *** ASSEMBLE ALL COMPONENTS *** //
        add(labelworkcreate);
        add(textfield);
        add(label0);
	    add(label1);
	    add(label2);
	    add(label3);
	    add(label4);
	    add(label5);
	    add(label6);
	    add(label7);
	    add(label811);
	    add(label812);
	    add(label813);
	    add(label821);
	    add(label831);
	    add(textField0);
	    add(textField1);
	    add(textField2);
	    add(textField3);
	    add(textField4);
	    add(textField5);
	    add(textField6);
	    add(textField811);
	    add(textField812);
	    add(textField813);
	    add(textField821);
	    add(textField822);
	    add(textField823);
	    add(textField831);
	    add(textField832);
	    add(textField833);
        add(descrButton);
        add(previewButton);
        
        // *** CREATE VISIBILITIES *** //
        setVisible(true);
	}
} // END OF CREATEPANEL2 //

// *** START EDITPANEL2 +++ NOT YET COMPLETE IMPLEMENTED *** //
class editPanel2 extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton testButton;
	JLabel labelGelb2;
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	public editPanel2() {
		
        setBackground(c2);
        setBounds(400,10,350,350);
        setLayout(null);
        JLabel labelGelb2 = new JLabel("Edit Panel");
		labelGelb2.setBounds(5,5,100,30);
		labelGelb2.setBackground(ctop);
		labelGelb2.setForeground(cwhite);
		labelGelb2.setLayout(null);
		
		labelGelb2.setVisible(true);
        JButton testButton = new JButton("TEST");
        testButton.setBounds(5,50,100,100);
        
        add(labelGelb2);
        add(testButton);
        setVisible(true);
		
	}
}

// *** START DELETEPANEL2 +++ NOT YET IMPLEMENTED YET *** //
class deletePanel2 extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton testButton;
	JLabel labelGelb2;
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	public deletePanel2() {
		
        setBackground(c2);
        setBounds(400,10,350,350);
        setLayout(null);
        JLabel labelGelb2 = new JLabel("Delete Panel");
		labelGelb2.setBounds(5,5,100,30);
		labelGelb2.setBackground(ctop);
		labelGelb2.setForeground(cwhite);
		labelGelb2.setLayout(null);
		
		labelGelb2.setVisible(true);
        JButton testButton = new JButton("TEST");
        testButton.setBounds(5,50,100,100);
        
        add(labelGelb2);
        add(testButton);
        setVisible(true);
		
	}
}

