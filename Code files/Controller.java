package com.internshala.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public Button converter;

    @FXML
    public TextField inputUser;

    private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

    private boolean isC_TO_F = true;


    // controller entry point
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);

        choiceBox.setValue(C_TO_F_TEXT);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.equals(C_TO_F_TEXT)){
                isC_TO_F = true;
            }else {
                isC_TO_F = false;
            }
        });

        converter.setOnAction(event -> {
            convert();
        });

    }

    private void convert() {

        String input = inputUser.getText(); // if we input any value it will get stored as string

        float enteredTemperature = 0.0f;

        try {

            enteredTemperature = Float.parseFloat(input); // entered value will get converted into float
            
        }catch(Exception mistake){
            
            warning();

            return;
        }


        float newTemperature = 0.0f;

        if(isC_TO_F){

            newTemperature = (enteredTemperature * 9/5) + 32; // convert the temperature from celsius to fahrenheit
        }else{
            newTemperature = (enteredTemperature - 32) * 5/9; // convert the temperature from celsius to fahrenheit
        }
        
        display(newTemperature);
    }

    private void warning() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid input!!!");
        alert.setContentText("Please enter a valid temperature input");
        alert.show();
    }

    private void display(float newTemperature) {

        String unit = isC_TO_F? "Fahrenheit" : "Celsius";

        System.out.println("The new temperature is: " + newTemperature + " " + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is: " + newTemperature + " " + unit);
        alert.show();

    }
}
