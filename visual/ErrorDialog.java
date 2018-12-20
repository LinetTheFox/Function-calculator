package sample.visual;

import javafx.scene.control.Alert;

public class ErrorDialog {
    public static void displayError(String headerText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("ERROR");
        alert.setHeaderText(headerText);
        alert.show();
    }
}
