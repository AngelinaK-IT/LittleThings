package Language;

import java.util.ArrayList;

import TopPackage.VariablenHandler;

public class LanguageModul_France {
	
	static String languageString = "Langue";
	static String englishMain = "Anglais";
	static String germanMain = "Français";
	static String franceMain = "Français";
	static String welcomeString = "Bienvenue";
	static String buyWithoutReg = "Acheter sans s'inscrire";
	static String registration = "inscription";
	static String login = "inscription";
	ArrayList<String> appStart = new ArrayList<>();
	
	static String regTitleString = "Inscription";
	static String zusatzString = "Complément(titre)";
	static String salutationString = "Titre de civilité";
	static String surNameString = "Nom de famille";
	static String firstNameString = "Prénom";
	static String ageString = "Âge";
	static String mailAddresseString = "Adresse e-mail";
	static String userNameString = "Nom d'utilisateur";
	static String typePasswordString = "Saisir le mot de passe";
	static String repeatPasswordString = "Répéter le mot de passe";
	static String registNowString = "S'inscrire maintenant";
	static String backWithoutString = "Retourner sans s'inscrire";
	static String passwordWarningString = "Les mots de passe ne correspondent pas. Veuillez les saisir à nouveau!";
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
