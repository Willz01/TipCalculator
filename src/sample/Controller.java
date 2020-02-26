package sample;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ResourceBundle;

import static java.lang.Integer.*;

/**
 * Simple javaFX tip calculator
 * used to calculate tip percentage and amount from actual amount.
 * Wills Ekanem 2020.
 */

public class Controller implements Initializable {

    @FXML
    private TextField AmountField;
    @FXML
    private Slider TipSlider;
    @FXML
    private Label Tip;
    @FXML
    private Label Total;
    @FXML
    private Label TipLabel;
    @FXML
    private Button button;

    @FXML
    public void calculateButton() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TipLabel.textProperty().bindBidirectional(TipSlider.valueProperty(), NumberFormat.getIntegerInstance());


        button.setOnMousePressed(event ->
                {
                    int amount = 0;
                    double tipPer = 0;
                    double tip = 0;
                    try {
                        amount = Integer.parseInt(AmountField.getText());

                        tipPer = TipSlider.getValue();
                       // tip = ((tipPer / 100) * amount);
                        tip = (tipPer/100)*amount;
                        Tip.setText(String.valueOf(tip));
                        double total = (tipPer/100)*amount + amount;
                        Total.setText(String.valueOf(total));
                        // System.out.println(total); test
                    } catch (Exception e) {
                        //  System.out.println(e);
                    }
                }
        );


    }
}
