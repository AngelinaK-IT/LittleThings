package TopPackage;

import java.util.ArrayList;

import Language.LanguageModul_English;


public class ApplicationCustomer {
	
	// *** ONLY FOR THE FIRST START *** //
	public static ArrayList<String> tempAppStartArrayList = LanguageModul_English.getAppStartLanguage();
	public static ArrayList<String> tempRegList = LanguageModul_English.getRegLanguage();
	
	public static void main(String[] args) {
		
		ApplicationScreenCustomer go = new ApplicationScreenCustomer();
		go.GUIStartCustomer(tempAppStartArrayList, tempRegList);
	}
}
