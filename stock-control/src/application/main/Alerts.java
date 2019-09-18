package application.main;

import javafx.scene.control.Alert;

/**
 * The Alerts class is used to generate modal dialogues with messages for the user.
 *
 * @author David Spencer
 * @version 1.0
 */
public class Alerts
{
    /**
     * Generates an alert from given input.
     * @param type type of alert
     * @param title title of alert
     * @param text text for alert
     */
    public static void showAlert(Alert.AlertType type, String title, String text)
    {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}

