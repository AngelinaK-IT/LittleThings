package Language;

public class LanguageSettings {
    private static String selectedLanguage = "English";

    public static String getSelectedLanguage() {
        return selectedLanguage;
    }

    public static void setSelectedLanguage(String language) {
        selectedLanguage = language;
    }
}

