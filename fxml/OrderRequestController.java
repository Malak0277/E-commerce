import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

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
        
        // Allow only numbers and limit Card Number to maximum 16 characters
        phoneNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                number.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() >= 11) {
                number.setText(newValue.substring(0, 16));
            }
        });

        // Check if any of the text fields are empty
        if (ad.isEmpty() || phoneNumber.isEmpty()) {
            MessageLabel.setText("Please fill in all fields");
            return; 
        }

        if(phoneNumber.length < 11){
            MessageLabel.setText("Phone number too short");
            return; 
        }

        Order o = new Order();
        o.orderRequest(ad, phoneNumber);

        if ("Cash".equals(selectedOption)) {
            Parent root;
            try {
                    FXMLLoader loader = new FXMLLoader (getClass().getResource("Omangement.fxml")); 
                    root = loader.load();
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();} 
            catch (IOException e) {}
        } else {
            if("Existing Visa".equals(selectedRadio)){
                Parent root;
                try {
                        FXMLLoader loader = new FXMLLoader (getClass().getResource("paymentExistingCard.fxml")); 
                        root = loader.load();
                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();} 
                catch (IOException e) {}
        }
        else{
            Parent root;
            try {
                    FXMLLoader loader = new FXMLLoader (getClass().getResource("payment.fxml")); 
                    root = loader.load();
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();} 
            catch (IOException e) {}
        }
        }
    }

    @FXML
    void backBtnOnAction(ActionEvent event, String selectedOption) {
        // todo: go to homepage
    }

    
    @FXML
    public void initialize() { 

        methodChoiceBox.getItems().addAll("Visa", "Cash");
        methodChoiceBox.getSelectionModel().selectFirst();
        String selectedOption = methodChoiceBox.getValue();
        String selectedRadio = ((RadioButton) visaSelection.getSelectedToggle()).getText();
    
        // Add event listener to the ChoiceBox
        methodChoiceBox.setOnAction(event -> {
            if ("Cash".equals(selectedOption)) {
                existingRadioBox.setVisible(false);
                newRadioBox.setVisible(false);
            } else {
                existingRadioBox.setVisible(true);
                newRadioBox.setVisible(true);
            }
        });

        nextBtn.setOnAction(event -> {
            nextBtnOnAction(event, selectedOption, selectedRadio);
        });

        backBtn.setOnAction(event -> backBtnOnAction(event));
    }

}
