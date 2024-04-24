package com.example.testingproject;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OrderListController {

    @FXML
    private AnchorPane Data;

    @FXML
    private AnchorPane Main;

    @FXML
    private Label MessageLabel;

    @FXML
    private Button backBtn;

    @FXML
    private ListView<String> cards;

    @FXML
    private Button nextBtn;

    private User user = EcomSystem.getCurrentSystem().getCurrentUser();


    @FXML
    void nextBtnOnAction(ActionEvent event) {
        String selectedOrderInfo = cards.getSelectionModel().getSelectedItem();
        if (selectedOrderInfo != null) {
            String orderId = extractOrderId(selectedOrderInfo);
            Order.SelectedOrder = user.getOrder(orderId);
            navigateTo(event, "Omangment.fxml");
        }
        else{
            MessageLabel.setText("Please select an order");
            return;
        }
    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        navigateTo(event, "Catalog.fxml");
    }

    private void populateOrdersList() {
        List<Order> ordersList = user.get_orders();

        // Loop through each order and concatenate the required information
        for (Order order : ordersList) {
            String orderInfo = "Order ID: " + order.getOrderID() +
                               " | Phone: " + order.getPhoneNumber() +
                               " | Address: " + order.getAddress();
            cards.getItems().add(orderInfo);
        }
    }

    private String extractOrderId(String orderInfo) {
        int endIndex = orderInfo.indexOf(" | Phone:");
        return orderInfo.substring("Order ID: ".length(), endIndex).trim();
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

    //static boolean s = true;
    @FXML
     public void initialize() {
        /*if(s) {
            User.getCurrentUser().orderGenerator();
            s = false;
        }*/
        populateOrdersList();
        nextBtn.setOnAction(event -> nextBtnOnAction(event));
        backBtn.setOnAction(event -> backBtnOnAction(event));
    }

}
