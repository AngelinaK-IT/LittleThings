package TopPackage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import java.io.IOException;

public class FileFunctions {
	
	//username, name, path, tempStat
	String username = PathHandler2.getMail();
	String name = VerifyLogin.nameString;
	String path = PathHandler2.currentPath;
	String tempStat = PathHandler2.statis;
	
	/*
	 * Hier wird eine Datei erstellt.
	 * 
	 * @param name ist der Dateiname.
	 * @param end ist der Datentyp.
	 * Es gibt keinen Ausgabeparameter.
	 * @throws Exception 
	 */
	public void createFile(String name, String end) throws Exception { 
		String currentPath = PathHandler2.getPath();
		String operationCompleted = ("File created: " +name + end);
		String fileName = (name + end);
		try {
			Path p = Paths.get(PathHandler2.getPath() + "\\" + fileName);
			String[] data = getVisual();
			boolean tester = false;
			int l = data.length - 1;
			while (l >= 0) { 
				if (data[l].equals(fileName)) {     
					tester = true;
				} // end of if
				l--;
			} // end of while
			System.out.println(tester);
			if (tester == true) {
				JOptionPane.showMessageDialog(null, "The file already exists. Please choose another name.", "Warnung", JOptionPane.PLAIN_MESSAGE);
				
				JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
	            tempMainFrame.dispose();
				GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
				restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
			} // end of if
			if (tester == false) {
				Files.createFile(p);
      
				LogbookFunctions.writeLogbookDirectory(operationCompleted, currentPath, currentPath);
				JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
	            tempMainFrame.dispose();
				GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
				restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
			} // end of if
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}     
	}
	
	/*
	 *  Mit dieser Funktion kann eine Datei gelöscht werden.
	 * 
	 * @param datei ist die zu löschende Datei.
	 */
	public void deleteFile(String datei) {                                         //Löschen einer Datei -> Aufruf aus der Verzeichnisübersicht
		String operationCompleted = "Datei gelöscht: "+ datei;
		String pathCurrent = (PathHandler2.getPath());
		try {
			String path = (PathHandler2.getPath()+"\\"+datei);
			Path target = Paths.get(path);
			Files.delete(target);
			LogbookFunctions.writeLogbookDirectory(operationCompleted, pathCurrent, pathCurrent);
			
			JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
	        tempMainFrame.dispose();
			GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
			restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
		} catch(IOException e) {
			e.printStackTrace();
		}     
	}
	
	/*
	 * Mit dieser Funktion kann eine Datei umbenannt werden.
	 * 
	 * @param next ist der neue Ordnername.
	 * @param current ist der alte Ordnername.
	 */
	public void renameFile(String current, String next) {   //Umbenennen einer Datei -> Aufruf aus Verzeichnisübersicht (WICHTIG: Dateiändung kann nicht geändert werden.)
		String pathCurrent = (PathHandler2.getPath());
		String[] data = getVisual();
		boolean tester = false;
		int l = data.length - 1;
		String operationCompleted = "Datei umbenannt: "+current+" zu "+next;
		while (l >= 0) { 
			if (data[l].equals(next)) {     
				tester = true;
			} // end of if
			l--;
		} // end of while
		if (tester == true) {
			JOptionPane.showMessageDialog(null, "Datei darf nicht den selben Namen wie eine andere tragen. \n Umbenennung nicht erfolgreich", "Warnung", JOptionPane.PLAIN_MESSAGE);
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
	 * Mit dieser Funktion kann nach der Dateiöffnung diese gespeichert werden.
	 * 
	 * @param chosen ist der Dateiname.
	 * @param text ist der Text einer Datei.
	 */
	public void safeFile(String chosen, String text) {    
		String operationCompleted = "Datei bearbeitet: " + chosen;
		FileWriter writer;
		String pathCurrent = (PathHandler2.getPath());
		File file = new File(PathHandler2.getPath()+"\\"+chosen);
		try {
			writer = new FileWriter(file, false);
			writer.write(text);
			writer.flush();
			writer.close();
			LogbookFunctions.writeLogbookDirectory(operationCompleted, pathCurrent, pathCurrent);
		} catch(Exception e) {
			e.printStackTrace();
		} 
		JFrame tempMainFrame = GUImitarbeiterAdminScreen.mainframe;
        tempMainFrame.dispose();
		GUImitarbeiterAdminScreen restartAdminScreen = new GUImitarbeiterAdminScreen();
		restartAdminScreen.GUImitarbeiterAdminScreen(username, name, path, tempStat); 
	}
	
	/*
	 * Hiermit wird eine Datei verschoben. Im Prototyp wird es genutzt um das Logbuch nach Löschung eines Ordners zu verschieben.
	 * 
	 * @param next ist der zukünftige Standort der Datei.
	 * @param current ist der aktuelle Standort der Datei.
	 * @param name ist der Name der Datei.
	 */
	public void moveFile(String current, String next, String name) {              
		try {
			File oldFile = new File(current);
			System.out.println("oldFile:" + oldFile);
			System.out.println("next ist:" + next);
			oldFile.renameTo(new File(next));
		} catch(Exception e) {
			e.printStackTrace();
		}   
	}
	
	/*
	 * Durch diese Funktion kann eine Datei heruntergeladen werden.
	 * 
	 * @param in Zielordner des Downloads.
	 * @param out Ursprungsordner der Downloaddatei.
	 * @param chosen ist der Name der ausgewählten Datei.
	 */
	public void downloadFile(String in, String out, String chosen) {   
		String operationCompleted = "Datei heruntergeladen: " + chosen;
		String pathCurrent = PathHandler2.getPath();
		Path pin = Paths.get(in);
		Path pout = Paths.get(out);
		File fin = pin.toFile();
		File fout = pout.toFile();
  
		LogbookFunctions.writeLogbookDirectory(operationCompleted, pathCurrent, pathCurrent);
		copyFile(fin, fout); 
	}
	
	/*
	 * Durch diese Funktion kann eine Datei hochgeladen werden.
	 * 
	 * @param in Zielordner des Downloads.
	 * @param out Ursprungsordner der Downloaddatei.
	 * @param chosen ist der Name der ausgewählten Datei.
	 */
	public void uploadFile(String in, String out, String chosen) {
		//Funktion für die Regelung des Uploads von Dateien
		String pathCurrent = PathHandler2.getPath();
		Path pin = Paths.get(in);
		Path pout = Paths.get(out);
		File fin = pin.toFile();
		File fout = pout.toFile();
		String filename = getFileName(fin);
		String outB = out + "\\" + filename ;
		Path poutB = Paths.get(outB);
		File foutB = poutB.toFile();
  
		String operationCompleted = "Datei hochgeladen: " + filename;
		LogbookFunctions.writeLogbookDirectory(operationCompleted, pathCurrent, pathCurrent);
  
		copyFile(fin, foutB);        
	}

/*  public void copyFile(File in, File out){                                    //Funktioniert leider nicht
  FileChannel inChannel = null;                                               //(Zugriff verweigert)
  FileChannel outChannel = null;
  try {
    inChannel = new FileInputStream(in).getChannel()
    outChannel = new FileOutputStream(out).getChannel();
    inChannel.transferTo(0, inChannel.size(), outChannel);
  } catch(Exception e) {
    e.printStackTrace();
  } finally {
    try {
      if (inChannel != null) {
        inChannel.close();
      } // end of if
      if (outChannel != null) {
        outChannel.close();
      } // end of if
    } catch(Exception e2) {
      e2.printStackTrace();
    }
  } // end of try  
  
}
*/

	/*
	 * Hilfsfunktion für den Up und Download.
	 * 
	 * @param in Zielordner des Downloads.
	 * @param out Ursprungsordner der Downloaddatei.
	 */
	public void copyFile(File in, File out) {                                      
		try {                                                                       
			Files.copy(in.toPath(), out.toPath());
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}  

	/*
	 * Darstellung des Verzeichnisinhaltes.
	 * 
	 * Es gibt keine Ein -& Ausgabeparamter.
	 */
	public String[] getVisual() {                                                  
		File file = PathHandler2.getPathFile();
		String[] folder = file.list();
		return folder;
	} 

	/*
	 * Darstellung des Verzeichnisinhaltes innerhalb eines bestimmten Verzeichnisses.
	 * @param dir ist das aktuelle Verzeicnis.
	 * Es gibt keine Ausgabeparameter. 
	 */
	public String[] getContent(String dir) {                                   
		PathHandler2.addToPath(dir);                                                         
		File file = PathHandler2.getPathFile();
		String[] folder = file.list();
		PathHandler2.deleteFromPath();
		return folder;
	} 

	/*
	 * Diese Funktion gibt den Namen einer Datei zurück.
	 * Sie ist eine Hilffunktion für viele Funktionen.
	 * @param file ist die Datei wesen Name gesucht wird.
	 * @return name den Namen der Datei. 
	 */
	public String getFileName(File file) {
		String name;
		name = file.getName();
		return name;
	}

}

