package com.example.testingproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class PaymentExistingCardController {

    @FXML
    private AnchorPane Data;

    @FXML
    private AnchorPane Main;

    @FXML
    private Button backBtn;

    @FXML
    private ListView<?> cards;

    @FXML
    private PasswordField cvv;

    @FXML
    private Button nextBtn;

    @FXML
    public void initialize() {

        // Add event filter to the CVV field to restrict input to maximum 3 characters
        cvv.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (cvv.getText().length() >= 3) {
                event.consume();
            }
        });
    }

}

