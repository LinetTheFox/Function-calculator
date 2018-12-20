package sample.visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.functional.FunctionHandling;
import sample.functional.TableParameters;
import sample.functional.TableValues;

public class Controller {
    @FXML
    protected TableView<TableValues> mainTable;
    @FXML
    protected TableColumn<TableValues, Double> xVal, yVal;
    @FXML
    protected TextField startField, endField, stepField, paramField, maxField, minField;
    private NumberAxis xAxis = new NumberAxis(), yAxis = new NumberAxis();
    @FXML protected LineChart<Number, Number> plotChart = new LineChart<>(xAxis, yAxis);

    private static ObservableList<TableValues> tableValues = FXCollections.observableArrayList();

    public static ObservableList<TableValues> getTableValues() {
        return tableValues;
    }

    private FunctionHandling func = new FunctionHandling();
    private TableParameters params = new TableParameters();


    @FXML
    protected void handleCalculate() {
        if(!mainTable.getItems().isEmpty()) mainTable.getItems().clear();
        if(!plotChart.getData().isEmpty()) plotChart.getData().clear();
        func.getNumbers(startField, endField, stepField, paramField);
        if (!func.validNumbers()) return;
        func.setList();
        xVal.setCellValueFactory(new PropertyValueFactory<>("X"));
        yVal.setCellValueFactory(new PropertyValueFactory<>("Y"));
        mainTable.setItems(tableValues);
        maxField.setText(Double.toString(func.getMax()));
        minField.setText(Double.toString(func.getMin()));
        plotChart.getData().addAll(func.getSeries());
    }

    @FXML
    protected void handleTableHeight() {
        params.changeHeight(mainTable);
    }

    @FXML
    protected void handleTableFont() {
        params.changeFont(mainTable);
    }

    @FXML
    protected void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("(c) Sirius SIlverclaw - 2018");
        alert.show();
    }

}

