package TopPackage;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;

/*
 * Die Funktion trägt die im Nutzerregistrierung eingegeben Daten in eine txt-Datei ein.
 * 
 * @version 1.0.
 * @author xxx
 */
//FuncEmployeeRegister UserRegister
public class FuncEmployeeRegister {
	
	public static Scanner x;
	
	/*
	 * Die Funktion schreibt die  Daten, siehe params, in die LoginData.txt und UserData.txt.
	 * Somit werden neue User in unsere Speicherdatei eingefügt.
	 * 
	 *Die folgenden Paramter stammen aus der Eingabe der Nutzerübersicht.
	 *@see Nutzerreg.
	 * @param vorname Das ist der vom Nutzer eingetragene Vorname.
	 * @param nachname Das ist der vom Nutzer eingetragene Nachname.
	 * @param password Das ist das vom Nutzer eingetragene Passwort.
	 * @param mail Das ist die vom Nutzer eingetragene E-Mailadresse.
	 * @param abteilung Das ist die vom Nutzer eingetragene Abteilung.
	 * @domain ist die Zuweisung zu einer bestimmten Firma.
	 * 
	 * Es können sich keine zwei user mit der selben E-Mail registrieren.
	 * Es gibt keinen Rückgabewert.
	 */
	public static void UserRegister(String vorname, String nachname, String password, String mail, String abteilung, String domain, String status) {   
		
		String tempVorname = "";
		String tempNachname = "";
		String tempPassword = "";
		String tempMail = "";
		String tempAbteilung = "";
		String tempDomain = "";
		String tempTime = "";
		String tempStatus = "";
		
		boolean found = false;
    
		try {
			
			x = new Scanner(new File("UserData.txt"));
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found) {
				
				tempVorname = x.next();
				tempNachname = x.next();
				tempPassword = x.next();
				tempMail = x.next();
				tempAbteilung = x.next();
				tempDomain = x.next();
				tempTime = x.next();
				tempStatus = x.next();
        
				if (tempMail.trim().equals(mail.trim())) {  
					found = true;             
				}   
			}

		} catch(Exception e) {
			e.printStackTrace();
		} 
		if (found == false) {     //keine Dopplung
			
			FileWriter write;
			FileWriter writer;
      
			File datei = new File("LoginData.txt");  
			File dat = new File("UserData.txt");    
			
			try{
				
				write = new FileWriter(dat, true);
				Date today = Calendar.getInstance().getTime();
				write.write(vorname+","+nachname+","+password+","+mail+","+abteilung+","+status+","+domain+","+today+"\n");
				write.flush();
				write.close();
        
				String path = ("\\Server\\"+domain+"\\"+abteilung+"\\"+mail);             
        
				writer = new FileWriter(datei, true);                                     //verändert
				writer.write(mail+","+password+","+path+"\n");
        
				writer.flush();
				writer.close(); 
//        System.out.println("Übergang zum Strartscreen"); 
        
				//ApplicationScreenCompany GUIStartCompany
				ApplicationScreenCompany go = new ApplicationScreenCompany();
				go.GUIStartCompany();  //Ab hier neu
				
				DirectoryFunctions dh = new DirectoryFunctions();
				dh.createUser(domain, abteilung, mail, path);  
				
			} catch (Exception e) {
				
				e.printStackTrace();      
				
			}
		}
		
		else {              //wenn found == true
			
			JOptionPane.showMessageDialog(null, "This user is already logged in", "Warnung", JOptionPane.PLAIN_MESSAGE);
			//ApplicationScreenCompany GUIStartCompany
			ApplicationScreenCompany go = new ApplicationScreenCompany();
			go.GUIStartCompany();
			
		} // end of if-else
	}  
}                               
