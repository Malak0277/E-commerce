import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private Button CancelButton;

    @FXML
    private Button LoginButton;

    @FXML
    private Label LoginMessageLabel;

    @FXML
    private AnchorPane LoginPane;

    @FXML
    private PasswordField PasswordTF;

    @FXML
    private Button SignupButton;

    @FXML
    private TextField UsernameTF;

    @FXML
    void CancelButtonOnAction(ActionEvent event) {
        // todo: cancel it
    }

    @FXML
    void LoginButtonOnAction(ActionEvent event) {
        String username = UsernameTF.getText();
        String password = PasswordTF.getText();

        // todo: check if username exists in database
        // todo: check if password matches username's password in database
    }

    @FXML
    void SignupButtonOnAction(ActionEvent event) {
        // todo: go to sign up page
    }

    @FXML
    public void initialize() {
        LoginButton.setOnAction(event -> LoginButtonOnAction(event));
    }

}
