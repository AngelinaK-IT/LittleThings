package TopPackage;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import Language.LanguageModul_English;
import Language.LanguageModul_France;
import Language.LanguageModul_German;

public class BuyWithoutRegistration extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private GroupLayout layout; // Füge diese Zeile hinzu
    private GroupLayout.SequentialGroup vGroup; // defines the vertical layout
    private GroupLayout.ParallelGroup hGroup; // defines the horizontal layout
    
    private ActionListener actionListener;
    private ActionListener actionListener2;
    
    private static JRadioButton percentDiscountStudentButton;
    private static JRadioButton percentDiscountSocialButton;
    private static JRadioButton percentDiscountFamilyButton;
    private static ButtonGroup buttonGroup;
    private static JLabel percentDiscountStudentLabel;
    private static JLabel percentDiscountSocialLabel;
    private static JLabel percentDiscountFamilyLabel;
    private static JTextField percentDiscountStudentField;
    private static JTextField percentDiscountSocialField;
    private static JTextField percentDiscountFamilyField;
    private static JTextField completeSCPriceField;
    private static JTextField nettoSCPriceField;
    private static JLabel currencyLabelGross;
    private static JLabel currencyLabelNet;
    private static JLabel taxcurrencyLabelNet;
    private static JLabel finalcurrencyLabelNet; 
    private static JLabel taxLabel;
    private static JTextField taxField;
    private static JTextField taxEndPriceField;
    private static JTextField finalEndPriceField;
    private static JLabel finalLabel;
    private static JPanel warenKorbPanel;
    
    private static int CounterStart = 1; 
    private static int counter = 0;
    private static int maxOfTicketsSC = 20;
    private static int maxQuantityOfPlaces = 10;
    private static double tempEndPrice;
    private static String endSumString; 
    
    private static int SCMatrix[][] = new int[maxQuantityOfPlaces][maxOfTicketsSC];
    
    private static List<JTextField> endPriceFieldsList;
    private static List<List<JTextField>> complPriceFieldList;
    private static List<EntryPanelA> entryPanelsList;
    
    private static BuyWithoutRegistration panelArray[] = new BuyWithoutRegistration[maxOfTicketsSC];
    
    //private static List<BuyWithoutRegistration> registrationsList;
    
	// *** FRAME ELEMENTS *** //
	JFrame frame = null;
	JLabel label, label2 = new JLabel();
	JPanel panel = new JPanel();
	JMenuBar mbar, mbar2 = new JMenuBar();
	JScrollPane scroller = new JScrollPane();
	JScrollPane warenkorb = new JScrollPane();
	JScrollPane article = new JScrollPane();
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem engItem, gerItem, frenItem;
	JButton an, re, be, deleteButton, reButton;
	
	// *** FUNCTION *** //
	BufferedReader reader;
	
	boolean found = false;
	int foundIndex = -1;
	
	String status = "ausverkauft";
	String status2 = "abgesagt";
	String gastString = "Gast";
	
	// *** COLOR VARIABLES *** // 
	static Color c1 = new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	// *** LINES *** //
	static LineBorder line = new LineBorder(c2, 1, true);
	
	// *** STRING ARRAYS *** //
	String[] values;
	String[] kindOfEvent = {"Messe", "Konzert", "Oper", "Open-Air Festival"};
	
	//static JList<String> shopping_cartList;
	//static DefaultListModel<String> listModel = new DefaultListModel<>();
	//JList<QuantityPanel> quantity_List;
	//List<QuantityPanel> listModel2 = new ArrayList<>();
	
	static String filenameString = Paths.get("src//TopPackage//verantstaltung_funfactory.csv").toAbsolutePath().toString();
	static String filenameString2 = Paths.get("src//TopPackage//verantstaltung_funfactory2.csv").toAbsolutePath().toString();
	static String filenameString3 = Paths.get("src\\Server\\Veranstaltungen\\00001_Lego\\00001-Lego.CSV").toAbsolutePath().toString();
	static String currWorkPathString5 = PathHandler.complWorkServerVerPath2.resolve(Paths.get("00019_CSD")).resolve("00019-CSD.CSV").toString();
	//static String fileName = "C:\\Users\\angel\\eclipse-workspace\\Java Tutorial\\src\\verantstaltung_funfactory.csv";
	//static String fileName2 = "C:\\Users\\angel\\eclipse-workspace\\Java Tutorial\\src\\verantstaltung_funfactory2.csv";
	public static ArrayList<String> tempAppStartArrayList = LanguageModul_English.getAppStartLanguage();
	public static ArrayList<String> tempRegList = LanguageModul_English.getRegLanguage();
	
	// *** MAIN FOR TESTS *** //
	public static void main(String[] args){
		BuyWithoutRegistration kaufen = new BuyWithoutRegistration();
		kaufen.GUIBuyWithoutRegistration(tempAppStartArrayList, tempRegList);
	}
	// *** END MAIN *** //
	
	/***********
	 *** GUI ***
	 ***********/
	/* 
	 * GUI Aussehen beim KaufenOhneReg
	 * 
	 * Im Linken Teil wird dem Kunden die gesammte �bersicht in einem BaumModel angezeigt.
	 * Beim Anklicken eines der Daten innerhalbt der DatenStruktur wird eine Visuelle Ansicht angezeigt von dem Veranstaltungsraum.
	 * Wurden pl�tze innerhalb der Ansicht markiert und �ber den Button "Zum Warenkorb hinzuf�gen", werden diese im rechten Teil(Warenkorb)
	 * wie eben beschrieben hinzugef�gt.
	 */
	public void GUIBuyWithoutRegistration(ArrayList<String> tempAppStart, ArrayList<String> regList) {
		
		// *** FRAME *** //
		frame = new JFrame ("Ultimate-events");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(815,700);					
		frame.setLocationRelativeTo(null);
		frame.add(scroller);
		frame.add(panel);
		//frame.setResizable(false);
		
		// *** PANEL *** //
		panel.setBackground(c2);
		panel.setLayout(null);
		
		// *** LANGUAGE_MENUBAR *** //
		menuBar = new JMenuBar();
		fileMenu = new JMenu(tempAppStart.get(0));
		engItem = new JMenuItem(tempAppStart.get(1));
		gerItem = new JMenuItem(tempAppStart.get(2));
		frenItem = new JMenuItem(tempAppStart.get(3));
	
        engItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
       
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
		// *** END OF LANGUAGE_MENUBAR *** // 
		
		/*****************
		 *** TOP LABEL ***
		 *****************/
		label = new JLabel("Guten Tag " + gastString, SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBounds(0,0,800,30);
		label.setBackground(ctop);
		label.setForeground(c2);
		
		/**************************************
		 *** LEFT SIDE OF THE SHOPPING CART *** 
		 **************************************/
		// *** LEFT _ TOP *** //
		// *** LOGIN BUTTON *** //
		an = new JButton("Anmeldung");
		an.setBounds(45, 80, 400, 30);
		an.setOpaque(true);
		an.addActionListener(this);
			    
		// *** REGISTRATION BUTTON *** //
		re = new JButton("Registrierung");
		re.setBounds(45, 160, 400, 30);
		re.setOpaque(true);
		re.addActionListener(this);
		
		// *** MENUBAR *** //
		mbar = new JMenuBar();
		mbar.setBounds(0, 30, 250, 30);
		mbar.setLayout(new GridLayout());
		mbar.add(re);
		mbar.add(an);
		mbar.setBackground(c2);
		mbar.setVisible(true);
		//mbar.setLayout(null);
		
		// *** LEFT _ MIDDLE *** //
		// *** SCROLLER FOR JTREE *** //
		scroller.setBackground(c2);
		scroller.setLayout(null);
		
		// *** INITIALISIERUNG *** //
        panelArray = new BuyWithoutRegistration[maxOfTicketsSC];
        complPriceFieldList = new ArrayList<>();
        
        String price = "0";
		int i = CounterStart;
		
		for (int t = 0; t < panelArray.length; t++) {
			
			panelArray[t] = new BuyWithoutRegistration();
        	panelArray[t].setName("Artikel_" + (t+1)); 
        	panelArray[t].addEntryPanel("Artikel_" + (t+1), "Artikel_" + (t+1), i, price);
        	List<JTextField> endPriceFieldsList = panelArray[t].getEndPriceFieldsList();
        	complPriceFieldList.add(endPriceFieldsList);
        	
		}
		 
		// *** SHOPPING CART PANEL *** //
		warenKorbPanel = new JPanel();
	    warenKorbPanel.setBackground(Color.gray);
        warenKorbPanel.setLayout(new BoxLayout(warenKorbPanel, BoxLayout.Y_AXIS));
        
		// *** CREATE THE JTREE *** //
		//TreeNode root = createTree();
		//JTree tree = new JTree(root);
		DefaultMutableTreeNode dataTree = BuildSubTree(filenameString2);
		DefaultMutableTreeNode dataTree2 = BuildSubTree2(filenameString);
		DefaultMutableTreeNode dataTree3 = BuildSubTree3(filenameString3);
		DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode("Veranstaltungsübersicht");
		rootTreeNode.add(dataTree);
		rootTreeNode.add(dataTree2);
		rootTreeNode.add(dataTree3);
		JTree tree = new JTree(rootTreeNode);
		
		/*
		// Extrahiere Informationen aus dem ausgew�hlten Knoten
        if (selectedNode != null) {
        	String nodeText = selectedNode.getUserObject().toString();
		}

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath[] selectedPaths = tree.getSelectionPaths();
                if (selectedPaths != null) {
                    for (TreePath path : selectedPaths) {
                        // LAST ELEMENT SELECTED IN TREEPATH
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                        String selectedElement = selectedNode.toString();
                        listModel.addElement(selectedElement);
                    }
                }
            }
        });
        
        // Baum-Selektionsereignis-Listener
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = e.getPath();
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                String pathString = pathToString(path);
                System.out.println("Path als String: " + pathString);
                String[] pathElements = pathString.split("/");
                for (String element : pathElements) {
                	System.out.println("Element: " + element);
                }
                // Extrahiere Informationen aus dem ausgew�hlten Knoten
                if (selectedNode != null) {
                    String nodeText = selectedNode.getUserObject().toString();
                    System.out.println("Ausgew�hlter Knoten: " + nodeText);
                    listModel.addElement(nodeText);
                    // Sie k�nnen weitere Informationen aus dem ausgew�hlten Knoten extrahieren,
                    // wenn der Knoten benutzerdefinierte Daten enth�lt.
                    // Beispiel: String selectedElement = selectedNode.getUserObject().getSomeProperty();
                }
            }
        });
        */
        
        // Ein ActionListener hinzuf�gen, um den ausgew�hlten TreeNode zu extrahieren und zum Warenkorb hinzuzuf�gen
        tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				
				TreePath path = e.getPath();
            
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
				String pathString = pathToString(path);
				
                System.out.println("Path als String: " + pathString); 
                
                /*
                String[] pathElements = pathString.split("/");
                
                for (String element : pathElements) {
                	System.out.println("Element: " + element);
                }
                */
                
                // Extrahiere Informationen aus dem ausgewählten Knoten
                if (selectedNode != null) {
                    String nodeText = selectedNode.getUserObject().toString();
                    System.out.println("Ausgewählter Knoten: " + nodeText);
                    
                    // NOT CURRENT WORKING 
                    String searchingString1 = "Messe";
                    String searchingString2 = "Festival";
                    String searchingString3 = "Konzert";
                    if (searchingString1.equals(nodeText)) {
                    	
                    } else if(searchingString2.equals(nodeText)) {
                    	
                    } else if(searchingString3.equals(nodeText)) {
                    	openConcertScreenCustomer();
                    }
                    
                    //listModel.addElement(nodeText);
                    // Sie können weitere Informationen aus dem ausgewählten Knoten extrahieren,
                    // wenn der Knoten benutzerdefinierte Daten enthält.
                    // Beispiel: String selectedElement = selectedNode.getUserObject().getSomeProperty();
                }
                
				//String pathString = pathToString(path);
				//System.out.println("Path als String: " + pathString);

				// Splitten des Pfads
                /*
				String[] pathElements = pathString.split("/");
				
            	for (String element : pathElements) {
            		if (element.equals(status)) {
            			found = true;
            			JOptionPane.showMessageDialog(null, "Event is sold-out.", "Warnung", JOptionPane.PLAIN_MESSAGE);
            			//System.out.println("Element: " + element);
            		} else if (element.equals(status2)) {
            			found = true;
            			JOptionPane.showMessageDialog(null, "Event is canceled.", "Warnung", JOptionPane.PLAIN_MESSAGE);
            		} else {
            	}
            	*/
            		
				/* WORKS
            	if (selectedNode.isLeaf()) {
            		String leafText = selectedNode.toString();
            		String[] info = leafText.split(":\\s+"); // Hier k�nnen Sie den Text des Blattknotens analysieren und Informationen extrahieren
            		if (info.length >= 6) { // Beispielhaft angenommen, dass es drei Teile im Text gibt (Sie k�nnen dies entsprechend Ihren Daten anpassen)
            			String item = info[0];
            			String platz = info[1];
            			String quantity = info[3];
            			String zone = info[4];
            			//int quantity = Integer.parseInt(info[1]);
            			String price = info[5];
            			
                            
            			// Hier k�nnen Sie das ausgew�hlte Element zum Warenkorb hinzuf�gen oder weitere Aktionen durchf�hren
            			addToShoppingCart(item, platz, quantity, zone, price);
            			 System.out.println("Element zum Warenkorb hinzugef�gt: " + item + ", Art der Plaetze: " + platz + ", Anzahl: " + quantity + zone + ", Preis: " + price);
            			//String selectedElement = Double.toString(price) + Integer.toString(quantity); 
            			//listModel.addElement(selectedElement);
            		}
            	}  
            	*/    
            	
            	if (selectedNode.isLeaf()) {
            		
            		String leafText = selectedNode.toString();
            		String[] splitbyColon = leafText.split(":\\s+"); // Hier k�nnen Sie den Text des Blattknotens analysieren und Informationen extrahieren
            		List<String> resultList = new ArrayList<>();
            		System.out.println("ResultList PRINT 1: " + resultList);
            		
            		for (String partString : splitbyColon) {
            			
            			String[] splitBySlash = partString.split("/");
            			System.out.println(partString);
            			Collections.addAll(resultList, splitBySlash);
            			/*
            			for(String part : splitBySlash) {
            				System.out.println(part);
            			}
            			*/
            		}
            		
            		System.out.println("ResultList PRINT 2: " + resultList);
            		
            		if (resultList.size() >= 6) { // Beispielhaft angenommen, dass es drei Teile im Text gibt (Sie k�nnen dies entsprechend Ihren Daten anpassen)
            			
            			String item = resultList.get(0)+"_ticket";
            			String quantityPlaces = resultList.get(2);
            			//int quantity = Integer.parseInt(resultList.get(5);
            			String price = resultList.get(5);
            			
            			int i = CounterStart-1;
            			
            			System.out.println("------------------------------");
            			System.out.println("TEST FOR SINGLE ELEMENTS: ");
            			System.out.println("CURRENT ITEM: " + item);
            			System.out.println("QUANTITY PLACES: " + quantityPlaces);
            			System.out.println("CURRENT PRICE: " + price);
            			System.out.println("COUNTERSTART == i: " + CounterStart + "==" + i);
            			System.out.println("PANEL NAME ORIGNAL: " + panelArray[i].getName());
            			
            			
            			String priceDoubleString = price.replaceAll("[€$¥£]", "");
            			System.out.println("PRICE WITHOUT CURRENCY: " +priceDoubleString);
            			System.out.println("END OF TEST");
            			System.out.println("------------------------------");
            			
            			//QuantityPanel panel = new QuantityPanel(foundIndex);
            			//addToShoppingCart(item, quantityPlaces, price);
            			//quantityPanel panelToAddPanel = new quantityPanel();
            	        //list.addElement(panelToAddPanel);
            			//quantity_List.setCellRenderer(new CustomPanelRenderer());
            			//quantity_List.add(new QuantityPanel(foundIndex));
            			//quantity_List.repaint();
            			
            			//<html>Zone: " + item + "<br>Anzahl: " + quantity + ", Preis/ticket: " + price + "</html>
            			//BuyWithoutRegistration panel = new BuyWithoutRegistration();
            			//addEntryPanel(String name, String entry, int counter, String price)
            			//panel.setName(articleName);
            			//panel.addEntryPanel(item, articleName, i, price);
            			//panelArray[CounterStart-1].addEntryPanel(quantityPlaces, price,i);
            			//CounterStart--;
            			//panelArray[i].add(panel);
            			//panelArray[CounterStart].add(panel); 
            			
            			
            			
            			panelArray[i] = new BuyWithoutRegistration();
                    	panelArray[i].setName("Artikel_" + (counter+1)); 
                    	panelArray[i].addEntryPanel("ArtikelItem_" + (counter+1), item, CounterStart, priceDoubleString);
            			
                    	System.out.println("PANEL NAME AFTER REWRITE: " + panelArray[counter].getName());
                    	
                    	counter++;
                    	
            			warenKorbPanel.add(panelArray[i]);
            			List<JTextField> endPriceFieldsList = panelArray[i].getEndPriceFieldsList();
                    	System.out.println("TREE -> endpriceFieldList.get(" + i + "::" + endPriceFieldsList.get(i).getText());
            			complPriceFieldList.add(endPriceFieldsList);
            			
            			for(JTextField field : endPriceFieldsList) {
            				field.getText();
            			}
                        
                        System.out.println("INSIDE JTREELISTENER: " + endSumString);
                        
                        System.out.println("-----------------------------");
                		System.out.println("TEST->JTREE LISTENER");
                		for(List<JTextField> textField : complPriceFieldList) {
                			for(JTextField subfieldField : textField) {
                				System.out.println("complPriceFieldsList: " + subfieldField.getText());
                			}
                		}
                		
                		for(JTextField subfieldField : endPriceFieldsList) {
                			System.out.println("endPriceFieldsList: " + subfieldField.getText());
                		}
                		System.out.println("-----------------------------");
                        
                        refresh();
                    	updateTree();
                    	
                    	
                    	
            			//BuyWithoutRegistration panel1 = new BuyWithoutRegistration();
            			//panel1.addEntryPanel(item, price, i);
            			//registrationsList.add(panel);
            			//warenKorbPanel.add(registrationsList.get(i));  
            			//warenKorbPanel.add(panelArray[CounterStart-1]);
            			//List<JTextField> endPriceFieldsList = registrationsList.get(i).getEndPriceFields();
            			
            			//String selectedElement = Double.toString(price) + Integer.toString(quantity); 
            			//listModel.addElement(selectedElement);
                    	
            			/*
            			if (panelArray[CounterStart-1] != null) {
            			    warenKorbPanel.add(panelArray[CounterStart-1]);
            			    List<JTextField> endPriceFieldsList = panelArray[CounterStart-1].getEndPriceFields();
            			    complPriceFieldList.add(endPriceFieldsList);
            			    CounterStart++;
            			    updateTree();
            			} else {
            			    System.err.println("Panel ist null.");
            			}
            			if (panelArray[CounterStart-1] instanceof BuyWithoutRegistration) {
            			    // Es ist eine Instanz von BuyWithoutRegistration
            			    warenKorbPanel.add(panelArray[CounterStart-1]);
            			    List<JTextField> endPriceFieldsList = panelArray[CounterStart-1].getEndPriceFields();
            			    complPriceFieldList.add(endPriceFieldsList);
            			    CounterStart++;
            			    updateTree();
            			} else {
            			    System.err.println("Panel ist keine Instanz von BuyWithoutRegistration.");
            			}
            			*/
            		}
            	}        
			}
        });
         
        /*
        // Baum-Selektionsereignis-Listener
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = e.getPath();
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                String pathString = pathToString(path);
                System.out.println("Path als String: " + pathString);
                String[] pathElements = pathString.split("/");
                for (String element : pathElements) {
                	System.out.println("Element: " + element);
                }
                // Extrahiere Informationen aus dem ausgewählten Knoten
                if (selectedNode != null) {
                    String nodeText = selectedNode.getUserObject().toString();
                    System.out.println("Ausgewählter Knoten: " + nodeText);
                    listModel.addElement(nodeText);
                    // Sie können weitere Informationen aus dem ausgewählten Knoten extrahieren,
                    // wenn der Knoten benutzerdefinierte Daten enthält.
                    // Beispiel: String selectedElement = selectedNode.getUserObject().getSomeProperty();
                }
            }
        });
        */
        
        // *** LEFT _ DOWN *** //
		scroller = new JScrollPane(tree);
		scroller.setBounds(0,60,350,450);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		/**********************************
		 *** RIGHT SIDE OF SHOPPINGCART *** 
		 **********************************/
		// *** RIGHT _ TOP *** //
		// *** LABEL2 *** //
		label2 = new JLabel("Your currently Shopping cart", SwingConstants.LEFT);
		label2.setBounds(365,30,200,30);
		label2.setBackground(cwhite);
		label2.setForeground(cwhite);
		
		// *** DELETE BUTTON *** //
		deleteButton = new JButton("Delete content");
		deleteButton.setBounds(630, 0, 100, 30);
		deleteButton.setOpaque(true);
		deleteButton.addActionListener(this);
		
		// *** MENUBAR2 *** //
		mbar2 = new JMenuBar();
		mbar2.setBounds(650, 30, 150, 30);
		mbar2.add(deleteButton);
		mbar2.setBackground(c2);
		mbar2.setVisible(true);
		mbar2.setLayout(new GridLayout());
		
		// *** RIGHT _ MIDDLE *** //
		// *** SHOPPING CART *** //
		warenkorb = new JScrollPane(warenKorbPanel);
		warenkorb.setBounds(355,60,445,250);
		warenkorb.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		warenkorb.setBackground(c2);
		warenkorb.setBackground(ctop);
		
		/*
		JList<QuantityPanel> quantity_List;
		List<QuantityPanel> listModel2 = new ArrayList<>();
		
		listModel2 = new ArrayList<>();
		quantity_List = new JList<>(listModel2.toArray(new QuantityPanel[0]));
		
		article = new JScrollPane(quantity_List);
		article.setBounds(575,60,225,250);
		article.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		article.setBackground(c2);
		article.setBackground(ctop);
		*/
		
		// *** PERCENT DISCOUNT STUDENT BUTTON *** //
        percentDiscountStudentButton = new JRadioButton();
        percentDiscountStudentButton.setBounds(360,315,20,20);
        percentDiscountStudentButton.setBackground(c2);
        percentDiscountStudentButton.setForeground(Color.white);
        percentDiscountStudentButton.setBorder(line);
        percentDiscountStudentButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                calculateAndSetDiscount();
            }
        });
        percentDiscountStudentLabel = new JLabel("Studentenrabatt");
        percentDiscountStudentLabel.setBounds(385,315,200,20);
        percentDiscountStudentLabel.setBackground(c2);
        percentDiscountStudentLabel.setForeground(Color.white);
        percentDiscountStudentLabel.setBorder(line);
        percentDiscountStudentField = new JTextField("50%");
        percentDiscountStudentField.setBounds(520,315,30,20);
        percentDiscountStudentField.setBackground(c1);
        percentDiscountStudentField.setForeground(Color.white);
        percentDiscountStudentField.setBorder(line);
        percentDiscountStudentField.setEditable(false);
        
        // *** PERCENT DISCOUNT SOCIAL BUTTON *** //
        percentDiscountSocialButton = new JRadioButton();
        percentDiscountSocialButton.setBounds(360,340,20,20);
        percentDiscountSocialButton.setBackground(c2);
        percentDiscountSocialButton.setForeground(Color.white);
        percentDiscountSocialButton.setBorder(line);
        percentDiscountSocialButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                calculateAndSetDiscount();
            }
        });
        percentDiscountSocialLabel = new JLabel("Sozialhilfe Empfänger");
        percentDiscountSocialLabel.setBounds(385,340,200,20);
        percentDiscountSocialLabel.setBackground(c2);
        percentDiscountSocialLabel.setForeground(Color.white);
        percentDiscountSocialLabel.setBorder(line);
        percentDiscountSocialField = new JTextField("25%");
        percentDiscountSocialField.setBounds(520,340,30,20);
        percentDiscountSocialField.setBackground(c1);
        percentDiscountSocialField.setForeground(Color.white);
        percentDiscountSocialField.setBorder(line);
        percentDiscountSocialField.setEditable(false);
        
        // *** PERCENT DISCOUNT FAMILY BUTTON *** //
        percentDiscountFamilyButton = new JRadioButton();
        percentDiscountFamilyButton.setBounds(360,365,20,20);
        percentDiscountFamilyButton.setBackground(c2);
        percentDiscountFamilyButton.setForeground(Color.white);
        percentDiscountFamilyButton.setBorder(line);
        percentDiscountFamilyButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                calculateAndSetDiscount();
            }
        });
        percentDiscountFamilyLabel = new JLabel("Familienrabatt");
        percentDiscountFamilyLabel.setBounds(385, 365, 200,20);
        percentDiscountFamilyLabel.setBackground(c2);
        percentDiscountFamilyLabel.setForeground(Color.white);
        percentDiscountFamilyLabel.setBorder(line);
        percentDiscountFamilyField = new JTextField("15%");
        percentDiscountFamilyField.setBounds(520,365,30,20);
        percentDiscountFamilyField.setBackground(c1);
        percentDiscountFamilyField.setForeground(Color.white);
        percentDiscountFamilyField.setBorder(line);
        percentDiscountFamilyField.setEditable(false);
        
        // WICHTIG -> SchwerEingeschränkt(behindert) B oder 80?
        // Muss noch als Möglichkeit eines Radiobuttons implement werden
        // Seniorenrabatt (ab 65)
        // Kinderrabatt abstufung der Alterstufen je nach Veranstalter
        // FamilienSozialhilfe
        // VORKASSE/SofortÜberweisung für viele Wichtig da keine Kreditkarte oder Paypal vorhanden ist
        // KLeine und große Familienkarte
        // Gruppenpreise -> Kitas, SChulen, Privat
        
        // *** BUTTONGROUP *** //
        buttonGroup = new ButtonGroup();
        buttonGroup.add(percentDiscountSocialButton);
        buttonGroup.add(percentDiscountStudentButton);
        buttonGroup.add(percentDiscountFamilyButton);
        
        // *** PRICEFIELDS *** //
        completeSCPriceField = new JTextField();
        completeSCPriceField.setColumns(5);
        completeSCPriceField.setBounds(705,315,60,20);
        completeSCPriceField.setBackground(c1);
        completeSCPriceField.setForeground(Color.white);
        completeSCPriceField.setBorder(line);
        completeSCPriceField.setEditable(false);
        
        // *** CURRENCY LABEL *** //
        currencyLabelGross = new JLabel("€");
        currencyLabelGross.setBounds(770,315,30,20);
        currencyLabelGross.setBackground(c2);
        currencyLabelGross.setForeground(Color.white);
        currencyLabelGross.setBorder(line);
        
        // *** NET PRICE FIELD *** //
        nettoSCPriceField = new JTextField();
        nettoSCPriceField.setColumns(5);
        nettoSCPriceField.setBounds(705, 340,60,20);
        nettoSCPriceField.setBackground(c1);
        nettoSCPriceField.setForeground(Color.white);
        nettoSCPriceField.setBorder(line);
        nettoSCPriceField.setEditable(false);
        
        // *** CURRENCY LABEL NET *** //
        currencyLabelNet = new JLabel("€");
        currencyLabelNet.setBounds(770,340,30,20);
        currencyLabelNet.setBackground(c2);
        currencyLabelNet.setForeground(Color.white);
        currencyLabelNet.setBorder(line);
    
        // *** TAX PRICE LINE *** //
        taxLabel = new JLabel("Mwst.");
        taxLabel.setBounds(585,365,60,20);
        taxLabel.setBackground(c2);
        taxLabel.setForeground(Color.white);
        taxLabel.setBorder(line);
        
        String currTaxString = "7%";
        taxField = new JTextField(currTaxString);
        taxField.setBounds(665,365,30,20);
        taxField.setBackground(c1);
        taxField.setForeground(Color.white);
        taxField.setBorder(line);
        taxField.setEditable(false);
        
        taxEndPriceField = new JTextField();
        taxEndPriceField.setBounds(705,365,60,20);
        taxEndPriceField.setBackground(c1);
        taxEndPriceField.setForeground(Color.white);
        taxEndPriceField.setBorder(line);
        taxEndPriceField.setEditable(false);
        
        taxcurrencyLabelNet = new JLabel("€");
        taxcurrencyLabelNet.setBounds(770,365,30,20);
        taxcurrencyLabelNet.setBackground(c2);
        taxcurrencyLabelNet.setForeground(Color.white);
        taxcurrencyLabelNet.setBorder(line);
        
        // *** FINAL PRICE NET *** //
        finalLabel = new JLabel("Ihr Endpreis: ");
        finalLabel.setBounds(585,420,150,20);
        finalLabel.setBackground(c2);
        finalLabel.setForeground(Color.white);
        finalLabel.setBorder(line);
        
        finalEndPriceField = new JTextField();
        finalEndPriceField.setBounds(705,420,60,20);
        finalEndPriceField.setBackground(c1);
        finalEndPriceField.setForeground(Color.white);
        finalEndPriceField.setBorder(line);
        finalEndPriceField.setEditable(false);
        
        // *** CURRENCY LABEL NET *** //
        finalcurrencyLabelNet = new JLabel("€");
        finalcurrencyLabelNet.setBounds(770,420,30,20);
        finalcurrencyLabelNet.setBackground(c2);
        finalcurrencyLabelNet.setForeground(Color.white);
        finalcurrencyLabelNet.setBorder(line);
        
		/******************** 
		 *** RIGHT _ DOWN ***
		 ********************/
        // *** REFRESH BUTTON *** //
        reButton = new JButton("Aktualisieren");
        reButton.setBounds(565, 465,200,60);
        reButton.setBackground(cblue);
        reButton.setForeground(Color.white);
        reButton.addActionListener(this);
		
        // *** PAYMENT BUTTON *** //
		be = new JButton("Bezahlen");
		be.setBounds(565,530,200,60); 
		be.setBackground(cblue);
		be.setForeground(Color.WHITE);
		be.addActionListener(this);
		
		// *** ADDING AND CONNECTING SINGLE ELEMENTS *** //
		panel.add(label);
		panel.add(mbar);
		panel.add(scroller);
		panel.add(label2);
		panel.add(mbar2);
		panel.add(warenkorb);
		
		panel.add(percentDiscountStudentButton);
		panel.add(percentDiscountStudentLabel);
		panel.add(percentDiscountStudentField);
		panel.add(percentDiscountSocialButton);
		panel.add(percentDiscountSocialLabel);
		panel.add(percentDiscountSocialField);
		panel.add(percentDiscountFamilyButton);
		panel.add(percentDiscountFamilyLabel);
		panel.add(percentDiscountFamilyField);
		panel.add(completeSCPriceField);
		panel.add(currencyLabelGross);
		panel.add(nettoSCPriceField);
		panel.add(currencyLabelNet);
		
		panel.add(taxLabel);
		panel.add(taxField);
		panel.add(taxEndPriceField);
		panel.add(taxcurrencyLabelNet);
		
		panel.add(finalLabel);
		panel.add(finalEndPriceField);
		panel.add(finalcurrencyLabelNet);
		
		panel.add(reButton);
		panel.add(be);
		
		// *** VISIBILITYS *** //
		panel.setVisible(true);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		
	} 
	// END OF FRAME
	
	/* 
	 * ActionListener Events
	 * 
	 * Hier wird, abhaegig vom Buttondruck auf der Startseite die jeweilige Funktion aufgerufen.
	 * Entweder darf der User sich regestrieren oder anmelden.
	 * Oder Kaufen ohne sich zu registrieren.
	 * 
	 */ 
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == an){
			AnmeldeScreen anmeldung = new AnmeldeScreen();
			anmeldung.GUIAnmeldung();
			frame.setVisible(false);
		} // end of if
		if (e.getSource() == re){
			//RegistrierungsScreen registrierung = new RegistrierungsScreen();
			//registrierung.GUIRegistrierung();
			frame.setVisible(false);       
		}// end of if
		if (e.getSource() == deleteButton) {
			deleteContentSC();
			
		}
		if (e.getSource() == be){
			//Not implemented yet
			//frame.setVisible(false);     
			
		}// end of if
		if (e.getSource() == reButton) {
			refresh();
		}
	}
	
	/**********************
	 *** BUILD SUBTREE *** 
	 **********************/
	/*
	 * Build the First Version of a SubTree
	 * 
	 * @param Input: Path to the Data as String
	 * @param Return: SubTree 
	 */
	private static DefaultMutableTreeNode BuildSubTree(String fileName) {
        // Auslesen aller Zeilen aus der CSV Datei
        ArrayList<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filenameString2))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] valueStrings = line.split(",");
//            	if(lineNumber != linetoSkip) {
//            		lineNumber++;
//            		continue;
//            	}
            	for(String values : valueStrings) {
            		lines.add(values);
            	}
//              break;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ArrayList lines: " + lines);
        System.out.println("Size of ArrayList lines: " + lines.size());
        
        /*
         * Hier erfolgt der hierarische Aufbau der Veranstaltungs�bersicht (DataStruture Baum: JTree)
         */
        // *** NUMBER PLACES AND PRICES *** //
        List<String> zone1 = lines.subList(13, 21);
        System.out.println(zone1);
        String zonecomplete1 = zone1.get(0) + ": Plätze: " + zone1.get(1) + ": " + zone1.get(4) + ": " + zone1.get(5);
        List<String> zone2 = lines.subList(21, 29);
        System.out.println(zone2);
        String zonecomplete2 = zone2.get(0) + ": Plätze: " + zone2.get(1) + ": " + zone2.get(4) + ": " + zone2.get(5);
        List<String> zone3 = lines.subList(29, 37);
        System.out.println(zone3);
        String zonecomplete3 = zone3.get(0) + ": Plätze: " + zone3.get(1) + ": " + zone3.get(4) + ": " + zone3.get(5);
        String zonecompleteString = "Preis Übersicht";
        
        DefaultMutableTreeNode zoneNode1 = new DefaultMutableTreeNode(zonecomplete1);
        DefaultMutableTreeNode zoneNode2 = new DefaultMutableTreeNode(zonecomplete2);
        DefaultMutableTreeNode zoneNode3 = new DefaultMutableTreeNode(zonecomplete3);
        DefaultMutableTreeNode zoneParentNode = new DefaultMutableTreeNode(zonecompleteString);
        zoneParentNode.add(zoneNode1);
        zoneParentNode.add(zoneNode2);
        zoneParentNode.add(zoneNode3);
        
        // *** TIME NODES *** //
        String timecomplete = lines.get(9) + ": " + lines.get(10);
        DefaultMutableTreeNode timeNode = new DefaultMutableTreeNode(timecomplete);
        timeNode.add(zoneParentNode);
        DefaultMutableTreeNode timeNode1 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode2 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode3 = copyNode(timeNode);
        
        // *** DATE NODES *** //
        List<String> dateList = lines.subList(6, 9);
        DefaultMutableTreeNode dateNode1 = new DefaultMutableTreeNode(dateList.get(0));
        dateNode1.add(timeNode1);
        DefaultMutableTreeNode dateNode2 = new DefaultMutableTreeNode(dateList.get(1));
        dateNode2.add(timeNode2);
        DefaultMutableTreeNode dateNode3 = new DefaultMutableTreeNode(dateList.get(2));
        dateNode3.add(timeNode3);
        DefaultMutableTreeNode dateGrandfahterNode = new DefaultMutableTreeNode("Termine:");
        dateGrandfahterNode.add(dateNode1);
        dateGrandfahterNode.add(dateNode2);
        dateGrandfahterNode.add(dateNode3);

        // *** TOP NODES UNTIL SUBROOT *** //
        List<String> subList = lines.subList(0,5);
        // System.out.println(subList);
        // System.out.println(dateList);
        DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(subList.get(0));
        DefaultMutableTreeNode placeNode = new DefaultMutableTreeNode(subList.get(1) + ": " + subList.get(2));
        DefaultMutableTreeNode stateNode = new DefaultMutableTreeNode(subList.get(3) + ": " + subList.get(4));
        stateNode.add(dateGrandfahterNode);
        placeNode.add(stateNode);
        subroot.add(placeNode);
      
        return subroot;
        
//      for (String line : lines) {
//         String[] values = line.split(",");
//         DefaultMutableTreeNode parent = root;
//            
//         for (String value : values) {
//            DefaultMutableTreeNode node = new DefaultMutableTreeNode(value);
//            parent.add(node);
//            parent = node;
//         }
//      }
    } 
	// END OF BUILDSUBTREE
	
	/**********************
	 *** BULD SUBTREE 2 *** 
	 **********************/
	/*
	 * Build the Second Version of a SubTree
	 * 
	 * @param Input: Path to the Data as String
	 * @param Return: SubTree 
	 */
	private static DefaultMutableTreeNode BuildSubTree2(String fileName) {
        // *** READ ALL LINES FROM THE CSV-FILE *** //
        ArrayList<String> lines2 = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] valueStrings = line.split(",");
//            	if(lineNumber != linetoSkip) {
//            		lineNumber++;
//            		continue;
//            	}
            	for(String values : valueStrings) {
            		lines2.add(values);
            	}
//              break;
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ArrayList lines2: " + lines2);
        System.out.println("Size of ArrayList lines2: " + lines2.size());
        
        
        /* Here is the hierarchical structure of the event overview (DataStruture tree: JTree) */
    
        // *** ZONEN VIEW *** //
        List<String> zone1 = lines2.subList(20, 30);
        System.out.println(zone1);
        String zone1complete = zone1.get(0) + ": Plaetze: " + zone1.get(1) + ": " + zone1.get(7) + ": " + zone1.get(8) + "." + zone1.get(9) + "€";
        List<String> zone2 = lines2.subList(40, 50);
        System.out.println(zone2);
        String zone2complete = zone2.get(0) + ": Plaetze: " + zone2.get(1) + ": " + zone2.get(7) + ": " + zone2.get(8) + "." + zone2.get(9) + "€";
        List<String> zone3 = lines2.subList(60, 70);
        System.out.println(zone3);
        String zone3complete = zone3.get(0) + ": Plaetze: " + zone3.get(1) + ": " + zone3.get(7) + ": " + zone3.get(8) + "." + zone3.get(9) + "€";
        String zonecompleteString = "Zonen Übersicht";
        DefaultMutableTreeNode zone1Node = new DefaultMutableTreeNode(zone1complete);
        DefaultMutableTreeNode zone2Node = new DefaultMutableTreeNode(zone2complete);
        DefaultMutableTreeNode zone3Node = new DefaultMutableTreeNode(zone3complete);
        DefaultMutableTreeNode zone = new DefaultMutableTreeNode(zonecompleteString);
        zone.add(zone1Node);
        zone.add(zone2Node);
        zone.add(zone3Node);
        
        // *** TIME NODE *** //
        String timecomplete = lines2.get(13) + ": " + lines2.get(14);
        DefaultMutableTreeNode timeNode = new DefaultMutableTreeNode(timecomplete);
        timeNode.add(zone);
        DefaultMutableTreeNode timeNode1 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode2 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode3 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode4 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode5 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode6 = copyNode(timeNode);
        
        // *** DATE NODES *** //
        List<String> dateList = lines2.subList(7, 13); 
        DefaultMutableTreeNode dateNode1 = new DefaultMutableTreeNode(dateList.get(0));
        dateNode1.add(timeNode1);
        DefaultMutableTreeNode dateNode2 = new DefaultMutableTreeNode(dateList.get(1));
        dateNode2.add(timeNode2);
        DefaultMutableTreeNode dateNode3 = new DefaultMutableTreeNode(dateList.get(2));
        dateNode3.add(timeNode3);
        DefaultMutableTreeNode dateNode4 = new DefaultMutableTreeNode(dateList.get(3));
        dateNode4.add(timeNode4);
        DefaultMutableTreeNode dateNode5 = new DefaultMutableTreeNode(dateList.get(4));
        dateNode5.add(timeNode5);
        DefaultMutableTreeNode dateNode6 = new DefaultMutableTreeNode(dateList.get(5));
        dateNode6.add(timeNode6);
        DefaultMutableTreeNode dateNodeMaster = new DefaultMutableTreeNode("Termine:");
        dateNodeMaster.add(dateNode1);
        dateNodeMaster.add(dateNode2);
        dateNodeMaster.add(dateNode3);
        dateNodeMaster.add(dateNode4);
        dateNodeMaster.add(dateNode5);
        dateNodeMaster.add(dateNode6);
        
        // *** TOP NODES UNTIL SUBROOT *** //
        List<String> subList = lines2.subList(0,6);
        DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(subList.get(0));
        DefaultMutableTreeNode placeNode = new DefaultMutableTreeNode(subList.get(2) + ": " + subList.get(3));
        DefaultMutableTreeNode stateNode = new DefaultMutableTreeNode(subList.get(4) + ": " + subList.get(5));
        stateNode.add(dateNodeMaster);
        placeNode.add(stateNode);
        subroot.add(placeNode);
       
        return subroot;
//        for (String line : lines) {
//            String[] values = line.split(",");
//            DefaultMutableTreeNode parent = root;
//            
//            for (String value : values) {
//                DefaultMutableTreeNode node = new DefaultMutableTreeNode(value);
//                parent.add(node);
//                parent = node;
//            }
//        }
    }
	// END OF BUILDSUBTREE2
	
	/************************
	 *** BUILD SUBTREE 3 *** 
	 ************************/
	private static DefaultMutableTreeNode BuildSubTree3(String fileName) {
        // *** READ ALL LINES FROM THE CSV-FILE *** //
        ArrayList<String> lines2 = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] valueStrings = line.split(",");
//            	if(lineNumber != linetoSkip) {
//            		lineNumber++;
//            		continue;
//            	}
            	for(String values : valueStrings) {
            		lines2.add(values);
            	}
//              break;
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // FOR TEST PURPOSE // 
        System.out.println("------------------------------------------");
        System.out.println("ArrayList lines2: " + lines2);
        System.out.println("Size of ArrayList lines2: " + lines2.size());
        System.out.println("------------------------------------------");
        
        /*
        lines2.remove(0);
        lines2.remove(1);
        lines2.remove(2);
        lines2.remove(3);
        System.out.println(lines2);
        System.out.println(lines2.size());
        */
        
        /*
         * Here is the hierarchical structure of the event overview (DataStruture tree: JTree)
         */
        // *** ZONEN VIEW *** //
        //[0], [1],   [2],  [3],  [4], [5],  [6],    [7], [8],[9],[10], [11], [12], [13], [14], [15],   [16], [17],  [18],  [19],  [20]
        //[1, Messe, Lego, Lego, Kurz, Tag, Zeitraum, 25, 35, 75, 5000, 5000, 5000, Open, Open, Berlin, Köln, 10.05, 15.05, 10-18, 10-18]
        //21
       
        // CREATE ZONEs
        int maxZoneListElement = 12;
        ArrayList<String> zone1 = new ArrayList<>();
        for (int i = 4; i < maxZoneListElement; i+=3) {
        	zone1.add(lines2.get(i));
        }
        String ticketZone1  = zone1.get(0) + ": Plätze: " + zone1.get(2) + ": Preis/ticket: " + zone1.get(1)+".00 €";
       
        ArrayList<String> zone2 = new ArrayList<>();
        for (int i = 5; i < maxZoneListElement; i+=3) {
        	zone2.add(lines2.get(i));
        }
        String ticketZone2 = zone2.get(0) + ": Plätze: " + zone2.get(2) + ": Preis/ticket: " + zone2.get(1)+".00 €";
       
        ArrayList<String> zone3 = new ArrayList<>();
        for (int i = 6; i <= maxZoneListElement; i+=3) {
        	zone3.add(lines2.get(i));
        }
        String ticketZone3 = zone3.get(0) + ": Plätze: " + zone3.get(2) + ": Preis/ticket: " + zone3.get(1)+".00 €";
        
        
        // FOR CHECK
        System.out.println("------------------------------------------");
        System.out.println("ZONE 1: " + zone1);
        System.out.println("ZONE 2: " + zone2);
        System.out.println("ZONE 3: " + zone3);
        System.out.println(ticketZone1);
        System.out.println(ticketZone2);
        System.out.println(ticketZone3);
        System.out.println("------------------------------------------");
        
        // CREATE ZONENODES FOR TREE
        DefaultMutableTreeNode zone1Node = new DefaultMutableTreeNode(ticketZone1);
        DefaultMutableTreeNode zone2Node = new DefaultMutableTreeNode(ticketZone2);
        DefaultMutableTreeNode zone3Node = new DefaultMutableTreeNode(ticketZone3);
        String zonecompleteString = "Zonen Übersicht";
        DefaultMutableTreeNode zoneOverview = new DefaultMutableTreeNode(zonecompleteString);
        zoneOverview.add(zone1Node);
        zoneOverview.add(zone2Node);
        zoneOverview.add(zone3Node);
        
        // CREATE TIMELIST + TIMENODES
        List<String> timeList = lines2.subList(19, 21);
        int timeListSize = timeList.size();
        
        System.out.println("------------------------------------------");
        System.out.println("timeList: " + timeList);
        System.out.println("timeListSize: " + timeListSize);
        System.out.println("------------------------------------------");
        
        String[] timeListStrings = new String[timeListSize];
        DefaultMutableTreeNode[] timeListNodes = new DefaultMutableTreeNode[timeListSize];
        for(int i = 0; i < timeListSize; i++) {
        	timeListStrings[i] = "Uhrzeiten: "+ timeList.get(i);
        	timeListNodes[i] = new DefaultMutableTreeNode(timeListStrings[i]); 
        	timeListNodes[i].add(copyNode(zoneOverview));
        }
        
        List<String> dateList = lines2.subList(17, 19);
        int dataListSize = dateList.size();
        
        System.out.println("------------------------------------------");
        System.out.println("dateList: " + dateList);
        System.out.println("dataListSize: " + dataListSize);
        System.out.println("------------------------------------------");
        
        String[] dateListStrings = new String[dataListSize];
        DefaultMutableTreeNode[] dateListNodes = new DefaultMutableTreeNode[dataListSize];
        DefaultMutableTreeNode dateNodeMaster = new DefaultMutableTreeNode("Termine:");
        for(int i = 0; i < dataListSize; i++) {
    	   dateListStrings[i] = dateList.get(i);
    	   dateListNodes[i] = new DefaultMutableTreeNode(dateListStrings[i]);
    	   dateListNodes[i].add(copyNode(timeListNodes[i]));
    	   dateNodeMaster.add(dateListNodes[i]);
        }
       
        List<String> statisList = lines2.subList(13, 15);
        int statisListSize = statisList.size();
        
        System.out.println("------------------------------------------");
        System.out.println("statisList: " + statisList);
        System.out.println("statisListSize: " + statisListSize);
        System.out.println("------------------------------------------");
        
        String[] statiStrings = new String[statisListSize];
        DefaultMutableTreeNode[] statisNodes = new DefaultMutableTreeNode[statisListSize];
        for(int i = 0; i < statisListSize; i++) {
    	   statiStrings[i] = "Status: " + statisList.get(i);
    	   statisNodes[i] = new DefaultMutableTreeNode(statiStrings[i]);
    	   statisNodes[i].add(copyNode(dateNodeMaster));
       }
       
       List<String> placeList = lines2.subList(15, 17);
       int placeListSize = placeList.size();
       String[] placeStrings = new String[placeListSize];
       DefaultMutableTreeNode[] placeNodes = new DefaultMutableTreeNode[placeListSize];
       for(int i = 0; i < placeListSize; i++) {
    	   placeStrings[i] = "Orte: " + placeList.get(i);
    	   placeNodes[i] = new DefaultMutableTreeNode(placeStrings[i]);
    	   placeNodes[i].add(copyNode(statisNodes[i]));
       }
       
        /*
      
        DefaultMutableTreeNode zone1Node = new DefaultMutableTreeNode(zone1complete);
        DefaultMutableTreeNode zone2Node = new DefaultMutableTreeNode(zone2complete);
        DefaultMutableTreeNode zone3Node = new DefaultMutableTreeNode(zone3complete);
        DefaultMutableTreeNode zone = new DefaultMutableTreeNode(zonecompleteString);
        zone.add(zone1Node);
        zone.add(zone2Node);
        zone.add(zone3Node);
         
        // *** TIME NODE *** //
        
        DefaultMutableTreeNode[] treeNodeTimeArray = new DefaultMutableTreeNode[timeList.size()];
       
        for (int i = 0; i < timeList.size(); i++) {
        	treeNodeTimeArray[i]= new DefaultMutableTreeNode(lines2.get(i));
        }
        String timeString = "Uhrzeiten: " + lines2.get(19);
        DefaultMutableTreeNode timeNode = new DefaultMutableTreeNode(timeString);
        timeNode.add(zoneOverview);
        DefaultMutableTreeNode timeNode1 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode2 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode3 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode4 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode5 = copyNode(timeNode);
        DefaultMutableTreeNode timeNode6 = copyNode(timeNode);
        
        // *** DATE NODES *** //
        List<String> dateList = lines2.subList(7, 13); 
        DefaultMutableTreeNode dateNode1 = new DefaultMutableTreeNode(dateList.get(0));
        dateNode1.add(timeNode1);
        DefaultMutableTreeNode dateNode2 = new DefaultMutableTreeNode(dateList.get(1));
        dateNode2.add(timeNode2);
        DefaultMutableTreeNode dateNode3 = new DefaultMutableTreeNode(dateList.get(2));
        dateNode3.add(timeNode3);
        DefaultMutableTreeNode dateNode4 = new DefaultMutableTreeNode(dateList.get(3));
        dateNode4.add(timeNode4);
        DefaultMutableTreeNode dateNode5 = new DefaultMutableTreeNode(dateList.get(4));
        dateNode5.add(timeNode5);
        DefaultMutableTreeNode dateNode6 = new DefaultMutableTreeNode(dateList.get(5));
        dateNode6.add(timeNode6);
        
        dateNodeMaster.add(dateNode1);
        dateNodeMaster.add(dateNode2);
        dateNodeMaster.add(dateNode3);
        dateNodeMaster.add(dateNode4);
        dateNodeMaster.add(dateNode5);
        dateNodeMaster.add(dateNode6);
        
        // *** TOP NODES UNTIL SUBROOT *** //
        List<String> subList = lines2.subList(0,6);
        
        DefaultMutableTreeNode placeNode = new DefaultMutableTreeNode(subList.get(2) + ": " + subList.get(3));
        DefaultMutableTreeNode stateNode = new DefaultMutableTreeNode(subList.get(4) + ": " + subList.get(5));
        stateNode.add(dateNodeMaster);
        placeNode.add(stateNode);
        */
       String artist_OrganizerString = lines2.get(2)+"_"+lines2.get(3);
       DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(artist_OrganizerString);
       for(int i = 0; i < dataListSize; i++) {
    	   subroot.add(placeNodes[i]);
       }
       
       String eventTypeString = lines2.get(1)+"n";
       DefaultMutableTreeNode eventType = new DefaultMutableTreeNode(eventTypeString);
       eventType.add(subroot);
       
       return eventType; 
	}
	
	/*****************
	 *** COPY NODE *** 
	 *****************/
    /* 
     * Hier wird ein Knoten mit mehreren KindKnoten rekursiv kopiert
     * 
     * @param input: DefaultMutableTreeNode
     * @param return: ist die Kopie eines Knotens inkl. KindKnoten
     */
    public static DefaultMutableTreeNode copyNode(DefaultMutableTreeNode node) {
    	DefaultMutableTreeNode copy = new DefaultMutableTreeNode(node.getUserObject());
    	
    	for(int i=0;i<node.getChildCount();i++) {
    		copy.add(copyNode((DefaultMutableTreeNode) node.getChildAt(i)));
    	}
    	
    	return copy;
    }
   
    /**************************
     *** IS SUBSET FUNCTION ***
     **************************/
    public boolean isSubset(String[] array1, String[] array2) {
    	ArrayList<String> list2 = new ArrayList<>(Arrays.asList(array2));
    	for (String element : array1) {
    		if (!list2.contains(element)) {
    			return false;
    		}
    	}
    	return true; 
    }
    
    /**********************
     *** PATH TO STRING *** 
     **********************/
    public static String pathToString(TreePath path) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] pathElements = path.getPath();
        for (int i = 0; i < pathElements.length; i++) {
            stringBuilder.append(pathElements[i].toString());
            if (i < pathElements.length - 1) {
                stringBuilder.append("/");
            }
        }
        return stringBuilder.toString();
    }
    /******************************
     *** END OF JTREE FUNCTIONS *** 
     ******************************/
    
    
    /*
    private static void addToShoppingCart(String item, String quantity, String price) {
        //System.out.println("Element zum Warenkorb hinzugef�gt: " + item + ", Plaetze: " + platz + ", Zone: " + zone + ", Preis: " + price);
       //String selectedElement = selectedNode.toString();
        listModel.addElement("<html>Zone: " + item + "<br>Anzahl: " + quantity + ", Preis/ticket: " + price + "</html>");
        int listModelSize = listModel.getSize();
		System.out.println(listModelSize);
    }
    /*
    
    /********************************
     *** BUY WITHOUT REGISTRATION *** 
     ********************************/
    public BuyWithoutRegistration() {
    	
    	// *** LACOUT VARIABLES *** //
        layout = new GroupLayout(this);
        vGroup = layout.createSequentialGroup();
        hGroup = layout.createParallelGroup(Alignment.CENTER);
       
        layout.setVerticalGroup(vGroup);
        layout.setHorizontalGroup(hGroup);
        this.setLayout(layout);
        
        // *** LIST VARIABLES *** //
       entryPanelsList = new ArrayList<>(); // Initialize the list
       endPriceFieldsList = new ArrayList<>();
        
        // *** ACTIONLISTENER ACTIONS *** //
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//CurrPanel
                EntryPanelA panel = (EntryPanelA) ((JComponent) e.getSource()).getParent();
                int i = CounterStart;
                
                if (i < maxQuantityOfPlaces) {
                	Double priceDouble = panel.getPrice();
                	String currPanelNameString = panel.getName();
                 	
                	System.out.println("PANEL NAME: " + currPanelNameString + ":: " + priceDouble);
                	// TEST PURPOSE -> panel.getName()
                	System.out.println("CURRNAME STRING: " + currPanelNameString);
                
                	int intValue = extractIntFromArtikel(currPanelNameString)-1;
                	
                	// ACTION TO GET CURRENT QUANTITY OF TICKETS
                	JTextField currQuantityJTF = panel.getQuantityField();
                	String currQuarString = currQuantityJTF.getText();
                	int currQuantityINT = changeStringToInt(currQuarString);
                	
                	System.out.println("INT VALUE: " + intValue);
                	System.out.println("CUR QUANTITY STRING o. CURR NAME STRING: " + currQuarString + "->" + currPanelNameString);
                    System.out.println(panel.getEntry() + ":" + i);
                    
                    // Zugriff auf die Spalte
                    int[] columnVector = getColumn(SCMatrix, intValue);
                    //currQuantityINT = i;
                    i = currQuantityINT;
                    i++;
                    
                    System.out.println("CUR QUANTITY STRING 2: " + i);
                    
                    
                   
                    if (i == maxQuantityOfPlaces) {
                    	System.out.println("Maximale Anzahl an verfügbaren Tickets erreicht"); 
                	}
                	panel.updateQuantifyField(i);
                    panel.updateEndPriceField(i, panel.getPrice());
                    
                    System.out.println("INSIDE ACTIONLISTENER 1: " + endSumString);
                    
                    updateCompleteSCPriceField(endSumString, (i*panel.getPrice()));
                	refresh();
                     System.out.println(endSumString);
              	} else {
                    System.out.println("Maximale Anzahl erreicht. Keine weiteren Tickets verfügbar.");
                }
               
            }
        };
        actionListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				EntryPanelA panel = (EntryPanelA) ((JComponent) f.getSource()).getParent();
				int i = CounterStart;
				if (i > 0) {
					
					String currPanelNameString = panel.getName();
	                
                	// TEST PURPOSE -> panel.getName()
                	System.out.println("CURRNAMESTRING: " + currPanelNameString);
                
                	int intValue = extractIntFromArtikel(currPanelNameString)-1;
                	
                	// ACTION TO GET CURRENT QUANTITY OF TICKETS
                	JTextField currQuantityJTF = panel.getQuantityField();
                	String currQuarString = currQuantityJTF.getText();
                	int currQuantityINT = changeStringToInt(currQuarString);
                	
                	System.out.println("INTVALUE: " + intValue);
                	System.out.println("CURQUANTITYSTRING o. CURRNAMESTRING: " + currQuarString + "->" + currPanelNameString);
                    System.out.println(panel.getEntry() + ":" + i);
                    
                    // Zugriff auf die Spalte
                    int[] columnVector = getColumn(SCMatrix, intValue);
                    //currQuantityINT = i;
                    i = currQuantityINT;
                    i--;
                    
                    System.out.println("CURQUANTITYSTRING 2: " + i);

                    if (i == 0) {
                    	System.out.println("Keine Tickets verfügbar.");
                	}
                	panel.updateQuantifyField(i);
                    panel.updateEndPriceField(i, panel.getPrice());
                    System.out.println("");
                    updateCompleteSCPriceField(endSumString, (i*panel.getPrice()));
                	refresh();
                    System.out.println(endSumString);
					
                } else {
                    System.out.println("Ausverkauft.");
                }		
			}
		};
    }
    // *** END OF ACTIONLISTENER *** //
    
    /********************************
     *** ADD ENTRY PANEL FUNCTION ***
     ********************************/
    public void addEntryPanel(String name, String entry, int counter, String price) {
    	String arrowUp = "\u25B2";
        String arrowDown = "\u25BC";
        //String priceString = "35";
    	
        System.out.println("INSIDE addEntryPanel: ");
        System.out.println("NAME: " + name);
        System.out.println("ENTRY: " + entry);
        System.out.println("COUNTER: " + counter);
        System.out.println("PRICE: " + price);
        
        EntryPanelA entryPanel = new EntryPanelA(name, arrowUp, arrowDown, counter, price);
        
        // *** ENTRY FOR LABEL INSIDE SHOPPING CART *** //
        JLabel entryLabel = new JLabel(entry);
        
        JTextField priceField = entryPanel.getPriceField();
        priceField.setText(price);
        priceField.setColumns(5);
        priceField.setEditable(false);
        
        JButton upButton = new JButton(arrowUp);
        JButton downButton = new JButton(arrowDown);
        upButton.addActionListener(actionListener);
        downButton.addActionListener(actionListener2);
        
        JTextField quantityField = entryPanel.getQuantityField();
        quantityField.setColumns(5);

        JTextField endPriceField = entryPanel.getEndPriceField();
        endPriceField.setColumns(5);
        
        entryPanel.add(entryLabel);
        entryPanel.add(priceField);
        entryPanel.add(upButton);
        entryPanel.add(downButton);
        entryPanel.add(quantityField);
        entryPanel.add(endPriceField);
        
        entryPanelsList.add(entryPanel); // Add the entryPanel to the list
        endPriceFieldsList.add(endPriceField);
        updateLayout(); // Update the layout with the new entryPanel
    }
    
    /*************************
     *** GET ENDPRICEFIELD *** 
     *************************/
    public List<JTextField> getEndPriceFieldsList() {
        return endPriceFieldsList;
    }
    
    /******************
     *** GET COLUMN *** 
     ******************/
    public static int[] getColumn(int[][] array, int columnIndex) {
    	
        int rows = array.length;
        int[] columnVector = new int[rows];

        for (int i = 0; i < rows; i++) {
            columnVector[i] = array[i][columnIndex];
        }
        
        return columnVector;
    }
    
    /********************************
     *** EXTRACT INT FROM ARTIKEL *** 
     ********************************/
    public static int extractIntFromArtikel(String input) {
        // Entferne alle nicht-numerischen Zeichen
        String numericPart = input.replaceAll("[^0-9]", "");

        // Versuche den verbleibenden String in einen Integer umzuwandeln
        try {
            return Integer.parseInt(numericPart);
        } catch (NumberFormatException e) {
            // Handle den Fehler, wenn die Umwandlung fehlschlägt
            System.err.println("Ungültige Zahl im String");
            return 0; // oder einen anderen Standardwert
        }
    }
    
    /*******************************
     *** CHANGE STRING TO DOUBLE *** 
     *******************************/
    public static Double changeStringToDouble(String priceText) {
    	
        Double priceValue = 0.0;
        
        try {
            priceValue = Double.parseDouble(priceText);
            System.out.println("Inside ChangeStringToInt: " + priceValue);
        } catch (NumberFormatException e) {
            // Das Textfeld enthält keine gültige Zahl
            System.err.println("Ungültige Zahl im Textfeld");
        }
        
        return priceValue;
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
    
    /**********************************
     *** CALCULATE AND SET DISCOUNT *** 
     **********************************/
    private static void calculateAndSetDiscount() {
        
        double discountPercentage = 0.0;

        if (percentDiscountStudentButton.isSelected()) {
            discountPercentage = 50.0; // Hier sollte die entsprechende Berechnung stehen
        } else if (percentDiscountSocialButton.isSelected()) {
            discountPercentage = 25.0; // Hier sollte die entsprechende Berechnung stehen
        } else if (percentDiscountFamilyButton.isSelected()) {
        	discountPercentage = 15.0;
        }

        double currentPrice = Double.parseDouble(completeSCPriceField.getText());
        double discountedPrice = currentPrice - (currentPrice * (discountPercentage / 100));
        nettoSCPriceField.setText(String.valueOf(discountedPrice));
        updateTaxPriceField();
    }
    
    /*****************************
     *** CALCULATE COMPL PRICE *** 
     *****************************/
    public static double calculateComplPrice(List<List<JTextField>> tempLists) {
        double sum = 0;
        for (List<JTextField> sublist : tempLists) {
            StringBuilder completeText = new StringBuilder();
            for (JTextField textField : sublist) {
                completeText.append(textField.getText().trim()).append(" ");
                String tempSumString = completeText.toString().trim();
                System.out.println(tempSumString + "//"+ sum);
            	sum += Double.parseDouble(tempSumString);
            }
            System.out.println("INSIDE calculateComplPrice:" + completeText); 
        }
        System.out.println("SUM?:" + sum);
        return sum;
    }

    /**********************************************
     *** UPDATE COMPLETE SC PRICEFIELD FUNCTION *** 
     **********************************************/
    public void updateCompleteSCPriceField(String newText, double tempEndPrice) {
    	System.out.println("NEWTEXT:" + newText);
    	completeSCPriceField.setText(String.valueOf(Double.parseDouble(newText)+ tempEndPrice));
    	
    	
    }
    
   
    
    public static void updateTaxPriceField() {
    	
    	double tax = Double.parseDouble(taxField.getText().replaceAll("%", ""));
    	double nettoPrice = Double.parseDouble(nettoSCPriceField.getText());
    	double endprice = nettoPrice * tax / 100;
    	
    	//String.valueOf(taxField.getText());
    	
    	taxEndPriceField.setText(String.valueOf(endprice));
    	
    }
    
    /*******************
     *** UPDATE TREE *** 
     *******************/
    private void updateTree() {
    	warenKorbPanel.revalidate();
    	warenKorbPanel.repaint();
    }
    
    /******************************
     *** UPDATE LAYOUT FUNCTION ***
     ******************************/
    private void updateLayout() {
    	 vGroup = layout.createSequentialGroup(); // Erstelle eine neue vertikale Gruppe
    	 hGroup = layout.createParallelGroup(Alignment.CENTER); // Erstelle eine neue horizontale Gruppe
    	 
    	 for (EntryPanelA entryPanel : entryPanelsList) {
    		 vGroup.addComponent(entryPanel);
    		 hGroup.addComponent(entryPanel);
    	 }

    	 layout.setVerticalGroup(vGroup);
    	 layout.setHorizontalGroup(hGroup);
    	 
    	 revalidate();
    }
   

    /***************
     *** REFRESH *** 
     ***************/
    public void refresh() {
    	 // ENDSUMME 210.0
        tempEndPrice = calculateComplPrice(complPriceFieldList);
        endSumString = String.valueOf(tempEndPrice);
        
        System.out.println("TempEndPrice?:" + tempEndPrice);
        System.out.println("endSumString?" + endSumString);
    		
    	completeSCPriceField.setText(endSumString);
    }
    
    /***************************************
     *** DELETE CONTENT OF SHOPPING CART *** 
     ***************************************/
	public void deleteContentSC() {
		
		System.out.println("-----------------------------");
		System.out.println("TEST->DELETECONTENT(BEFORE RESTART)");
		for(List<JTextField> textField : complPriceFieldList) {
			for(JTextField subfieldField : textField) {
				System.out.println("complPriceFieldsList: " + subfieldField.getText());
			}
		}
		
		for(JTextField subfieldField : endPriceFieldsList) {
			System.out.println("endPriceFieldsList: " + subfieldField.getText());
		}
		System.out.println("-----------------------------");
		
    	String price = "0";
    	nettoSCPriceField.setText(price);
    	completeSCPriceField.setText(price);
    	
    	//completeSCPriceField = null;
    	//nettoSCPriceField = null;
    	endPriceFieldsList = null;
    	//completeSCPriceField = null;
    	entryPanelsList = null;
    	
    	
    	for (int i = 0; i < maxOfTicketsSC; i++) {
            if (panelArray[i] != null) {
                panelArray[i].clearEntryPanels();
            }
        }
    	
    	Container parent = warenKorbPanel.getParent();
    	if (parent != null) {
    		
    	    parent.remove(warenKorbPanel);
    	    parent.revalidate();
    	    parent.repaint();
    	    
    	}
    	
        endPriceFieldsList = new ArrayList<>();
        complPriceFieldList = new ArrayList<>();
        //private static List<BuyWithoutRegistration> registrationsList;
        entryPanelsList = new ArrayList<>(); // List to store EntryPanel instances
        completeSCPriceField = new JTextField();
        nettoSCPriceField = new JTextField();
        endPriceFieldsList = new ArrayList<>();
        entryPanelsList = new ArrayList<>();
    	
        System.out.println("-----------------------------");
		System.out.println("TEST->DELETECONTENT(RESTART LIST AND TEXTFIELDS)");
		for(List<JTextField> textField : complPriceFieldList) {
			for(JTextField subfieldField : textField) {
				System.out.println("complPriceFieldsList: " + subfieldField.getText());
			}
		}
		
		for(JTextField subfieldField : endPriceFieldsList) {
			System.out.println("endPriceFieldsList: " + subfieldField.getText());
		}
		System.out.println("-----------------------------");
   
  		int i = CounterStart;
    	panelArray = new BuyWithoutRegistration[maxOfTicketsSC];
        complPriceFieldList = new ArrayList<>();
		for (int t = 0; t < panelArray.length; t++) {
			
			panelArray[t] = new BuyWithoutRegistration();
        	panelArray[t].setName("Artikel_" + (t+1)); 
        	System.out.println("PANELARRAY[t] NAME: " + panelArray[t].getName() + " ");
        	panelArray[t].addEntryPanel("Artikel_" + (t+1), "Artikel_" + (t+1), i, price);
        	//ScrollPanel.add(panelArray[y]);
        	List<JTextField> endPriceFieldsList = panelArray[t].getEndPriceFieldsList();
        	complPriceFieldList.add(endPriceFieldsList);

		}
		
		System.out.println("-----------------------------");
		System.out.println("TEST->DELETECONTENT(RESTART TEST INITIALIZE)");
		for(List<JTextField> textField : complPriceFieldList) {
			for(JTextField subfieldField : textField) {
				System.out.println("complPriceFieldsList: " + subfieldField.getText());
			}
		}
		
		for(JTextField subfieldField : endPriceFieldsList) {
			System.out.println("endPriceFieldsList: " + subfieldField.getText());
		}
		System.out.println("-----------------------------");
		
		restart(parent);
		/*
		parent.add(warenKorbPanel);
		parent.revalidate();
		parent.repaint();
		 
		
            	if (parent == null) {
            		restart(parent);
            		refresh();
            		updateTree();
            	} 
		 
		
        warenkorb = new JScrollPane();
        warenkorb.add(warenKorbPanel);
    	*/
    }
	
    public void clearEntryPanels() {
        entryPanelsList = null;  // Setze das Array auf null, um die Referenzen zu löschen
    }
    
    /***************
     *** RESTART *** 
     ***************/
    public void restart(Container parent) {
    	
    	warenKorbPanel = new JPanel();
	    warenKorbPanel.setBackground(Color.gray);
        warenKorbPanel.setLayout(new BoxLayout(warenKorbPanel, BoxLayout.Y_AXIS));
    	parent.add(warenKorbPanel);
    	parent.revalidate();
    	parent.repaint();
    		
    }
    
    // NOT IMPLEMENTED YET //
    public void openConcertScreenCustomer() {
    	
    }
}

/*************************
 *** CLASS ENTRYPANELA *** 
 *************************/
class EntryPanelA extends JPanel {

    private static final long serialVersionUID = 1L;
    String panelNameString;
    String entry;
    String entry2;
    int counter;
    Double price;
    String priceStringNew;
    JTextField priceField = new JTextField();
    JTextField quantityField = new JTextField();
    JTextField endPriceField = new JTextField();
    
    /*******************************
     *** ENTRYPANELA CONSTRUCTOR *** 
     *******************************/
    public EntryPanelA(String a, String e, String f, int i, String priceString) {
    	panelNameString = a;
    	entry = e;
    	entry2 = f;
    	counter = i;
    	priceStringNew = priceString;
    	
    	price = BuyWithoutRegistration.changeStringToDouble(priceString);
    	updateQuantifyField(counter);
    	updateEndPriceField(counter, price);
    }

    public void setName(String nameString) {
    	this.panelNameString = nameString;
    }
    
    public String getName() {
    	return panelNameString;
    }
    
    public String getEntry() {
        return entry;
    }
    
    public String getEntry2() {
    	return entry2;
    }
    
    public int getCounter() {
    	return counter;
    }
    
    public void setCounter(int i) {
    	this.counter = i;
    }
    
    public Double getPrice() {
    	return price;
    }
    
    public void setPrice(String priceString) {
    	this.priceStringNew = priceString;
    }
    
    public JTextField getQuantityField() {
        return quantityField;
    }
    
    public JTextField getPriceField() {
    	return priceField;
    }
    
    public JTextField getEndPriceField() {
    	return endPriceField;
    }
    
    public void updateQuantifyField(int newValue) {
        quantityField.setText(String.valueOf(newValue));
    }

    public void updateEndPriceField(int counter, double price) {
    	endPriceField.setText(String.valueOf(counter*price));
    }
    
}

/*
class QuantityPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JButton upButton, downButton;
	
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	public QuantityPanel(int shoppingcartSize) {
		
		JPanel[] panels = new JPanel[shoppingcartSize];
		JButton[] upButtons = new JButton[shoppingcartSize];
		JButton[] downButtons = new JButton[shoppingcartSize];
		
		for (int i = 0; i < shoppingcartSize; i++) {
			panels[i]= new JPanel(); 
		}
		
		setBackground(c2);
		setBounds(0,0,215,40);
		setLayout(null);
	
		String arrowUp = "\u25B2";
        String arrowDown = "\u25BC";
		upButton = new JButton(arrowUp);
		upButton.setBounds(0,0,60,40);
        downButton = new JButton(arrowDown);
        downButton.setBounds(65,0,60,40);
        
        add(upButton);
        add(downButton);
		
		setVisible(true);
		
	}
}
*/

 /*
  SIMPLES TREENODE EXAMPLE
	private static TreeNode createTree() {
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Wurzel");
			
			DefaultMutableTreeNode letters = new DefaultMutableTreeNode("Buchstaben");
			DefaultMutableTreeNode digits = new DefaultMutableTreeNode("Zahlen");
			
			DefaultMutableTreeNode letterA = new DefaultMutableTreeNode("A");
			DefaultMutableTreeNode letterB = new DefaultMutableTreeNode("B");
			DefaultMutableTreeNode letterC = new DefaultMutableTreeNode("C");
			
			DefaultMutableTreeNode digit1 = new DefaultMutableTreeNode("1");
			DefaultMutableTreeNode digit2 = new DefaultMutableTreeNode("2");
			DefaultMutableTreeNode digit3 = new DefaultMutableTreeNode("3");
			
			letters.add(letterA);
			letters.add(letterB);
			letters.add(letterC);
			
			digits.add(digit1);
			digits.add(digit2);
			digits.add(digit3);
			
			root.add(letters);
			root.add(digits);
			
			return root;
	}
	*/