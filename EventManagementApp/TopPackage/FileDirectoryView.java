package TopPackage;

import java.io.File;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
 * Diese Klasse erstellt die Ansicht auf die Dateien in einer tabellarischen Form und gibt die Möglchkeit der Ansicht der Daten. 
 * 
 * es gibt keine Ein- & Ausgabeparameter.
 */
// FileDirectoryView GUIFileDirectoryScreen
public class FileDirectoryView extends JFrame implements ActionListener {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel= new JPanel();
	JTextArea show;
	JButton close, safe;
	JTextField littleHelper;
	JLabel label;
	JScrollPane rLeiste;
  
	Color c2=new Color(20, 26, 50);
	Color cwhite= new Color(210, 210, 215);
	Color ctop=new Color(128, 156, 245);
	Color cyellow= new Color(207, 180, 94);
	Color cblue= new Color(62, 101, 251);
	Color c1= new Color(55, 63, 93);
	LineBorder line2= new LineBorder(cyellow, 2, true);

	//username, name, path, tempStat
	String username = PathHandler2.getMail();
	String name = VerifyLogin.nameString;
	String path = PathHandler2.currentPath;
	String tempStat = PathHandler2.statis;
	
	public static Scanner x;
	
	/*
	 * Hier wird das Fenster der Dateiansicht erstellt.
	 * 
	 * @param chosen ist ein string und ist der Name der Datei.
	 * 
	 * es gibt keine Ausgabeparameter.
	 */
	public void GUIFileDirectoryScreen(String chosen) throws FileNotFoundException {
		frame = new JFrame("Ultimate-events");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(panel);
		panel.setBackground(c2);
		panel.setLayout(null);
    
		label = new JLabel("Dateiansicht", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBounds(0,0,800,30);
		label.setBackground(ctop);
		label.setForeground(c2); 
    
		show = new JTextArea(getText(chosen));                                                          
		show.setOpaque(true);
		show.setBackground(c1);
		show.setForeground(Color.white);
    
		JScrollPane rLeiste= new JScrollPane(show);
		rLeiste.setBounds(50,80,680,300);
    
		littleHelper = new JTextField(chosen);
    
		close = new JButton("Datei Schließen");
		close.setBounds(185, 390, 200, 30);
		close.setBackground(cblue);
		close.setForeground(Color.WHITE);
		close.addActionListener(this);
    
		safe = new JButton("Datei speichern");
		safe.setBounds(395, 390, 200, 30);
		safe.setBackground(cblue);
		safe.setForeground(Color.WHITE);
		safe.addActionListener(this);
    
		panel.add(close);
		panel.add(safe);
		panel.add(label);
		panel.add(rLeiste);
    
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == close) {
			//JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
			//tempMainFrame.dispose();
			GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
			restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
			frame.setVisible(false);
		} // end of if
    
		if (e.getSource() == safe) {
			String chosen = littleHelper.getText();
			String text = show.getText();
			if (chosen.equals("Logbook.txt")) {
				JOptionPane.showMessageDialog(null, "Logbook darf nicht bearbeitet werden!!", "Warnung", JOptionPane.PLAIN_MESSAGE);
			} // end of if
			else {
				if (chosen.contains(".txt") == false && chosen.contains(".docx") == false) {
					JOptionPane.showMessageDialog(null, "Nur Dateien mit .txt und .docx werden unterstützt", "Warnung", JOptionPane.PLAIN_MESSAGE);
				} // end of if
				else {
					FileFunctions fh = new FileFunctions();
					fh.safeFile(chosen, text);
					frame.setVisible(false);
				} // end of if-else
			} // end of if-else 
		} // end of if
	}
  
	/*
	 * Auslesen des gesamten Textes einer Textdatei.
	 * 
	 * @param chosen ist ein String in und ist der Name der Datei.
	 * es gibt keinen Ausgabeparameter.
	 */
	public String getText(String chosen) throws FileNotFoundException{
		File file = new File(PathHandler2.getPath() + "\\" + chosen);
		String tempLine = "";
		String text = "";
		try{
			x = new Scanner(file);
			x.useDelimiter("[\n]");
			while (x.hasNext()) { 
				tempLine = x.next();
				text = text + "\n" +tempLine;
			} // end of while
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return text;
    } 
}

