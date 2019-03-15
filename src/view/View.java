package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    //private static Locale locale = new Locale("ua");
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    "messages",
                    new Locale("ua", "UA"));  // Ukrainian
                   // new Locale("en"));        // English

    public void printMessage(String message){
        System.out.println(message);

    }
    //button1 = new Button(myResources.getString("OkKey"));

}