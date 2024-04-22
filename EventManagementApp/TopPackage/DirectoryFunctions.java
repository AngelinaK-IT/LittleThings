package TopPackage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Hier werden alle Funktion zur Handhabung mit Verzeichnissen definiert. 
 * 
 * @version 2.0.
 * @author xxx
 */
// DirectoryFunctions createDeatments createDirectoryB createUser; follow functions not in action: createDirectory openDirectory
public class DirectoryFunctions {
	//username, name, path, tempStat
	String username = PathHandler2.getMail();
	String name = VerifyLogin.nameString;
	String path = PathHandler2.currentPath;
	String tempStat = PathHandler2.statis;
	
	/*
	 * Mit dieser Funktion k�nnen Abteilungen festgelegt werden und ihnen wird der ein Ordner erstellt.
	 * 
	 * @param domain ist die E-Maildomain der Firma.
	 * @param a ist die erste Abteilung.
	 * @param ab ist die zweite Abteilung.
	 * @param abt ist die dritte Abteilung.
	 * 
	 * Es gibt keinen Ausgabeparameter.
	 */
	public void createDepartments(String currServerPathString, String domain, String abt1, String abt2, String abt3) {
		createDirectoryD(currServerPathString, domain);
		createDirectoryD((currServerPathString+"\\"+domain), abt1);
		createDirectoryD((currServerPathString+"\\"+domain), abt2);
		createDirectoryD((currServerPathString+"\\"+domain), abt3);
	}
	
	/*
	 * Das erste Verzeichnis bei Erstellung eines Nutzers oder von Firmen wird erstellt. 
	 * 
	 * @param directoryName ist der Name des neuen Ordners.
	 * @param path ist der aktuelle Standort.
	 */
	public void createDirectoryD(String currPathString, String dirDepNameString) {
		try {
			String currPathString2 = currPathString + "\\" + dirDepNameString;
			Path newDirPath = Paths.get(currPathString2);
			
			String operationString = ("Created Directory: " + dirDepNameString);
			Files.createDirectories(newDirPath);
			
			LogbookFunctions.createLogbookInNewFolder(currPathString2);
			LogbookFunctions.preparationLogbook(currPathString2);
			LogbookFunctions.writeLogbookDirectory(operationString, currPathString2, currPathString2);
			LogbookFunctions.writeLogbookDirectory(operationString, currPathString, currPathString);	
		} catch (Exception e2) {	
			e2.printStackTrace();
		}
	}
	
	/*
	 * 
	 */
	public static void createDirectoryC(Path currentPath, String directoryName, String operation) {	
		try {
			String currentPathString = currentPath.toString();
			String complCurrentPathString = currentPath + "\\" + directoryName;
			
			LogbookFunctions.createLogbookInNewFolder(currentPathString);
			LogbookFunctions.preparationLogbook(currentPathString);
			LogbookFunctions.writeLogbookDirectory(operation, complCurrentPathString, complCurrentPathString);
			LogbookFunctions.writeLogbookDirectory(operation, currentPathString, currentPathString);
		} catch (Exception e2) {	
			e2.printStackTrace();	
		}
		return;
	}
	
	public static void createLogBooks(String workFolderPathString, String operation) {
		
		try {
			LogbookFunctions.createLogbookInNewFolder(workFolderPathString);
			LogbookFunctions.preparationLogbook(workFolderPathString);
			LogbookFunctions.writeLogbookDirectory(operation, workFolderPathString, workFolderPathString);
			LogbookFunctions.writeLogbookDirectory(operation, workFolderPathString, workFolderPathString);
		} catch (Exception e2) {	
			e2.printStackTrace();	
		}
		return;
	}
	
	/*
	 * Hier wird aus der Verzeichnis�berischt heraus ein Verzeichnis erstellt.
	 * 
	 * @param path ist der Pfad des aktuellen Standortes.
	 * @param directoryName ist der Namedes neuen Verzeichnisses.
	 * 
	 * Es gibt keinen Ausgabeparameter.
	 * 
	 * @throws Exception 
	 */
	public void createDirectory(String path, String directoryName) throws Exception {               
		try {
			Path pathNewDirectory = (Paths.get(path + "\\" + directoryName));
			String pathCurrent = (path + "\\" + directoryName);
			String[] data = getVisual(path);
			boolean tester = false;
			int l = data.length - 1;
			String operationCompleted = ("Directory created: "+ directoryName);
			while (l >= 0) { 
				if (data[l].equals(directoryName)) {     
					tester = true;
				} // end of if
				l--;
			} // end of while
			if (tester == true) {
				//DirectoryConstructor directory
				JOptionPane.showMessageDialog(null, "Directory must not have the same name as another one.\n Renaming not successful", "Warnung", JOptionPane.PLAIN_MESSAGE);
				DirectoryScreen cd = new DirectoryScreen();
				cd.GUIcreateDirectoryScreen();
			}  
			if (tester == false) {
				Path donePath = Files.createDirectories(pathNewDirectory);
				LogbookFunctions.createLogbookInNewFolder(pathCurrent);
				LogbookFunctions.preparationLogbook(pathCurrent);
				LogbookFunctions.writeLogbookDirectory(operationCompleted, pathCurrent, pathCurrent);
				LogbookFunctions.writeLogbookDirectory(operationCompleted, path, path);
				
				JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
	            tempMainFrame.dispose();
				GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
				restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat);  
			} // end of if
		} catch (Exception e2){
			//e2.printStackTrace();
			//Hier ver�ndert da exception nicht weiter geworfen wurde
			throw e2;
		}
		return;
	} 
	
	/*
	 * Mit dieser Funktion wird das pers�nliche Verzeichnis eines Users erstellt.
	 * 
	 * @param domain ist die domain der E-Mail.
	 * @param a ist die Abteilung.
	 * @param mail ist die E-Mailadresse des Users.
	 * @param path ist der aktuelle Pfad.
	 */
	public void createUser(String domain, String a, String mail, String path) {    
		File file = new File("");
		String here = file.getAbsoluteFile().toString();
		createDirectoryD(here+"\\Server\\"+domain+"\\"+ a  , mail);
	}
	
	/*
	 * Hier wird �berpr�ft, wieviele Dateien in einem Ordner an einem bestimmten Pfad sind und diese werden zur�ckgegeben.
	 * Diese Funktion wird im vergleich zu getVisual() ben�tigt vor der Initialisierung des VariablenHandlers. 
	 * 
	 * @param path ist der Pfad der Datei.
	 * 
	 * @return help ist ein Fehlerabfang. Hier wird eine Leere Liste ausgegeben.
	 * @return folder gibt die Liste der vorhandenen Dateien in diesem Ordner zur�ck.
	 */
	public String[] getVisual(String path) {                                      
	    Path data = Paths.get(path);                                                       
	    File file = data.toFile();
	    String[] folder = file.list();
	    String[] help = {" "};
	    if (folder.length == 0) {
	      return help;
	    } // end of if
	    else {
	      return folder;
	    } // end of if-else    
	}
	
	/*
	 * Mit dieser Funktion k�nnen Verzeichnisse geschlossen werden.
	 * 
	 * Es gibt keine Ein- & Ausgabeparameter.
	 */  
	 public void closeDirectory() {
		 PathHandler2.deleteFromPath();
		 
		 JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
         tempMainFrame.dispose();
		 GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
		 restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
	 }
	 
	 /*
	  * Mit dieser Funktion kann ein Verzeichnis umbenannt werden.
	  * 
	  * @param next ist der neue Ordnername.
	  * @param current ist der alte Ordnername.
	  */
	  public void renameDirectory(String current, String next) {                    
		  String pathCurrent = (PathHandler2.getPath());
		  String[] data = PathHandler2.getVisual();
		  boolean tester = false;
		  int l = data.length - 1;
		  String operationCompleted = "Verzeichnis umbenannt: "+current+" zu "+next;
		  while (l >= 0) { 
			  if (data[l].equals(next)) {     
				  tester = true;
			  } // end of if
			  l--;
		  } // end of while
		  if (tester == true) {
			  JOptionPane.showMessageDialog(null, "Verzeichnis darf nicht den selben Namen wie eine anderes tragen. \n Umbenennung nicht erfolgreich", "Warnung", JOptionPane.PLAIN_MESSAGE);
		  } // end of if
		  if (tester == false) {
			  File fileA = new File(PathHandler2.getPath()+"\\"+current);
			  File fileB = new File(PathHandler2.getPath()+"\\"+next);
			  LogbookFunctions.writeLogbookDirectory(operationCompleted, pathCurrent, pathCurrent);
	      
			  fileA.renameTo(fileB);   
		  } // end of if
		  JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
		  tempMainFrame.dispose();
		  GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
		  restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
	  }
	  
	  /*
	   * Hier wird ein Verzeichnis gel�scht und zum vorherigen Verzeichnis zur�ckgekehrt.
	   * 
	   * @param dir ist das zu l�schende Verzeichnis.
	   * 
	   * Es gibt keinen R�ckgabewert.
	   */
	  public void deleteDirectory(String dir) {                                      
		  if (getContent(dir).length == 1) {
			  File file = new File("");
			  String here = file.getAbsoluteFile().toString();
			  String operationCompleted = ("Directory delete: " + dir);
			  String log = (PathHandler2.getPath() + "\\" + dir + "\\Logbook.txt");
			  String logNew = (here + "\\Server\\"+PathHandler2.getFirma()+"\\"+PathHandler2.getAbteilung()+"\\"+PathHandler2.getMail()+"\\"+"Logbook_"+dir+".txt" ) ;
			  String str = (PathHandler2.getPath() + "\\" + dir);
			  Path path = Paths.get(str);
			  File files = path.toFile();     
	      
			  FileFunctions fh = new FileFunctions();
			  LogbookFunctions.writeLogbookData(operationCompleted, str);
			  fh.moveFile(log, logNew ,dir);
			  files.delete();
			  String pathNew = dir.toString();
			  
			  JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
			  tempMainFrame.dispose();
			  GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
			  restartAdminScreen.GUImitarbeiterAdminScreen(username, name, pathNew, tempStat); 
		  } // end of if
		  else {
			  JOptionPane.showMessageDialog(null, "Directories can be deleted only if they are empty except for their log.", "Warnung", JOptionPane.PLAIN_MESSAGE);
			 
			  GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
			  restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
		  } // end of if-else
	  }
	  
	  /*
	  Mit dieser Funktion k�nnen Verzeichnisse ge�ffnet werden.
	   Es gibt keine Ein- & Ausgabeparameter.
	   */
	  //Ubersicht guiubersicht
	  public void openDirectory(String directoryName) {                            
		  String newPathString = PathHandler2.addToPath(directoryName);
	    
		  JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
		  tempMainFrame.dispose();
		  GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
		  restartAdminScreen.GUImitarbeiterAdminScreen(username, name, newPathString, tempStat); 
	  }
	  
	  /*
	   * Mit dieser Funktion wird der Inhalt eines Verzeichnisses herausgefunden.
	   * @param dir ist das Vezeichnis von dem die Dateien aufgerufen werden.
	   * @return folder gibt die Liste der vorhandenen Dateien in diesem Ordner zur�ck.
	   */ 
	   public String[] getContent(String dir) {                                  
		   PathHandler2.addToPath(dir);                                                         
		   File file = PathHandler2.getPathFile();
		   String[] folder = file.list();
		   PathHandler2.deleteFromPath();
		   return folder;
	   }
	
  
  /************************
   * Aktuell nicht vonnoeten
   ************************/
	/*
	public void createDepartments(String domain, String a, String ab, String abt){  
		File file = new File("");
		String here = file.getAbsoluteFile().toString();
		createDirectoryB(here+"\\Server", domain);
		createDirectoryB(here+"\\Server\\"+domain, a);
		createDirectoryB(here+"\\Server\\"+domain, ab);
		createDirectoryB(here+"\\Server\\"+domain, abt); 
	} 
	
	
	public void createDirectoryB(String path, String directoryName) {             
		try {
			String pathCurrent = (path + "\\" + directoryName);
			Path pathNewDirectory = (Paths.get(pathCurrent));
			
			String operationCompleted = ("Verzeichis erstellt: "+ directoryName);
			Path donePath = Files.createDirectories(pathNewDirectory);
			
			LogbookFunctions.createLogbookInNewFolder(pathCurrent);
			LogbookFunctions.preparationLogbook(pathCurrent);
			LogbookFunctions.writeLogbookDirectory(operationCompleted, pathCurrent, pathCurrent);
			LogbookFunctions.writeLogbookDirectory(operationCompleted, path, path);  
		} catch (Exception e2){
			e2.printStackTrace(); 
		}
		return;                                         
	}
	
   Mit dieser Funktion k�nnen Verzeichnisse geschlossen werden.
   Es gibt keine Ein- & Ausgabeparameter.
   
  public void closeDirectory(){                                               
    VariablenHandler.deleteFromPath();
    
    Ubersicht ubersicht= new Ubersicht();
    ubersicht.guiubersicht();
    }
  
   Hier wird �berpr�ft, wieviele Dateien in einem Ordner sind und diese werden zur�ckgegeben.
   Es gibt keine Eingabeparameter
   @return folder gibt die Liste der vorhandenen Dateien in diesem Ordner zur�ck.
  
    
    public String[] getVisual(){                                                
    	File file = VariablenHandler.getPathFile();
    	String[] folder = file.list();
    	return folder;
    
  	}  
    
	 */
}
