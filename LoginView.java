package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class LoginView {
    private TextField emailField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Button signupButton = new Button("Create Account");
    private Text statusText = new Text();

    public Parent createView() {
        ImageView logoView = new ImageView(new Image(getClass().getResource("/assets/images/logo.jpeg").toExternalForm()));
        emailField.setPromptText("Email");
        passwordField.setPromptText("Password");
        statusText.setFill(Color.RED);
        
        logoView.setFitWidth(120);
        logoView.setFitHeight(120);
        Circle clip = new Circle(60, 60, 60);
        logoView.setClip(clip);
        logoView.setEffect(new DropShadow(10, Color.gray(0, 0.5)));

        emailField.setStyle("-fx-font-size: 14px; -fx-pref-width: 300px; -fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #CCCCCC; -fx-padding: 10;");
        passwordField.setStyle("-fx-font-size: 14px; -fx-pref-width: 300px; -fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #CCCCCC; -fx-padding: 10;");
        
        loginButton.setStyle("-fx-background-color: #007AFF; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 8; -fx-pref-width: 300px; -fx-padding: 12;");
        signupButton.setStyle("-fx-background-color: #E5E5EA; -fx-text-fill: #333333; -fx-font-size: 14px; -fx-background-radius: 8; -fx-pref-width: 300px; -fx-padding: 12;");
        
        VBox form = new VBox(20, logoView, emailField, passwordField, loginButton, signupButton, statusText);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(40));
        form.setMaxWidth(400);
        form.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 20, 0, 0, 5);");

        StackPane root = new StackPane(form);
        root.setStyle("-fx-background-color: #F4F7F9;");
        return root;
    }

    public TextField getEmailField() { return emailField; }
    public PasswordField getPasswordField() { return passwordField; }
    public Button getLoginButton() { return loginButton; }
    public Button getSignupButton() { return signupButton; }
    public Text getStatusText() { return statusText; }
}