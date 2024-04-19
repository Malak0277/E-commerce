import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class ocontroller {

    @FXML
    private Label L2;

    @FXML
    private Label L5;

    @FXML
    private Label L4;

    @FXML
    private Label L3;

    @FXML
    private Label L1;
    @FXML
    private Order order; 
    @FXML
    private Button hii;
    @FXML
    void cancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel this order?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            if (order.getStatus().equals("Delivered")) {
                Alert alet = new Alert(AlertType.WARNING);
                alet.setTitle("Warning");
                alet.setHeaderText("Order cannot be canceled");
                alet.setContentText("The order has already been delivered and cannot be canceled.");
                alet.showAndWait();
        }   else {
            order.cancel_order();}
        }
    }
    
    private void updateStatusLabel(String text1, String text2, String text3, String text4, String text5) {
        L1.setText(text1);
        L2.setText(text2);
        L3.setText(text3);
        L4.setText(text4);
        L5.setText(text5);
    }
    @FXML
    private void checkCondition() {

        hii.setDisable(true);

        switch (order.getStatus()) {
            case "Order_Placed":
                updateStatusLabel("Done", "In Progress", "In Progress", "In Progress", "Thank You!");
                hii.setDisable(false);
                break;
            case "Packed":
                updateStatusLabel("Done", "Done", "In Progress", "In Progress", "Thank You!");
                hii.setDisable(false);
                break;
            case "Dispatch":
                updateStatusLabel("Done", "Done", "Done", "In Progress", "Thank You!");
                hii.setDisable(false);
                break;
            case "Delivered":
                updateStatusLabel("Done", "Done", "Done", "Done", "Thank You!");
                hii.setDisable(false);
                break;
            case "Cancelled":
                updateStatusLabel("", "", "", "", "Cancelled");
                break;
        }
    
    }
    @FXML
    private void initialize() {
        checkCondition();
    }
    
}
