package Language;

import java.util.ArrayList;

import TopPackage.VariablenHandler;

public class LanguageModul_German {
	
	static String languageString = "Sprache";
	static String englishMain = "Englisch";
	static String germanMain = "Deutsch";
	static String franceMain = "Französisch";
	static String welcomeString = "Herzlich Willkommen";
	static String buyWithoutReg = "Kaufen ohne Registration";
	static String registration = "Registrieren";
	static String login = "Anmelden";
	ArrayList<String> appStart = new ArrayList<>();
	
	static String zusatzString = "Zusatz(Titel)";
	static String salutationString = "Anrede";
	static String surNameString = "Nachname";
	static String firstNameString = "Vorname";
	static String mailAddresseString = "Email Adresse";
	static String userNameString = "Benutzername";
	static String typePasswordString = "Passwort eingeben";
	static String repeatPasswordString = "Passwort wiederholen";
	static String registNowString = "Jetzt registrieren";
	static String backWithoutString = "Zurück ohne registrieren";
	static String passwordWarningString = "Passwörte stimmen nicht überein. Bitte nochmal";
	ArrayList<String> regStart = new ArrayList<>();
	
	public static ArrayList<String> getAppStartLanguage() {
		ArrayList<String> appStart = new ArrayList<>();
		appStart = VariablenHandler.CollectAndSaveInList(languageString, englishMain, germanMain, franceMain, 
								 						 welcomeString, buyWithoutReg, registration, login);
		return appStart;
	}
	
	public static ArrayList<String> getRegLanguage() {
		ArrayList<String> regStart = new ArrayList<>();
		regStart = VariablenHandler.CollectAndSaveInList(zusatzString, salutationString, surNameString, firstNameString, 
				 										 mailAddresseString, userNameString, typePasswordString, repeatPasswordString,
				 										 registNowString, backWithoutString, passwordWarningString);
		return regStart;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
