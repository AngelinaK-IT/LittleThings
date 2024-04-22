package TopPackage;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/*
 * Die Klasse, welche das Overlay für die Umbennug von Dateien zur Verfügung stellt.
 * Da sie mit GUIs aufgebaut wird, wird sie mit der vordefinierten Klasse JFrame erweitert und die vordefinierte Klasse. 
 * ActionListener wird implementiert.
 * 
 * @version 1.0.
 * @author Gruppe 11.
 */
public class RenameDirectoryScreen extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel= new JPanel();
	JButton button1;
	JButton button2;
	JLabel label1, label;
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
  	 * Diese Funktion erstellt, den Bildschirm für die Umbennung des Verzeichnisses.
  	 *
  	 * @param current ist der aktuelle Ordner.
  	 *
  	 */
  	public void GUIRenameDirectoryScreen(String current) {
   
  		// *** FENSTER ***
  		frame = new JFrame("Ulitmate-events");
  		frame.setSize(500, 300);                        
  		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
  		frame.setResizable(false);                        
  		frame.setLocationRelativeTo(null);
  		frame.add(panel);
  		panel.setBackground(c2);                    
  		panel.setLayout(null);                          
  		frame.requestFocus(); 
  		//JLabel                       
  		label = new JLabel("Rename Directory", SwingConstants.CENTER);
  		label.setOpaque(true);
  		label.setBounds(0,0,500,30);
  		label.setBackground(ctop);
  		label.setForeground(c2);
  		// *** LABEL ***
  		// Label-"Name der Datei"
  		label1 = new JLabel("New directory name",0);
  		label1.setOpaque(true);
  		label1.setBounds(55,110,160,30);
  		label1.setBackground(ctop);
  		label1.setForeground(c2);                   
    
  		// *** TEXTFELD ***
  		// Textfeld-"Name der Datei"  
  		textField1 = new JTextField(30);
  		textField1.setBounds(225, 110, 200, 30);
  		textField1.setBackground(c1);
  		textField1.setBorder(line);
  		textField1.setForeground(Color.WHITE);
    
  		littleHelper = new JTextField(current);
  		// *** BUTTON ***
  		// Close-Button
  		button1 = new JButton("Close");
  		button1.setBounds(55, 150, 160, 30);
  		button1.setBackground(cblue);
  		button1.setForeground(Color.WHITE);
  		button1.addActionListener(this);    
                         
    
  		// Ok-Button
  		button2 = new JButton("Accepted");
  		button2.setBounds(225, 150, 200, 30);
  		button2.setBackground(cblue);
  		button2.setForeground(Color.WHITE);
  		button2.addActionListener(this);             
    
          
  		panel.add(button1);                           // Button in Fenster hinzufügen
  		panel.add(button2);                           // Button in Fenster hinzufügen
  		panel.add(label1);                            // Label in Fenster hinzufügen
  		panel.add(textField1);                          // Textfeld in Fenster hinzufügen
  		panel.add(label);
    
  		frame.setVisible(true);                         // Fenster sichtbar
  	}
  
  	/*
  	 * Diese Methode speichert die Änderung des Namens oder verwirft sie (abhängig vom gedrückten Knopf).
  	 * 
  	 * @see DirectoryHandler.
  	 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
  	 * 
  	 * Es gibt keinen Rückgabewert
  	 */
  	public void actionPerformed (ActionEvent e){
  		if (e.getSource() == button2) {
  			String name = textField1.getText();
  			String currentPath = littleHelper.getText();
      
  			DirectoryFunctions dh = new DirectoryFunctions();
  			dh.renameDirectory(currentPath, name); 
  			frame.setVisible(false);     
  		} // end of if
  		if (e.getSource() == button1) {
  			GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
  			restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
	
  			frame.setVisible(false);
  		} // end of if    
  	}  
}

