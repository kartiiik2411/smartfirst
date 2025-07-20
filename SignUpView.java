package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SignUpView {
    private TextField fnameField = new TextField();
    private TextField lnameField = new TextField();
    private TextField emailField = new TextField();
    private TextField ageField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private PasswordField confirmPasswordField = new PasswordField();
    private Button signupButton = new Button("Sign Up");
    private Button backButton = new Button("Back to Login");
    private Text statusText = new Text();

    public Parent createView() {
        fnameField.setPromptText("First Name");
        lnameField.setPromptText("Last Name");
        emailField.setPromptText("Email");
        ageField.setPromptText("Your Age");
        passwordField.setPromptText("Create Password");
        confirmPasswordField.setPromptText("Confirm Password");
        statusText.setFill(Color.RED);

        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                ageField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        String textFieldStyle = "-fx-font-size: 14px; -fx-pref-width: 300px; -fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #CCCCCC; -fx-padding: 10;";
        fnameField.setStyle(textFieldStyle);
        lnameField.setStyle(textFieldStyle);
        emailField.setStyle(textFieldStyle);
        ageField.setStyle(textFieldStyle);
        passwordField.setStyle(textFieldStyle);
        confirmPasswordField.setStyle(textFieldStyle);

        signupButton.setStyle("-fx-background-color: #007AFF; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 8; -fx-pref-width: 300px; -fx-padding: 12;");
        backButton.setStyle("-fx-background-color: #E5E5EA; -fx-text-fill: #333333; -fx-font-size: 14px; -fx-background-radius: 8; -fx-pref-width: 300px; -fx-padding: 12;");

        VBox form = new VBox(15, new Label("Create New Account"),
            fnameField, lnameField, emailField, ageField,
            passwordField, confirmPasswordField,
            signupButton, backButton, statusText);
            
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(40));
        form.setMaxWidth(400);
        form.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 20, 0, 0, 5);");

        StackPane root = new StackPane(form);
        root.setStyle("-fx-background-color: #F4F7F9;");
        return root;
    }

    public TextField getFnameField() { return fnameField; }
    public TextField getLnameField() { return lnameField; }
    public TextField getEmailField() { return emailField; }
    public TextField getAgeField() { return ageField; }
    public PasswordField getPasswordField() { return passwordField; }
    public PasswordField getConfirmPasswordField() { return confirmPasswordField; }
    public Button getSignupButton() { return signupButton; }
    public Button getBackButton() { return backButton; }
    public Text getStatusText() { return statusText; }
}