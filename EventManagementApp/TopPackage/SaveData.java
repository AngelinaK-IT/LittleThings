package TopPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SaveData {
	
	public static Path currentPathPath2; 
	/* 
	 * Funktion um die Daten kompakt auf den Server zu speichern.
	 * 
	 * @param1 ArrayList<ArrayList<String>> = kompakte Sammlung aller Werte
	 * @param2 Path = aktueller lokaler Path
	 * 
	 * static Path currentPathPath1 = PathHandler.complWorkServerVerPath;
	 */
	public static void SaveDataOnServer(ArrayList<ArrayList<String>> verDataComplete, Path currentPathPath1 ) {
		
		System.out.println("verDataComplete 2D ArrayList: " + verDataComplete);
		System.out.println("Given Parameter Path: " + currentPathPath1);
		
		// CATEGORY FOLDER NAME
		String categoryFolderString = verDataComplete.get(0).get(1);
		Path categoryFolderPath = Path.of(categoryFolderString);
		
		// PREFORMAL PATH CURRENTWORK PATH + FOLDERNAME
		Path completeCategoryPathPath = currentPathPath1.resolve(categoryFolderString);
		
		System.out.println("CategoryPath?: " + completeCategoryPathPath);
		
		try {
			// CHECK IF FILE ON PATH NOT EXIST
			if(!Files.exists(completeCategoryPathPath)) {
				
				JOptionPane.showMessageDialog(null, "Ordner wird erstellt", "Warnung", JOptionPane.PLAIN_MESSAGE);
				
				//Path completeWorkCategoryServerPathPath = Files.createDirectories(completeCategoryPathPath);
				Path completeWorkCategoryServerPathPath = Files.createDirectories(PathHandler.ConcatPath(currentPathPath1, categoryFolderPath));
				currentPathPath2 = completeWorkCategoryServerPathPath;
				//completeWorkCategoryServerPathString = completeWorkCategoryServerPathPath.toString();
				
				System.out.println("created File inside the Path?: " + completeWorkCategoryServerPathPath);
				
			} else if(Files.exists(completeCategoryPathPath)) {
				
				JOptionPane.showMessageDialog(null, "Der Ordner existiert bereits", "Warnung", JOptionPane.PLAIN_MESSAGE);
				currentPathPath2 = completeCategoryPathPath;
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Path form inside if?: " + currentPathPath2);
		System.out.println("CurrentPathPath2: " + currentPathPath2);
		
		// create Event Folder
		String FolderNameString = verDataComplete.get(0).get(0)+"_"+verDataComplete.get(0).get(3);
		Path FolderPath = Path.of(FolderNameString);
		// add Event folder to path
		Path completeWorkFolderServerPath = currentPathPath2.resolve(FolderNameString);
		System.out.println("EVENT PATH BEFORE CREATE: " + completeWorkFolderServerPath);
		try { 
			// CHECK IF PATH EXISTS
			if(Files.exists(completeWorkFolderServerPath)) {
						
				JOptionPane.showMessageDialog(null, "Der Ordner existiert bereits.\nZur Bearbeiung bitte in das Bearbeitungspanel wechseln", "Warnung", JOptionPane.PLAIN_MESSAGE);
						
				//Hier k�nnte der Mitarbeiter dennoch das SaveFrame �ffnen und die Datei seperat als alternative zur zuvor ausgew�hlten Dateientyp speichern
				//new SaveFrame(verDataComplete, completeWorkFolderPath);
						
			} else if(!Files.exists(completeWorkFolderServerPath)) {
						
				System.out.println("completeWorkFolderServerPath: " + completeWorkFolderServerPath);
				System.out.println("folderNamePath: " + FolderPath);
				Path currentWorkFolderServerPath = Files.createDirectories(PathHandler.ConcatPath(currentPathPath2, FolderPath));
				System.out.println("BEFORE NEW SAVEFRAME:" + currentWorkFolderServerPath);
				new SaveFrame(verDataComplete, currentWorkFolderServerPath);
						
						//*** Diente zu Testzwecken
						//Path.of(filenameString4).resolve(verDataComplete.get(0).get(0)));
						//Path tempFile3 = Files.createFile(path5.resolve("textdokument4.txt"));
						//File fileName = new File(FolderNameString);
			}
		} catch (Exception e) {
					
			e.printStackTrace();
					
		}
		
		/*
		Path completeWorkFolderPath = PathHandler.ConcatPath(currentPathPath1, FolderPath);
		System.out.println(completeWorkFolderPath);
		
		Path completeWorkFolderServerPath = Path.of(currentPathPath1.toString()+"\\"+FolderNameString);
		*/
	}
	
	/*
	 * 
	 */
	public static void SaveDecriptionOnServer(ArrayList<ArrayList<String>> verDataComplete, String currentPathString) {
		String artist = verDataComplete.get(0).get(3); //verDataComplete.get(0).get(3)
	    //String[] artistParts = artist.split(":");
		String endString = ".txt";
		String FileNameString = "Description" + "_" + verDataComplete.get(0).get(0) + "-" + artist + endString;
		
		//File Foldername = new File(FolderNameString);
		Path FolderPath = Path.of(FileNameString);
		Path currentPathPath = Path.of(currentPathString);
		Path completeServerPath = PathHandler.ConcatPath(currentPathPath, FolderPath);
		
		
		try {
			if(Files.exists(completeServerPath)) {
				JOptionPane.showMessageDialog(null, "Der Ordner existiert bereits.", "Warnung", JOptionPane.PLAIN_MESSAGE);
				
				//Hier k�nnte der Mitarbeiter dennoch das SaveFrame �ffnen und die Datei seperat als alternative zur zuvor ausgew�hlten Dateientyp speichern
				//new SaveFrame(verDataComplete, completeWorkFolderPath);
				
			} else if(!Files.exists(completeServerPath)) {
				Path WorkFolderPath = Files.createDirectories(PathHandler.ConcatPath(currentPathPath, FolderPath));
				//String workFolderPathString = WorkFolderPath.toString();
				new SaveFrame(verDataComplete, WorkFolderPath);
				
				//*** Diente zu Testzwecken
				//Path.of(filenameString4).resolve(verDataComplete.get(0).get(0)));
				//Path tempFile3 = Files.createFile(path5.resolve("textdokument4.txt"));
				//File fileName = new File(FolderNameString);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		/*
		 String servernameString = "Server";
	  
	  
	  Path path = Path.of(serverPathStringCurr, servernameString);
	
	
	  if(Files.exists(path)) {
				
			JOptionPane.showMessageDialog(null, "The Directory \"Server\" exists already.", "Warnung", JOptionPane.PLAIN_MESSAGE);
				
	  } else {
			try {
				path = Files.createDirectories(path);
				JOptionPane.showMessageDialog(null, "Directory \"Server\" was succesfull created");
				
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Fehler beim Erstellen des Verzeichnisses: " + e.getMessage());
			
			}
	  }
	  System.out.println(path);
	  return path.toString();
		 */
	}
	
	/* 
	 * Funktion um die Daten in eine .txt-Datei zu speichern
	 * 
	 * @param1 ArrayList<ArrayList<String>> = kompakte Sammlung aller Werte
	 * @param2 Path = Lokale Arbeitsverzeichnis, in welches der neue Ordner gespeichert werden soll
	 * @param3 String = Suffix(Datentyp) der Datei, in welche die Daten gespeichert werden sollen 
	 */
	public static void saveAsTXT(ArrayList<ArrayList<String>> data, Path WorkFolderPath, String end) {
		String fileNameString = data.get(0).get(0) + "-" + data.get(0).get(3) + end;
		File file = new File(fileNameString);
		String operationComplete = "Veranstaltung: " + data.get(0).get(0) + " wurde erstellt.";
		
		try {
			
			if(file.exists()) {
				
				JOptionPane.showMessageDialog(null, "Die File existiert bereits.\nZur Bearbeiung bitte in das Bearbeitungspanel wechseln", "Warnung", JOptionPane.PLAIN_MESSAGE);
				
			} else {
				String workFolderPath2 = WorkFolderPath.toString();
				Path filePath = Files.createFile(WorkFolderPath.resolve(fileNameString));
				String fileName = filePath.toString();
				
				System.out.println("INSIDE SAVEasCSV->else");
				System.out.println(filePath);
				System.out.println(workFolderPath2);
				
				JOptionPane.showMessageDialog(null, "Daten gespeichert.", "Meldung", JOptionPane.PLAIN_MESSAGE);
				DirectoryFunctions.createLogBooks(workFolderPath2, operationComplete);
				//DirectoryFunctions.createDirectoryC(WorkFolderPath, fileName, operationComplete);
				write2DArrayListToFile(data, fileName);
				JOptionPane.showMessageDialog(null, "Veranstaltungslogbook aktualisiert.", "Meldung", JOptionPane.PLAIN_MESSAGE);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/* 
	 * Funktion um die Daten in eine .CSV-Datei zu speichern
	 * 
	 * @param1 ArrayList<ArrayList<String>> = kompakte Sammlung aller Werte
	 * @param2 Path = Lokale Arbeitsverzeichnis, in welches der neue Ordner gespeichert werden soll
	 * @param3 String = Suffix(Datentyp) der Datei, in welche die Daten gespeichert werden sollen 
	 */
	public static void saveAsCSV(ArrayList<ArrayList<String>> data, Path WorkFolderPath, String end) {
		String fileNameString = data.get(0).get(0) + "-" + data.get(0).get(3) + end;
		File file = new File(fileNameString);
		String operationComplete = "Veranstaltung: " + data.get(0).get(0) + " wurde erstellt.";
		
		try {
			
			if(file.exists()) {
				
				JOptionPane.showMessageDialog(null, "Die File existiert bereits.\nZur Bearbeiung bitte in das Bearbeitungspanel wechseln", "Warnung", JOptionPane.PLAIN_MESSAGE);
				
			} else {
				String workFolderPath2 = WorkFolderPath.toString();
				Path filePath = Files.createFile(WorkFolderPath.resolve(fileNameString));
				String fileName = filePath.toString();
				
				System.out.println("INSIDE SAVEasCSV->else");
				System.out.println(filePath);
				System.out.println(workFolderPath2);
				
				JOptionPane.showMessageDialog(null, "Daten gespeichert.", "Meldung", JOptionPane.PLAIN_MESSAGE);
				DirectoryFunctions.createLogBooks(workFolderPath2, operationComplete);
				//DirectoryFunctions.createDirectoryC(WorkFolderPath, fileName, operationComplete);
				write2DArrayListToFile(data, fileName);
				JOptionPane.showMessageDialog(null, "Veranstaltungslogbook aktualisiert.", "Meldung", JOptionPane.PLAIN_MESSAGE);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	/* 
	 * Funktion um die ArrayList<ArrayList<String>> zu entpacken und in die Datei zu schreiben
	 * 
	 * @param1 ArrayList<ArrayList<String>> = kompakte Sammlung aller Daten
	 * @param2 String = Name der Datei
	 */
	public static void write2DArrayListToFile(ArrayList<ArrayList<String>> data, String fileName) {
		// ArrayList<String> collectedArrayList, ArrayList<String> placeList, ArrayList<String> dateList, ArrayList<String> timeList
		// [000002, Kategorie: Messe, Veranstalter: Lego GmbH, Künstler: , ZonenName1: Kurzbesuch Ticket, ZonenName2: tages Ticket, ZonenName3: Zeitraum Ticket, Price1: 30, Price2: 75, Price3: 350, Anzahl_Plätze1: 500000, Anzahl_Plätze2: 500000, Anzahl_Plätze3: 5000]
	  	// get(0)	get(1)				get(2)					get(3)		get(4)							get(5)					get(6)						get(7)		get(8)		get(9)			get(10)					get(11)					get(12)
	
		//[[00001, Messe, Lego, Lego, Berlin, 10.05, 10-18, Kurz, 25, 5000, Tag, 35, 5000, Zeitraum, 75, 5000], [00001, Messe, Lego, Lego, Köln, 15.05, 10-18, Kurz, 25, 5000, Tag, 35, 5000, Zeitraum, 75, 5000]]
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
        	
        	/*
            if (placeList.size() == 1) {
            	bw.write("Places," + placeList.get(0);
            } else {
            	---> AdmWorkEventPanel // EditPanel
            }
            bw.write("Places," + placeList.get(0);
            */
        	List<String> subList = data.get(0).subList(0,4);
        	String eventNumber = subList.get(0);
        	String categoryString = subList.get(1);
        	String organizerString = subList.get(2);
        	String artistString = subList.get(3);
            bw.write("Event-Number," +  eventNumber);
            bw.newLine();
            bw.write("Category," + categoryString);
            bw.newLine();
            bw.write("Organizer," + organizerString);
            bw.newLine();
            bw.write("Artist," + artistString);
            bw.newLine();
        	int datasize = data.size();
        	for(int i = 0; i < datasize; i++) {
        		List<String> subList2 = data.get(i).subList(4, 16);
        		for (String item : subList2) {
                
        			bw.write(item + ",");
        		}
        		bw.newLine();
        	}
        	/*
            ArrayList<String> oneList = new ArrayList<>();
            for (ArrayList<String> sublist : data) {
            	oneList.addAll(sublist);
            }
            int oneList2size = oneList.size();
            */
      
        } catch (IOException e) {
            e.printStackTrace();
        }
            /*
        	// BEISPIEL: Daten in die CSV-Datei schreiben
            writer.write("Name,Age,City");
            writer.newLine(); // Neue Zeile hinzufügen

            String name1 = "John";
            int age1 = 30;
            String city1 = "New York";
            writer.write(name1 + "," + age1 + "," + city1);
            writer.newLine();
            
            String name2 = "Jane";
            int age2 = 25;
            String city2 = "San Francisco";
            writer.write(name2 + "," + age2 + "," + city2);
            writer.newLine();
            */
           
    }
}

class SaveFrame extends JFrame {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton backButton, saveastxt, saveasCSV;
	static Color c1= new Color(55, 63, 93);
	static Color c2 = new Color(20, 26, 50);
	static Color cwhite = new Color(210, 210, 215);
	static Color ctop  =new Color(128, 156, 245);
	static Color cyellow = new Color(207, 180, 94);
	static Color cblue = new Color(62, 101, 251);
	
	static String suffixStringTXT = ".txt";
	static String suffixStringCSV = ".CSV";
	
	/* 
	 * Hier wird ein neues Fenster ge�ffnet, durch das der Mitarbeiter entscheiden kann ob er die Daten
	 * als .txt oder .CSV speichern m�chte.
	 * 
	 * @param1
	 * @param2
	 * 
	 * @return = null (Es gibt keinen Return Wert)
	 */
	public SaveFrame(ArrayList<ArrayList<String>> verDataComplete, Path WorkFolderPath){
		setBackground(c2);
        setBounds(400,10,350,350);
        setLayout(null);
        
        saveastxt = new JButton("Save as .txt");
        saveastxt.setBounds(5,5, 150, 30);
        saveastxt.setBackground(c1);
        saveastxt.setForeground(Color.white);
        saveastxt.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	SaveData.saveAsTXT(verDataComplete, WorkFolderPath, suffixStringTXT);
	            setVisible(false); 
	        }
	    });
        saveasCSV = new JButton("Save as .CSV");
        saveasCSV.setBounds(5,40, 150, 30);
        saveasCSV.setBackground(c1);
        saveasCSV.setForeground(Color.white);
        saveasCSV.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	SaveData.saveAsCSV(verDataComplete, WorkFolderPath, suffixStringCSV);
	        	setVisible(false);   
	        }
	    });
        backButton = new JButton("Back // Close");
	    backButton.setBounds(5,75, 150, 30);
        backButton.setBackground(c1);
	    backButton.setForeground(Color.white);
	    backButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
	            frame.setVisible(false);
	        }
	    });
	    add(saveasCSV);
	    add(saveastxt);
	    add(backButton);
        setVisible(true);
        
	}
}
