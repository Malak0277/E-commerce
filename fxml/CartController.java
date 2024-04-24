package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    @FXML
    private Label amount;

    @FXML
    private Label bookName;

    @FXML
    private VBox cart;

    @FXML
    private Button decrease;

    @FXML
    private HBox hb;

    @FXML
    private Button increase;

    @FXML
    private Label logout;

    @FXML
    private Label orders;

    @FXML
    private Region navHome;

    @FXML
    private Button orderNow;

    @FXML
    private Label price;

    @FXML
    private Label remove;

    @FXML
    private VBox sideNav;

    @FXML
    private Label totalPrice;

//    @FXML
//    private ScrollPane cartScrollPane;

    ///////////////EDIT BASED ON WHERE IT BE CALLED
    Cart c = User.getCurrentUser().getCart();
    private Map<Item, Integer> cartItems = c.getItems();

    @FXML
    private void handleNavHomeClick(MouseEvent event) {
        navigateToMouse(event, "Catalog.fxml");
    }

    @FXML
    private void handleOrdersClick(MouseEvent event) {
        navigateToMouse(event, "OrdersList.fxml");
    }

    @FXML
    private void handleLogoutClick(MouseEvent event) {
        navigateToMouse(event, "login.fxml");
    }

    @FXML
    private void increaseOnAction(ActionEvent event, Item item, Label label) {
        int newValue = c.increaseAmount(item);
        label.setText(String.valueOf(newValue));
        totalPrice.setText(String.valueOf((float)c.getTotalPrice() + " $"));
    }

    @FXML
    private void decreaseOnAction(ActionEvent event, Item item, Label label) {
        int newValue = c.decreaseAmount(item);
        if(newValue != 0) {
            label.setText(String.valueOf(newValue));
            totalPrice.setText(String.valueOf((float) c.getTotalPrice() + " $"));
        }
        else
            GUIadding();

    }


    @FXML
    private void removeOnAction(MouseEvent event, Item item) {
        c.removeFromCart(item);
        GUIadding();
    }

    @FXML
    private void orderNowOnAction(ActionEvent event) {
        navigateTo(event, "orderRequest.fxml");
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

    public void navigateToMouse(MouseEvent event, String nextPageFXML) {
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

    public void GUIadding()
    {
        cart.getChildren().clear();
        if (cartItems.isEmpty()) {
            Label empty = new Label("Empty Cart");
            empty.setAlignment(Pos.CENTER);
            empty.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-padding: 150px;");
            cart.getChildren().add(empty);
        } else {
            for (Map.Entry<Item, Integer> currItem : cartItems.entrySet()) {
                if(currItem.getKey().getStock() == 0){
                    c.removeFromCart(currItem.getKey());
                    continue;
                }

                HBox hb = new HBox();
                hb.setPrefHeight(100); // Set preferred height for HBox

                Label bookName = new Label(currItem.getKey().getName());
                bookName.setPrefHeight(60);
                bookName.setPrefWidth(160);
                bookName.setStyle("-fx-font-size: 14px;");
                HBox.setMargin(bookName, new Insets(20, 10, 0, 25)); // Set margins

                Label price = new Label(String.valueOf(currItem.getKey().getPrice()) + " $");
                price.setPrefHeight(60);
                price.setPrefWidth(81);
                price.setStyle("-fx-font-size: 14px;");
                HBox.setMargin(price, new Insets(20, 0, 0, 0)); // Set margins

                Button decrease = new Button("-");
                decrease.setPrefHeight(26);
                decrease.setPrefWidth(28);
                HBox.setMargin(decrease, new Insets(38, 0, 0, 0)); // Set margins


                Integer amountValue;
                if(currItem.getValue() > currItem.getKey().getStock())
                    amountValue = currItem.getKey().getStock();
                else
                    amountValue = currItem.getValue();

                Label amount = new Label(String.valueOf(amountValue));
                amount.setAlignment(javafx.geometry.Pos.CENTER);
                amount.setPrefHeight(60);
                amount.setPrefWidth(45);
                HBox.setMargin(amount, new Insets(20, 0, 0, 0)); // Set margins

                Button increase = new Button("+");
                increase.setPrefHeight(26);
                increase.setPrefWidth(28);
                HBox.setMargin(increase, new Insets(38, 0, 0, 0)); // Set margins

                Label remove = new Label("🗑");
                remove.setPrefHeight(60);
                remove.setPrefWidth(45);
                remove.setStyle("-fx-font-size: 30px;");
                HBox.setMargin(remove, new Insets(25, 0, 0, 15)); // Set margins

                hb.getChildren().addAll(bookName, price, decrease, amount, increase, remove);
                cart.getChildren().add(hb);

                increase.setOnAction(event -> increaseOnAction(event, currItem.getKey(), amount));
                decrease.setOnAction(event -> decreaseOnAction(event, currItem.getKey(), amount));
                remove.setOnMouseClicked(event -> removeOnAction(event, currItem.getKey()));
            }
            totalPrice.setText(String.valueOf((float)c.getTotalPrice() + " $"));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GUIadding();

        navHome.setOnMouseClicked(this::handleNavHomeClick);
        orders.setOnMouseClicked(this::handleOrdersClick);
        logout.setOnMouseClicked(this::handleLogoutClick);
        orderNow.setOnAction(event -> orderNowOnAction(event));

    }
}
