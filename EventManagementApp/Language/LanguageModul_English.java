package Language;

import java.util.ArrayList;

import TopPackage.VariablenHandler;

public class LanguageModul_English {
	
	static String languageString = "Language";
	static String englishMain = "English";
	static String germanMain = "German";
	static String franceMain = "France";
	static String welcomeString = "Welcome";
	static String buyWithoutReg = "Buy Without Registration";
	static String registration = "Registration";
	static String login = "Login";
	ArrayList<String> appStart = new ArrayList<>();
	
	static String regTitleString = "Registration";
	static String zusatzString = "Addendum(Title)";
	static String salutationString = "Salutation";
	static String surNameString = "Surname";
	static String firstNameString = "First name";
	static String ageString = "Age";
	static String mailAddresseString = "Mail address";
	static String userNameString = "User name";
	static String typePasswordString = "Enter password";
	static String repeatPasswordString = "Repeat password";
	static String registNowString = "Register now";
	static String backWithoutString = "Back without registration";
	static String passwordWarningString = "Passwords do not match. Please enter again!";
	ArrayList<String> regStart = new ArrayList<>();
	
	public static ArrayList<String> getAppStartLanguage() {
		ArrayList<String> appStart = new ArrayList<>();
		appStart = VariablenHandler.CollectAndSaveInList(languageString, englishMain, germanMain, franceMain, 
								 						 welcomeString, buyWithoutReg, registration, login);
		return appStart;
	}
	
	public static ArrayList<String> getRegLanguage() {
		ArrayList<String> regStart = new ArrayList<>();
		regStart = VariablenHandler.CollectAndSaveInList(regTitleString, zusatzString, salutationString, surNameString, firstNameString, 
				 										 ageString, mailAddresseString, userNameString, typePasswordString, 
				 										 repeatPasswordString, registNowString, backWithoutString, passwordWarningString);
		return regStart;
	}
	
	// *** MAIN FOR TEST PURPOSE *** //
	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<>();
		aList = getAppStartLanguage();
		
		System.out.println(aList);
		
	}
	// *** END MAIN *** //
}
