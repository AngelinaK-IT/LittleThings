package TopPackage;

import java.io.File;
import java.io.FileWriter;

/*
 * @see Firmregistrierung.
 * Nach Durchführung der Firmenregisttrierung werden die Daten an diese Funktion weitergegeben und in der zugehöhrigen txt-Datei gespeichert (FirmData.txt).
 * 
 * @version 1.0.
 * @author xxx
 */
public class FuncCompanyRegister {

	/*
	 * hier werden die Daten der Firmen in der entsprechenden txt Datei gespeichert.
	 * 
	 * @param domain ist die E-maildomain der Firma.
	 * @param a ist die 1.Abteilung der Firma.
	 * @param ab ist die 2.Abteilung der Firma.
	 * @param abt ist die 3. Abteilung der Firma.
	 */
	//RegistrationCompany CompReg
	public static void FuncCompanyRegister(String newServerPathString ,String domain, String a, String ab, String abt) {        //Funktion zum Erstellen einer Firma im System. Es wird ein neuer Eintrag in FirmData gemacht und Verzeichnisse mit dem Namen der Firma und Firma\Abteilung erstellt
   
		FileWriter writer;                                
		File datei = new File("FirmData.txt");
		int x = 0;
		
		try{
			writer = new FileWriter(datei, true);
			writer.write(domain+","+a+","+ab+","+abt+"\n");

			writer.flush();
			writer.close(); 
//      	System.out.println("hat funktioniert");           
			x = 1;
			
		} catch (Exception e) {
			
			e.printStackTrace(); 
//      	System.out.println("Error"); 
      
		}
		if (x == 1) {
			
			ApplicationScreenCompany go = new ApplicationScreenCompany();
			go.GUIStartCompany();
			
			//DirectoryFunctions createDirectory createDirectoryB createDeatments createUser openDirectory
			DirectoryFunctions dh = new DirectoryFunctions();                             //Das ist neu
			dh.createDepartments(newServerPathString, domain, a, ab, abt);
		
//      File file = new File("");
//      String here = file.getAbsoluteFile().toString();
//      System.out.println(here);
//      System.out.println(here+"\\Server");
//      System.out.println(here+ "\\Server\\"+domain);
//      dh.createDirectory(here+"\\Server\\"+domain, domain);
//      DirectoryHandler dha = new DirectoryHandler();
//      System.out.println("1");
//      dha.createDirectory(here+"\\Server\\"+domain+"\\"+ a, a);
//      DirectoryHandler dhb = new DirectoryHandler();
//      System.out.println("2");            
//      dhb.createDirectory(here+"\\Server\\"+domain+"\\"+ ab, ab);
//      DirectoryHandler dhc = new DirectoryHandler();
//      System.out.println("3");
//      dhc.createDirectory(here+"\\Server\\"+domain+"\\"+ abt, abt);             //Bis hier 
//      System.out.println("4");
			
		} // end of if
		else {
			
			//RegistrationScreenCompany CompReg
			RegistrationScreenCompany fire = new RegistrationScreenCompany();
			fire.GUICompanyReg();  
			
		} // end of if-else
	}
}                         
