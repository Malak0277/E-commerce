import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ArrayList;
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
    private Label logout1;

    @FXML
    private Region navCart;

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
                hb = new HBox();
                bookName.setText(currItem.getKey().getName());
                price.setText(String.valueOf(currItem.getKey().getPrice()));
                amount.setText(currItem.getValue().toString());
                hb.getChildren().add(bookName);
                hb.getChildren().add(amount);
                cart.getChildren().add(hb);
            }
            totalPrice.setText(String.valueOf(c.getTotalPrice()));
        }
    }



}
