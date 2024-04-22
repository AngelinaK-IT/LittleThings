package TopPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;

/*
 *In dieser Funktion wird der Startscreen aufgerufen. Application ist die Funktion, welche zum Ausführen des Programms gestartet werden muss.
 * 
 * @version 1.0.
 * @author xxx
 */
// DirectoryScreen GUIcreateDirectoryScreen
public class DirectoryScreen extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel = new JPanel();
	static JButton button1;
	JButton button2;
	JLabel label1, label2;
	JTextField textField1;
	  
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
	 * Diese Funktion erstellt das Fenster der Verzeichnisübersicht.
	 * 
	 * @version 1.0.
	 * @author xxx
	 */
	public void GUIcreateDirectoryScreen() {

		// *** FENSTER ***
		frame = new JFrame("Ultimate-events");
		frame.setSize(500, 300);                        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
		frame.setResizable(false);                        
		frame.setLocationRelativeTo(null);                    
		frame.add(panel);                                     
		panel.setBackground(c2);                              
		panel.setLayout(null);                          
		frame.requestFocus();                         
    
		//label für die Leiste
		label2 = new JLabel("Create new directory", SwingConstants.CENTER);
		label2.setOpaque(true);
		label2.setBounds(0,0,500,30);
		label2.setBackground(ctop);
		label2.setForeground(c2);
    
		// *** LABEL ***
		// Label-"Name des Ordners"
		label1 = new JLabel("Directory name",0);
		label1.setOpaque(true);
		label1.setBounds(55,110,160,30);           
		label1.setBackground(ctop);
		label1.setForeground(c2);                   
    
		// *** TEXTFELD ***
		// Textfeld-"Name des Ordners"  
		textField1 = new JTextField(30);
		textField1.setBounds(225, 110, 200, 30);
		textField1.setBackground(c1);
		textField1.setBorder(line);
		textField1.setForeground(Color.WHITE);
    
		// *** BUTTON ***
		// OK-Button
		button2 = new JButton("Close");
		button2.setBounds(55, 150, 160, 30);                  
		button2.setBackground(cblue);            
		button2.setFocusPainted(true);                      
		button2.setForeground(Color.WHITE);                 
		button2.setBorder(line);     // Button: Rahmen
		button2.addActionListener(this);             
		button2.setVisible(true);                       

		// Close-Button
		button1 = new JButton("Accepted");
		button1.setBounds(225, 150, 200, 30);                 
		button1.setBackground(cblue);            
		button1.setForeground(Color.WHITE);      
		button1.setFocusPainted(true);                      
		button1.setBorder(line);    
		button1.addActionListener(this);            
		button1.setVisible(true);                       
                        
		panel.add(button1);                          
		panel.add(button2);                           
		panel.add(label1);                           
		panel.add(textField1);
		panel.add(label2);                       
    
		frame.setVisible(true); 
		
	}

	/*
	 * um die Anmeldung fortzusezen, muss überprüft werden ob die eingeben Userdaten gelistet sind und dafür werden diese hier an VerifyLogin übergeben.
	 * 
	 * @see createDirectory
	 * @see Ubersicht
	 * @param e ist der Typ des ActioEvent mit dieser Aufgerufen wird.
	 * 
	 * Es gibt keinen Rückgabewert
	 */
	public void actionPerformed(ActionEvent e){
		// ACCEPTED //
		if (e.getSource() == button1) {
			String name = textField1.getText();
			DirectoryFunctions dh = new DirectoryFunctions();
			//Hier Geändert, weil CreateDirectory selber eine Exception wirft. Daher Try/Catch nötig
			try {
				dh.createDirectory(PathHandler2.getPath(), name);
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
