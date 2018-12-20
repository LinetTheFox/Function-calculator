package sample.functional;

import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class TableParameters {
    public void changeHeight(TableView<TableValues> table) {
        Dialog heightDialog = new TextInputDialog();
        heightDialog.setHeaderText("Enter the height value (in pixels)");
        Optional<String> res = heightDialog.showAndWait();
        double Value;
        if (res.isPresent()) {
            Value = Double.parseDouble(res.get());
        } else return;
        table.setFixedCellSize(Value);
    }

    public void changeFont(TableView<TableValues> table) {
        Dialog FontDialog = new TextInputDialog();
        FontDialog.setHeaderText("Enter the font size value");
        Optional<String> res = FontDialog.showAndWait();
        double Value;
        if(res.isPresent()) {
            Value = Double.parseDouble(res.get());
        } else return;
        table.setStyle("-fx-font-size:"+Value);
    }
}
