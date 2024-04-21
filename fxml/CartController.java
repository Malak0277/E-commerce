import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    @FXML
    private VBox cart;

    ///////////////EDIT BASED ON WHERE IT BE CALLED
    Cart c;
    private Map<Item, Integer> cartItems = c.getItems();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cart.getChildren().clear();
        if(cartItems.isEmpty()){
            Label empty = new Label("Empty Cart");
            cart.getChildren().add(empty);
        } else {
            for (Map.Entry<Item, Integer> currItem: cartItems.entrySet()) {
                HBox hb = new HBox();
                Label bookName = new Label(currItem.getKey().getName());
                Label bookAmount = new Label(currItem.getValue().toString());
                hb.getChildren().add(bookName);
                hb.getChildren().add(bookAmount);
                cart.getChildren().add(hb);
            }

        }


    }



}
