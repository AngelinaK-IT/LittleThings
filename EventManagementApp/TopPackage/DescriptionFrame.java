package TopPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DescriptionFrame implements ActionListener {
	
	JFrame frame = null;
	JTextArea show;
	JButton close, safe;
	JTextField littleHelper;
	JLabel label;
	JScrollPane rLeiste;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem openItem, saveItem, exitItem;
	
	public static Scanner x;
	static Color c1= new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	LineBorder line= new LineBorder(c2, 1, true);
	
	/*
	 * Hier bekommt der User die Möglichkeit Beschreibungen für die Veranstaltung zu öffnen, bearbeiten und zu speichern.
	 */
	@SuppressWarnings("static-access")
	public DescriptionFrame() {
		
		frame = new JFrame("Beschreibung der Veranstaltung");
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setSize(500,500);					
		frame.setLocationRelativeTo(frame);
		
		//----------Menubar-------------//
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		show = new JTextArea();
		show.setOpaque(true);
		show.setBackground(c1);
	    show.setForeground(Color.white);
		show.setLineWrap(true);
		show.setWrapStyleWord(true);
		show.setFont(new Font("Arial", Font.PLAIN,12));
		
		rLeiste = new JScrollPane(show);
		rLeiste.setPreferredSize(new Dimension(450,450));
		rLeiste.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);                                         
	   
		frame.setJMenuBar(menuBar);
		
		frame.add(rLeiste);
		frame.setVisible(true);
	}
	
	//getText(chosen)
//	public String getChosen(){                                                 
//
//	    //String chosen = (String) Verzeichniss.getSelectedValue();
//
//	    //return chosen;
//	    
//	  } 
	
	

	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==fontColorButton) {
//			JColorChooser colorChooser = new JColorChooser();
//			
//			Color color = colorChooser.showDialog(null, "Choose a Color", Color.black);
//			textArea.setForeground(color);
//		}
//		
//		if(e.getSource()==fontBox) {
//			textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
//		}
//		
		if(e.getSource()==openItem) {
			JFileChooser fileChooser= new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files","txt", "csv");
			fileChooser.setFileFilter(filter);
			
			int response = fileChooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				try {
					fileIn = new Scanner(file);
					
					if(file.isFile()) {
						while(fileIn.hasNextLine()) {
							String line = fileIn.nextLine()+"\n";
							show.append(line);
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					fileIn.close();
				}
			}
		}
		//GGF ÄNDERN DAMIT ES AUTOMATISCH SPEICHERT OHNE INDIVIDUELLE AUSWAHL
		if(e.getSource()==saveItem) {
			JFileChooser fileChooser= new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int response = fileChooser.showSaveDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileOut = null;
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(show.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					fileOut.close();
				}
			}
		}
		//Funktioniert nicht!! Fenster sollte sich schließen
		if(e.getSource()==exitItem) {
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
	}
}
