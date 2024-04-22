package TopPackage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class PathHandler {
	
	/*******************
	 *** START PATHS ***
	 *******************/
	
	// *** String *** //
	static String workPathString = System.getProperty("user.dir");
	
	// *** Path *** //
	static Path userdirPath = Paths.get(workPathString);
	
	/**********************
	 *** ALL WORK AREAS *** 
	 **********************/
	
	// *** TOP AREAS *** //
	static Path srcPath = Paths.get("src");
	static Path serverPath = Paths.get("Server");
	//static Path subPathcompletePath = userdirPath.resolve(srcPath).resolve(serverPath);
	
	// *** WORK AREAS *** //
	static Path veranstaltungenPath = Paths.get("Veranstaltungen");
	static Path customerPath = Paths.get("Kunden");
	static Path employerPath = Paths.get("Mitarbeiter");
	static Path emailRegPath = Paths.get("email_Registrierung");
	static Path emailVorgotPasswPath = Paths.get("email_Passwort_Vergessen");
	static Path emailTicketPath = Paths.get("email_Tickets");
	static Path mailTicketPath = Paths.get("mail_Tickets");
	
	/*********************************
	 *** COMPLETE WORK AREAS PATHS *** 
	 *********************************/
	static Path subWorkCompletePath = ConcatPath2(userdirPath, srcPath, serverPath);
	public static Path complWorkServerVerPath = ConcatPath(subWorkCompletePath, veranstaltungenPath);
	static Path complWorkServerCusPath = ConcatPath(subWorkCompletePath, customerPath);
	static Path complWorkServerEmpPath = ConcatPath(subWorkCompletePath, employerPath);
	static Path complWorkServerRegPath = ConcatPath(subWorkCompletePath, emailRegPath);
	static Path complWorkServerEmailPWPath = ConcatPath(subWorkCompletePath, emailVorgotPasswPath);
	static Path complWorkServerEmailTickPath = ConcatPath(subWorkCompletePath, emailTicketPath);
	static Path complWorkServerMailTickPath = ConcatPath(subWorkCompletePath, mailTicketPath);
	
	/*********************** 
	 *** PATHS TO STRING *** 
	 ***********************/
	// *** TRIPLE CONNECT PATH *** //
	static String subWorkCompletePathString = subWorkCompletePath.toString();
	// *** DOUBLE CONNECT PATH *** //
	public static String complWorkServerVerPathString = complWorkServerVerPath.toString();
	static String complWorkServerCusPathString = complWorkServerCusPath.toString();
	static String complWorkerverEmpPathString = complWorkServerEmpPath.toString();
	static String complworkServerRegPathString = complWorkServerRegPath.toString();
	static String complWorkServerEmailPWPathString = complWorkServerEmailPWPath.toString();
	static String complWorkServerEmailTickPathString = complWorkServerEmailTickPath.toString();
	static String complWorkServerMailTickPathString = complWorkServerMailTickPath.toString();
	
	public static String[] categoryStrings = {"Messe", "Sport", "Konzerte", "Theater", "Musical", "Oper", "Ausstellungen", "Venisage", "Festival", "Konferenzen", "Tagungen"};
	
	public static Path complWorkServerVerPath2 = ConcatPath(complWorkServerVerPath, Path.of(categoryStrings[8]));
	
	public static String[] concertGenreStrings = {"Pop", "Rock", "Klassik", "Jazz", "Hip-Hop", "Punk"};
	public static String[] theaterGenreStrings = {"Theater", "Musicals", "Oper"};
	public static String[] sportEventStrings = {"Fußball", "Basketball", "Tennis", "Golf", "Leichtathletik"};
	public static String[] festivalKindStrings = {"Truck", "Comic", "Wine"};
	public static String[] charityKindStrings = {"Benefizkonzerte, Galen"};
	public static String[] fairKindStrings = {"Trade", "Book", "Technic", };
	public static String[] exhibitionKindStrings = {"Kunst", "Venisage"};
					
	//subStrings
	static String serverVerPathString;
	static String serverCustPathString;
	static String serverEmplPathString;
	static String emailRegPathString;
	static String emailVorgotPasswPathString;
	static String emailTickesPathString;
	static String mailTicketsPathString;
	
	// *** Vorgefertigte Paths m�ssen noch in die jeweiligen WorkPanel integriert werden bzw. durch getter weitergereicht
	//static Path serverVerPathPath = subPathcompletePath.resolve(veranstaltungenPath); - FINISH
	//static Path serverCustPathPath = subPathcompletePath.resolve(customerPath); - FINISH
	//static Path serverEmplPathPath = subPathcompletePath.resolve(employerPath); - FINISH
	//static Path emailRegPathPath = subPathcompletePath.resolve(emailRegPath);
	//static Path emailVorgotPasswPathPath = subPathcompletePath.resolve(emailVorgotPasswPath);
	//static Path emailTickesPathPath = subPathcompletePath.resolve(emailTicketPath);
	//static Path mailTicketsPathPath = subPathcompletePath.resolve(mailTicketPath);
	
	// *** MAIN FOR TEST PURPOSE *** //
	public static void main(String[] args) throws Exception{
		
		System.out.println(workPathString);
		System.out.println(subWorkCompletePath);
		System.out.println(complWorkServerCusPath);
		System.out.println(complWorkServerEmpPath);
		
		
		System.out.println(srcPath);
		System.out.println(serverPath);
		
		/*
		String filenameString5 = System.getProperty("user.dir");
		Path userdirPath10 = Paths.get(System.getProperty("user.dir"));
		
		Path userdirPath2 = Paths.get(filenameString5);
		Path srcPath2 = Paths.get("src");
		Path serverPath2 = Paths.get("Server");
		Path verPath = Paths.get("Veranstaltungen");
		//Path subVerPath = Paths.get("00000002");
		
		//Path selber konstruieren
		//Path anothercompletePath2 = userdirPath2.resolve(srcPath2).resolve(serverPath2).resolve(verPath).resolve(path);
		
		//Komplexe Verschachtelte Funktion um den Path zu bauen
		//Path anothercompletePath42 = ConcatPath(ConcatPath(ConcatPath2(userdirPath, srcPath, serverPath), veranstaltungenPath), path);
		
		
		
		System.out.println("You are here: currentpaht = "+ currentPath);
		System.out.println("You are really here: userdirPath = " + userdirPath);
		//String serverPathString = Files.createDirectories(userdirPath.resolve("Server")).toString();
		//System.out.println("ServerPathString created: -> " + serverPathString);
		String serverNameString = "Server";
		File folderFile = new File(serverNameString);
		String absolutePathString = folderFile.getAbsolutePath();
		System.out.println("Absoluter PFad des Ordners: " + absolutePathString);
		
		serverPathString = workPathString + "\\" + serverNameString;
		System.out.println(serverPathString);
		//Path userDirServerPathPath = ConcatPath(Path.of(serverPathString), Path.of(serverNameString));
		//System.out.println("userDirServerPathString: " + userDirServerPathPath.toString());
		
		Path path = Paths.get("testdokument.txt");
		System.out.println(path);
		Path anothercompletePath4 = ConcatPath(complWorkServerVerPath, path);
	
		System.out.println("-----------------------*************----------------------------");
		if(Files.exists(anothercompletePath4)) {
			if(Files.isRegularFile(anothercompletePath4)){
				JOptionPane.showMessageDialog(null, "Die Datei existiert.", "Warnung", JOptionPane.PLAIN_MESSAGE);
				System.out.println("File exists");
				System.out.println(anothercompletePath4);
			}
		} else {
			System.out.println("File doesn�t exists");
		}
		System.out.println("-----------------------*************----------------------------");
		*/
	}
	// *** END OF MAIN *** //
	
	//*** Little StringHelper ***
//	protected static Path getPathPath(Path a) {
//		Path path = Paths.get(a);
//		return path;
//	}
	
//	void concatPathString(String a, String b){
//		String completePathString = a + b;
//	}

	//*** Little PathHelper ***
	public static Path convertStringToPath(String a) {
		Path completePathPath = Path.of(a);
		return completePathPath;
	}
	
	
	/* 
	 * Funktion um den ben�tigten Path zu bekommen
	 * 
	 * @param = ist der PathString der weitergereicht werden soll
	 * @return = Path ist der path der zur�ck gegeben wird
	 */
	public static Path getPathString(String a) {
		Path path = Paths.get(a);
		return path;
	}
	
	
	/* 
	 * Funktion um Paths to concat
	 * 
	 * @param1 = "Path a" der als Vervollst�ndigter Root ben�tigt wird
	 * @param2 = "Path b" der als an " Path a" angeh�ngt werden soll
	 */
	static Path ConcatPath(Path a, Path b) {
		 Path path = a.resolve(b);
		 return path;
	}
	
	/* 
	 * Funktion um Paths to concat
	 * 
	 * @param1 = "Path a" der als Vervollst�ndigter Root ben�tigt wird
	 * @param2 = "Path b" der an "Path a" angeh�ngt werden soll
	 * @param2 = "Path c" der an "Path b" angeh�ngt werden soll
	 */
	static Path ConcatPath2(Path a, Path b, Path c) {
		Path path = a.resolve(b).resolve(c);
		return path;
	}
	
	public static String mail;
	 public static String currentPath;
	 public static String firma;
	 public static String statis;
	 public static String abteilung;
	  
	 /* 
	  * Initialisierungskonstruktor wenn zum Beispiel Account gel�scht bzw bearbeitet.
	  *
	  * Es gibt keine Ein-& Ausgabeparamter.
	  */
	  public static void variablenHandler(){                                        
		  mail = "root";
		  statis = "CEO";
	  }
	  
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
	  
	//Kommt von VariablenHandler (Original)
	/*****************************
	 * MUSS NOCH SORTIERT WERDEN *
	 *****************************/
	 
	  /* 
	   * Funktion um in einem Ordner eine Datei oder einen Ordner zu �ffnen und sich in diesem zu befinden.
	   * 
	   * @param data ist der zu �ffnende Ordner bzw zu �fnnende Datei.
	   * @return currentPath ist der R�ckgabeparameter.
	   */
	  public static String addToPath(String data){                                
	    if (currentPath.equals(currentPath.replaceAll(data, ""))) {
	      currentPath = (currentPath + "/" +data);
	    } // end of if
	    currentPath = currentPath.trim();
	    return currentPath;
	  }
	  
	  /*
	   * Funktion um einen Schritt im Dateipfad zur�ck zugehen.
	   *
	   * Es gibt keine Ein-& Ausgabeparameter.
	   */ 
	  public static String deleteFromPath() {                                       
		    boolean check = false;
		    char[] currentP = currentPath.toCharArray();
		    int i = currentP.length;
		    if (getDirectoryName().equals(getFirma())) {
		      JOptionPane.showMessageDialog(null, "Das ist das h�chste f�r Sie einsehbare Verzeichnis", "Warnung", JOptionPane.PLAIN_MESSAGE);
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
	   * Diese Hilfsfunktion gibt den aktuellen Dateipfad als String zur�ck. 
	   * 
	   * Es gibt keine Eingabeparamter. 
	   * 
	   * @return currentPath der aktuelle Pfad.
	   */
	  public static String getPath(){
		  return currentPath;
	  } 
	  
	  /*
	   * Diese Hilfsfunktion gibt die E-Mail als String zur�ck.
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
	   * Diese Hilfsfunktion gibt die Firma als String zur�ck.
	   * 
	   * Es gibt keine Eingabeparamter. 
	   * 
	   * @return firma ist die Firma.
	   */
	  public static String getFirma(){                                             
		  return firma;
       
	  }
	  
	  /*
	   * Diese Hilfsfunktion gibt die Abteilung als String zur�ck.
	   * 
	   * Es gibt keine Eingabeparamter. 
	   * 
	   * @return abteilung ist die Abteilung des Nutzers.
	   */
	  public static String getAbteilung(){                                       
		  return abteilung;
   
	  }
	  
	  /*
	   * Diese Hilfsfunktion gibt den Status als String zur�ck.
	   * 
	   * Es gibt keine Eingabeparamter. 
	   * 
	   * @return Statis ist die Abteilung des Nutzers.
	   */
	  public static String getStatis() {
		  return statis;
	  }
	  
	  /*
	   * Diese Hilfsfunktion gibt den aktuellen Dateipfad als Path zur�ck.
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
	   * Diese Hilfsfunktion gibt den aktuellen Dateipfad als File zur�ck.
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
	   * Diese Hilfsfunktion gibt den Namen des Verzeichnis als String zur�ck.
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

}
