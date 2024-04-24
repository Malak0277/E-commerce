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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class PaymentExistingCardController {

    @FXML
    private AnchorPane Data;

    @FXML
    private AnchorPane Main;

    @FXML
    private Button backBtn;

    @FXML
    private ListView<Visa> cards;

    @FXML
    private PasswordField cvv;

    @FXML
    private Button nextBtn;

    @FXML
    private Label MessageLabel;

    private Alert alert;
    
    private User user = EcomSystem.getCurrentSystem().getCurrentUser();

    @FXML
    void nextBtnOnAction(ActionEvent event) {
        String cv = cvv.getText();
        Visa selectedVisa = cards.getSelectionModel().getSelectedItem();

        if (selectedVisa == null) {
            MessageLabel.setText("Please choose a visa");
            return;
        }

        if (cv.isEmpty()){
            MessageLabel.setText("Please enter cvv");
            return;
        }

        int cvvNumber = Integer.parseInt(cv);

        if(!selectedVisa.CVV_check(cvvNumber)){
            MessageLabel.setText("Wrong cvv");
            return;
        }

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

        User currentUser = user;


        // Create a custom cell factory for the ListView
        cards.setCellFactory(list -> new ListCell<Visa>() {
            private Label label = new Label();

            @Override
            protected void updateItem(Visa item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    // Get the last four characters of the Visa number
                    String visaNumber = item.getVisaNumber();
                    String displayedText = "**** **** **** " + visaNumber.substring(Math.max(visaNumber.length() - 4, 0));
                    label.setText(displayedText);
                    setGraphic(label);
                }
            }
        });
        cards.getItems().addAll(currentUser.get_visas());


        // Limit CVV input to maximum 3 characters using a TextFormatter
        UnaryOperator<TextFormatter.Change> cvvFilter = change -> {
            if (change.getControlNewText().length() <= 3) {
                return change;
            }
            return null;
        };
        cvv.setTextFormatter(new TextFormatter<>(cvvFilter));


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