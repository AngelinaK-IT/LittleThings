package TopPackage;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Die Klasse, welche das Overlay für die Umbennug von Dateien zur Verfügung stellt.
 * Da sie mit GUIs aufgebaut wird, wird sie mit der vordefinierten Klasse JFrame erweitert und die vordefinierte Klasse. 
 * ActionListener wird implementiert.
 * 
 * @version 1.0.
 * @author Gruppe xxx.
 * 
 */
// RenameFileSceen GUIRenameFileScreen
public class RenameFileSceen extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel= new JPanel();
	JButton button1;
	JButton button2;
	JLabel label, label1, label2;
	JTextField textField1, littleHelper;
	
	Color c2=new Color(20, 26, 50);
	Color cwhite= new Color(210, 210, 215);
	Color ctop=new Color(128, 156, 245);
	Color cyellow= new Color(207, 180, 94);
	Color cblue= new Color(62, 101, 251);
	Color c1= new Color(55, 63, 93);
	LineBorder line= new LineBorder(c2, 1, true);
	
	//username, name, path, tempStat
 	String username = PathHandler2.getMail();
 	String name = VerifyLogin.nameString;
 	String path = PathHandler2.currentPath;
 	String tempStat = PathHandler2.statis;
 	
    /*
     * Diese Funktion erstellt, den Bildschirm für die Umbennung einer Datei.
     *
     * @param data ist die Datei die umbenannt wird.
     */
 	public void GUIRenameFileScreen(String data) {

 		// *** FENSTER ***
 		frame = new JFrame("Ultimate-events");
 		frame.setSize(500, 300);                        		// Fenster: Groeöe
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Fenster bei x-Button schlieÃŸen
 		frame.setResizable(false);                        		// Fenstergrösse nicht veänderbar
 		frame.setLocationRelativeTo(null);
 		frame.add(panel);
 		panel.setBackground(c2);
 		panel.setLayout(null);                          		// Layout-Manager - null = Eigenbestimmung
 		frame.requestFocus();                         			// Fokus auf Fenster soll bleiben
    
 		label = new JLabel("Rename file", SwingConstants.CENTER);
 		label.setOpaque(true);
 		label.setBounds(0,0,500,30);
 		label.setBackground(ctop);
 		label.setForeground(c2);

 		// *** LABEL ***
 		// Label-"Name der Datei"
 		label1 = new JLabel("New directory name",0);
 		label1.setOpaque(true);
 		label1.setBounds(55,90,160,30);
 		label1.setBackground(ctop);
 		label1.setForeground(c2);
    
 		label2 = new JLabel("Datatype: " + data.substring(getIndexOfDot(data)));
 		label2.setBounds(55, 130, 370, 30);
 		label2.setBackground(ctop);
 		label2.setForeground(c2);
 		label2.setOpaque(true);
 		System.out.println(data.substring(getIndexOfDot(data))); 
    
 		// *** TEXTFELD ***
 		// Textfeld-"Name der Datei"  
 		textField1 = new JTextField(30);
 		textField1.setBounds(225, 90, 200, 30);
 		textField1.setBackground(c1);
 		textField1.setBorder(line);
 		textField1.setForeground(Color.WHITE);
    
 		littleHelper = new JTextField(data);
    
 		// *** BUTTON ***
 		// Close-Button
 		button1 = new JButton("Close");
 		button1.setBounds(55, 170, 160, 30);
 		button1.setBackground(cblue);
 		button1.setForeground(Color.WHITE);
 		button1.addActionListener(this);             			// Aktion bei Klick auf Button
    
 		// Ok-Button
 		button2 = new JButton("Accepted");
 		button2.setBounds(225, 170, 200, 30);
 		button2.setBackground(cblue);
 		button2.setForeground(Color.WHITE);
 		button2.addActionListener(this);             			// Aktion bei Klick auf Button
    
 		panel.add(button1);                           			// Button in Fenster hinzufügen
 		panel.add(button2);                           			// Button in Fenster hinzuügen
 		panel.add(label1);                            			// Label in Fenster hinzufügen
 		panel.add(textField1);                          		// Textfeld in Fenster hinzufügen
 		panel.add(label2);
 		panel.add(label);
    
 		frame.setVisible(true);                         		// Fenster sichtbar
 	}
  
 	/*
 	 * Diese Methode speichert die änderung des Namens oder verwirft sie (abhÄngig vom gedrÜckten Knopf).
 	 * Des weiteren wird nach änderung die üersicht aktualisiert.
 	 * 
 	 * @see Ubersicht.
 	 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
 	 * 
 	 * Es gibt keinen Rückgabewert
 	 */
 	public void actionPerformed (ActionEvent e){
 		if (e.getSource() == button2) {
 			String current =  littleHelper.getText();
 			String next = (textField1.getText() + littleHelper.getText().substring(getIndexOfDot(littleHelper.getText())));
      
 			FileFunctions fh = new FileFunctions();
 			fh.renameFile(current, next);
      
 			frame.setVisible(false);
 		} // end of if
 		if (e.getSource() == button1) {
 			GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
 			restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
		
 			frame.setVisible(false);
 		} // end of if        
 	}
  
 	/*
 	 * Mit dieser Methode wird die Endung der Datei extrahiert.
 	 * 
 	 * @param name ist der Name der Datei.
 	 * 
 	 * @return i ist die Stelle, an der die Endung der Datei beginnt.
 	 */
 	public int getIndexOfDot(String name){                                
 		char[] string = name.toCharArray();                                       
 		int i = 0;
    
 		while (string[i] != '.') { 
 			i++;
 		} // end of while
 		return i;
 	}    
}

