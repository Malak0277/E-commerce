import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

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


    @FXML
    void nextBtnOnAction(ActionEvent event, String selectedOption, String selectedRadio) {
        String selectedOrderInfo = cards.getSelectionModel().getSelectedItem();
            if (selectedOrderInfo != null) {
                String orderId = extractOrderId(selectedOrderInfo);

                Order selectedOrder = User.getCurrentUser().getOrder(orderId);
                if (selectedOrder != null) {
                    navigateToOmangement(event, selectedOrder.getStatus());
                }
                else{
                    MessageLabel.setText("Please select an order");
                    return;
                }
            }
    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        navigateTo(event, "Catalog.fxml");
    }

    private void populateOrdersList() {
        List<Order> ordersList = User.getCurrentUser().get_orders();

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

    public void navigateToOmangement(ActionEvent event, String status){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Omangement.fxml"));
            Parent root = loader.load();

            // Pass the status to the initialize method of OmangementController
            OmangementController omangementController = loader.getController();
            omangementController.initialize(status);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
     public void initialize() {
        populateOrdersList();
        nextBtn.setOnAction(event -> nextBtnOnAction(event));
        backBtn.setOnAction(event -> backBtnOnAction(event));
    }

}
