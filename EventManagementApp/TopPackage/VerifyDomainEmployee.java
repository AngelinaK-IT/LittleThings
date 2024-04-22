package TopPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Hier werden die in Nutzerregistrierung eintragenen Daten einer Firma in einer .txt Datei gepseichert.
 * @see Nutzerregistrierung.
 * 
 * @version 1.0.
 * @author xxx
 */
//VerifyDomainEmployee verifyDomain
public class VerifyDomainEmployee {
  
	public static Scanner x;
	
	/*
	 * Die Funktion überprüft ob die domain der E-Mailadresse des Users bereits vorhanden ist(FirmData.txt). 
	 * 
	 * 
	 * die Parameter wurden in das Fenster der Klasse Nutzerregistrierung eingetragen.
	 * @param domain ist die Domain der E-Mailadresse der Firma. Diese dient als Authentifizerung und Zuweisung der Mitarbeiter.
	 * 
	 * es gibt keinen Rückgabewert.
	 */
	public static void verifyDomain(String domain){                               //Funktion um die in NutzerRegistrierung eingegebene Domain zu checken, ob sie vorhanden ist.
    
		boolean found = false;
		String tempDomain = "";
		String tempA = "";
		String tempAb = "";
		String tempAbt = "";

		try {
			x = new Scanner(new File("FirmData.txt"));
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found){
				tempDomain = x.next();
				tempA = x.next();
				tempAb = x.next();
				tempAbt = x.next();                                
				if (tempDomain.trim().equals(domain.trim())) {
					found = true;
				}
			}
			x.close();
      
			if (found == true) {
				JOptionPane.showMessageDialog(null, "Es handelt sich hier um einen Prototyp. Die Daten werden in einer unverschlüsselten .txt Datei gespeichert. Daher raten wir stark von der Verwendung von realen Daten ab und würden das Testen mit Testdaten empfehlen.", "Datenschutzhinweis", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "Die angegebenen Daten werden an keine Person weitergeleitet und ist lediglich von den Admins und dem User selbst einsehbar und anpassbar.", "Datenschutzhinweis", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "Die Öffnung des privaten Dateisystems wird lediglich zum hoch- und runterladen der Dateien verwendet und während der Verwendung wird keine nicht ausgewählte Datei in das System übernommen.", "Datenschutzhinweis", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "Die Inhalte der hochgeladenen Daten werden von Seiten des Anbieters nicht geöffnet oder heruntergeladen.", "Datenschutzhinweis", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "Durch das Löschen der persönlichen Daten werden diese komplett aus dem Sicherheitssystem entfernt. Es gibt keine Sicherheitskopien.", "Datenschutzhinweis", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "Mit dem Zustimmen dieses Fensters und der anschließenden Anmeldung stimmen sie den oben genannten Punkten zu und erlauben der Anwendung die Speicherung der personenbezogenen Daten und die Öffnung und Nutzung des lokalen Dateisystems.", "Datenschutzhinweis", JOptionPane.PLAIN_MESSAGE);                                                                                                                                               //-> Eintrag in LoginData und UserData + Erstellen des Nutzerverzeichnisses mit seinem Namen
				//EmployeeRegistration GUINuReg
				EmployeeRegistration nutzerreg = new EmployeeRegistration();
				nutzerreg.GUINuReg(domain);
			} // end of if
			else {
				//RegistrationScreenEmployee GUIEmployeeReg
				JOptionPane.showMessageDialog(null, "This domain is not assigned to any company", "Warnung", JOptionPane.PLAIN_MESSAGE);
				RegistrationScreenEmployee nure = new RegistrationScreenEmployee();
				nure.RegistrationScreenEmployee();        
			} // end of if-else
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
