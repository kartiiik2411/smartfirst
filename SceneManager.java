package com.thethinkers.smartfirst.util;

import com.thethinkers.smartfirst.controller.*;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneManager {

    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("SmartFirst");
    }
    
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void showSplashScreen() {
        ImageView logo = new ImageView(new Image(SceneManager.class.getResource("/assets/images/logo.jpeg").toExternalForm()));
        logo.setFitWidth(150);
        logo.setPreserveRatio(true);

        Text tagline = new Text("First kick to First Word !!.... Everything matters");
        tagline.setStyle("-fx-font-family: 'Quicksand'; -fx-font-size: 22px; -fx-fill: #4A4A4A;");

        VBox root = new VBox(30, logo, tagline);
        root.setStyle("-fx-background-color: #FDFDFD;");
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> showLoginScene());
        delay.play();
    }
    
    public static void showLoginScene() {
        LoginController loginController = new LoginController();
        primaryStage.setScene(loginController.createScene());
        primaryStage.setTitle("SmartFirst - Login");
    }

    public static void showSignUpScene() {
        SignUpController signUpController = new SignUpController();
        primaryStage.setScene(signUpController.createScene());
        primaryStage.setTitle("SmartFirst - Sign Up");
    }
    
    public static void showBabyInfoScene() {
        BabyInfoController babyInfoController = new BabyInfoController();
        primaryStage.setScene(babyInfoController.createScene());
        primaryStage.setTitle("SmartFirst - Baby's Information");
    }

    public static void showMainDashboard() {
        MainDashboardController dashboardController = new MainDashboardController();
        primaryStage.setScene(dashboardController.createScene());
        primaryStage.setTitle("SmartFirst - Dashboard");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        primaryStage.centerOnScreen();
    }
    
    public static void showAdminDashboard() {
        AdminController adminController = new AdminController();
        Stage adminStage = new Stage();
        adminStage.setTitle("SmartFirst - Admin Panel");
        adminStage.setScene(adminController.createScene());
        adminStage.setWidth(500);
        adminStage.setHeight(500);
        adminStage.show();
    }
}