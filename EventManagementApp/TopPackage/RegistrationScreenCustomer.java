package TopPackage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Language.LanguageModul_English;
import Language.LanguageModul_France;
import Language.LanguageModul_German;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationScreenCustomer extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 
	 */
	JFrame frame = null;
	JPanel panel = new JPanel();
	JLabel titellabel, label2, anrlabel, pwlabel, pwlabel2, vnlabel, nnlabel, altlabel, benutznlabel, emaillabel;
	JTextField titel, benutzn, email, vn, nn, alt;
	JButton reg, fi, ba;
	JScrollPane anredescroller;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem engItem, gerItem, frenItem;
	String anrede, mail, zusatz, alter, vorname, nachname, benutzername;
	
	Color c1 = new Color(55, 63, 93);
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
	
	LineBorder line= new LineBorder(c1, 1, true);
	
	static JList<String> anredeListe = new JList<>(new String[]{"Herr", "Frau", "Diverse"});
	static JTextArea anr;
	static JPasswordField pw = new JPasswordField(30);
    static JPasswordField pw2 = new JPasswordField(30);
    static char[] passwort;
	static char[] passwort2;
	
	public static Scanner x; 
	// public static ArrayList<String> tempAppStartArrayList = LanguageModul_English.getAppStartLanguage();
	public static ArrayList<String> tempRegList = LanguageModul_English.getRegLanguage();
	public static String warnString = tempRegList.get(12);
	
	// *** MAIN FOR TEST PURPOSE *** //
	/*	
 	public static void main(String[] args){
		RegistrierungsScreenCustomer start = new RegistrierungsScreenCustomer();
		start.GUIRegistrierungCustomer();
	}
	 */
	
	/***********
	 *** GUI ***
	 ***********/
	public void GUIRegistrationCustomer(ArrayList<String> appStart, ArrayList<String> regList) {
		

		frame = new JFrame ("Ultimate-Events");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setSize(500,650);
	    frame.setLocationRelativeTo(null);
	    frame.add(panel);
	    panel.setBackground(c2);
	    panel.setLayout(null);
	    //frame.setLayout(new GridLayout(4, 1, 10, 10));
	    
	    menuBar = new JMenuBar();
		fileMenu = new JMenu(appStart.get(0));
		engItem = new JMenuItem(appStart.get(1));
		gerItem = new JMenuItem(appStart.get(2));
		frenItem = new JMenuItem(appStart.get(3));
	
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
		
	    // regList->(regTitleString, zusatzString, salutationString, surNameString, firstNameString, 
		// ageString, mailAddresseString, userNameString, typePasswordString, 
		// repeatPasswordString, registNowString, backWithoutString, passwordWarningString)
		
	    //Top Label
	    label2 = new JLabel(regList.get(0),0);
	    label2.setOpaque(true);
	    label2.setBounds(0,0,500,30);
	    label2.setBackground(ctop);
	    label2.setForeground(c2);
	    //Titel(Dr., Med., Prof., Baron etc.)
	    titellabel = new JLabel(regList.get(1),0);
	    titellabel.setOpaque(true);
	    titellabel.setBackground(ctop);
	    titellabel.setForeground(c2);
	    titellabel.setBounds(40, 50, 140, 30);
	    titel = new JTextField();
	    titel.setOpaque(true);
	    titel.setBackground(c1);
	    titel.setForeground(Color.white);
	    titel.setBorder(line);
	    titel.setBounds(190, 50, 260, 30);
		
	    //Anrede
		anrlabel = new JLabel(regList.get(2),0);  
	    anrlabel.setOpaque(true);
	    anrlabel.setBackground(ctop);
	    anrlabel.setForeground(c2);
	    anrlabel.setBounds(40, 90, 70, 30);
	    
	    //anredeListe.addListSelectionListener(ListSelectionList);
	    anredescroller = new JScrollPane(anredeListe);
	    anredescroller.setBounds(110,90,70,30);
	    anredescroller.setBackground(ctop);
	    anredescroller.setForeground(c2);
	    anredeListe.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = anredeListe.getSelectedIndex();
                    String selectedItem = anredeListe.getModel().getElementAt(selectedIndex);
                    anr.setText(selectedItem);
                }
            }
        });
	    anr = new JTextArea();
	    anr.setOpaque(true);
	    anr.setBackground(c1);
	    anr.setForeground(Color.white);
	    anr.setBorder(line);
	    anr.setBounds(190, 90, 260, 30);
	   
	    nnlabel = new JLabel(regList.get(3),0);
	    nnlabel.setOpaque(true);
	    nnlabel.setBackground(ctop);
	    nnlabel.setForeground(c2);
	    nnlabel.setBounds(40, 130, 140, 30);
	    nn = new JTextField();
	    nn.setOpaque(true);
	    nn.setBackground(c1);
	    nn.setForeground(Color.white);
	    nn.setBorder(line);
	    nn.setBounds(190, 130, 260, 30);
	    
	    vnlabel = new JLabel(regList.get(4),0);  
	    vnlabel.setOpaque(true);
	    vnlabel.setBackground(ctop);
	    vnlabel.setForeground(c2);
	    vnlabel.setBounds(40, 170, 140, 30);
	    vn = new JTextField();
	    vn.setOpaque(true);
	    vn.setBackground(c1);
	    vn.setForeground(Color.white);
	    vn.setBorder(line);
	    vn.setBounds(190, 170, 260, 30);
	    
	    altlabel = new JLabel(regList.get(5),0);  
	    altlabel.setOpaque(true);
	    altlabel.setBackground(ctop);
	    altlabel.setForeground(c2);
	    altlabel.setBounds(40, 210, 140, 30);
	    alt = new JTextField();
	    alt.setOpaque(true);
	    alt.setBackground(c1);
	    alt.setForeground(Color.white);
	    alt.setBorder(line);
	    alt.setBounds(190, 210, 260, 30);
	    
	    emaillabel = new JLabel(regList.get(6),0);
	    emaillabel.setOpaque(true);
	    emaillabel.setBackground(ctop);
	    emaillabel.setForeground(c2);
	    emaillabel.setBounds(40, 250, 140, 30);
	    email = new JTextField();
	    email.setOpaque(true);
	    email.setBackground(c1);
	    email.setForeground(Color.WHITE);
	    email.setBorder(line);
	    email.setBounds(190, 250, 260, 30);
	    
	    benutznlabel = new JLabel(regList.get(7),0);
	    benutznlabel.setOpaque(true);
	    benutznlabel.setBackground(ctop);
	    benutznlabel.setForeground(c2);
	    benutznlabel.setBounds(40, 290, 140, 30);
	    benutzn = new JTextField();
	    benutzn.setOpaque(true);
	    benutzn.setBackground(c1);
	    benutzn.setForeground(Color.WHITE);
	    benutzn.setBorder(line);
	    benutzn.setBounds(190, 290, 260, 30);
	    
	    pwlabel = new JLabel(regList.get(8),0);
	    pwlabel.setOpaque(true);
	    pwlabel.setBackground(ctop);
	    pwlabel.setForeground(c2);
	    pwlabel.setBounds(40, 330, 140, 30);
	    pw = new JPasswordField(30);
	    pw.setOpaque(true);
	    pw.setBackground(c1);
	    pw.setForeground(Color.white);
	    pw.setBorder(line);
	    pw.setBounds(190, 330, 260, 30);
	    
	    pwlabel2 = new JLabel(regList.get(9),0);
	    pwlabel2.setOpaque(true);
	    pwlabel2.setBackground(ctop);
	    pwlabel2.setForeground(c2);
	    pwlabel2.setBounds(40, 370, 140, 30);
	    pw2 = new JPasswordField(30);
	    pw2.setOpaque(true);
	    pw2.setBackground(c1);
	    pw2.setForeground(Color.white);
	    pw2.setBorder(line);
	    pw2.setBounds(190, 370, 260, 30);
	    
	    reg = new JButton(regList.get(10));
	    reg.setBounds(40,410,410,60);
	    reg.setOpaque(true);
	    reg.addActionListener(this);
	    reg.setBackground(cblue);
	    reg.setForeground(Color.white);
	    
	    ba = new JButton(regList.get(11));
	    ba.setBounds(40,480,410,60);
	    ba.setOpaque(true);
	    ba.addActionListener(this);
	    ba.setBackground(cblue);
	    ba.setForeground(Color.white);
	    
	    //panel.add(label);
	    panel.add(label2);
	    panel.add(titellabel);
	    panel.add(titel);
	    
	    panel.add(anrlabel);
	    panel.add(anredescroller);
	    panel.add(anr);
	    
	    panel.add(nnlabel);
	    panel.add(nn);
	    panel.add(vnlabel);
	    panel.add(vn);
	    
	    panel.add(altlabel);
	    panel.add(alt);
	    
	    panel.add(emaillabel);
	    panel.add(email);
	    
	    panel.add(benutznlabel);
	    panel.add(benutzn);
	    panel.add(pwlabel);
	    panel.add(pw);
	    panel.add(pwlabel2);
	    panel.add(pw2);
	    
	    panel.add(reg);
	    panel.add(ba);
	    
	    frame.setVisible(true);
	}
	
	//Funktioniert nicht
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reg) {
			zusatz = titel.getText();
			anrede = anr.getSelectedText();
			mail = email.getText();
			vorname = vn.getText();
			nachname = nn.getText();
			passwort = pw.getPassword();
			passwort2 = pw2.getPassword();
			alter = alt.getText();
			benutzername = benutzn.getText();
			if(passwort != passwort2) {
				JOptionPane.showMessageDialog(null, warnString, "Warnung", JOptionPane.PLAIN_MESSAGE);
    		}                            
//			    UserRegister ure = new UserRegister();
//			    ure.UserRegister(nachname, vorname, passwort, mail);
//			    frame.setVisible(false); 
		}
		if (e.getSource() == ba) {	  
			//TopRegistrationScreen GUITopRegistrierung
			TopRegistrationScreen registrierung = new TopRegistrationScreen();
			registrierung.GUITopRegistrierung();
			frame.setVisible(false);   
		}
	}
}
