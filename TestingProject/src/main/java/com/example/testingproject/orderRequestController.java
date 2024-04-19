package com.example.testingproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class orderRequestController {

    @FXML
    private AnchorPane Data;

    @FXML
    private AnchorPane Main;

    @FXML
    private TextField address;

    @FXML
    private Button backBtn;

    @FXML
    private RadioButton existingRadioBox;

    @FXML
    private ChoiceBox<String> methodChoiceBox;

    @FXML
    private RadioButton newRadioBox;

    @FXML
    private Button nextBtn;

    @FXML
    private TextField phoneNo;

    @FXML
    private ToggleGroup visaSelection;

    @FXML
    public void initialize() {
        // Add options to the ChoiceBox
        methodChoiceBox.getItems().addAll("Visa", "Cash");

        // Set a default selection if needed
        methodChoiceBox.getSelectionModel().selectFirst();

        // Add event listener to the ChoiceBox
        methodChoiceBox.setOnAction(event -> {
            String selectedOption = methodChoiceBox.getValue();
            if ("Cash".equals(selectedOption)) {
                existingRadioBox.setVisible(false);
                newRadioBox.setVisible(false);
            } else {
                existingRadioBox.setVisible(true);
                newRadioBox.setVisible(true);
            }
        });
    }

}
