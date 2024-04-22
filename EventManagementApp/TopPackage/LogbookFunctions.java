package TopPackage;

import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Hier wird das Logbook mit allen Inhalten erstellt. 
 * Ein Logbuch ist in jedem Ordner vorhanden und dokumentiert die Änderungen des Ordnerinhalts.
 * 
 * @version 1.0.
 * @author xxx
 */ 
//START OF CLASS
public class LogbookFunctions {
 
	public static java.util.Date date_unformat = java.util.Calendar.getInstance().getTime();     
	static SimpleDateFormat format = new SimpleDateFormat(String.format("%-15s %-15s", "yyyy/MM/dd", "HH:mm:ss"));     
	static String date = format.format(date_unformat); 																					// formatiertes Datum
	
	/*
	 * Neue LogBook Datei wird erstellt
	 */
	public static void createLogbookInNewFolder(String directoryName) {         														// Hiermit wird eine neue Datei Logbook.txt erstellt
		
		File logbook = new File (directoryName + "\\" + "Logbook.txt");              													// Erstellung der Datei im neuen Verzeichnis
        
		try {
    	
			logbook.createNewFile(); 																									// Erstellung der Datei
      
		} catch (IOException e1) { 																										// Exception-Abfrage
    	
			e1.printStackTrace();
      
		}
    
	}
  
	/*
	 * Hier wird das tabelatisches Grundkonzept jedes Logbuches erstellt.
	 * 
	 * @param directoryName ist der Name des Ordners für den ein Logbuch erstellt wird.
	 */ 
	public static void preparationLogbook(String directoryName) {                 

		FileWriter writer;
		String PathLogbook = (directoryName + "\\" + "Logbook.txt");
		File dataWrite = new File (PathLogbook);
    
		try {
    	
			writer = new FileWriter(dataWrite, true);        // true -> Datei nicht überschreiben
										//Date Time User Statis Operation File
			writer.write(String.format("%-15s %-15s %-15s %-15s %-30s %-255s", "DATE", "TIME", "USER", "STATIS", "OPERATION", "FILE")); // Zeile 4 - Header
			writer.write(System.getProperty("line.separator"));                     													// Zeile 5 - Leerzeile
      
			writer.flush();                                       																		// Stream wird geleert
			writer.close();
      
		} catch (IOException e) {
    	
			e.printStackTrace();
      
		}
    
	}
  
	/*
	 * Diese Funktion wird aufgerufen, wenn eine änderung an Dateien im Ordner durchgeführt worden und dokumentiert diese.
	 * 
	 * @param operation 	= berschreibung der ausgeführten Operation (kopiert, gelöscht etc).
	 * @param pathDirectory = Pfad des Logbooks in welchem die änderung eingetragen wird
	 * @param directoryName = Name des Ordners der in welchem die änderung stattfand
	 */ 
	public static void writeLogbookDirectory(String operation, String pathDirectory, String directoryName) {                										// Funktion für einen neuen Eintrag im Logbook
    
		FileWriter writer;
		String PathLogbook = (pathDirectory + "\\" + "Logbook.txt");
		File dataWrite = new File (PathLogbook);
    
		try {
    	
			writer = new FileWriter(dataWrite, true);                         																						// true -> Datei nicht überschreiben
			writer.write(String.format("%-30s %-15s %-15s %-30s %-255s", date, PathHandler2.getMail(), PathHandler2.getStatis(), operation, directoryName));      	// Eintragung ins Logbuch
			writer.write(System.getProperty("line.separator"));                     																				// Leerzeile
      
			writer.flush();                                       																									// Stream wird geleert
			writer.close();
      
		} catch (IOException e) {
    	
			e.printStackTrace();
      
		}
    
	}
  
	/*
	 * Diese Funktion wird aufgerufen, wenn eine änderung an Dateien im Ordner durchgeführt worden und dokumentiert diese.
	 * 
	 * @param operation sagt was gemacht würde (kopiert, gelöscht etc).
	 * @param path ist der Pfad in dem gearbeitet wird.
	 */  
	public static void writeLogbookData(String operation, String path) {          																					// Funktion für einen neuen Eintrag im Logbook
    
		FileWriter writer;
		String PathLogbook = path + "\\" + "Logbook.txt";
		File dataWrite = new File (PathLogbook);
    
		try {
    	
			writer = new FileWriter(dataWrite, true);                         																						// true -> Datei nicht überschreiben
			writer.write(String.format("%-30s %-15s %-15s %-30s %-255s", date, PathHandler2.getMail(), PathHandler2.getStatis(), operation, path));            		// Eintragung ins Logbuch
			writer.write(System.getProperty("line.separator"));                     																				// Leerzeile
      
			writer.flush();                                       																									// Stream wird geleert
			writer.close();
      
		} catch (IOException e) {
    	
			e.printStackTrace();
      
		}
    
	}

}
//END OF CLASS