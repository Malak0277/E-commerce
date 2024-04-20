import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Spinner;

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

    private Item item;

    private Image image;

    private SpinnerValueFactory<Integer> spin;

    private Alert alert;

    private Cart cart;
    private double totalPrice;


    public void setData(Item item) {
        itemName.setText(item.getName());
        itemPrice.setText("$" + String.valueOf(item.getPrice()));
        //image = new Image(item.getImage(), 200, 195, false, true)
        itemImg.setImage(image);
    }

    public void setQuantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, item.getStock(), 0);
        amount.setValueFactory(spin);
    }

    private int itemAmount;
    public void add() {

        CatalogController c = new CatalogController();

        itemAmount = amount.getValue();

        if (item.getStock() == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Out of stock!");
            alert.setHeaderText(null);
            alert.setContentText("Sorry, this item is out of stock");
        } else {
            cart.addToCart(item, itemAmount);
            totalPrice = itemAmount * item.getPrice();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Added!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setQuantity();
    }
}
