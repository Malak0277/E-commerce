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

public class SignupController {

    @FXML
    private Button GobackButton;

    @FXML
    private AnchorPane SignupPane;

    @FXML
    private PasswordField confirmPassTF;

    @FXML
    private TextField firstnameTF;

    @FXML
    private TextField lastnameTF;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label passwordMatchLabel;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private Button signupFrameButton;

    @FXML
    private Label signupmessageLabel;

    @FXML
    private TextField usernameTF;

    @FXML
    void GobackButtonOnAction(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("login.fxml"));
            root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();}
        catch (IOException e) {}
    }

    @FXML
    void signupFrameButtonOnAction(ActionEvent event) {
        String firstName = firstnameTF.getText();
        String lastName = lastnameTF.getText();
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String confirmPassword = confirmPassTF.getText();

        // Check if any of the text fields are empty
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            signupmessageLabel.setText("Please fill in all fields");
            return;
        }

        // Check if password and confirmPassword are equal
        if (!password.equals(confirmPassword)) {
            signupmessageLabel.setText("Passwords don't match");
            return;
        }

        User user = new User();
        if(!user.signup(username)){
            signupmessageLabel.setText("Username already exists");
            return;
        }

        user.CreateAccount(firstName, lastName, username, password);

        // todo: go to homepage
    }

    @FXML
    public void initialize() {
        signupFrameButton.setOnAction(event -> signupFrameButtonOnAction(event));
        GobackButton.setOnAction(event -> GobackButtonOnAction(event));
    }

}