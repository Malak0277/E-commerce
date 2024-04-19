package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignupController {

    @FXML
    private AnchorPane SignupPane;

    @FXML
    private TextField firstnameTF;

    @FXML
    private TextField lastnameTF;

    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private PasswordField confirmPassTF;

    @FXML
    private Button signupFrameButton;

    @FXML
    private Button GobackButton;

    @FXML
    private Label passwordMatchLabel;

    @FXML
    private Label signupmessageLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    void GobackButtonOnAction(ActionEvent event) {

    }

    @FXML
    void signupFrameButtonOnAction(ActionEvent event) {

    }

}
