package TopPackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import javax.swing.text.AbstractDocument.Content;

import Constructors.EntryPanelB;
import Constructors.HaalAreas;
import Settings.MainSettings;

public class AdmWorkEventPanel extends JPanel implements ActionListener{
	
	/*
	 * 
	 */
	public static GUImitarbeiterAdminScreen mAScreen;
	private static final long serialVersionUID = 1L;
	
	// *** ADMWORKEVENTPANEL COMPONENTEN *** //
	static JLabel labelright, labelleft;
	static JPanel panelMenu = new JPanel();
	static JPanel panelWork = new JPanel();
	static JSplitPane splitpane = new JSplitPane();
	static JButton createButtonEvent, editButtonEvent, deleteButtonEvent, abmeldeButton;
	
	// *** COLOR VARIABLES *** //
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop = new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	// *** MAIN FOR TEST PURPOSE *** //
	/*
	public static void main(String[] args) {
	
		dmWorkVerPanel admworkverpanel = new AdmWorkVerPanel();
		admworkverpanel.AdmWorkVerPanel();
		
	}
	*/
	
	@SuppressWarnings("static-access")
	public AdmWorkEventPanel(GUImitarbeiterAdminScreen mAScreen, String tempStat) {
		this.mAScreen = mAScreen;
		
		// *** Labels ***
		labelleft = new JLabel("Menu");
        labelleft.setOpaque(true);
        labelleft.setBounds(0,0,200,30);
        labelleft.setBackground(ctop);
        labelleft.setForeground(c2);
        labelleft.setVisible(true);
      
        labelright = new JLabel("You are located as \"" + tempStat + "\" int the event panel");
        labelright.setOpaque(true);
        labelright.setBounds(0,0,400,30);
        labelright.setBackground(ctop);
        labelright.setForeground(c2);
        labelright.setVisible(true);
        
        // *** Button ***
        //Buttons des PanelMenu
        createButtonEvent = new JButton("Create events");
        createButtonEvent.setOpaque(true);
        createButtonEvent.setBounds(10,65,150,30);
        createButtonEvent.addActionListener(this);
        createButtonEvent.setVisible(true);
        
        editButtonEvent = new JButton("Edit events");
        editButtonEvent.setOpaque(true);
        editButtonEvent.setBounds(10,100,150,30);
        editButtonEvent.addActionListener(this);
        editButtonEvent.setVisible(true);
  
        deleteButtonEvent = new JButton("Delete events");
        deleteButtonEvent.setOpaque(true);
        deleteButtonEvent.setBounds(10,135,150,30);
        deleteButtonEvent.addActionListener(this);
        deleteButtonEvent.setVisible(true);
        
        //PanelMenu vom SplitPane(Left)
        // *** JPanel ***
        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(true);
        panelMenu.setBackground(c2);
        panelMenu.setBounds(10,10,350,700);
        panelMenu.add(labelleft);
        panelMenu.add(createButtonEvent);
        panelMenu.add(editButtonEvent);
        panelMenu.add(deleteButtonEvent);
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
        createButtonEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					createPanel createPanel = new createPanel();
					splitpane.setRightComponent(createPanel);
			}
			
		});
        editButtonEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					editPanel editPanel = new editPanel();
					splitpane.setRightComponent(editPanel);
			}
			
		});
        deleteButtonEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					deletePanel deletePanel = new deletePanel();
					splitpane.setRightComponent(deletePanel);
			}
			
		});
        /*
        abmeldeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        			AnmeldeScreen anmeldung = new AnmeldeScreen();
        			anmeldung.GUIAnmeldung();
        			
        			mAScreen.dispose();
        			
        			closeGUImitarbeiterAdminScreen();
        	}
        });
        */
        
        panelMenu.setVisible(true);
        panelWork.setVisible(true);
  		
        add(splitpane);
        splitpane.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== createButtonEvent) {
			createPanel createPanel = new createPanel();
			splitpane.setRightComponent(createPanel);
		}
		
	}
	
}

// *** START CREATEPANEL *** //
class createPanel extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// *** CREATE COMPONENTEN *** //
	JLabel labelworkcreate, label3, label2, label1;
	JButton testButton;

	// ***  *** //
	static ArrayList<String> placeList = new ArrayList<>();
	static ArrayList<String> dateList = new ArrayList<>();
	static ArrayList<String> timeList = new ArrayList<>();
	
	// *** LOCALE PATHS *** //
	static Path currentPathPath1 = PathHandler.complWorkServerVerPath;
	static String currentPathString1 = PathHandler.complWorkServerVerPath.toString();
	//String workPath = System.getProperty("user.dir");
	//String CurrentPath1 = workPath + kompString;
	
	// *** NECESSARY FOR LATER LANGUAGE PAKET +++ NOT IMPLEMENTED YET *** //
	String currencyEU = "€";
	String currencyUSD = "$";
	
	// *** COLORS VARIABLES *** //
	static Color c1 = new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop = new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	// *** LINES *** //
	LineBorder line = new LineBorder(c2, 1, true);
	
	/*
	 * 
	 */
	public createPanel() {
		
        setBackground(c2);
        setBounds(400,10,350,650);
        setLayout(null);
        
        // FOR TEST //
        System.out.println(currentPathString1);
        
        // *** TOP LABEL *** //
        JLabel labelworkcreate = new JLabel("Working Panel");
        labelworkcreate.setBounds(5,5,100,30);
        labelworkcreate.setBackground(ctop);
        labelworkcreate.setForeground(cwhite);
        labelworkcreate.setLayout(null);
		
        // *** TOP TEXTFIELD *** //
        JTextField textfield = new JTextField();
		textfield.setBounds(165,0,700,30);
		textfield.setEditable(false);
		textfield.setText(currentPathString1);
		
		// *** EVENT NUMBER *** //
        // Label-"EVENT NUMBER" //
		JLabel label0 = new JLabel("Event number",SwingConstants.CENTER);
	    label0.setOpaque(true);
	    label0.setBounds(5,35,150,30);
	    label0.setBackground(ctop);
	    label0.setForeground(c2);
	    
	    // TextField-"EVENT NUMBER" //
	    JTextField textField0 = new JTextField(30);
	    textField0.setBounds(165, 35, 200, 30);
	    textField0.setOpaque(true);
	    textField0.setBackground(c1);
	    textField0.setForeground(Color.white);
	    textField0.setBorder(line);
	    
	    // *** CATEGORY *** //
	    // Label-"CATEGORY" //
		JLabel label1 = new JLabel("Category", 0);
	    label1.setOpaque(true);
	    label1.setBounds(5,70,150,30);
	    label1.setBackground(ctop);
	    label1.setForeground(c2);
	    
	    // TextField-"CATEGORY" //  
	    JTextField textField1 = new JTextField(30);
	    textField1.setBounds(165, 70, 200, 30);
	    textField1.setOpaque(true);
	    textField1.setBackground(c1);
	    textField1.setForeground(Color.white);
	    textField1.setBorder(line);
	    
	    JButton createHaalButton = new JButton("Create Haal");
	    createHaalButton.setBounds(370, 70,150,30);
        createHaalButton.setBackground(c1);
	    createHaalButton.setForeground(Color.white);
	    createHaalButton.addActionListener(new ActionListener() {
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
					 String categoryString = textField1.getText();
					 createCategoryScreen(categoryString);	
			}	
		});
	    
	    // *** ORGANIZER *** //
	    // Label-"ORGANIZER" //
	    JLabel label2 = new JLabel("Organizer", 0);
	    label2.setOpaque(true);
	    label2.setBounds(5, 105, 150, 30);
	    label2.setBackground(ctop);
	    label2.setForeground(c2);
	    
	    // TextField-"ORGANIZER" // 
	    JTextField textField2 = new JTextField(30);
	    textField2.setBounds(165, 105, 200, 30);
	    textField2.setOpaque(true);
	    textField2.setBackground(c1);
	    textField2.setForeground(Color.white);
	    textField2.setBorder(line);
	        
	    // *** ARTIST *** //
	    // Label-"ARTIST" //
	    JLabel label3 = new JLabel("Artist", 0);
	    label3.setOpaque(true);
	    label3.setBounds(5, 140, 150, 30);  
	    label3.setBackground(ctop);
	    label3.setForeground(c2);
	    
	    // TextField-"ARTIST" // 
	    JTextField textField3 = new JTextField(30);
	    textField3.setBounds(165, 140, 200, 30);
	    textField3.setOpaque(true);
	    textField3.setBackground(c1);
	    textField3.setForeground(Color.white);
	    textField3.setBorder(line);
	                      
	    // *** Button *** //
	    //JButton descrButton = new JButton("Beschreibung");
	    //descrButton.setBounds(5, 175, 150, 30);
	        
	    // *** PLACE *** //
	    // Label-"PLACES" //
        JLabel label4 = new JLabel("Places", 0);
	    label4.setOpaque(true);
	    label4.setBounds(5, 210, 150, 30);
	    label4.setBackground(ctop);
	    label4.setForeground(c2);
	    
	    // TextField-"PLACES" //  
	    JTextField textField4 = new JTextField(30);
	    textField4.setBounds(165, 210, 200, 30);
	    textField4.setOpaque(true);
	    textField4.setBackground(c1);
	    textField4.setForeground(Color.white);
	    textField4.setBorder(line);
	    
	    // *** DATES *** //
        // Label-"DATES" //
        JLabel label5 = new JLabel("Dates", 0);
	    label5.setOpaque(true);
	    label5.setBounds(5, 245, 150, 30);
	    label5.setBackground(ctop);
	    label5.setForeground(c2);
	    
	    // TextField-"DATES" //
	    JTextField textField5 = new JTextField(30);
	    textField5.setBounds(165, 245, 200, 30);
	    textField5.setOpaque(true);
	    textField5.setBackground(c1);
	    textField5.setForeground(Color.white);
	    textField5.setBorder(line);
	  
	    // *** TIMES *** //
	    // Label-"TIMES" //
	    JLabel label6 = new JLabel("Times", 0);
	    label6.setOpaque(true);
	    label6.setBounds(5, 280, 150, 30); 
	    label6.setBackground(ctop);
	    label6.setForeground(c2);
	     
	    // TextField-"TIMES" //
	    JTextField textField6 = new JTextField(30);
	    textField6.setBounds(165, 280, 200, 30);
	    textField6.setOpaque(true);
	    textField6.setBackground(c1);
	    textField6.setForeground(Color.white);
	    textField6.setBorder(line);
	    
	    // *** STATIS OF EVENT *** //
	    // Label-"STATIS" //
	    JLabel label9 = new JLabel("Statis", 0);
	    label9.setOpaque(true);
	    label9.setBounds(5, 315, 150, 30);
	    label9.setBackground(ctop);
	    label9.setForeground(c2);
	    
	    // TextField-"STATIS" //
	    JTextField textField9 = new JTextField(30);
	    textField9.setOpaque(true);
	    textField9.setBounds(165, 315, 200, 30);
	    textField9.setBackground(c1);
	    textField9.setForeground(Color.white);
	    textField9.setBorder(line);
	    
	    // *** CATEGORY OF THE AREA *** //
	    // Label-"CATEGORIZATION"
	    JLabel label7 = new JLabel("Categorization of the areas", 0);
	    label7.setOpaque(true);
	    label7.setBounds(5, 350, 200, 30);     
	    label7.setBackground(ctop);
	    label7.setForeground(c2);
	    
	    // *** PRICE FIELDS FOR AREA *** //
	    JLabel label812 = new JLabel("Price/ticket in the area (in " + currencyEU + ")", 0);
	    label812.setOpaque(true);
	    label812.setBounds(275, 395, 200, 30);  
	    label812.setBackground(ctop);
	    label812.setForeground(c2);
	    
	    // *** SEATS IN AREAS *** //
	    JLabel label813 = new JLabel("Available seats in the area", 0);
	    label813.setOpaque(true);
	    label813.setBounds(485, 395, 200, 30);  
	    label813.setBackground(ctop);
	    label813.setForeground(c2);
	    
	    // *** AREA 1 *** //
	    JLabel label811 = new JLabel("Name 1", 0);
	    label811.setOpaque(true);
	    label811.setBounds(5, 430, 150, 30);   
	    label811.setBackground(ctop);
	    label811.setForeground(c2);
	    
	    // TextField-"NAME1" //  
	    JTextField textField811 = new JTextField(30);
	    textField811.setBounds(165, 430, 100, 30);
	    textField811.setOpaque(true);
	    textField811.setBackground(c1);
	    textField811.setForeground(Color.white);
	    textField811.setBorder(line);
	    
	    // TextField-"PRICE FOR NAME1" //
	    JTextField textField812 = new JTextField("0");
	    textField812.setBounds(275, 430, 200, 30);
	    textField812.setOpaque(true);
	    textField812.setBackground(c1);
	    textField812.setForeground(Color.white);
	    textField812.setBorder(line);
	    
	    // TextField-"SEATS FOR NAME1" //
	    JTextField textField813 = new JTextField("0");
	    textField813.setBounds(485, 430, 200, 30);
	    textField813.setOpaque(true);
	    textField813.setBackground(c1);
	    textField813.setForeground(Color.white);
	    textField813.setBorder(line);
	               
	    // *** AREA 2 *** //
	    JLabel label821 = new JLabel("Name 2", 0);
	    label821.setOpaque(true);
	    label821.setBounds(5, 465, 150, 30);  
	    label821.setBackground(ctop);
	    label821.setForeground(c2);
	                     
	    // TextField-"NAME2" // 
	    JTextField textField821 = new JTextField(30);
	    textField821.setBounds(165, 465, 100, 30);
	    textField821.setOpaque(true);
	    textField821.setBackground(c1);
	    textField821.setForeground(Color.white);
	    textField821.setBorder(line);
	    
	    // TextField-"PRICE FOR NAME2" //
	    JTextField textField822 = new JTextField("0");
	    textField822.setBounds(275, 465, 200, 30);
	    textField822.setOpaque(true);
	    textField822.setBackground(c1);
	    textField822.setForeground(Color.white);
	    textField822.setBorder(line);
	    
	    // TextField-"SEATS FOR NAME2" //
	    JTextField textField823 = new JTextField("0");
	    textField823.setBounds(485, 465, 200, 30);
	    textField823.setOpaque(true);
	    textField823.setBackground(c1);
	    textField823.setForeground(Color.white);
	    textField823.setBorder(line);
	    
	    // *** AREA 3 *** //
	    JLabel label831 = new JLabel("Name 3", 0);
	    label831.setOpaque(true);
	    label831.setBounds(5, 500, 150, 30);     
	    label831.setBackground(ctop);
	    label831.setForeground(c2);
	                   
	    // TextField-"NAME3" // 
	    JTextField textField831 = new JTextField(30);
	    textField831.setBounds(165, 500, 100, 30);
	    textField831.setOpaque(true);
	    textField831.setBackground(c1);
	    textField831.setForeground(Color.white);
	    textField831.setBorder(line);
	     
	    // TextField-"PRICE FOR NAME3" //
	    JTextField textField832 = new JTextField("0");
	    textField832.setBounds(275, 500, 200, 30);
	    textField832.setOpaque(true);
	    textField832.setBackground(c1);
	    textField832.setForeground(Color.white);
	    textField832.setBorder(line);
	    
	    // TextField-"SEATS FOR NAME3" //
	    JTextField textField833 = new JTextField("0");
	    textField833.setBounds(485, 500, 200, 30);
	    textField833.setOpaque(true);
	    textField833.setBackground(c1);
	    textField833.setForeground(Color.white);
	    textField833.setBorder(line);

        // *** BUTTONS *** //
	    // Button-"DESCRIPTION" //
        JButton descrButton = new JButton("Description");
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
					new DescriptionFrame();
					
			}	
		});
	    
	    // Button-"PREVIEW" //
	    JButton previewButton = new JButton("Preview");
	    previewButton.setBounds(5,535, 150, 30);
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
				String kategoryString = "Kategorie: " + textField1.getText();
				String organizerString = "Veranstalter: " + textField2.getText();
				String artistString = "Künstler: " + textField3.getText();
				String statisString = textField9.getText();
				
				// *** GET TEXTFIELDS AND COLLECT IN ARRAYLISTS *** //
				placeList = new ArrayList<>();
				String inputString = "Orte: " + textField4.getText();
				String[] parts = inputString.split("[,\\s]+");
				for( String part : parts) {
					placeList.add(part);
				}
				CheckAndChangeStrings(placeList);
				System.out.println("PlaceList geupdatet: " + placeList);
				
				// *** GET TEXTFIELDS AND COLLECT IN ARRAYLISTS *** //
				dateList = new ArrayList<>();
				String inputString2 = "Termine: " + textField5.getText();
				String[] parts2 = inputString2.split("[,\\s]+");
				for( String part : parts2) {
					dateList.add(part);
				}
				
				// *** GET TEXTFIELDS AND COLLECT IN ARRAYLISTS *** //
				timeList = new ArrayList<>();
				String inputString3 = "Zeiten: " + textField6.getText();
				String[] parts3 = inputString3.split("[,\\s]+");
				for( String part : parts3) {
					timeList.add(part);
				}
				
				// *** GET TEXTFIELDS DATA 2 *** //
				String ZoneName1 = "ZonenName1: " + textField811.getText();
				String priceNumber1 = "Price1: " + textField812.getText();
				String quantifyNumber1 = "Anzahl_Plätze1: " + textField813.getText();
				
				String ZoneName2 = "ZonenName2: " + textField821.getText();
				String priceNumber2 = "Price2: " + textField822.getText();
				String quantifyNumber2 = "Anzahl_Plätze2: " + textField823.getText();
				
				String ZoneName3 = "ZonenName3: " + textField831.getText();
				String priceNumber3 = "Price3: " + textField832.getText();
				String quantifyNumber3 = "Anzahl_Plätze3: " + textField833.getText();
				
				// *** COLLECT ALL TECTFIELDS DATA IN ARRAYLIST *** //
				ArrayList<String> collectedArrayList = VariablenHandler.CollectAndSaveInList(number, kategoryString, organizerString, artistString, statisString ,ZoneName1, ZoneName2, ZoneName3, priceNumber1, priceNumber2, priceNumber3, quantifyNumber1, quantifyNumber2, quantifyNumber3);
				
				// *** SEND ALL DATALISTS TO PREVIEWFRAME *** //
				/*
				 * @param1 collectedArrayList1 = gesammelte Werte aus den Textfeldern
				 * @param2 collectedArrayList2 = gesammelte Werte aus dem Place_Textfield
				 * @param3 collectedArrayList3 = gesammelte Werte aus dem Date_Textfield
				 * @param4 collectedArrayList4 = gesammelte Werte aus dem time_Textfield
				 * @param5 currentPath1 = aktuelle lokale Pfad im Verzeichnisbaum
				 */
				//new EventPreviewFrame11(collectedArrayList, placeList, dateList, timeList, currentPathPath1);	
				new PreviewFrames(collectedArrayList, placeList, dateList, timeList, currentPathPath1);
			}
			
		});
	    
	    // *** ASSEMBLE ALL COMPONENTS *** //
        add(labelworkcreate);
        add(textfield);
        add(label0);
	    add(label1);
	    add(createHaalButton);
	    add(label2);
	    add(label3);
	    add(label4);
	    add(label5);
	    add(label6);
	    add(label7);
	    add(label9);
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
	    add(textField9);
        add(descrButton);
        add(previewButton);
        
        // *** CREATE VISIBILITIES *** //
        setVisible(true);
	}
	
	private void createCategoryScreen(String category)  {
		if (category.equals("Concert-OpenAir") || category.endsWith("Concert-Haal") || category.equals("Theater") || category.equals("Opera")) {
			CreateCategoryFrame frame = new CreateCategoryFrame();
			frame.GUICreateCategoryFrame();
			//CreateCategoryFrame();
		} else if (category.equals("")) {
			JOptionPane.showMessageDialog(null, "Text field must not be empty.", "Message", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No possibility to create a seating plan.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	
	public void CheckAndChangeStrings(ArrayList<String> placeList) {
		
		// *** OPTIONAL: Extract these follow Lines in an external function *** //
		placeList.remove(0); // Must be deleted if Textfields changed ~>placelist(0)
		List<String> updateList = new ArrayList<>();
		String lastCity = ""; 
		for (String itemString : placeList) {
			if (itemString.contains("Frankfurt")) {
				lastCity = "Frankfurt";
			} else if (itemString.contains("Oder")) {
				updateList.add(lastCity + " (Oder)");
			} else if (itemString.contains("Main")) {
				updateList.add(lastCity + " (Main)");
			} else {
				updateList.add(itemString);
			}
			if (itemString.contains("an") ^ itemString.contains("der") ^ itemString.contains("am")) {
				updateList.remove("an");
				updateList.remove("der"); 
				updateList.remove("am");
			}
		}
		placeList.clear();
		placeList.addAll(updateList);
		if(placeList.size() > 1) {
			JOptionPane.showMessageDialog(null, "Attention! Please note that for more than one venue, additional data must be deposited.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
	
		
		// END FOR OPTINAL FUNCTION //
	}
	/*
	public void createFrames(int numberOfFrames) {
		JFrame[] frames = new JFrame[numberOfFrames];
		
		EventPreviewFrame11 eventPreviewFrame11 = new EventPreviewFrame11(dateList, placeList, dateList, timeList, currentPathPath1);
		EventPreviewFrame12 eventPreviewFrame12 = new EventPreviewFrame12(numberOfFrames, dateList, placeList, dateList, timeList, currentPathPath1);
		
		for(int i = 0; i < numberOfFrames; i++) {
			frames[i] = new JFrame("Frame " + (i + 1));
        
            frames[i].setVisible(true);
		}
		
		frames[0] = eventPreviewFrame11;
		frames[1] = eventPreviewFrame12;
		
	}
	*/
}

// *** START EDITPANEL2 +++ NOT YET COMPLETE IMPLEMENTED *** //
class editPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton testButton;
	JLabel labelGelb2;
	
	public editPanel() {
		
        setBackground(MainSettings.getColorC2());
        setBounds(400,10,350,350);
        setLayout(null);
        JLabel labelGelb2 = new JLabel("Edit Panel");
		labelGelb2.setBounds(5,5,100,30);
		labelGelb2.setBackground(MainSettings.getColorCTop());
		labelGelb2.setForeground(MainSettings.getColorCWhite());
		labelGelb2.setLayout(null);
		
		labelGelb2.setVisible(true);
        JButton testButton = new JButton("TEST");
        testButton.setBounds(5,50,100,100);
        
        add(labelGelb2);
        add(testButton);
        setVisible(true);
		
	}
}

// *** START DELETEPANEL2 +++ NOT YET COMPLETE IMPLEMENTED *** //
class deletePanel extends JPanel {

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
	
	public deletePanel() {
		
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

/**********************************
 *** CLASS CREATE CATEGORYFRAME *** 
 **********************************/
class CreateCategoryFrame extends JPanel {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GroupLayout layout; // Füge diese Zeile hinzu
    private GroupLayout.SequentialGroup vGroup; // defines the vertical layout
    private GroupLayout.ParallelGroup hGroup; // defines the horizontal layout
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel settingsLabel = new JLabel();
	private static JLabel previewLabel = new JLabel();
	private static JLabel countOfAreasLabel = new JLabel();
	private static JTextField countOfAreasJTextField = new JTextField();
	private static JButton createButton = new JButton();
	private static JButton refreshButton = new JButton();
	private static JButton createOverViewButton = new JButton();
	private static JLabel rowsLabel = new JLabel();
	private static JLabel columnsLabel = new JLabel();
	private static JPanel borderPanel = new JPanel();
	private static JLabel stageLabel = new JLabel();
	private static JScrollPane scroller = new JScrollPane();
	private static JPanel scrollerPanel = new JPanel();
	private static JScrollPane scroller2 = new JScrollPane();
	private static JPanel scrollerPanel2 = new JPanel();
	private static JButton closeButton = new JButton();
	private static JButton deleteButton = new JButton();
	
	private static int maxOfAreas = 10;
	private static int gridx = 1;
	private static int gridy = 0;
	private static String startString = "0";
	
	private static List<String> nameList = new ArrayList<>();
	
	public static List<JTextField> rowsFieldsList = new ArrayList<>();
	public static List<JTextField> columnsFieldsList = new ArrayList<>();
	public static List<List<JTextField>> complAreaSizeList;
	
	private static List<EntryPanelB> entryPanels; // List to store EntryPanel instances
	private static CreateCategoryFrame panelArray[] = new CreateCategoryFrame[maxOfAreas];
	//public static JPanel panelArray2[] = new JPanel[maxOfAreas];
	
	private static LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
	//private static LinkedHashMap<String, JPanel> panelMap = new LinkedHashMap<>();
	private static List<List<String>> fieldMatrixString = new ArrayList<>();
	private static List<List<Integer>> fieldMatrixInteger = new ArrayList<>();
	
	private static Color[] color = { MainSettings.getColorSOrange(), MainSettings.getColorSCyan(), MainSettings.getColorCBlue(), 
									MainSettings.getColorSMagenta(), MainSettings.getColorSPink() };
	private int colorNumber = 0;
	
	/*********************************
	 *** GUI CREATE CATEGORY FRAME *** 
	 *********************************/
	public void GUICreateCategoryFrame() {
		
		// *** WINDOW SETTINGS *** //
		frame = new JFrame ("Create Screen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,550);					
		frame.setLocationRelativeTo(null);
	
		/**************************
		 *** LEFT SIDE OF FRAME *** 
		 **************************/
		// *** MAIN PANEL OF FRAME *** //
		panel.setBounds(0,0,500,400);
		panel.setBackground(MainSettings.getColorC2());
		panel.setLayout(null);
		panel.setVisible(true);
		
		// *** SETTINGS LABEL FOR OVERVIEW OF EVENT *** //
		settingsLabel = new JLabel("Settings");
		settingsLabel.setBounds(10,10,100,30);
		settingsLabel.setBackground(MainSettings.getColorCTop());
		settingsLabel.setForeground(MainSettings.getColorCWhite());
		settingsLabel.setLayout(null);
		
		panelArray = new CreateCategoryFrame[maxOfAreas];
		complAreaSizeList = new ArrayList<>();
		
		// TEST PURPOSE //
		/*
		for (int t = 0; t < panelArray.length; t++) {
			
			panelArray[t] = new CreateCategoryFrame();
        	panelArray[t].setName("Area_" + (t+1)); 
        	panelArray[t].addEntryPanelB("Area_" + (t+1), "Area_" + (t+1), startString);
        	
        	System.out.println("--------------------------");
		    System.out.println("PANELARRAY[t] NAME: " + panelArray[t].getName() + " ");
		    System.out.println("--------------------------");
        	
		}
		*/
		
		countOfAreasLabel = new JLabel("Count of Areas");
		countOfAreasLabel.setBounds(10,45,120,30);
		countOfAreasLabel.setBackground(MainSettings.getColorCTop());
		countOfAreasLabel.setForeground(MainSettings.getColorCWhite());
		countOfAreasLabel.setLayout(null);
		countOfAreasLabel.setOpaque(true);
		
		// *** COUNT OF AREAS JTEXTFIELD *** //
		countOfAreasJTextField = new JTextField();
		countOfAreasJTextField.setBounds(135,45,30,30);
		countOfAreasJTextField.setBackground(MainSettings.getColorC1());
		countOfAreasJTextField.setForeground(MainSettings.getColorCWhite());
		countOfAreasJTextField.setBorder(MainSettings.getLineBorder());
		countOfAreasJTextField.setOpaque(true);
		
		// *** CREATE BUTTON *** //
		createButton = new JButton("Create Entrys");
		createButton.setBounds(235,45,150,30);
		createButton.setBackground(MainSettings.getColorC1());
		createButton.setForeground(MainSettings.getColorCWhite());
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				maxOfAreas = changeStringToInt(countOfAreasJTextField.getText());
				panelArray = new CreateCategoryFrame[maxOfAreas];
				System.out.println("panelArray length: " + panelArray.length); 
				System.out.println("----------------------------");
				System.out.println("AFTER CLICK ON CREATE BUTTON");
				System.out.println("----------------------------");
				
				for (int t = 0; t < panelArray.length; t++) {
					
				    panelArray[t] = new CreateCategoryFrame();
				    panelArray[t].setName("Area_" + (t + 1));
				    panelArray[t].addEntryPanelB("Area_" + (t + 1), "Area_" + (t + 1), startString);
				 
				    System.out.println("--------------------------");
				    System.out.println("AFTER ADDENTRYPANELB");
				    System.out.println("PANELARRAY[t] NAME: " + panelArray[t].getName() + " ");
				    System.out.println("--------------------------");
				    
				    //columnsFieldsList = panelArray[t].getColumsField();
				    //rowsFieldsList = panelArray[t].getRowsField();
				    
				    List<String> subList = new ArrayList<>();
 				    String panelNameString = panelArray[t].getName();
 				     
				    subList.add(startString);
				    subList.add(startString);
				    
 				    System.out.println("--------------------------");
				    System.out.println("CHECK ELEMENTS");
				    System.out.println("PANELARRAY[t] NAME: " + panelNameString);
				    System.out.println("subList: " + subList);
				    System.out.println("--------------------------");
				   
		        	nameList.add(panelNameString);
				    map.put(panelNameString, subList);
				    
				    
				    scrollerPanel.add(panelArray[t]);
				    scrollerPanel.revalidate();
				    updateLayout();
				}
				
				// TEST PURPOSE //
				System.out.println("----------------------------");
			    System.out.println("CHECK MAP ");
			    
			    for (Map.Entry<String, List<String>> eintrag : map.entrySet()) {
			    	String bezeichner = eintrag.getKey();
			        List<String> liste = eintrag.getValue();

			        System.out.println("Bezeichner: " + bezeichner);
			        System.out.println("Elemente: " + liste);
			        System.out.println();
     
			            
			    }
			    System.out.println("----------------------------");
			}
			
		});
		
		refreshButton = new JButton("Refresh");
		refreshButton.setBounds(235,80,150,30);
		refreshButton.setBackground(MainSettings.getColorC1());
		refreshButton.setForeground(MainSettings.getColorCWhite());
		refreshButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollerPanel.revalidate();
				scrollerPanel2.revalidate();
				scrollerPanel.repaint();
				scrollerPanel2.repaint();
				updateLayout();
			}
			
		});
		
		createOverViewButton = new JButton("Create Plan of Haal");
		createOverViewButton.setBounds(235,115,150,30);
		createOverViewButton.setBackground(MainSettings.getColorC1());
		createOverViewButton.setForeground(MainSettings.getColorCWhite());
		createOverViewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//panelArray2 = new JPanel[maxOfAreas];
			    for (Map.Entry<String, List<String>> eintrag : map.entrySet()) {
			        //String bezeichner = eintrag.getKey();
			        List<String> liste = eintrag.getValue();
			        fieldMatrixString.add(liste);
			    }
			    
			    /* TEST PURPOSE */
			    System.out.println("-------------------");
			    System.out.println("CREATE PLAN OF HAAL");
			    System.out.println("LIST: " + fieldMatrixString);
			    System.out.println("SIZE: " + fieldMatrixString.size());
			    System.out.println("-------------------");
			    
			    /*
			    for(int t = 0; t < panelArray2.length; t++) {
			    	
			    	int row = BuyWithoutRegistration.changeStringToInt(fieldMatrixString.get(t).get(t));
			        int column = BuyWithoutRegistration.changeStringToInt(fieldMatrixString.get(t).get(t+1));
			        List<Integer> subList = new ArrayList<>();
			        subList.add(row);
			        subList.add(column);   
			                
			        fieldMatrixInteger.add(subList);
			    	panelArray2[t] = new JPanel();
			    	panelArray2[t].add(new HaalAreas(row, column, "Area_" + (t+1)));
			    	scrollerPanel2.add(panelArray2[t]); 
			    
			    }   
			    */
			    JPanel scroller2Panel = new JPanel(new GridBagLayout());
			    scroller2Panel.setBackground(MainSettings.getColorCBlue());
			    //GridBagConstraints gbc = new GridBagConstraints();
			   
			    /* OPERATE FOR MATRIX CHANGE */
			    for (List<String> subList : fieldMatrixString) {
			    	
			    	/* CHANGE STRINGS IN MATRIX TO INTEGER-MATRIX */
			    	int row = BuyWithoutRegistration.changeStringToInt(subList.get(0)); // Erstes Element in der Unterliste
			    	int column = BuyWithoutRegistration.changeStringToInt(subList.get(1)); // Zweites Element in der Unterliste
			       
			    	/* CREATE NEW SUBLIST TO MATRIX */
			    	List<Integer> subIntegerList = new ArrayList<>();
			    	subIntegerList.add(row);
			    	subIntegerList.add(column);
			    	fieldMatrixInteger.add(subIntegerList);
			    	
			    	int height = HaalAreas.getSeatHeight();
			    	int width = HaalAreas.getSeatWidth();
			    	int seatSize = height*width;
			    	
			    	/* TEST PURPOSE */
			    	System.out.println("---------------------");
			    	System.out.println("SEATSIZE: " + seatSize);
			    	System.out.println("SIZE HEIGHT: " + column*height);
			    	System.out.println("SIZE WIDTH: " + row*width);
			    	System.out.println("---------------------");
			    }	
			    
			    int x = 0;
			    int y = 0;
			    int row = fieldMatrixInteger.get(x).get(y);
				int column = fieldMatrixInteger.get(x).get(y+1);
				
				/* DIMENSIONS */
			    Dimension dim1 = new Dimension((row*HaalAreas.getSeatWidth())+100, column*HaalAreas.getSeatHeight());
			    Dimension dim2 = new Dimension(row*HaalAreas.getSeatWidth()+300, column*HaalAreas.getSeatHeight());
			    
			    if (fieldMatrixInteger.size() == 1) {
			    	 System.out.println("entryPanelssize: " + entryPanels.size());
			    	int actualColor = getColorNumber();
		            
			    	/* PANEL */
					JPanel panelArea = new JPanel();
				    panelArea.setBackground(color[actualColor]);
				    if (actualColor == color.length-1) {
				    	actualColor = 0;
				    	setColorNumber(actualColor);
				    } else {
				    	setColorNumber(actualColor+1);
				    }
				    panelArea.setPreferredSize(dim1); // Setzt die bevorzugte Größe
				    panelArea.add(new HaalAreas(row, column, "Area_" + (fieldMatrixInteger.size())));		
				    	
				    scroller2Panel.add(panelArea, createGBC(1,0, 1,GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
				    	
				    scrollerPanel2.add(scroller2Panel);
				    	
			    } else if(fieldMatrixInteger.size() == 2) {
			    	
			    	System.out.println("entryPanelssize: " + entryPanels.size());
			    	int actualColor = getColorNumber();
		            	
			    	JPanel panelArea = new JPanel();
			    	panelArea.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}	
			    	panelArea.setPreferredSize(dim1); // Setzt die bevorzugte Größe
			    	panelArea.add(new HaalAreas(row, column, "Area_" + (fieldMatrixInteger.size())));
			    	
			    	actualColor++;
			    	int row2 = fieldMatrixInteger.get(x+1).get(y);
			    	int column2 = fieldMatrixInteger.get(x+1).get(y+1);
			    	
			    	JPanel panelArea2 = new JPanel();
			    	panelArea2.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}
			    	panelArea2.setPreferredSize(dim1);
			    	panelArea2.add(new HaalAreas(row2, column2, "Area_" + (fieldMatrixInteger.size()+1)));
			    				
			    	scroller2Panel.add(panelArea, createGBC(1,0,1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
			    	scroller2Panel.add(panelArea2, createGBC(1,1,1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));			    			
			    			
			    	scrollerPanel2.add(scroller2Panel);
			    	
			    } else if(fieldMatrixInteger.size() == 3) {
			    	
			    	System.out.println("entryPanelssize: " + entryPanels.size());
			    	int actualColor = getColorNumber();
	            	
			    	JPanel panelArea = new JPanel();
			    	panelArea.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}	
			    	panelArea.setPreferredSize(dim1); // Setzt die bevorzugte Größe
			    	panelArea.add(new HaalAreas(row, column, "Area_" + (fieldMatrixInteger.size())));
			    	
			    	actualColor++;
			    	int row2 = fieldMatrixInteger.get(x+1).get(y);
			    	int column2 = fieldMatrixInteger.get(x+1).get(y+1);
			    	
			    	JPanel panelArea2 = new JPanel();
			    	panelArea2.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}
			    	panelArea2.setPreferredSize(dim1);
			    	panelArea2.add(new HaalAreas(row2, column2, "Area_" + (fieldMatrixInteger.size()+1)));
			    	actualColor++;
			    	int row3 = fieldMatrixInteger.get(x+1).get(y);
			    	int column3 = fieldMatrixInteger.get(x+1).get(y+1);
			    	JPanel panelArea3 = new JPanel();
			    	panelArea3.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}
			    	panelArea3.setPreferredSize(dim1);
			    	panelArea3.add(new HaalAreas(row3, column3, "Area_" + (fieldMatrixInteger.size()+1)));
			    	
			    	scroller2Panel.add(panelArea, createGBC(1,0,1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
			    	scroller2Panel.add(panelArea2, createGBC(1,1,1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
			    	scroller2Panel.add(panelArea3, createGBC(1, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
			    			
			    	scrollerPanel2.add(scroller2Panel);
			    
			    } else if(fieldMatrixInteger.size() == 4) {
			    	
			    	System.out.println("entryPanelssize: " + entryPanels.size());
			    	int actualColor = getColorNumber();
	            	
			    	JPanel panelArea = new JPanel();
			    	panelArea.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}	
			    	panelArea.setPreferredSize(dim1); // Setzt die bevorzugte Größe
			    	panelArea.add(new HaalAreas(row, column, "Area_" + (fieldMatrixInteger.size())));
			    	
			    	actualColor++;
			    	int row2 = fieldMatrixInteger.get(x+1).get(y);
			    	int column2 = fieldMatrixInteger.get(x+1).get(y+1);
			    	
			    	JPanel panelArea2 = new JPanel();
			    	panelArea2.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}
			    	panelArea2.setPreferredSize(dim1);
			    	panelArea2.add(new HaalAreas(row2, column2, "Area_" + (fieldMatrixInteger.size()+1)));
			    	
			    	actualColor++;
			    	int row3 = fieldMatrixInteger.get(x+1).get(y);
			    	int column3 = fieldMatrixInteger.get(x+1).get(y+1);
			    	
			    	JPanel panelArea3 = new JPanel();
			    	panelArea3.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}
			    	panelArea3.setPreferredSize(dim1);
			    	panelArea3.add(new HaalAreas(row3, column3, "Area_" + (fieldMatrixInteger.size()+1)));
			    	
			    	actualColor++;
			    	int row4 = fieldMatrixInteger.get(x+1).get(y);
			    	int column4 = fieldMatrixInteger.get(x+1).get(y+1);
			    	
			    	JPanel panelArea4 = new JPanel();
			    	panelArea4.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}
			    	panelArea4.setPreferredSize(dim2);
			    	panelArea4.add(new HaalAreas(row4, column4, "Area_" + (fieldMatrixInteger.size()+1)));
			    	
			    	scroller2Panel.add(panelArea, createGBC(1,0,1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
			    	scroller2Panel.add(panelArea2, createGBC(1,1,1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
			    	scroller2Panel.add(panelArea3, createGBC(1, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1,1));
			    	scroller2Panel.add(panelArea4, createGBC(0, 3, 0, GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 1,3));
			    			
			    	scrollerPanel2.add(scroller2Panel);
			    }
		            	/*
		            	gbc.gridx = 0; // X-Position
				    	gbc.gridy = z; // Y-Position
				    	//gbc.anchor = z < maxOfAreas ? GridBagConstraints.CENTER : z == 7 ? GridBagConstraints.WEST : GridBagConstraints.EAST; // Positionierung relativ zum Gitterzellenanfang
				    	//gbc.gridwidth = z == maxOfAreas ? row*width+300 : row*width+100;
				    	//gbc.gridheight = z == maxOfAreas ? column*height : column*height;
				    	gbc.insets = new Insets(0, 0, 0, 0); // Abstand um das JPanel
		            	*/
		            	

			    	/*
			    	gbc.gridx = 0; // X-Position
			    	gbc.gridy = z; // Y-Position
			    	//gbc.anchor = z < maxOfAreas ? GridBagConstraints.CENTER : z == 7 ? GridBagConstraints.WEST : GridBagConstraints.EAST; // Positionierung relativ zum Gitterzellenanfang
			    	//gbc.gridwidth = z == maxOfAreas ? row*width+300 : row*width+100;
			    	//gbc.gridheight = z == maxOfAreas ? column*height : column*height;
			    	gbc.insets = new Insets(0, 0, 0, 0); // Abstand um das JPanel
			    	int actualColor = getColorNumber();
			    	
				    JPanel panelArea = new JPanel();
			    	panelArea.setBackground(color[actualColor]);
			    	if (actualColor == color.length-1) {
			    		actualColor = 0;
			    		setColorNumber(actualColor);
			    	} else {
			    		setColorNumber(actualColor+1);
			    	}
			    	
			    	Dimension dim1 = new Dimension(row*width+100, column*height);
			    	Dimension dim3 = new Dimension(row*width+300, column*height);
			    	panelArea.setPreferredSize(dim1); // Setzt die bevorzugte Größe
			    	panelArea.add(new HaalAreas(row, column, "Area_" + (fieldMatrixInteger.size())));
			    	//panelArea.setLayout(null);
			    	//panelArea.setBounds(getVisibleRect());
			    	
			    	JPanel scroller2Panel = new JPanel();
			    	scroller2Panel.setBackground(MainSettings.getColorCBlue());
			    	scroller2Panel.add(panelArea);
			    	scrollerPanel2.add(scroller2Panel);
			    	
			    	scroller2Panel.add(panelArea, gbc);
			    	
			    	//scroller2Panel.add(panelArea);
			    	scrollerPanel2.add(scroller2Panel);

			    	z++;
			    	*/
			    
			    
			    /* TEST PURPOSE 
			    for(int m = 0; m<panelArray2.length; m++) {
				    System.out.println("PanelArray2: " +panelArray2[m]);	
				}
			    */
			    System.out.println("-----------------");
			    System.out.println("CHECK THE DETAILS");
			    System.out.println("LIST: " + fieldMatrixInteger);
			    System.out.println("NAMELIST: " + nameList);
			    System.out.println("SIZE: " + fieldMatrixInteger.size());
			    System.out.println("-----------------");
			    
			    scrollerPanel2.revalidate();
			}
			
		});
		
		deleteButton = new JButton("Delete Content");
		deleteButton.setBounds(235,150,150,30);
		deleteButton.setBackground(MainSettings.getColorC1());
		deleteButton.setForeground(MainSettings.getColorCWhite());
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContentPreviewFrame();
			}
			
		});
		
		scroller.setBackground(MainSettings.getColorC2());
		scroller.setLayout(null);

        rowsLabel = new JLabel("Rows");
        rowsLabel.setBounds(75,80,55,30);
        rowsLabel.setBackground(MainSettings.getColorSGray());
        rowsLabel.setForeground(MainSettings.getColorCWhite());
        rowsLabel.setOpaque(true);
        rowsLabel.setLayout(null);
        
        columnsLabel = new JLabel("Columns");
        columnsLabel.setBounds(135,80,55,30);
        columnsLabel.setBackground(MainSettings.getColorSGray());
        columnsLabel.setForeground(MainSettings.getColorCWhite());
        columnsLabel.setOpaque(true);
        columnsLabel.setLayout(null);
		 
		// *** SCROLLER PANEL *** //
		scrollerPanel = new JPanel();
		scrollerPanel.setBackground(MainSettings.getColorSGray());
		scrollerPanel.setLayout(new BoxLayout(scrollerPanel, BoxLayout.Y_AXIS));
	
		// *** SCROLLER *** //
        scroller = new JScrollPane(scrollerPanel);
        scroller.setBounds(10,115,220,200);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setBackground(MainSettings.getColorC2());
        scroller.setForeground(MainSettings.getColorCTop());
		
        // *** CLOSE FRAME BUTTON *** //
		closeButton = new JButton("Close Frame");
		closeButton.setBounds(10,365,150,30);
		closeButton.setBackground(MainSettings.getColorC1());
	    closeButton.setForeground(MainSettings.getColorCWhite());
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
		
		/***************************
		 *** RIGHT SIDE OF FRAME *** 
		 ***************************/
		// *** BORDERPANEL *** //
		borderPanel = new JPanel();
		borderPanel.setBounds(395, 10, 20,485);
		borderPanel.setBackground(MainSettings.getColorSGray());
		
		// *** PREVIEWLABEL *** //
		previewLabel = new JLabel("Preview");
		previewLabel.setBounds(510,10,100,30);
		previewLabel.setForeground(MainSettings.getColorCWhite());
		
		// *** STAGE LABEL *** //
		stageLabel = new JLabel("Stage", SwingConstants.CENTER);
		stageLabel.setBounds(655,45,200, 65);
		stageLabel.setBackground(MainSettings.getColorCTop());
		stageLabel.setForeground(MainSettings.getColorCWhite());
		stageLabel.setOpaque(true);
		
		// *** SCROLLERPANEL2 *** //
		
		scrollerPanel2 = new JPanel();
		scrollerPanel2.setBackground(MainSettings.getColorSGray());
		
		
		//scrollerPanel2.setLayout(new BoxLayout(scrollerPanel2, BoxLayout.Y_AXIS));
		/*
		// Erstellen der Constraints für das JPanel
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; // X-Position
		gbc.gridy = 0; // Y-Position
		//gbc.anchor = GridBagConstraints.NORTHWEST; // Positionierung relativ zum Gitterzellenanfang
		gbc.insets = new Insets(10, 10, 10, 10); // Abstand um das JPanel
		*/
		
		// *** SCROLLER2 *** //
		scroller2 = new JScrollPane(scrollerPanel2);
		scroller2.setBounds(510,115,460, 320);
        scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller2.setBackground(MainSettings.getColorC2());
        scroller2.setForeground(MainSettings.getColorCTop());
        
        // *** COLLECT ALL ELEMENTS TO ONE *** //
		panel.add(settingsLabel);
		panel.add(countOfAreasLabel);
		panel.add(countOfAreasJTextField);
		panel.add(createButton);
		panel.add(refreshButton);
		panel.add(createOverViewButton);
		panel.add(deleteButton);
		panel.add(rowsLabel);
		panel.add(columnsLabel);
		panel.add(scroller);
		panel.add(closeButton);
		panel.add(borderPanel);
		panel.add(previewLabel);
		panel.add(stageLabel);
		panel.add(scroller2);
		frame.add(panel);
		//frame.add(previewPanel);
		
		// *** VISIBILITY OF THE ELEMENT *** //
		frame.setVisible(true);
		
	}
	
	/*
	// Erstellen eines Panels mit einer Beschriftung
    private static JPanel createPanelArea(int number, int colorNumber) {
        JPanel panel = new JPanel();
        
        panel.setBackground();
        JLabel label = new JLabel("Panel " + number);
        panel.add(label);
        return panel;
    }
    */
    
	private static GridBagConstraints createGBC(int x, int y, int weightx, int fill, int anchor, int width, int heigth) {
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.gridx = x;
    	gbc.gridy = y;
        gbc.weightx = weightx;
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.gridwidth = width;
        gbc.gridheight = heigth;
        gbc.insets = new Insets(0, 0, 0, 0);
		return gbc;
    }
    
	
	/****************************
     *** CHANGE STRING TO INT *** 
     ****************************/
    public static int changeStringToInt(String priceText) {
    	
        int priceValue = 0;
        
        try {
            priceValue = Integer.parseInt(priceText);
            System.out.println("Inside ChangeStringToInt: " + priceValue);
        } catch (NumberFormatException e) {
            // Das Textfeld enthält keine gültige Zahl
            System.err.println("Ungültige Zahl im Textfeld");
        }
        
        return priceValue;
        
    }

    /*
     *** GET ROWSFIELD LIST *** 
     */
	public List<JTextField> getRowsFieldList() {
		
        return rowsFieldsList;
		
	}
	
	/*
	 *** GET COLUMNSFIELD LIST *** 
	 */
	public List<JTextField> getColumnsFieldList() {
		
		return columnsFieldsList;
		
	}

	/*
	 *** CREATE CATEGORY FRAMES *** 
	 */
	public CreateCategoryFrame() {
		
		// *** LACOUT VARIABLES *** //
        layout = new GroupLayout(this);
        vGroup = layout.createSequentialGroup();
        hGroup = layout.createParallelGroup(Alignment.CENTER);
       
        layout.setVerticalGroup(vGroup);
        layout.setHorizontalGroup(hGroup);
        this.setLayout(layout);
        
        // *** LIST VARIABLES *** //
        entryPanels = new ArrayList<>(); // Initialize the list
        rowsFieldsList = new ArrayList<>();
        columnsFieldsList = new ArrayList<>();
	}
	
	/*
	 *** ADD ENTRYPANELB *** 
	 */
	public void addEntryPanelB(String name, String entry, String start) {
    	
		System.out.println("----------------------------");
        System.out.println("INSIDE addEntryPanel-> Beginning: ");
        System.out.println("NAME: " + name);
        System.out.println("ENTRY: " + entry);
        System.out.println("start: " + start);
        System.out.println("----------------------------");
        //System.out.println("PRICE: " + price);
        
        EntryPanelB entryPanel = new EntryPanelB(name, start);
        JLabel entryLabel = new JLabel(entry);
        
        JTextField rowsField = entryPanel.getRowsField();
        rowsField.setColumns(5);
        rowsField.setText(start);
        // Füge einen ActionListener hinzu, um auf Textänderungen zu reagieren
        rowsField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	//updateMap( rowsField, entryPanel);
            	String rowString = rowsField.getText();
                String nameString = entryPanel.getName();
                
                // Prüfe, ob die tempList für den Eintrag existiert
                if (map.containsKey(nameString)) {
                    List<String> tempList = map.get(nameString);
                    
                    // Setze den neuen Wert für die Zeilen (0. Index)
                    if (tempList.size() > 0) {
                        tempList.set(0, rowString);
                    } else {
                        tempList.add(rowString);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	//updateMap( rowsField, entryPanel);
            	String rowString = rowsField.getText();
                String nameString = entryPanel.getName();
                
                // Prüfe, ob die tempList für den Eintrag existiert
                if (map.containsKey(nameString)) {
                    List<String> tempList = map.get(nameString);
                    
                    // Setze den neuen Wert für die Zeilen (0. Index)
                    if (tempList.size() > 0) {
                        tempList.set(0, rowString);
                    } else {
                        tempList.add(rowString);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	
            	System.out.println("INSIDE addEntryPanelB->changedUpdate: " + rowsField.getText());
            	System.out.println("entryPanelB name: " + entryPanel.getName());
            
            }
        });
        
        JTextField columnsField = entryPanel.getColumnsField();
        columnsField.setColumns(5);
        columnsField.setText(start);
        columnsField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	//updateMap( columnsField, entryPanel);
            	String columString = columnsField.getText();
                String nameString = entryPanel.getName();
                
                // Prüfe, ob die tempList für den Eintrag existiert
                if (map.containsKey(nameString)) {
                    List<String> tempList = map.get(nameString);
                    
                    // Setze den neuen Wert für die Zeilen (0. Index)
                    if (tempList.size() > 0) {
                        tempList.set(1, columString);
                    } else {
                        tempList.add(columString);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	//updateMap( columnsField, entryPanel);
            	String columString = columnsField.getText();
                String nameString = entryPanel.getName();
                
                // Prüfe, ob die tempList für den Eintrag existiert
                if (map.containsKey(nameString)) {
                    List<String> tempList = map.get(nameString);
                    
                    // Setze den neuen Wert für die Zeilen (0. Index)
                    if (tempList.size() > 0) {
                        tempList.set(1, columString);
                    } else {
                        tempList.add(columString);
                    }
                }
           	 	
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	
            	System.out.println("INSIDE addEntryPanelB->changedUpdate: " + columnsField.getText());
            	System.out.println("entryPanelB name: " + columnsField.getName());
            
            }
        });
        
        
        System.out.println("----------------------------");
        System.out.println("RowsField: " + rowsField.getText());
        System.out.println("ColumnsField: " + columnsField.getText());
        System.out.println("----------------------------");
        
        rowsFieldsList.add(rowsField);
        columnsFieldsList.add(columnsField);
        entryPanel.add(entryLabel);
        entryPanel.add(rowsField);
        entryPanel.add(columnsField);
       
        
        entryPanels.add(entryPanel); // Add the entryPanel to the list
        //endPriceFields.add(endPriceField);
       
        updateLayout(); // Update the layout with the new entryPanel
        
    }
	
	 /******************************
	  *** UPDATE LAYOUT FUNCTION ***
	  ******************************/
    private void updateLayout() {
    	
    	 vGroup = layout.createSequentialGroup(); // Erstelle eine neue vertikale Gruppe
    	 hGroup = layout.createParallelGroup(Alignment.CENTER); // Erstelle eine neue horizontale Gruppe
    	 
    	 for (EntryPanelB entryPanel : entryPanels) {
    		 vGroup.addComponent(entryPanel);
    		 hGroup.addComponent(entryPanel);
    	 }

    	 layout.setVerticalGroup(vGroup);
    	 layout.setHorizontalGroup(hGroup);
    	 
    	 revalidate();
    }
    
    // WICHTIG - FOLGENDE ZEILEN AUF DIESE ANWENDUNG ANWENDEN //
    
    /***************************************
     *** DELETE CONTENT OF SHOPPING CART *** 
     ***************************************/
	public void deleteContentPreviewFrame() {
    	System.out.println("fieldMatrixInteger: " + fieldMatrixString);
		/*
		private static List<String> nameList = new ArrayList<>();
		
		public static List<JTextField> rowsFieldsList = new ArrayList<>();
		public static List<JTextField> columnsFieldsList = new ArrayList<>();
		public static List<List<JTextField>> complAreaSizeList;
		
		private static List<EntryPanelB> entryPanels; // List to store EntryPanel instances
		private static CreateCategoryFrame panelArray[] = new CreateCategoryFrame[maxOfAreas];
		public static JPanel panelArray2[] = new JPanel[maxOfAreas];
		
		private static List<List<String>> fieldMatrixString = new ArrayList<>();
		private static List<List<Integer>> fieldMatrixInteger = new ArrayList<>();
		*/
		
    	//clearEntryPanels();
    	//clearJPanelArrays();
    	rowsFieldsList = null;
    	columnsFieldsList = null;
    	fieldMatrixString = null;
    	fieldMatrixInteger = null;
    	nameList = null;
    	
    	for (int i = 0; i < maxOfAreas; i++) {
            if (panelArray[i] != null) {
                panelArray[i].clearEntryPanels();
            }
        }
    	
    	
    	/*
    	
    	if (parent2 != null) {
    	    parent2.remove(scrollerPanel2);
    	    parent2.revalidate();
    	    parent2.repaint();
    	}
    	
    	Container parent = scrollerPanel.getParent();
    	if (parent != null) {
    		parent.remove(scrollerPanel);
    		parent.revalidate();
    		parent.repaint();
    	}
        */
    	scrollerPanel.removeAll();
    	scrollerPanel.revalidate();
    	scrollerPanel.repaint();
    	scrollerPanel2.removeAll();
    	scrollerPanel2.revalidate();
    	scrollerPanel2.repaint();
    	map.clear();
    	fieldMatrixInteger = new ArrayList<>();
    	fieldMatrixString = new ArrayList<>();
    	//entryPanels = new ArrayList<>();
       
        //rowsFieldsList = new ArrayList<>();
        //columnsFieldsList = new ArrayList<>();
        nameList = new ArrayList<>();
    	//panelArray = new CreateCategoryFrame[maxOfAreas];
    	 System.out.println("fieldMatrixString: " + fieldMatrixString);
         System.out.println("fieldMatrixInteger: " + fieldMatrixInteger);
         System.out.println("entryPanels: " + entryPanels);
         System.out.println("nameList: " + nameList);
    	//panelArray2 = new JPanel[maxOfAreas];
		//restart(parent, parent2);
		scroller.add(scrollerPanel);
    	scroller2.add(scrollerPanel2);
    }
    
    /***************
     *** RESTART *** 
     ***************/
	/*
    public void restart(Container parent, Container parent2) {
    	countOfAreasJTextField.setText(startString);
    	System.out.println("GRIDX before restart: " + gridx);
    	System.out.println("GRIDY before restart: " + gridy);
    	
    	
       
        gridx = 1;
    	gridy = 0;
    	
        parent.add(scrollerPanel);
    	//parent.revalidate();
    	//parent.repaint();
    	parent2.add(scrollerPanel2);
    	//parent2.revalidate();
    	//parent2.repaint();
    	
    	System.out.println("GRIDX after restart: " + gridx);
    	System.out.println("GRIDY after restart: " + gridy);
    	
    }
    */
	// Methode zum Freigeben der Ressourcen
    public void clearEntryPanels() {
        entryPanels = null;  // Setze das Array auf null, um die Referenzen zu löschen
    }
    /*
    public void clearJPanelArrays() {
    	panelArray2 = null;
    }
    */
    public void setColorNumber(int colorNumber) {
    	this.colorNumber = colorNumber;
    }
    
    public int getColorNumber() {
    	return colorNumber;
    }
    
}

