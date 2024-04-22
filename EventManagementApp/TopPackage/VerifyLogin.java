package TopPackage;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 *Diese Funktion wird nach dem Anmeldescreen aufgerufeh. Hier wird überprüft, ob der User einen Account für diese Anwendung hat.
 *
 * 
 * @version 1.0.
 * @author xxx
 */
public class VerifyLogin{
  
	public Scanner x, y;
	
	static String nameString; 
	
	/*
	 * Hier werden die vom Anmeldescreen übergebenen Daten überprüft, ob sie einem User zuzuordnen sind.
	 * @param username	entspricht dem usernamen des Users.
	 * @param password	ist das Passwort des Users.
	 */
	public void verifyLogin(String username, String name, String password) {	//Funktion um Mailadresse und Passwort zu verifizieren. Außerdem wird VariablenManager mit werten belegt
		nameString = name;
		String path = "";                                       // -> Eintragung seiner Daten in LoginData und UserData
    
		String Abteilung = "";
		String firma = "";
    
		String tempUsername = "";
		String tempPassword = "";
		String tempPath = "";
    
		String tempNn = "";
		String tempVn = "";
		String tempPw = "";
		String tempUs = "";
		String tempAb = "";
		String tempFi = "";
		String tempData = "";
		String tempStat = "";
    
		boolean found = false;
//    	File file = new File(filepath);
//    	System.out.println(file);
//    	System.out.println(filepath);
		try {
			x = new Scanner(new File("LoginData.txt"));
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found){
				tempUsername = x.next();
				tempPassword = x.next();
				tempPath = x.next();
				if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
					found = true;
					path = tempPath;
				}
			}
			x.close();
			y = new Scanner(new File("UserData.txt"));
			y.useDelimiter("[,\n]");
			while (y.hasNext()) { 
				tempNn = y.next();
				tempVn = y.next();
				tempPw = y.next();
				tempUs = y.next();
				tempAb = y.next();
				tempStat = y.next();
				tempFi = y.next();
				tempData = y.next();
        
				System.out.println(tempUs + tempPw);
				if (tempUs.trim().equals(username.trim()) && tempPw.trim().equals(password.trim())) {
					Abteilung = tempAb;
					firma = tempFi;
				}        
			} // end of while
			y.close();
			if (found == true) {
//        		System.out.println("Übergang zur Verzeichnisübersicht");
//        		System.out.println("hier");
//        		System.out.println(path);
//        		System.out.println(Abteilung);
//        		System.out.println(firma);
				PathHandler2.variablenHandler(username, path, tempStat, Abteilung, firma);
                
				GUImitarbeiterAdminScreen mAdminScreen = new GUImitarbeiterAdminScreen();
				mAdminScreen.GUImitarbeiterAdminScreen(username, name , path, tempStat);
				//Ubersicht ubersicht= new Ubersicht();
				//ubersicht.guiubersicht();
				
			} // end of if
			else {
				JOptionPane.showMessageDialog(null, "Incorrect login data", "Warnung", JOptionPane.PLAIN_MESSAGE);
				AnmeldeScreen anmeldung = new AnmeldeScreen();
				anmeldung.GUIAnmeldung();
			} // end of if-else
         
		} catch(Exception e) {
			e.printStackTrace();
		} 
    
	}
}

