import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.KeyEvent;
import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter;

public class PaymentController {

    @FXML
    private AnchorPane Data;

    @FXML
    private AnchorPane Main;

    @FXML
    private Button backBtn;

    @FXML
    private PasswordField cvv;

    @FXML
    private ChoiceBox<String> monthChoiceBox;

    @FXML
    private TextField name;

    @FXML
    private Button nextBtn;

    @FXML
    private TextField number;

    @FXML
    private ChoiceBox<String> yearChoiceBox;

    @FXML
    public void initialize() {
        // Add values to the month and year ChoiceBoxes

        // Populate month choice box with formatted strings for months (01 to 12)
        for (int i = 1; i <= 12; i++) {
            String month = String.format("%02d", i); // Format month to have leading zero if necessary
            monthChoiceBox.getItems().add(month);
        }

        // Populate year choice box with formatted strings for years (01 to 99)
        for (int i = 24; i <= 99; i++) {
            String year = String.format("%02d", i); // Format year to have leading zero if necessary
            yearChoiceBox.getItems().add(year);
        }

        // Add event filter to the CVV field to restrict input to maximum 3 characters
        cvv.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (cvv.getText().length() >= 3) {
                event.consume();
            }
        });
        
        // Allow only letters for Cardholder's name
        UnaryOperator<TextFormatter.Change> nameFilter = change -> {
            if (change.getText().matches("[a-zA-Z]+")) {
                return change;
            }
            return null;
        };
        name.setTextFormatter(new TextFormatter<>(nameFilter));

        // Allow only numbers and limit Card Number to maximum 16 characters
        number.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                number.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 16) {
                number.setText(newValue.substring(0, 16));
            }
        });
    }
}
