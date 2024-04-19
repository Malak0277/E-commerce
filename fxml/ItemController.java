import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;

public class ItemController {

    @FXML
    private Button addButton;

    @FXML
    private Spinner<?> itemAmount;

    @FXML
    private ImageView itemImg;

    @FXML
    private Label itemName;

    @FXML
    private Label itemPrice;

    private Item item;

    private Image image;

    public void setData(Item item) {
        itemName.setText(item.getName());
        itemPrice.setText(String.valueOf(item.getPrice()));
        //image = new Image(item.getImage(), 200, 195, false, true)
        itemImg.setImage(image);


    }

}
