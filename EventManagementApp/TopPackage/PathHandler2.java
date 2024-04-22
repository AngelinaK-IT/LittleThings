package TopPackage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class PathHandler2 {
	
		//*** Strings ***
		//user.dir String
		public static String serverPathStartString = System.getProperty("user.dir");
		public static String serverNameString = "Server";
		
		public static String mail;
		public static String currentPath;
		public static String firma;
		public static String statis;
		public static String abteilung;
		
		public static String[] fileTypes = {".txt", ".docx", ".xlsx", ".pdf", ".png", ".jpg", ".bmp", ".mp3", ".wav", ".mp4", ".mpg", ".tex", ".bib", ".java", ".csv", ".db" };
		//static String newServerPathString;
		
		/*
		public static void main(String[] args) {
			//String tempString;
			
			
			String newServerPathString = null;
			System.out.println("Before:" + newServerPathString);
			newServerPathString = startCompany();
			System.out.println("After: " + newServerPathString);
			testString = newServerPathString;
			System.out.println(testString);
			
			//tempString = sendString(serverPathStartString);
			//System.out.println(tempString);
		}
		*/
		
		/*
		 * 
		 */
		public static String startCompany() {
			String tempPathString = serverPathStartString+"\\"+serverNameString;
 			Path path = Path.of(tempPathString);
			if(Files.exists(path)) {
				JOptionPane.showMessageDialog(null, "The Directory \"Server\" exists already.", "Warnung", JOptionPane.PLAIN_MESSAGE);
			} else {
				try {
					tempPathString = (Files.createDirectories(path).toString());
					JOptionPane.showMessageDialog(null, "Directory \"Server\" was succesfull created");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error while creating the directory: " + e.getMessage());
				}
			}  
			  return tempPathString;
		}
		
		
		//*** Little PathHelper ***
		void convertStringToPath(String a) {
			Path completePathPath = Path.of(a);
		}
		
		/* 
		 * Funktion um den benötigten Path zu bekommen
		 * 
		 * @param = ist der PathString der weitergereicht werden soll
		 * @return = Path ist der path der zurück gegeben wird
		 */
		private static Path getPathPath(String a) {
			Path path = Paths.get(a);
			return path;
		}
		
		
		/* 
		 * Funktion um Paths to concat
		 * 
		 * @param1 = "Path a" der als Vervollständigter Root benötigt wird
		 * @param2 = "Path b" der als an " Path a" angehängt werden soll
		 */
		static Path ConcatPath(Path a, Path b) {
			 Path path = a.resolve(b);
			 return path;
		}
		
		/* 
		 * Funktion um Paths to concat
		 * 
		 * @param1 = "Path a" der als Vervollständigter Root benötigt wird
		 * @param2 = "Path b" der an "Path a" angehängt werden soll
		 * @param2 = "Path c" der an "Path b" angehängt werden soll
		 */
		static Path ConcatPath2(Path a, Path b, Path c) {
			Path path = a.resolve(b).resolve(c);
			return path;
		}
		
		 /* 
		  * Initialisierungskonstruktor wenn zum Beispiel Account gelöscht bzw bearbeitet.
		  *
		  * Es gibt keine Ein-& Ausgabeparamter.
		  */
		  public static void variablenHandler() {                                        
			  mail = "root";
			  statis = "CEO";
		  }
		  
		  /* ******************************
		   * *** AUS DEM VERIFY LOGIN *** *
		   * ******************************/
		  
		  /* 
		   * Initialisierungskonstruktor mit richtigen Daten.
		   * 
		   * @param email ist die Email des users.
		   * @param path ist der aktuelle Pfad.
		   * @param abt ist die Abteilung des users.
		   * @param firm ist die Firma des users.
		   * 
		   * Es gibt keine Ausgabeparameter.
		   */ 
		  public static void variablenHandler(String email, String path, String stat, String abt, String firm) {
			  File file = new File("");
			  String here = file.getAbsoluteFile().toString();
			  mail = email;
			  currentPath = (here+"\\"+path);
			  firma = firm;
			  abteilung = abt;
			  statis = stat;
		  }
		  
		  /* 
		   * Funktion um in einem Ordner eine Datei oder einen Ordner zu öffnen und sich in diesem zu befinden.
		   * @param data ist der zu öffnende Ordner bzw zu öfnnende Datei.
		   */
		  public static String addToPath(String data) {                                
			  if (currentPath.equals(currentPath.replaceAll(data, ""))) {
			      	currentPath = (currentPath + "/" +data);
			  } // end of if
			  currentPath = currentPath.trim();
			  return currentPath;
		  }
		  
		  /*
		   * Funktion um einen Schritt im Dateipfad zurück zugehen.
		   * Es gibt keine Ein-& Ausgabeparameter.
		   */ 
		  public static String deleteFromPath() {                                       
			  boolean check = false;
			  char[] currentP = currentPath.toCharArray();
			  int i = currentP.length;
			  if (getDirectoryName().equals(getFirma())) {
				  JOptionPane.showMessageDialog(null, "Das ist das höchste für Sie einsehbare Verzeichnis", "Warnung", JOptionPane.PLAIN_MESSAGE);
			  } // end of if
			  else {
				  while (check == false) {     
					  char lastChar = currentP[i-1];
					  String current = "" + lastChar;
					  if (current.equals("\\") || current.equals("/")) {
						  check = true;
					  } else {
						  //System.out.println(currentP);
						  //System.out.println("1");
						  currentP[i-1] = ' ';
					  } // end of if-else
					  i = i-1;
				  } // end of while
				  currentP[i] = ' ';
				  //System.out.println(currentP);
				  currentPath = String.copyValueOf(currentP);
				  //System.out.println("derzeitiger Pfad:" + currentPath);
				  currentPath = currentPath.trim();
			  } // end of if-else
			  return currentPath.trim(); 
		  }
		  
		  
		  /*
		   * Diese Hilfsfunktion gibt den aktuellen Dateipfad als String zurück. 
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return currentPath der aktuelle Pfad.
		   */
		  public static String getPath(){
			  return currentPath;
		  } 
		  
		  /*
		   * Diese Hilfsfunktion gibt die E-Mail als String zurück.
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return mail ist die E-Mail des Users.
		   */
		  public static String getMail(){
			  //System.out.println(mail);
			  return mail;
		  } 
		  
		  /*
		   * Diese Hilfsfunktion gibt die Firma als String zurück.
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return firma ist die Firma.
		   */
		  public static String getFirma(){                                             
			  return firma;
		  }
		  
		  /*
		   * Diese Hilfsfunktion gibt die Abteilung als String zurück.
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return abteilung ist die Abteilung des Nutzers.
		   */
		  public static String getAbteilung(){                                       
			  return abteilung;
		  }
		  
		  /*
		   * Diese Hilfsfunktion gibt den Status als String zurück.
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return Statis ist die Abteilung des Nutzers.
		   */
		  public static String getStatis() {
			  return statis;
		  }
		  
		  /*
		   * Diese Hilfsfunktion gibt den aktuellen Dateipfad als Path zurück.
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return path ist der aktuelle Pfad.
		   */
		  public static Path getPathPath(){                                            
			  Path path = Paths.get(currentPath);
			  return path;
		  } 
		  
		  /*
		   * Diese Hilfsfunktion gibt den aktuellen Dateipfad als File zurück.
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return file ist der aktuelle Pfad.
		   */ 
		  public static File getPathFile(){                                             
			  File file = getPathPath().toFile();          
			  return file;
		  } 
		  
		  /*
		   * Diese Hilfsfunktion gibt den Namen des Verzeichnis als String zurück.
		   * 
		   * Es gibt keine Eingabeparamter. 
		   * 
		   * @return name ist der Ordnername.
		   */  
		  public static String getDirectoryName(){//Funktion zur Ermittlung des Names des Verzeichnisses in dem sich der Nutzer gerade befindet
			  String name;
			  File file = getPathFile();
			  name = file.getName(); 
			  return name;
		  }

		  /*
		   * Hilfsfunktion um die Anzeige in der JListe zu realisieren.
		   * 
		   * @return folder Inhalte für die JListe.
		   * Es gibt keinen Eingabewert.
		   */
		  public static String[] getVisual(){                                                 
			  File file = getPathFile();                                                                         
			  String[] folder = file.list();
			  return folder;
		  }
			
}
