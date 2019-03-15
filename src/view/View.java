package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    "messages",
                    //new Locale("ua", "UA"));  // Ukrainian
                    new Locale("en"));        // English

    public void printMessage(String message){
        System.out.println(message);

    }
}