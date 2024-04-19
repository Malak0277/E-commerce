package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
        // todo: go back to login page
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
            signupmessageLabel.setText("Please fill in all fields.");
            return; 
        }

        // Check if password and confirmPassword are equal
        if (password.equals(confirmPassword)) {
            signupmessageLabel.setText("Password and Confirm Password should not be equal.");
            return;
        }

        // todo: check that username doesn't already exist in the database

        User user = new User();
        user.CreateAccount(firstName, lastName, username, password);

        // todo: add to database

        // todo: go to homepage
    }

    @FXML
    public void initialize() {
        signupFrameButton.setOnAction(event -> signupFrameButtonOnAction(event));
        GobackButton.setOnAction(event -> GobackButtonOnAction(event));
    }

}
