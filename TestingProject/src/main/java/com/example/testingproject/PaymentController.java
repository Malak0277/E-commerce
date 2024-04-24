package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.function.UnaryOperator;

import javafx.stage.Stage;

public class PaymentController {

    @FXML
    private AnchorPane Data;

    @FXML
    private AnchorPane Main;

    @FXML
    private Button backBtn;

    @FXML
    private PasswordField cvv;

    @FXML
    private ChoiceBox<String> monthChoiceBox;

    @FXML
    private TextField name;

    @FXML
    private Button nextBtn;

    @FXML
    private TextField number;

    @FXML
    private ChoiceBox<String> yearChoiceBox;

    @FXML
    private Label MessageLabel;

    private Alert alert;

    private User user = EcomSystem.getCurrentSystem().getCurrentUser();

    @FXML
    void nextBtnOnAction(ActionEvent event) {
        String cardHolder = name.getText();
        String num = number.getText();
        String cv = cvv.getText();
        String monthStr = monthChoiceBox.getValue();
        String yearStr = yearChoiceBox.getValue();

        int Month = Integer.parseInt(monthStr);
        int Year = Integer.parseInt(yearStr);
        int cvv = Integer.parseInt(cv);

        // Check if any of the text fields are empty
        if (cardHolder.isEmpty() || num.isEmpty() || cv.isEmpty()) {
            MessageLabel.setText("Please fill in all fields");
            return;
        }

        if(cv.length() < 3){
            MessageLabel.setText("Incomplete cvv");
            return;
        }

        Visa visa = new Visa();

        if(!visa.validvisa(Year, Month)){
            MessageLabel.setText("Invlaid Visa");
            return;
        }

        if(user.Visa_Exist(num)){
            MessageLabel.setText("Visa already exists!");
            return;
        }
        
        Visa v = new Visa(num, cvv);
		user.addVisa(v);

        Cart car = new Cart(user.getCart());
        Order order = new Order(car, Order.currrentOrder.getAddress(), Order.currrentOrder.getPhoneNumber());
        user.addOrder(order);

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Order added successully!");
        alert.showAndWait();

        navigateTo(event, "Catalog.fxml");

    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        navigateTo(event, "orderRequest.fxml");
    }

    @FXML
    public void initialize() {
        // Add values to the month and year ChoiceBoxes

        // Populate month choice box with formatted strings for months (01 to 12)
        for (int i = 1; i <= 12; i++) {
            String month = String.format("%02d", i); // Format month to have leading zero if necessary
            monthChoiceBox.getItems().add(month);
        }

        // Populate year choice box with formatted strings for years (01 to 99)
        for (int i = 24; i <= 99; i++) {
            String year = String.format("%02d", i); // Format year to have leading zero if necessary
            yearChoiceBox.getItems().add(year);
        }

        // Limit CVV input to maximum 3 characters using a TextFormatter
        UnaryOperator<TextFormatter.Change> cvvFilter = change -> {
            if (change.getControlNewText().length() <= 3) {
                return change;
            }
            return null;
        };
        cvv.setTextFormatter(new TextFormatter<>(cvvFilter));


        // Allow only letters for Cardholder's name
        UnaryOperator<TextFormatter.Change> nameFilter = change -> {
            if (change.getText().matches("[a-zA-Z]+")) {
                return change;
            }
            return null;
        };
        name.setTextFormatter(new TextFormatter<>(nameFilter));

        number.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                number.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 16) {
                number.setText(newValue.substring(0, 16));
            }
        });

        nextBtn.setOnAction(event -> nextBtnOnAction(event));
        backBtn.setOnAction(event -> backBtnOnAction(event));
    }

    public void navigateTo(ActionEvent event, String nextPageFXML) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource(nextPageFXML));
            root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();}
        catch (IOException e) {}
    }

}