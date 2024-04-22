package TopPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Reste.PreviewFrame3;

public class AdmWorkEmpPanel extends JPanel implements ActionListener{
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel labelright, labelleft;
	static JPanel panelMenu = new JPanel();
	static JPanel panelWork = new JPanel();
	static JSplitPane splitpane = new JSplitPane();
	//static JScrollPane scrollPane = new JScrollPane();
	static JScrollPane optionPane = new JScrollPane();
	static JButton createButtonEmpl, editButtonEmpl, deleteButtonEmpl;
	static JButton createButtonDept, editButtonDept, deleteButtonDept;
	
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);

	static String mitStatus2 = "Admin";
	
	/*
	//Main f�r Seperates Testen
	public static void main(String[] args) {
	AdmWorkEmpPanel admworkemppanel = new AdmWorkEmpPanel();
	admworkemppanel.AdmWorkEmpPanel();
		
	}
	*/
	
	/*
	 * 
	 */
	public AdmWorkEmpPanel(String tempStat) {
		
		// LEFT SIDE START //
		// *** Left side of AdmWorkEmpPanel (SplitPane left: MENU) *** //
		// *** Label *** //
		labelleft = new JLabel("Menu");
        labelleft.setOpaque(true);
        labelleft.setBounds(0,0,200,30);
        labelleft.setBackground(ctop);
        labelleft.setForeground(c2);
        labelleft.setVisible(true);
    
        // *** Buttons *** //
        createButtonEmpl = new JButton("Create new employee");
        createButtonEmpl.setOpaque(true);
        createButtonEmpl.setBounds(10,65,150,30);
        createButtonEmpl.addActionListener(this);
        createButtonEmpl.setVisible(true);
        
        editButtonEmpl = new JButton("Edit an employee");
        editButtonEmpl.setOpaque(true);
        editButtonEmpl.setBounds(10,100,150,30);
        editButtonEmpl.addActionListener(this);
        editButtonEmpl.setVisible(true);
  
        deleteButtonEmpl = new JButton("Delete an employee");
        deleteButtonEmpl.setOpaque(true);
        deleteButtonEmpl.setBounds(10,135,150,30);
        deleteButtonEmpl.addActionListener(this);
        deleteButtonEmpl.setVisible(true);
        
        createButtonDept = new JButton("Open Work Panel");
        createButtonDept.setOpaque(true);
        createButtonDept.setBounds(10,205,150,30);
        createButtonDept.addActionListener(this);
        createButtonDept.setVisible(true);
        /*
        editButtonDept = new JButton("Edit department");
        editButtonDept.setOpaque(true);
        editButtonDept.setBounds(10,240,150,30);
        editButtonDept.addActionListener(this);
        editButtonDept.setVisible(true);
        
        deleteButtonDept = new JButton("Delete department");
        deleteButtonDept.setOpaque(true);
        deleteButtonDept.setBounds(10,275,150,30);
        deleteButtonDept.addActionListener(this);
        deleteButtonDept.setVisible(true);
        */
        
        // *** JPanel MENU Complete *** //
        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(true);
        panelMenu.setBackground(c2);
        panelMenu.setBounds(10,10,350,700);
        panelMenu.add(labelleft);
        panelMenu.add(createButtonEmpl);
        panelMenu.add(editButtonEmpl);
        panelMenu.add(deleteButtonEmpl);
        panelMenu.add(createButtonDept);
        //panelMenu.add(editButtonDept);
        //panelMenu.add(deleteButtonDept);
        panelMenu.setLayout(null);
        // LEFT SIDE END //
        
        /* 
        JScrollPane scrollPane = new JScrollPane();
        //PanelWork vom SplitPane(Right)
        scrollPane.setPreferredSize(new Dimension(345,450));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		*/
        
        // RIGHT SIDE START //
        // *** Right side of AdmWorkEmpPanel (SplitPane Right: WORKAREA) *** //
     	// *** Label *** //
        JLabel labelright = new JLabel("You are located as \"" + tempStat + "\" int the employee panel");
        labelright.setOpaque(true);
        labelright.setBounds(0,0,400,30);
        labelright.setBackground(ctop);
        labelright.setForeground(c2);
        labelright.setVisible(true);
        
		// *** JPanel WORK Complete*** //
        JPanel panelWork = new JPanel();
        panelWork.add(labelright);
//      panelWork.add(scrollPane);
        panelWork.setBackground(c2);
        panelWork.setBounds(400,10,350,700);
        panelWork.setLayout(null);
        // RIGHT SIDE END //
        
        // *************************** //
        // *** JSplitPane Complete *** //
        // *************************** //
        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitpane.setBounds(10,10,930,620);
        splitpane.setLeftComponent(panelMenu);
        splitpane.setRightComponent(panelWork);
        Dimension minimumSize = new Dimension(170, 50);
        panelMenu.setMinimumSize(minimumSize);
        panelWork.setMinimumSize(minimumSize);
        //splitpane.setLayout(null);
        
        // *** ACTIONS OF THE BUTTONS *** //
        createButtonEmpl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					createPanel3 createPanel3 = new createPanel3();
					splitpane.setRightComponent(createPanel3);
			}
			
		});
        editButtonEmpl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					editPanel3 editPanel3 = new editPanel3();
					splitpane.setRightComponent(editPanel3);
			}
			
		});
        deleteButtonEmpl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					deletePanel3 deletePanel3 = new deletePanel3();
					splitpane.setRightComponent(deletePanel3);
			}
			
		});
        createButtonDept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					createPanel32 createPanel32 = new createPanel32();
					splitpane.setRightComponent(createPanel32);
			}
			
		});
        /*
        editButtonDept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					editPanel32 editPanel32 = new editPanel32();
					splitpane.setRightComponent(editPanel32);
			}
			
		});
        deleteButtonDept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					deletePanel32 deletePanel32 = new deletePanel32();
					splitpane.setRightComponent(deletePanel32);
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
		if(e.getSource() == createButtonEmpl) {
			createPanel3 createPanel3 = new createPanel3();
			splitpane.setRightComponent(createPanel3);
		}
		/*
		if(e.getSource() == createButtonDept) {
			createPanel32 createPanel32 = new createPanel32();
			splitpane.setRightComponent(createPanel32);
		}
		
		if(e.getSource()== createButton) {
			createPanel3 createPanel3 = new createPanel3();
			splitpane.setRightComponent(createPanel3);
		}
		*/
	}
	
}


class createPanel3 extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton testButton;
	JLabel labelworkcreate, label3, label2, label1;
	
	static Color c1 = new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop = new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	LineBorder line = new LineBorder(c2, 1, true);
	
	static ArrayList<String> WorkDataList = new ArrayList<>();
	static ArrayList<String> AppData = new ArrayList<>();
	static ArrayList<String> PrivateDataList = new ArrayList<>();
	static ArrayList<String> DiverseDataList = new ArrayList<>();
	
	// LOCALE PATHS -> M�SSEN ANGEPASST WERDEN
	// Lokaler Path
	static Path currentPathPath1 = PathHandler.complWorkServerEmpPath;
	static String currentPathString1 = PathHandler.complWorkServerEmpPath.toString();
	//String workPath = System.getProperty("user.dir");
	//String CurrentPath1 = workPath + kompString;
	
	public createPanel3() {
		//Aussehen des createPanel
        setBackground(c2);
        setBounds(400,10,350,650);
        setLayout(null);
        
        //System.out.println(currentPathString1);
        
        // *** LABEL ***
        // Top Label um anzuzeigen in welchem Fenster der User sich gerade befindet
        JLabel labelworkcreate = new JLabel("Working Panel");
        labelworkcreate.setBounds(5,0,100,30);
        labelworkcreate.setBackground(ctop);
        labelworkcreate.setForeground(cwhite);
        labelworkcreate.setLayout(null);
		
        JTextField textfield = new JTextField();
		textfield.setBounds(165,0,700,30);
		textfield.setEditable(false);
		textfield.setText(currentPathString1);
		
        // *** EMPLOYEE PERSONALID *** //
        // Label-"MitarbeiterPersonalID"
		JLabel label0 = new JLabel("Employee Personal ID",SwingConstants.CENTER);
	    label0.setOpaque(true);
	    label0.setBounds(5,35,150,30);
	    label0.setBackground(ctop);
	    label0.setForeground(c2);
	    
	    // *** TEXTFELD ***
	    // TextField-"MitarbeiterPersonalID"
	    JTextField textField0 = new JTextField(30);
	    textField0.setBounds(165, 35, 200, 30);
	    textField0.setOpaque(true);
	    textField0.setBackground(c1);
	    textField0.setForeground(Color.white);
	    textField0.setBorder(line);
	    
	    // *** STATIS *** //
	    // Label-"Status"
	    JLabel label1 = new JLabel("Statis", 0);
	    label1.setOpaque(true);
	    label1.setBounds(5, 70, 150, 30); 
	    label1.setBackground(ctop);
	    label1.setForeground(c2);
	    
	    // Textfeld-"Status"  
	    JTextField textField1 = new JTextField(30);
	    textField1.setBounds(165, 70, 200, 30);
	    textField1.setOpaque(true);
	    textField1.setBackground(c1);
	    textField1.setForeground(Color.white);
	    textField1.setBorder(line);
	    
	    
	    // *** DEPARTMENTS *** //
	    JLabel label13 = new JLabel("Department", 0);
	    label13.setOpaque(true);
	    label13.setBounds(5, 105, 150, 30); 
	    label13.setBackground(ctop);
	    label13.setForeground(c2);
	    
	    // Textfeld-"Department" 
	    JTextField textField13 = new JTextField(30);
	    textField13.setBounds(165, 105, 200, 30);
	    textField13.setOpaque(true);
	    textField13.setBackground(c1);
	    textField13.setForeground(Color.white);
	    textField13.setBorder(line);
	    
	    
	    // Label-"Geschlech"
		JLabel label2 = new JLabel("Sex", 0);
	    label2.setOpaque(true);
	    label2.setBounds(5,140,150,30);
	    label2.setBackground(ctop);
	    label2.setForeground(c2);
	   
	    // Textfel"Geschlecht" 
	    JTextField textField2 = new JTextField(30);
	    textField2.setBounds(165, 140, 200, 30);
	    textField2.setOpaque(true);
	    textField2.setBackground(c1);
	    textField2.setForeground(Color.white);
	    textField2.setBorder(line);
	    
	    
	    // Label-"Name"
	    JLabel label3 = new JLabel("Second name", 0);
	    label3.setOpaque(true);
	    label3.setBounds(5, 175, 150, 30);
	    label3.setBackground(ctop);
	    label3.setForeground(c2);
	    
	    // Textfeld-"Name" 
	    JTextField textField3 = new JTextField(30);
	    textField3.setBounds(165, 175, 200, 30);
	    textField3.setOpaque(true);
	    textField3.setBackground(c1);
	    textField3.setForeground(Color.white);
	    textField3.setBorder(line);
	    
	    
	    // Label-"Vorname"
	    JLabel label4 = new JLabel("First name", 0);
	    label4.setOpaque(true);
	    label4.setBounds(5, 245, 150, 30);  
	    label4.setBackground(ctop);
	    label4.setForeground(c2);
	    
	    // Textfeld-"Vorname"  
	    JTextField textField4 = new JTextField(30);
	    textField4.setBounds(165, 245, 200, 30);
	    textField4.setOpaque(true);
	    textField4.setBackground(c1);
	    textField4.setForeground(Color.white);
	    textField4.setBorder(line);
	    //String[] Orte = textField4.getText().split(" ");
	                      
	    // *** Button *** 
	    //JButton descrButton = new JButton("Beschreibung");
	    //descrButton.setBounds(5, 210, 150, 30);
	    // ** Nach descrButton **
	    
	    
	    // Label-"Geburtstag"
	    JLabel label5 = new JLabel("Birthday", 0);
	    label5.setOpaque(true);
	    label5.setBounds(5, 280, 150, 30); 
	    label5.setBackground(ctop);
	    label5.setForeground(c2);
	    
	    // Textfeld-"Geburtstag" 
	    JTextField textField5 = new JTextField(30);
	    textField5.setBounds(165, 280, 200, 30);
	    textField5.setOpaque(true);
	    textField5.setBackground(c1);
	    textField5.setForeground(Color.white);
	    textField5.setBorder(line);
	    
	    
	    // Label-"Alter"
        JLabel label6 = new JLabel("Age", 0);
	    label6.setOpaque(true);
	    label6.setBounds(5, 315, 150, 30);
	    label6.setBackground(ctop);
	    label6.setForeground(c2);
	    
	    // Textfeld-"Alter" 
	    JTextField textField6 = new JTextField(30);
	    textField6.setBounds(165, 315, 200, 30);
	    textField6.setOpaque(true);
	    textField6.setBackground(c1);
	    textField6.setForeground(Color.white);
	    textField6.setBorder(line);
	    
	    
        // Label-"Adresse"
        JLabel label7 = new JLabel("Addresse", 0);
	    label7.setOpaque(true);
	    label7.setBounds(5, 350, 150, 30);
	    label7.setBackground(ctop);
	    label7.setForeground(c2);
	    
	    // Textfeld-"Adresse" 
	    JTextField textField7 = new JTextField(30);
	    textField7.setBounds(165, 350, 200, 30);
	    textField7.setOpaque(true);
	    textField7.setBackground(c1);
	    textField7.setForeground(Color.white);
	    textField7.setBorder(line);
	  
	    
	    // Label-"Plz"
	    JLabel label8 = new JLabel("ZIP Code", 0);
	    label8.setOpaque(true);
	    label8.setBounds(5, 385, 150, 30); 
	    label8.setBackground(ctop);
	    label8.setForeground(c2);
	    
	    // Textfeld-"Plz" 
	    JTextField textField8 = new JTextField(30);
	    textField8.setBounds(165, 385, 200, 30);
	    textField8.setOpaque(true);
	    textField8.setBackground(c1);
	    textField8.setForeground(Color.white);
	    textField8.setBorder(line);
	      
	   
	    // Label-"Ort"
	    JLabel label9 = new JLabel("Place", 0);
	    label9.setOpaque(true);
	    label9.setBounds(5, 420, 150, 30); 
	    label9.setBackground(ctop);
	    label9.setForeground(c2);
	    
	    // Textfeld-"Ort" 
	    JTextField textField9 = new JTextField(30);
	    textField9.setBounds(165, 420, 200, 30);
	    textField9.setOpaque(true);
	    textField9.setBackground(c1);
	    textField9.setForeground(Color.white);
	    textField9.setBorder(line);
	    
	    
	    // Label-"Familienstand"
	    JLabel label10 = new JLabel("Marital status", 0);
	    label10.setOpaque(true);
	    label10.setBounds(5, 455, 150, 30); 
	    label10.setBackground(ctop);
	    label10.setForeground(c2);
	    
	    // Textfeld-"Familienstand" 
	    JTextField textField10 = new JTextField(30);
	    textField10.setBounds(165, 455, 200, 30);
	    textField10.setOpaque(true);
	    textField10.setBackground(c1);
	    textField10.setForeground(Color.white);
	    textField10.setBorder(line);
	    
	    
	    // Label-"Gesch�fts-email"
	    JLabel label11 = new JLabel("Business email", 0);
	    label11.setOpaque(true);
	    label11.setBounds(5, 490, 150, 30); 
	    label11.setBackground(ctop);
	    label11.setForeground(c2);
	    
	    // Textfeld-"Gesch�fts-email" 
	    JTextField textField11 = new JTextField(30);
	    textField11.setBounds(165, 490, 200, 30);
	    textField11.setOpaque(true);
	    textField11.setBackground(c1);
	    textField11.setForeground(Color.white);
	    textField11.setBorder(line);
	    
	    
	    // Label-"Passwort"
	    JLabel label12 = new JLabel("Password", 0);
	    label12.setOpaque(true);
	    label12.setBounds(5, 525, 150, 30); 
	    label12.setBackground(ctop);
	    label12.setForeground(c2);
	         
	    // Textfeld-"Passwort" 
	    JPasswordField passwordField = new JPasswordField(30);
	    //JTextField textField12 = new JTextField(30);
	    passwordField.setBounds(165, 525, 200, 30);
	    passwordField.setOpaque(true);
	    passwordField.setBackground(c1);
	    passwordField.setForeground(Color.white);
	    passwordField.setBorder(line);
	    Random random = new Random();
	    int x = random.nextInt(100000)+1;
	    String randomNumString = Integer.toString(x);
	    passwordField.setText(randomNumString);
	    //System.out.println(collectedArrayList);
	   
	    // *** Button *** 
	    //JButton descrButton = new JButton("Beschreibung");
	    //descrButton.setBounds(5, 210, 150, 30);
	    
        // *** Button *** 
	    // Button um die Beschreibung der Veranstaltung zu erstellen
        JButton descrButton = new JButton("Decription");
        descrButton.setBounds(5,210, 150, 30);
        descrButton.setBackground(c1);
	    descrButton.setForeground(Color.white);
	    descrButton.addActionListener(new ActionListener() {
	    	
	    	/*
	    	 * �ffnet ein neues Fenster, in dem der User die Beschreibung der Veranstaltung schreiben kann.
	    	 * Von hier aus kann diese ggf. korrigiert werden. 
	    	 */
			@Override
			public void actionPerformed(ActionEvent e) {
					new DescriptionFrame();
					
			}	
		});
	    
	    // Button um eine Vorschau zu generieren
	    JButton previewButton = new JButton("Preview");
	    previewButton.setBounds(5,560, 150, 30);
	    previewButton.setBackground(c1);
	    previewButton.setForeground(Color.white);
	    previewButton.addActionListener(new ActionListener() {
	    	
	    	/*
	    	 * �ffnet ein neues Fenster, in dem der User die Beschreibung der Veranstaltung schreiben kann.
	    	 * Von hier aus kann diese ggf. korrigiert werden. 
	    	 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String personalID = textField0.getText();
				String status = textField1.getText();
				String department = textField13.getText();
				String geschlecht = textField2.getText();
				String name = textField3.getText();
				String vorname = textField4.getText();
				String geburtstag = textField5.getText();
				String alter = textField6.getText();
				String adresse = textField7.getText();
				String plz = textField8.getText();
				String ort = textField9.getText();
				String familienstand = textField10.getText();
				String geschaeftsemail = textField11.getText();
				char[] passwort = passwordField.getPassword();
				
				ArrayList<String> WorkDataList = VariablenHandler.CollectAndSaveInList(personalID, status, department);
				ArrayList<String> AppDataList = VariablenHandler.CollectAndSaveInList2(geschaeftsemail, passwort);
				ArrayList<String> PrivateDataList = VariablenHandler.CollectAndSaveInList(geschlecht, name, vorname,geburtstag,alter,adresse,plz,ort, familienstand);
				ArrayList<String> DiverseDataList = VariablenHandler.CollectAndSaveInList(personalID, status);
				/*
				 * @param1 collectedArrayList1 = gesammelte Werte aus den Textfeldern
				 * @param2 collectedArrayList2 = gesammelte Werte aus dem Place_Textfield
				 * @param3 collectedArrayList3 = gesammelte Werte aus dem Date_Textfield
				 * @param4 collectedArrayList4 = gesammelte Werte aus dem time_Textfield
				 * @param5 currentPath1 = aktuelle lokale Pfad im Verzeichnisbaum
				 */
				PreviewFrame3 PreviewFrame3 = new PreviewFrame3(WorkDataList, AppDataList, PrivateDataList, DiverseDataList, currentPathPath1);	
			}
			
		});
	    
	    // *** Zusammenf�gen aller einzelnen Elemente zu einem
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
	    add(label8);
	    add(label9);
	    add(label10);
	    add(label11);
	    add(label12);
	    add(label13);
	    add(textField0);
	    add(textField1);
	    add(textField2);
	    add(textField3);
	    add(textField4);
	    add(textField5);
	    add(textField6);
	    add(textField7);
	    add(textField8);
	    add(textField9);
	    add(textField10);
	    add(textField11);
	    add(textField13);
	    add(passwordField);
        add(descrButton);
        add(previewButton);
        
        // *** Sichbarkeiten erzeugen
        setVisible(true);
	}
}

class editPanel3 extends JPanel {

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
	
	public editPanel3() {
		
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

class deletePanel3 extends JPanel {

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
	
	public deletePanel3() {
		
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

class createPanel32 extends JPanel {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton button, button1, button2, button3, button4, button5;
	JLabel labelworkcreate, label3, label2, label1, firma;
	JTextField textfield, searchField;
	JScrollPane leiste, optionPane;
	JList<String> Verzeichniss;
	JList<String> resultList;
    JComboBox<String> filterComboBox;
    DefaultListModel<String> resultListModel;
	
	static Color c1 = new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop = new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	LineBorder line = new LineBorder(c2, 1, true);
	LineBorder line1 = new LineBorder(cyellow, 2, true);
	
	static String currentDirectory = PathHandler2.getDirectoryName();
	  //String currentDirectory= "Teststring f�r oben";
	String[] visuals = PathHandler2.getVisual();
	
	//username, name, path, tempStat
	String username = PathHandler2.getMail();
	String name = VerifyLogin.nameString;
	String path = PathHandler2.currentPath;
	String tempStat = PathHandler2.statis;
	
	// LOCALE PATHS -> M�SSEN ANGEPASST WERDEN
	// Lokaler Path
	static Path currentPathPath1 = PathHandler.complWorkServerEmpPath;
	static String currentPathString1 = PathHandler.complWorkServerEmpPath.toString();
	//String workPath = System.getProperty("user.dir");
	//String CurrentPath1 = workPath + kompString;
	
	public createPanel32() {
		
        setBackground(c2);
        setBounds(400,10,350,650);
        setLayout(null);
        
        //System.out.println(currentPathString1);
        
        // *** Top Label *** //
        labelworkcreate = new JLabel("Working Panel");
        labelworkcreate.setBounds(5,0,100,30);
        labelworkcreate.setBackground(ctop);
        labelworkcreate.setForeground(cwhite);
        labelworkcreate.setLayout(null);
		
        // *** TextField *** //
        textfield = new JTextField();
		textfield.setBounds(150,0,700,30);
		textfield.setEditable(false);
		textfield.setText(currentPathString1);
		
		// *** Directory overview *** //
	    label2 = new JLabel("You are in the directory: " + currentDirectory,0);
	    label2.setOpaque(true);
	    label2.setBounds(150,35,535,30);
	    label2.setBackground(c1);
	    label2.setForeground(Color.WHITE);
	    
	    // *** Top directory Button *** //
	    button = new JButton("Top directory");      
	    button.setOpaque(true);
	    button.setBackground(cblue);
	    button.setForeground(Color.WHITE);
	    button.setBounds(5,70,140,30);
	   
	    // *** Open files Button *** //
	    button1 = new JButton("Open");
	    button1.setOpaque(true);
	    button1.setBackground(cblue);
	    button1.setForeground(Color.WHITE);
	    button1.setBounds(5,105,140,30);
	    
	    // *** Create directory Button *** //
	    button2 = new JButton("Create directory");
	    button2.setMargin(new Insets(0, 0, 0, 0));
	    button2.setOpaque(true);
	    button2.setBackground(cblue);
	    button2.setForeground(Color.WHITE);
	    button2.setBounds(5,140,140,30);
	   
	    // *** Create file Button *** //
	    button3 = new JButton("Create file");
	    button3.setOpaque(true);
	    button3.setBackground(cblue);
	    button3.setForeground(Color.WHITE);
	    button3.setBounds(5,175,140,30);
	    
	    // *** Rename Button *** //
	    button4 = new JButton("Rename");      
	    button4.setOpaque(true);
	    button4.setBackground(cblue);
	    button4.setForeground(Color.WHITE);
	    button4.setBounds(5,210,140,30);
	    
	    // *** Delete Button *** //
	    button5 = new JButton("Delete File");      
	    button5.setOpaque(true);
	    button5.setBackground(cblue);
	    button5.setForeground(Color.WHITE);
	    button5.setBounds(5,245,140,30);
	    
	    // *** Bar *** //
	    Verzeichniss = new JList<String>(visuals);
	    Verzeichniss.setOpaque(true);
	    Verzeichniss.setBounds(150,70,535,300);
	    Verzeichniss.setBackground(ctop);
	    Verzeichniss.setForeground(c2);
	    Verzeichniss.setFixedCellHeight(30);
	  
	    // *** ScrollPanel for the bar *** //
	    leiste = new JScrollPane(Verzeichniss);
	    leiste.setOpaque(true);
	    leiste.setBounds(175,70,350,300);
	    leiste.setBorder(line1);
	    
	    // *** Search Field *** //
	    searchField = new JTextField();
	    searchField.setOpaque(true);
	    searchField.setBounds(150, 365, 535, 30);
	    
	    // *** COMBOBOX *** //
	    filterComboBox = new JComboBox<>(PathHandler2.fileTypes);
	    filterComboBox.setOpaque(true);
	    filterComboBox.setBackground(ctop);
	    filterComboBox.setForeground(c2);
	    filterComboBox.setBounds(5, 400, 140, 30);
        
	    // *** Result List *** //
        resultListModel = new DefaultListModel<>();
        resultList = new JList<String>(resultListModel);
        optionPane = new JScrollPane(resultList);
        optionPane.setOpaque(true);
        optionPane.setBounds(150,400,535,100);
        optionPane.setBorder(line1);
        optionPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // *** ActionListener of 
        ActionListener searchListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResultList();
            }
        };
        searchField.addActionListener(searchListener);
        filterComboBox.addActionListener(searchListener);

        // *** Initialization of the List *** //
        updateResultList();
        
	    // *** ACTIONS OF THE BUTTONS *** //
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TOP DIRECTORY
				// DirectoryFunctions closeDirectory
				DirectoryFunctions dh = new DirectoryFunctions();
				dh.closeDirectory();
					
			}
			
		});
        button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// OPEN FILE OR DIRECTORY
				String directoryName = getChosen();
				if (directoryName.contains(".")) {
					try {
						// DateiAnsicht
						FileDirectoryView da = new FileDirectoryView();
						da.GUIFileDirectoryScreen(directoryName);
			          	
						/*
						JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
				        tempMainFrame.dispose();
			          	frame.setVisible(false);
			          	DateiAnsicht da  = new DateiAnsicht ();
			          	da.dateiAnsichtGUI(directoryName);      
			          	*/
			        } catch (Exception e2) {
			          	e2.printStackTrace();  
			        }
			    } // end of if
			    if (directoryName.contains(".") == false) {   
			        
			        // DirectoryHandler openDirectory
					DirectoryFunctions dh = new DirectoryFunctions();
					dh.openDirectory(directoryName);
					
					JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
			        tempMainFrame.dispose();
			        GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
					restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
				} // end of if-else
			}
		});
        button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// CREATE DIRECTORY
				// DirectoryScreen GUIcreateDirectoryScreen
				DirectoryScreen cd = new DirectoryScreen();
			    cd.GUIcreateDirectoryScreen();
			}
		});
        button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// CREATE FILE
				// CreateFileScreen GUIcreateDataScreen
				FileScreen cf = new FileScreen();
				cf.GUIcreateDataScreen();
			}
		});
        button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// RENAME FILE OR DIRECTORY
				String data = getChosen();
			    if (data.contains(".") && data.equals("Logbook.txt") == false) {
			    	RenameFileSceen rf = new RenameFileSceen();
			        rf.GUIRenameFileScreen(data);
			        //frame.setVisible(false);
				} // end of if
				if (data.contains(".") == false) {
			        RenameDirectoryScreen rd = new RenameDirectoryScreen();
			        rd.GUIRenameDirectoryScreen(data);;
			        
			        //frame.setVisible(false);
				} // end of if
				if (data.equals("Logboo)k.txt")) {
			        JOptionPane.showMessageDialog(null, "Logbook darf nicht umbenannt werden.", "Warnung", JOptionPane.PLAIN_MESSAGE);
				} // end of if      
			}
		});
        button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// DELETE FILE OR DIRECTORY
				String chosen = getChosen();
			      if (chosen == null) {
			        JOptionPane.showMessageDialog(null, "Select file or directory to delete", "Warnung", JOptionPane.PLAIN_MESSAGE);
			      } // end of if
			      else {
			        if (chosen.contains(".") && chosen.equals("Logbook.txt") == false) {
			          FileFunctions fh = new FileFunctions();
			          fh.deleteFile(chosen);
			          
			          
			          //frame.setVisible(false);
			        } // end of if
			        if (chosen.contains(".") == false) {
			          DirectoryFunctions dh = new DirectoryFunctions();
			          dh.deleteDirectory(chosen);
			          
			          
			          //frame.setVisible(false);
			        } // end of if
			        if (chosen.equals("Logbook.txt")) {
			          JOptionPane.showMessageDialog(null, "Logbook must not be deleted.", "Warnung", JOptionPane.PLAIN_MESSAGE);
			        } // end of if
			      } // end of if-else
			} // end of actionPerformed
		});
        
	    // *** Completion of the panel *** //
	    add(labelworkcreate);
	    add(textfield);
	    add(label2);
	    add(button);
	    add(button1);
	    add(button2);
	    add(button3);
	    add(button4);
	    add(button5);
	    add(Verzeichniss);
	    add(leiste);
	    add(searchField);
        add(filterComboBox);
        add(optionPane);
        
        // *** Create visibilities *** //
        setVisible(true);
        
	}
	
	/*
	 * 
	 */
	private void updateResultList() {
        resultListModel.clear();
        String searchText = searchField.getText().toLowerCase();
        String filter = filterComboBox.getSelectedItem().toString();
        for (String item : visuals) {
        	if (filter.equals("All") || item.toLowerCase().contains(filter.toLowerCase())) {
        		if (item.toLowerCase().contains(searchText)) {
        			resultListModel.addElement(item);
        		}
        	}
        }
    }

	/*
	 * Hier werden die Elemente f�r die JListe zu einem String umgewandelt
	 * 
	 * @return chosen ist der Dateiname als String.
	 */
	public String getChosen(){                                                
		String chosen = (String) Verzeichniss.getSelectedValue();
		return chosen;
	}  
}

/*
class editPanel32 extends JPanel {

	
	private static final long serialVersionUID = 1L;
	JButton testButton;
	JLabel labelGelb2;
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	public editPanel32() {
		
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

class deletePanel32 extends JPanel {

	
	private static final long serialVersionUID = 1L;
	JButton testButton;
	JLabel labelGelb2;
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	public deletePanel32() {
		
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
*/

