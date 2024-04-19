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
    void nextBtnOnAction(ActionEvent event, String selectedOption, String selectedRadio) {
        if ("Cash".equals(selectedOption)) {
            // todo: go to OManagement
        } else {
            if("Existing Visa".equals(selectedRadio)){
            // todo: go to paymentExistingCard
        }
        else{
            // todo: go to payment
        }
        }
    }

    @FXML
    void backBtnOnAction(ActionEvent event, String selectedOption) {
        // todo: go to homepage
    }

    
    @FXML
    public void initialize() {
        methodChoiceBox.getItems().addAll("Cash", "Visa");
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
            nextBtnnOnAction(event, selectedOption, selectedRadio);
        });
        nbackBtn.setOnAction(event -> backBtnOnAction(event));
    }

}
