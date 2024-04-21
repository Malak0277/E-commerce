import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class CartController {

    @FXML
    private BorderPane body;

    @FXML
    private Label closeButton;

    @FXML
    private VBox componentBox;

    @FXML
    private BorderPane contentPane;

    @FXML
    private Pane handPaneMac;

    @FXML
    private Region navHome;

    @FXML
    private AnchorPane root;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox sideArea;

    @FXML
    private HBox sideControls;

    @FXML
    private VBox sideNav;

    @FXML
    private void handleNavHomeClick(MouseEvent event) {
        navigateTo(event, "Catalog.fxml");
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
