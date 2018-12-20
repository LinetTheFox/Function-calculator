package sample.functional;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import sample.visual.Controller;
import sample.visual.ErrorDialog;

public class FunctionHandling {
    private double start, end, step, param;
    private ObservableList<TableValues> list = Controller.getTableValues();
    private XYChart.Series series = new XYChart.Series();
    private boolean validNumbers;


    public void getNumbers(TextField a, TextField b, TextField c, TextField d) {
            if (!a.getText().isEmpty() && !b.getText().isEmpty() && !c.getText().isEmpty() && !d.getText().isEmpty()) {
                try {
                    start = Double.parseDouble(a.getText());
                    end = Double.parseDouble(b.getText());
                    step = Double.parseDouble(c.getText());
                    param = Double.parseDouble(d.getText());
                    validNumbers = true;
                    return;
                } catch(NumberFormatException ex) {
                    ErrorDialog.displayError("Please enter a valid number!");
                    validNumbers = false;
                    ex.printStackTrace();
                }
            }
            ErrorDialog.displayError("Please fill all the fields!");
            validNumbers = false;
            if (start == end) {
                ErrorDialog.displayError("The interval must have non-zero length!");
            }
            if (step == 0) {
                ErrorDialog.displayError("The step must be a non-zero value!");
            }
            if (param <= 0) {
                ErrorDialog.displayError("The P parameter must be a positive value");
            }
    }

    public boolean validNumbers() {
        return validNumbers;
    }

    public void setList() {
        list.clear();
        if(start < end) {
            for (double x = start; x <= end; x+=step) {
                list.add(new TableValues(x, Function.func(x, param)));
            }
        }
        else if(start > end) {
            for (double x = end; x <= start; x+=step) {
                list.add(new TableValues(x, Function.func(x, param)));
            }
        }
    }

    public XYChart.Series getSeries() {
        if(!series.getData().isEmpty()) series.getData().clear();
        for(TableValues value : list) {
            series.getData().add(new XYChart.Data<>(Double.toString(value.getX()), value.getY()));
        }
        return series;
    }

    public double getMax() {
        double max = list.get(0).getY();
        for(TableValues value : list) {
            if (value.getY() > max) max = value.getY();
        }
        return max;
    }

    public double getMin() {
        double min = list.get(0).getY();
        for(TableValues value : list) {
            if (value.getY() < min) min = value.getY();
        }
        return min;
    }


}
