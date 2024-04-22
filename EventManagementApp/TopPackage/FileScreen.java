package TopPackage;

import java.awt.Color;
import java.io.File;
import java.util.Scanner;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Paths;
import java.lang.Object.*;                                                     
import java.nio.file.Path;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Diese Klasse erstellt das Fenster um eine Datei zu erstellen.
 * 
 * @version 1.0.
 * @author Gruppe xxx
 */
// FileScreen GUIcreateDataScreen
public class FileScreen implements ActionListener{

	static JButton button1;
	static JButton button2;
	static JLabel label1;
	static JLabel label2;
	static JLabel label3; 
	static JTextField textField1;
	static JComboBox<String> comboBox1;
	
	JFrame frame;
	JPanel panel = new JPanel();
	Color c2 = new Color(20, 26, 50);
	Color cwhite = new Color(210, 210, 215);
	Color ctop = new Color(128, 156, 245);
	Color cyellow = new Color(207, 180, 94);
	Color cblue = new Color(62, 101, 251);
	Color c1 = new Color(55, 63, 93);
	LineBorder line = new LineBorder(c2, 1, true);
	
	//username, name, path, tempStat
	String username = PathHandler2.getMail();
	String name = VerifyLogin.nameString;
	String path = PathHandler2.currentPath;
	String tempStat = PathHandler2.statis;
	
	/*
	 * Diese Funktion erstellt das Fenster in dem die Eingaben zur Anmeldung getätigt werden können.
	 * 
	 * es gibt keine Ein- & Ausgabeparameter.
	 */
	public void GUIcreateDataScreen() {

		// Fenster erstellen
		frame = new JFrame("Ultimate-events");
		frame.setSize(500, 300);                        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
		frame.setResizable(false);                       
		frame.setLocationRelativeTo(null);                 
		frame.add(panel);
		panel.setBackground(c2);
		panel.setLayout(null);                         
		frame.requestFocus();                         

		// Übersichtslabel
		label3 = new JLabel("Create new File", SwingConstants.CENTER);
		label3.setOpaque(true);
		label3.setBounds(0,0,500,30);
		label3.setBackground(ctop);
		label3.setForeground(c2);
		
		// *** LABEL ***
		// Label-"Name des Ordners"
		label1 = new JLabel("Name of file",0);
		label1.setOpaque(true);
		label1.setBackground(ctop);
		label1.setForeground(c2);
		label1.setBounds(85, 90, 100, 30);                   
  
		// Label-"Dateityp"
		label2 = new JLabel("File type",0);
		label2.setOpaque(true);
		label2.setBackground(ctop);
		label2.setForeground(c2);
		label2.setBounds(85, 130, 100, 30);                    

		// *** TEXTFELD ***
		// Textfeld-"Name des Ordners"  
		textField1 = new JTextField(30);
		textField1.setBounds(195, 90, 200, 30);
		textField1.setOpaque(true);
		textField1.setBackground(c1);
		textField1.setForeground(Color.white);
		textField1.setBorder(line);
  
		// *** COMBOBOX ***
		// Combobox-"Dateityp"
		String[] fileTypes = {".txt", ".docx", ".xlsx", ".pdf", ".png", ".jpg", ".bmp", ".mp3", ".wav", ".mp4", ".mpg", ".tex", ".bib", ".java", ".csv", ".db" };
		comboBox1 = new JComboBox<>(fileTypes);
		comboBox1.setOpaque(true);
		comboBox1.setBackground(ctop);
		comboBox1.setForeground(c2);
		comboBox1.setBounds(195, 130, 200, 30);
  
		// *** BUTTON ***
		// OK-Button
		button2 = new JButton("Close");
		button2.setBounds(85, 170, 100, 30);                 
		button2.setBackground(cblue);           
		button2.setFocusPainted(true);                     
		button2.setForeground(Color.WHITE);
		button2.setBorder(line);     // Button: Rahmen
		button2.addActionListener(this);             
		button2.setVisible(true);                     
  
		// Close-Button
		button1 = new JButton("Accepted");
		button1.setBounds(195, 170, 200, 30);                 
		button1.setBackground(cblue);            
		button1.setForeground(Color.WHITE);
		button1.setFocusPainted(true);                    
		button1.setBorder(line);     // Button: Rahmen
		button1.addActionListener(this);             
		button1.setVisible(true);                     
                      
		panel.add(button1);                         
		panel.add(button2);                           
		panel.add(label1);                            
		panel.add(label2);                            
		panel.add(textField1);                          
		panel.add(comboBox1);                         
		panel.add(label3);
    
		frame.setVisible(true);                      
	}
	
	/*
	 * Mit dem actionEvent wird entweder die Anlegung abgerochen (Szenario 2) und es wird zum FileHandler zurückgekehrt oder die Daten werden an den FileHandler zur Erstellung übergeben.
	 * 
	 * @see FileHandler.
	 * @see Ubersicht.
	 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
	 * 
	 * Es gibt keinen Rückgabewert.
	 */
	public void actionPerformed(ActionEvent e){
		// ACCEPTED //
		if (e.getSource() == button1) {
			String name = textField1.getText();
			String end = comboBox1.getSelectedItem().toString();
			FileFunctions fh = new FileFunctions();
			try {
				fh.createFile(name , end);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			frame.setVisible(false);
		} // end of if
		// CLOSE //
		if (e.getSource() == button2) {
			GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
			restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
			frame.setVisible(false);
		} // end of if
	} // end of actionPerformed
}

