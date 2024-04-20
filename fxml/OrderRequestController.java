import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderRequestController {

    @FXML
    private AnchorPane Data;

    @FXML
    private AnchorPane Main;

    @FXML
    private TextField address;

    @FXML
    private Button backBtn;

    @FXML
    private RadioButton existingRadioBox;

    @FXML
    private ChoiceBox<String> methodChoiceBox;
    
    @FXML
    private RadioButton newRadioBox;

    @FXML
    private Button nextBtn;

    @FXML
    private TextField phoneNo;

    @FXML
    private ToggleGroup visaSelection;

    @FXML
    private Label MessageLabel;

    @FXML
    void nextBtnOnAction(ActionEvent event, String selectedOption, String selectedRadio) {
        String ad = address.getText();
        String phoneNumber = phoneNo.getText();
        
        // Allow only numbers and limit Card Number to maximum 16 characters
        phoneNo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                phoneNo.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 11) {
                phoneNo.setText(oldValue); // Restore the previous value if it exceeds 11 characters
            }
        });

        // Check if any of the text fields are empty
        if (ad.isEmpty() || phoneNumber.isEmpty()) {
            MessageLabel.setText("Please fill in all fields");
            return; 
        }

        if(phoneNumber.length() < 11){ // Corrected method to get text length
            MessageLabel.setText("Phone number too short");
            return;
        }

         /* todo:
         on clicking "order now" in cart:
         Order o = new Order(, , ,);
         Order.currrentOrder = o;
         Order.currrentOrder.orderRequest(ad, phoneNumber);
        */

        if (selectedOption.equals("Cash")) {
            //Order.SelectedOrder = new Order();
            navigateTo(event, "Omangment.fxml");
        }
        else {
            if(selectedRadio.equals("Existing Visa")){
                User currentUser = User.getCurrentUser();
                if (currentUser.get_visas().isEmpty()){
                    MessageLabel.setText("You have no existing visas");
                    return;
                }
                navigateTo(event, "paymentExistingCard.fxml");

            }
            else{
                navigateTo(event, "payment.fxml");
            }
        }
    }

    @FXML
    void backBtnOnAction(ActionEvent event)  {
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

    
    @FXML
    public void initialize() { 

        methodChoiceBox.getItems().addAll("Visa", "Cash");
        methodChoiceBox.getSelectionModel().selectFirst();
    
        // Add event listener to the ChoiceBox
        methodChoiceBox.setOnAction(event -> {
            String selectedOption = methodChoiceBox.getValue();
            if (selectedOption.equals("Cash")) {
                existingRadioBox.setVisible(false);
                newRadioBox.setVisible(false);
            } else {
                existingRadioBox.setVisible(true);
                newRadioBox.setVisible(true);
            }
        });

        nextBtn.setOnAction(event -> {
            String selectedOption = methodChoiceBox.getValue();
            String selectedRadio = ((RadioButton) visaSelection.getSelectedToggle()).getText();
            nextBtnOnAction(event, selectedOption, selectedRadio);
        });

        backBtn.setOnAction(event -> backBtnOnAction(event));
    }

}
