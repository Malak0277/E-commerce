package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Spinner;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Spinner<Integer> amount;

    @FXML
    private ImageView itemImg;

    @FXML
    private Label itemName;

    @FXML
    private Label itemPrice;


    private User user = EcomSystem.getCurrentSystem().getCurrentUser();

    private Item item;

    private SpinnerValueFactory<Integer> spin;

    private Alert alert;

    private Cart cart = user.getCart();
    private int itemAmount;
    private double totalPrice;


    public void setData(Item item) {
        itemName.setText(item.getName());
        itemPrice.setText("$" + String.valueOf(item.getPrice()));
        //String path = "File:" + item.getImage();
        InputStream stream = getClass().getResourceAsStream(item.getImage());
        Image image = new Image(stream,200, 195, false, true);
        itemImg.setImage(image);
        setQuantity(item);
    }

    public void setQuantity(Item item) {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, item.getStock(), 1);
        amount.setValueFactory(spin);
    }

    public void add(ActionEvent event) {
        item = Catalog.getItem(itemName.textProperty().get());
        itemAmount = amount.getValue();

        if (item.getStock() == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Out of stock!");
            alert.showAndWait();
        } else {
            String msg = "Successfully Added!";
            Integer itemInCart = cart.getItems().get(item);
            if (itemInCart != null && itemInCart + itemAmount > item.getStock()) {
                msg = itemAmount - (item.getStock() - itemInCart) + " not available";
                itemAmount = item.getStock() - itemInCart;
            }

            cart.addToCart(item, itemAmount);
            totalPrice = itemAmount * item.getPrice();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addButton.setOnAction(event -> add(event));
    }
}