package TopPackage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class AnmeldeScreen extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = null;
	JPanel panel = new JPanel();
	
	JLabel label2, pwlabel, benutznlabel, emaillabel;
	JTextArea anr;
	JTextField benutzn, email, pw;
	String mail, passwort, benutzer, name;
	JButton an, ba;
	
	Color c1 = new Color(55, 63, 93);
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
	
	LineBorder line = new LineBorder(c1, 1, true);

	public static Scanner x; 
	
	//GUI Aussehen
	public void GUIAnmeldung() {
		
		frame = new JFrame ("Ultimate-Events");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setSize(500,500);
	    frame.setLocationRelativeTo(null);
	    frame.add(panel);
	    panel.setBackground(c2);
	    panel.setLayout(null);
	    //frame.setLayout(new GridLayout(4, 1, 10, 10));
	    
	    label2= new JLabel("Login",0);
	    label2.setOpaque(true);
	    label2.setBounds(0,0,500,30);
	    label2.setBackground(ctop);
	    label2.setForeground(c2);
	    
	    emaillabel= new JLabel("Mail address",0);
	    emaillabel.setOpaque(true);
	    emaillabel.setBackground(ctop);
	    emaillabel.setForeground(c2);
	    emaillabel.setBounds(40, 170, 140, 30);
	    
	    email = new JTextField();
	    email.setOpaque(true);
	    email.setBackground(c1);
	    email.setForeground(Color.WHITE);
	    email.setBorder(line);
	    email.setBounds(190, 170, 260, 30);
	    
	    benutznlabel = new JLabel("Username",0);
	    benutznlabel.setOpaque(true);
	    benutznlabel.setBackground(ctop);
	    benutznlabel.setForeground(c2);
	    benutznlabel.setBounds(40, 210, 140, 30);
	    
	    benutzn = new JTextField();
	    benutzn.setOpaque(true);
	    benutzn.setBackground(c1);
	    benutzn.setForeground(Color.WHITE);
	    benutzn.setBorder(line);
	    benutzn.setBounds(190, 210, 260, 30);
	    
	    pwlabel = new JLabel("Enter password",0);
	    pwlabel.setOpaque(true);
	    pwlabel.setBackground(ctop);
	    pwlabel.setForeground(c2);
	    pwlabel.setBounds(40, 250, 140, 30);
	    
	    pw = new JTextField("");
	    pw.setOpaque(true);
	    pw.setBackground(c1);
	    pw.setForeground(Color.white);
	    pw.setBorder(line);
	    pw.setBounds(190, 250, 260, 30);
	    
	    an = new JButton("Login");
	    an.setBounds(40,300,410,60);
	    an.setOpaque(true);
	    an.setBackground(cblue);
	    an.setForeground(Color.white);
	    an.addActionListener(this);
	    
	    ba = new JButton("Back");
	    ba.setBounds(40,370,410,60);
	    ba.setOpaque(true);
	    ba.setBackground(cblue);
	    ba.setForeground(Color.white);
	    ba.addActionListener(this);
	    
	    //panel.add(label);
	    panel.add(label2);
	    panel.add(emaillabel);
	    panel.add(email);
	    panel.add(benutznlabel);
	    panel.add(benutzn);
	    panel.add(pwlabel);
	    panel.add(pw);
	    panel.add(an);
	    panel.add(ba);
	    
	    frame.setVisible(true);
	}
	
	//Main für Tests
	public static void main(String[] args){
		AnmeldeScreen start = new AnmeldeScreen();
		start.GUIAnmeldung();
	}
	
	
	//Funktioniert nicht
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == an) {
			
		    benutzer = email.getText();
		    name = benutzn.getText();
		    passwort = pw.getText();
		    
		    VerifyLogin log = new VerifyLogin();
		    log.verifyLogin(benutzer, name, passwort);
		    
		    frame.setVisible(false);
		    
		}
		if (e.getSource() == ba) {
			
			//ApplicationScreenCompany GUIStartCompany
			ApplicationScreenCompany go = new ApplicationScreenCompany();
			go.GUIStartCompany();
			
			frame.setVisible(false);
			
		}
	}

		
}

	


