import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
        UsernameTF.setText("");
        PasswordTF.setText("");
        LoginMessageLabel.setText("");
    }

    @FXML
    void LoginButtonOnAction(ActionEvent event) {
        String username = UsernameTF.getText();
        String password = PasswordTF.getText();

        // Check if any of the text fields are empty
        if (username.isEmpty() || password.isEmpty()) {
            LoginMessageLabel.setText("Please fill in all fields");
            return;
        }

        User user = new User();
        if(user.login(username, password)){
            navigateTo(event, "Catalog.fxml");
        } else {
            LoginMessageLabel.setText("Wrong username or password");
        }
    }

    @FXML
    void SignupButtonOnAction(ActionEvent event) {
        navigateTo(event, "Signup.fxml");
    }

    @FXML
    public void initialize() {
        LoginButton.setOnAction(event -> LoginButtonOnAction(event));
        CancelButton.setOnAction(event -> CancelButtonOnAction(event));
    }

    public void navigateTo(ActionEvent event, String nextPageFXML) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource(nextPageFXML));
            root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {}
    }
}
