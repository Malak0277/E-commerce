import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
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
    Cart c = User.getCurrentUser().getCart();
    private Map<Item, Integer> cartItems = c.getItems();

    @FXML
    private void handleNavHomeClicked(MouseEvent event) {
        navigateToMouse(event, "Catalog.fxml");
    }

    @FXML
    private void handleNavCartClicked(MouseEvent event) {
        navigateToMouse(event, "Cart.fxml");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navCart.setOnMouseClicked(this::handleNavHomeClicked);
        navHome.setOnMouseClicked(this::handleNavCartClicked);

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
