package TopPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PreviewFrames extends JFrame implements ActionListener {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame frame = null;
	JPanel panel = new JPanel();
	JButton testButton, saveButton, closeButton;
	JLabel labelworkcreate, label3, label2, label1;
	
	static ArrayList<ArrayList<String>> VerDataComplete = new ArrayList<>();
	static String[] listNameString;
	
	
	// *** NECESSARY FOR LATER LANGUAGE PAKET +++ NOT YET IMPLEMENTED  *** //
	String currencyEU = "€";
	String currencyUSD = "$";
	
	static int counterFrame;
	
	// *** COLOR VARIABLES *** //
	static Color c1 = new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop = new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	// *** LINES *** //
	LineBorder line = new LineBorder(c2, 1, true);
	
	public PreviewFrames(ArrayList<String> collectedArrayList, ArrayList<String> placeList, ArrayList<String> dateList, ArrayList<String> timeList, Path currentPath1) {
		// *** FOR TEST PURPOSE *** //
		System.out.println(collectedArrayList);
		System.out.println(placeList);
		System.out.println(dateList);
		System.out.println(timeList);
				
		VerDataComplete = VariablenHandler.CollectAndSaveMatrixList(collectedArrayList, placeList, dateList, timeList);
				
		// *** FOR TEST PURPOSE *** //
		System.out.println(VerDataComplete);
		System.out.println(VerDataComplete.get(0).get(0));
		
		shortStrings(collectedArrayList);
		shortStrings(dateList);
		shortStrings(timeList);
		dateList.remove(0);
		timeList.remove(0);
		
		// *** FOR TEST PURPOSE *** //
		System.out.println("Event-Data: " + collectedArrayList);
		System.out.println("Place-Data: " + placeList);
		System.out.println("Date-Data: " + dateList);
		System.out.println("Time-Data: " + timeList);
		
		StringBuilder sBuilder = new StringBuilder();
		for(String itemString : placeList) {
    	sBuilder.append(itemString).append(",");
		}
		if (sBuilder.length() > 0 && sBuilder.charAt(sBuilder.length() - 1) == ',') {
			sBuilder.deleteCharAt(sBuilder.length() - 1);
		}
		sBuilder.toString();
		
		int numberOfFrames = placeList.size();
		counterFrame = numberOfFrames;
		
		//For Check
		System.out.println("Size of PlaceList: " + numberOfFrames);
		System.out.println("PlaceList: " + placeList);
		//System.out.println("Result String: " + result);
		
        JFrame[] frames = new JFrame[numberOfFrames];
        JPanel[] panels = new JPanel[numberOfFrames];
        JLabel[] labels = new JLabel[numberOfFrames];
        JLabel[] labels0 = new JLabel[numberOfFrames];
        JTextField[] textField0 = new JTextField[numberOfFrames];
        JLabel[] labels1 = new JLabel[numberOfFrames];
        JTextField[] textField1 = new JTextField[numberOfFrames];
        JLabel[] labels2 = new JLabel[numberOfFrames];
        JTextField[] textField2 = new JTextField[numberOfFrames];
        JLabel[] labels3 = new JLabel[numberOfFrames];
        JTextField[] textField3 = new JTextField[numberOfFrames];
        JLabel[] labels4 = new JLabel[numberOfFrames];
        JTextField[] textField4 = new JTextField[numberOfFrames];
        JLabel[] labels5 = new JLabel[numberOfFrames];
        JTextField[] textField5 = new JTextField[numberOfFrames];
        JLabel[] labels6 = new JLabel[numberOfFrames];
        JTextField[] textField6 = new JTextField[numberOfFrames];
        JLabel[] labels7 = new JLabel[numberOfFrames];
        JLabel[] labels9 = new JLabel[numberOfFrames];
        JTextField[] textField9 = new JTextField[numberOfFrames];
        
        JLabel[] labels812 = new JLabel[numberOfFrames];
        JLabel[] labels813 = new JLabel[numberOfFrames];
        JLabel[] labels811 = new JLabel[numberOfFrames];
        JLabel[] labels821 = new JLabel[numberOfFrames];
        JLabel[] labels831 = new JLabel[numberOfFrames];
        JTextField[] textField811 = new JTextField[numberOfFrames];
        JTextField[] textField812 = new JTextField[numberOfFrames];
        JTextField[] textField813 = new JTextField[numberOfFrames];
        JTextField[] textField821 = new JTextField[numberOfFrames];
        JTextField[] textField822 = new JTextField[numberOfFrames];
        JTextField[] textField823 = new JTextField[numberOfFrames];
        JTextField[] textField831 = new JTextField[numberOfFrames];
        JTextField[] textField832 = new JTextField[numberOfFrames];
        JTextField[] textField833 = new JTextField[numberOfFrames];
        
        for (int i = numberOfFrames-1; i >= 0; i--) {
            frames[i] = new JFrame("Preview " + (i + 1));
            frames[i].setBounds(400+(i*30), 10+(i*35), 805, 615);
            frames[i].setLayout(null);
            
            panels[i] = new JPanel();
            panels[i].setBackground(c2);
            panels[i].setBounds(0,0,800,600);
            panels[i].setLayout(null);
            
            labels[i] = new JLabel("Preview view " + (i + 1)); 
            labels[i].setBounds(5,5,150,30);
            labels[i].setBackground(ctop);
            labels[i].setForeground(cwhite);
            labels[i].setLayout(null);
            
            labels0[i] = new JLabel("Event number", SwingConstants.CENTER); 
            labels0[i].setOpaque(true);
    	    labels0[i].setBounds(5,35,150,30);
    	    labels0[i].setBackground(ctop);
    	    labels0[i].setForeground(c2);
    	    
    	    textField0[i] = new JTextField(30);
    	    textField0[i].setBounds(165, 35, 200, 30);
    	    textField0[i].setOpaque(true);
    	    textField0[i].setBackground(c1);
    	    textField0[i].setForeground(Color.white);
    	    textField0[i].setBorder(line);
    	    textField0[i].setEditable(false);
    	    textField0[i].setText(collectedArrayList.get(0));
    	    
    	    // Label-"Kategorie"
    		labels1[i] = new JLabel("Category", 0);
    	    labels1[i].setOpaque(true);
    	    labels1[i].setBounds(5,70,150,30);
    	    labels1[i].setBackground(ctop);
    	    labels1[i].setForeground(c2);
    	    
    	    // Textfeld-"Kategorie"  
    	    textField1[i] = new JTextField(30);
    	    textField1[i].setBounds(165, 70, 200, 30);
    	    textField1[i].setOpaque(true);
    	    textField1[i].setBackground(c1);
    	    textField1[i].setForeground(Color.white);
    	    textField1[i].setBorder(line);
    	    textField1[i].setEditable(false);
    	    textField1[i].setText(collectedArrayList.get(1));
    	    
    	    // Label-"Veranstalter"
    	    labels2[i] = new JLabel("Organizer", 0);
    	    labels2[i].setOpaque(true);
    	    labels2[i].setBounds(5, 105, 150, 30);
    	    labels2[i].setBackground(ctop);
    	    labels2[i].setForeground(c2);
    	    
    	    // Textfeld-"Veranstalter" 
    	    textField2[i] = new JTextField(30);
    	    textField2[i].setBounds(165, 105, 200, 30);
    	    textField2[i].setOpaque(true);
    	    textField2[i].setBackground(c1);
    	    textField2[i].setForeground(Color.white);
    	    textField2[i].setBorder(line);
    	    textField2[i].setEditable(false);
    	    textField2[i].setText(collectedArrayList.get(2));
    	    
    	    // Label-"Künstler"
    	    labels3[i] = new JLabel("Artist", 0);
    	    labels3[i].setOpaque(true);
    	    labels3[i].setBounds(5, 140, 150, 30);  
    	    labels3[i].setBackground(ctop);
    	    labels3[i].setForeground(c2);
    	    
    	    // Textfeld-"Künstler" 
    	    textField3[i] = new JTextField(30);
    	    textField3[i].setBounds(165, 140, 200, 30);
    	    textField3[i].setOpaque(true);
    	    textField3[i].setBackground(c1);
    	    textField3[i].setForeground(Color.white);
    	    textField3[i].setBorder(line);
    	    textField3[i].setEditable(false);
    	    textField3[i].setText(collectedArrayList.get(3));
    	    
    	    // ** Nach descrButton **
    	    
    	    // Label-"Orte" //
            labels4[i] = new JLabel("Place", 0);
    	    labels4[i].setOpaque(true);
    	    labels4[i].setBounds(5, 210, 150, 30);
    	    labels4[i].setBackground(ctop);
    	    labels4[i].setForeground(c2);
    	    
    	    // Textfeld-"Orte" //
    	    textField4[i] = new JTextField(30);
    	    textField4[i].setBounds(165, 210, 200, 30);
    	    textField4[i].setOpaque(true);
    	    textField4[i].setBackground(c1);
    	    textField4[i].setForeground(Color.white);
    	    textField4[i].setBorder(line);
    	    textField4[i].setEditable(false);
    	    textField4[i].setText(placeList.get(i));
    	    
    	    // Label-"Termine" //
            labels5[i] = new JLabel("Dates", 0);
    	    labels5[i].setOpaque(true);
    	    labels5[i].setBounds(5, 245, 150, 30);
    	    labels5[i].setBackground(ctop);
    	    labels5[i].setForeground(c2);
    	    
    	    // Textfeld-"Termine" 
    	    textField5[i] = new JTextField(30);
    	    textField5[i].setBounds(165, 245, 200, 30);
    	    textField5[i].setOpaque(true);
    	    textField5[i].setBackground(c1);
    	    textField5[i].setForeground(Color.white);
    	    textField5[i].setBorder(line);
    	    /*
    	    StringBuilder sBuilder2 = new StringBuilder();
    	    for(String itemString : dateList) {
    	    	sBuilder2.append(itemString).append(",");
    	    }
    	    textField5.setText(sBuilder2.toString());
    	    */
    	    textField5[i].setText(dateList.get(i));
    	    textField5[i].setEditable(false);
    	    
    	    // Label-"Uhrzeiten"
    	    labels6[i] = new JLabel("Times", 0);
    	    labels6[i].setOpaque(true);
    	    labels6[i].setBounds(5, 280, 150, 30); 
    	    labels6[i].setBackground(ctop);
    	    labels6[i].setForeground(c2);
    	    
    	    // Textfeld-"Uhrzeiten" 
    	    textField6[i] = new JTextField(30);
    	    textField6[i].setBounds(165, 280, 200, 30);
    	    textField6[i].setOpaque(true);
    	    textField6[i].setBackground(c1);
    	    textField6[i].setForeground(Color.white);
    	    textField6[i].setBorder(line);
    	    /*
    	    StringBuilder sBuilder3 = new StringBuilder();
    	    for(String itemString : timeList) {
    	    	sBuilder3.append(itemString).append(",");
    	    }
    	    textField6.setText(sBuilder3.toString());
    	    */
    	    textField6[i].setText(timeList.get(i));
    	    textField6[i].setEditable(false);
    	      
    	    // *** STATIS OF EVENT *** //
    	    // Label-"STATIS" //
    	    labels9[i] = new JLabel("Statis", 0);
    	    labels9[i].setOpaque(true);
    	    labels9[i].setBounds(5, 315, 150, 30);
    	    labels9[i].setBackground(ctop);
    	    labels9[i].setForeground(c2);
    	    
    	    // TextField-"STATIS" //
    	    textField9[i] = new JTextField(30);
    	    textField9[i].setOpaque(true);
    	    textField9[i].setBounds(165, 315, 200, 30);
    	    textField9[i].setBackground(c1);
    	    textField9[i].setForeground(Color.white);
    	    textField9[i].setBorder(line);
    	    textField9[i].setText(collectedArrayList.get(4));
    	    
    	    // *** CATEGORIZATION *** //
    	    // Label-"CATEGORIZATION" //
    	    labels7[i] = new JLabel("Categorization of the areas", 0);
    	    labels7[i].setOpaque(true);
    	    labels7[i].setBounds(5, 350, 200, 30);     
    	    labels7[i].setBackground(ctop);
    	    labels7[i].setForeground(c2);
    	                  
    	    // Label-"PRICE/TICKET" //
    	    labels812[i] = new JLabel("Price/ticket in the area (in " + currencyEU + ")", 0);
    	    labels812[i].setOpaque(true);
    	    labels812[i].setBounds(375, 395, 200, 30);  
    	    labels812[i].setBackground(ctop);
    	    labels812[i].setForeground(c2);
    	              
    	    // Label-"SEATS" //
    	    labels813[i] = new JLabel("Available seats in the area", 0);
    	    labels813[i].setOpaque(true);
    	    labels813[i].setBounds(585, 395, 200, 30);  
    	    labels813[i].setBackground(ctop);
    	    labels813[i].setForeground(c2);
    	    
    	    //[000002, Kategorie: Messe, Veranstalter: Lego GmbH, Künstler: , ZonenName1: Kurzbesuch Ticket, ZonenName2: tages Ticket, ZonenName3: Zeitraum Ticket, Price1: 30, Price2: 75, Price3: 350, Anzahl_Plätze1: 500000, Anzahl_Plätze2: 500000, Anzahl_Plätze3: 5000]
    	  	// get(0)	get(1)				get(2)					get(3)		get(4)							get(5)					get(6)						get(7)		get(8)		get(9)			get(10)					get(11)					get(12)
    	    
    	    // *** NAME 1 *** //
    	    // Label-"NAME 1" //
    	    labels811[i] = new JLabel("Name 1", 0);
    	    labels811[i].setOpaque(true);
    	    labels811[i].setBounds(5, 430, 150, 30);   
    	    labels811[i].setBackground(ctop);
    	    labels811[i].setForeground(c2);
    	    
    	    // TextField-"NAME 1" //
    	    textField811[i] = new JTextField(30);
    	    textField811[i].setBounds(165, 430, 200, 30);
    	    textField811[i].setOpaque(true);
    	    textField811[i].setBackground(c1);
    	    textField811[i].setForeground(Color.white);
    	    textField811[i].setBorder(line);
    	    /*
    	    String name1 = collectedArrayList.get(4);
    	    String[] namePart1 = name1.split(":");
    	    textField811.setText(namePart1[1]);
    	    */
    	    textField811[i].setText(collectedArrayList.get(5));
    	   
    	    // TextField-"PRICE FOR NAME 1" //
    	    textField812[i] = new JTextField("0");
    	    textField812[i].setBounds(375, 430, 200, 30);
    	    textField812[i].setOpaque(true);
    	    textField812[i].setBackground(c1);
    	    textField812[i].setForeground(Color.white);
    	    textField812[i].setBorder(line);
    	    /*
    	    String price1 = collectedArrayList.get(7);
    	    String[] pricePart1 = price1.split(":");
    	    textField812.setText(pricePart1[1]);
    	    */
    	    textField812[i].setText(collectedArrayList.get(8));
    	   
    	    // TextField-"SEATS FOR NAME 1" //
    	    textField813[i] = new JTextField("0");
    	    textField813[i].setBounds(585, 430, 200, 30);
    	    textField813[i].setOpaque(true);
    	    textField813[i].setBackground(c1);
    	    textField813[i].setForeground(Color.white);
    	    textField813[i].setBorder(line);
    	    /*
    	    String places1 = collectedArrayList.get(10);
    	    String[] placesPart1 = places1.split(":");
    	    textField813.setText(placesPart1[1]);
    	    */
    	    textField813[i].setText(collectedArrayList.get(11));
    	   
    	    // *** NAME 2 *** //
    	    // Label-"NAME 2" //
    	    labels821[i] = new JLabel("Name 2", 0);
    	    labels821[i].setOpaque(true);
    	    labels821[i].setBounds(5, 465, 150, 30);  
    	    labels821[i].setBackground(ctop);
    	    labels821[i].setForeground(c2);
    	    
    	    // TextField-"NAME 2" //
    	    textField821[i] = new JTextField(30);
    	    textField821[i].setBounds(165, 465, 200, 30);
    	    textField821[i].setOpaque(true);
    	    textField821[i].setBackground(c1);
    	    textField821[i].setForeground(Color.white);
    	    textField821[i].setBorder(line);
    	    /*
    	    String name2 = collectedArrayList.get(5);
    	    String[] namePart2 = name2.split(":");
    	    textField821.setText(namePart2[1]);
    	    */
    	    textField821[i].setText(collectedArrayList.get(6));
    	  
    	    // TextField-"PRICE FOR NAME 2" //
    	    textField822[i] = new JTextField("0");
    	    textField822[i].setBounds(375, 465, 200, 30);
    	    textField822[i].setOpaque(true);
    	    textField822[i].setBackground(c1);
    	    textField822[i].setForeground(Color.white);
    	    textField822[i].setBorder(line);
    	    /*
    	    String price2 = collectedArrayList.get(8);
    	    String[] pricePart2 = price2.split(":");
    	    textField822.setText(pricePart2[1]);
    	    */
    	    textField822[i].setText(collectedArrayList.get(9));
    	    
    	    // TextField-"SEATS FOR NAME 2" //
    	    textField823[i] = new JTextField("0");
    	    textField823[i].setBounds(585, 465, 200, 30);
    	    textField823[i].setOpaque(true);
    	    textField823[i].setBackground(c1);
    	    textField823[i].setForeground(Color.white);
    	    textField823[i].setBorder(line);
    	    /*
    	    String places2 = collectedArrayList.get(11);
    	    String[] placesPart2 = places2.split(":");
    	    textField823.setText(placesPart2[1]);
    	    */
    	    textField823[i].setText(collectedArrayList.get(12));
    	    
    	    // *** NAME 3 *** //
    	    // Label-"NAME 3" //
    	    labels831[i] = new JLabel("Name 3", 0);
    	    labels831[i].setOpaque(true);
    	    labels831[i].setBounds(5, 500, 150, 30);     
    	    labels831[i].setBackground(ctop);
    	    labels831[i].setForeground(c2);
    	                   
    	    // TextField-"NAME 3" //
    	    textField831[i] = new JTextField(30);
    	    textField831[i].setBounds(165, 500, 200, 30);
    	    textField831[i].setOpaque(true);
    	    textField831[i].setBackground(c1);
    	    textField831[i].setForeground(Color.white);
    	    textField831[i].setBorder(line);
    	    /*
    	    String name3 = collectedArrayList.get(6);
    	    String[] namePart3 = name3.split(":");
    	    textField831.setText(namePart3[1]);
    	    */
    	    textField831[i].setText(collectedArrayList.get(7));
    	   
    	    // TextField-"PRICE FOR NAME 3" //
    	    textField832[i] = new JTextField("0");
    	    textField832[i].setBounds(375, 500, 200, 30);
    	    textField832[i].setOpaque(true);
    	    textField832[i].setBackground(c1);
    	    textField832[i].setForeground(Color.white);
    	    textField832[i].setBorder(line);
    	    /*
    	    String price3 = collectedArrayList.get(9);
    	    String[] pricePart3 = price3.split(":");
    	    textField832.setText(pricePart3[1]);
    	    */
    	    textField832[i].setText(collectedArrayList.get(10));
    	   
    	    
    	    // TextField-"SEATS FOR NAME 3" //
    	    textField833[i] = new JTextField("0");
    	    textField833[i].setBounds(585, 500, 200, 30);
    	    textField833[i].setOpaque(true);
    	    textField833[i].setBackground(c1);
    	    textField833[i].setForeground(Color.white);
    	    textField833[i].setBorder(line);
    	    /*
    	    String places3 = collectedArrayList.get(12);
    	    String[] placesPart3 = places3.split(":");
    	    textField833.setText(placesPart3[1]);
    	    */
    	    textField833[i].setText(collectedArrayList.get(13));
    	    
    	    /* IMPORTANT FOR VERDATACOMPLETE
    	    String place1_name1 = placeList.get(0) + "_name1_" + textField811[0].getText();
    	    String place1_name1_price = placeList.get(0) + "_name1_" + textField812[0].getText();
    	    String place1_name1_seats = textField813[0].getText();
    	    String place1_name2 = placeList.get(0) + "_name2_" + textField821[0].getText();
    	    String place1_name2_price = placeList.get(0) + "_name2_" + textField822[0].getText();
    	    String place1_name2_seats = textField823[0].getText();
    	    String place1_name3 = placeList.get(0) + "_name3" + textField831[0].getText();
    	    String place1_name3_price = placeList.get(0) + "_name3_" + textField832[0].getText();
    	    String place1_name3_seats = textField833[0].getText();
    	   */
    	    
    	    
    	    
    	    /*
    	    nextButtons[i] = new JButton("Next Event");
    	    nextButtons[i].setBounds(160,500, 150, 30);
    	    nextButtons[i].setBackground(c1);
    	    nextButtons[i].setForeground(Color.white);
    	    nextButtons[i].addActionListener(new ActionListener() {
    	    	
    	    	
    	    	
    	    	 
    	        public void actionPerformed(ActionEvent e) {
    	        	
    	            new EventPreviewFrame12(sizeOfPlaceList ,collectedArrayList, placeList, dateList, timeList, currentPath1);
    	        	
    	        }
    	        
    	    });
    	    
    	    backButtons[i] = new JButton("Back//Close");
    	    backButtons[i].setBounds(315,500, 150, 30);
            backButtons[i].setBackground(c1);
    	    backButtons[i].setForeground(Color.white);
    	    backButtons[i].addActionListener(new ActionListener() {
    	    	
    	    	
    	        public void actionPerformed(ActionEvent e) {
    	        	
    	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButtons[i]); 
    	            frames[i].add(panels[i]);
    	            frames[i].setVisible(false);
    	            
    	        }
    	        
    	    });
    	    */
    	    JButton saveButton = new JButton("Save this Data");
    	    
    	    saveButton.setBounds(5,535, 150, 30);
            saveButton.setBackground(c1);
    	    saveButton.setForeground(Color.white);
    	    saveButton.addActionListener(new SaveButtonListener(frames[i]) {
    		/*
	    	 * öffnet ein neues Fenster, in dem der User die Beschreibung der Veranstaltung schreiben kann.
	    	 * Von hier aus kann diese ggf. korrigiert werden. 
	    	 */
			@Override
			public void actionPerformed(ActionEvent e) {
				//VerDataComplete = VariablenHandler.CollectAndSaveMatrixList(collectedArrayList, placeList, dateList, timeList);
				//System.out.println(VerDataComplete);
				 // Sammeln Sie die Texte aus allen JTextFields in einer 2D-ArrayList
		        ArrayList<ArrayList<String>> allTexts = collectAllTextsFromFrames(frames);
		        System.out.println(allTexts);
		        System.out.println(currentPath1);
				//SaveData.SaveDataOnServer(VerDataComplete, currentPath1);
				SaveData.SaveDataOnServer(allTexts, currentPath1);
			}
			
			});
    	    
    	    JButton closeButton = new JButton("Close this Frame");
            closeButton.addActionListener(new CloseButtonListener(frames[i]));
            closeButton.setBounds(160,535, 150, 30);
            closeButton.setBackground(c1);
    	    closeButton.setForeground(Color.white);
    	    
    	    JButton closeAllButton = new JButton("Close All Frames");
    	    closeAllButton.addActionListener(new CloseAllButtonListener(frames));
    	    closeAllButton.setBounds(315,535, 150, 30);
    	    closeAllButton.setBackground(c1);
    	    closeAllButton.setForeground(Color.white);
    	    
    	    // *** COMPLETE ALL COMPONENTS *** //
    	    panels[i].add(labels[i]);
    	    panels[i].add(labels0[i]);
    	    panels[i].add(textField0[i]);
    	    panels[i].add(labels1[i]);
    	    panels[i].add(textField1[i]);
    	    panels[i].add(labels2[i]);
    	    panels[i].add(textField2[i]);
    	    panels[i].add(labels3[i]);
    	    panels[i].add(textField3[i]);
    	    panels[i].add(labels4[i]);
    	    panels[i].add(textField4[i]);
    	    panels[i].add(labels5[i]);
    	    panels[i].add(textField5[i]);
    	    panels[i].add(labels6[i]);
    	    panels[i].add(textField6[i]);
    	    panels[i].add(labels7[i]);
    	    panels[i].add(labels9[i]);
    	    panels[i].add(textField9[i]);
    	    panels[i].add(labels812[i]);
    	    panels[i].add(labels813[i]);
    	    panels[i].add(labels811[i]);
    	    panels[i].add(textField811[i]);
    	    panels[i].add(textField812[i]);
    	    panels[i].add(textField813[i]);
    	    panels[i].add(labels821[i]);
    	    panels[i].add(textField821[i]);
    	    panels[i].add(textField822[i]);
    	    panels[i].add(textField823[i]);
    	    panels[i].add(labels831[i]);
    	    panels[i].add(textField831[i]);
    	    panels[i].add(textField832[i]);
    	    panels[i].add(textField833[i]);
    	    
    	    panels[i].add(saveButton);
            panels[i].add(closeButton);
            panels[i].add(closeAllButton);
            panels[i].setVisible(true);
            
            frames[i].add(panels[i]);
            frames[i].setVisible(true);
            
        } // END OF FOR_LOOP

        /*
        panel1.setBackground(c2);
        panel1.setBounds(0, 0, 800, 600);
        panel1.setLayout(null);
        
        labelworkcreate = new JLabel("Preview view");
        //labelworkcreate.setOpaque(true);
        labelworkcreate.setBounds(5,5,150,30);
        labelworkcreate.setBackground(ctop);
        labelworkcreate.setForeground(cwhite);
        labelworkcreate.setLayout(null);
        
        frames[0].add(labelworkcreate);
        frames[0].add(panel1);
        panel1.setVisible(true);
        frames[0].setVisible(true);
        
        panel2.setBackground(c2);
        panel2.setBounds(0, 0, 800, 600);
        panel2.setLayout(null);
        frames[1].add(panel2);
        panel2.setVisible(true);
        frames[1].setVisible(true);
        */
        
       
        /*
        // Ausgabe der gesammelten Texte
        for (int i = 0; i < allTexts.size(); i++) {
            System.out.println("Frame " + (i + 1) + " Texte:");
            ArrayList<String> textsInFrame = allTexts.get(i);
            for (String text : textsInFrame) {
                System.out.println(text);
            }
        }
        */
    }
	
	public static ArrayList<ArrayList<String>> collectAllTextsFromFrames(JFrame[] frames) {
        ArrayList<ArrayList<String>> allTexts = new ArrayList<>();
        for (JFrame frame : frames) {
            ArrayList<String> textsInFrame = new ArrayList<>();
            collectTextsFromContainer(frame.getContentPane(), textsInFrame);
            allTexts.add(textsInFrame);
        }
        return allTexts;
    }

    private static void collectTextsFromContainer(Container container, ArrayList<String> texts) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                texts.add(textField.getText());
            } else if (component instanceof Container) {
                collectTextsFromContainer((Container) component, texts);
            }
        }
    }
	
	public void shortStrings(ArrayList<String> list) {
	    List<String> updateList = new ArrayList<>();
	    for (String tempString : list) {
	        String[] arrayStrings = tempString.split(":");
	        if (arrayStrings.length >= 2) {
	            updateList.add(arrayStrings[1].trim());
	        } else {
	            // Wenn der String nicht im erwarteten Format ist, einfach den ursprünglichen String hinzufügen
	            updateList.add(tempString);
	        }
	    }

	    list.clear();
	    list.addAll(updateList);
	}
	
	public static ArrayList<ArrayList<String>>[] createArrayOf2DLists(int numberOfFrames) {
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<String>>[] arrayOf2DLists = new ArrayList[numberOfFrames];
		String[] listNameStrings = new String[numberOfFrames];
		
		for(int i = 0; i < numberOfFrames; i++) {
			arrayOf2DLists[i] = new ArrayList<ArrayList<String>>(); 
			listNameStrings[i] = "List " + (i+1); 
		}
		return arrayOf2DLists;
	}
	
	public void updateListData(String listName, ArrayList<String> data) {
	    // Finde die Liste anhand des Namens im listNames-Array
	    int index = -1;
	    for (int i = 0; i < listNameString.length; i++) {
	        if (listNameString[i].equals(listName)) {
	            index = i;
	            break;
	        }
	    }

	    // Wenn die Liste mit dem gegebenen Namen gefunden wurde, aktualisiere die Daten
	    if (index >= 0) {
	        ArrayList<ArrayList<String>>[] arrayOf2DLists = createArrayOf2DLists(counterFrame);
	        arrayOf2DLists[index].clear();
	        arrayOf2DLists[index].add(data);
	    } else {
	        // Wenn die Liste nicht gefunden wurde, kannst du eine Fehlerbehandlung durchführen
	        System.out.println("Liste mit dem Namen \"" + listName + "\" wurde nicht gefunden.");
	    }
	}

	
    static class SaveButtonListener implements ActionListener {
    	private JFrame frame;
    	public SaveButtonListener(JFrame frame) {
    		this.frame = frame;
    	}
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		
    		frame.dispose();
    	}
    }
    
    static class CloseButtonListener implements ActionListener {
        private JFrame frame;
        public CloseButtonListener(JFrame frame) {
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
    
    static class CloseAllButtonListener implements ActionListener {
    	private JFrame[] frames;
    	public CloseAllButtonListener(JFrame[] frames2) {
    		this.frames = frames2; 
    	}
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		for(JFrame frame : frames) {
    			frame.dispose();
    		}
    	}
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == saveButton) {
			
			
		}
		if(e.getSource() == closeButton) {
			
			frame.dispose();
		}
		if(e.getSource() == closeButton) {
			
		}
		
	}
}
