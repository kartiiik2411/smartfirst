package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.dao.BabyDao;
import com.thethinkers.smartfirst.dao.BabyDaoImpl;
import com.thethinkers.smartfirst.model.Baby;
import com.thethinkers.smartfirst.model.SessionManager;
import com.thethinkers.smartfirst.util.SceneManager;
import com.thethinkers.smartfirst.view.BabyInfoView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BabyInfoController {
    private BabyInfoView view;
    private BabyDao babyDao = BabyDaoImpl.getInstance();

    public Scene createScene() {
        this.view = new BabyInfoView();
        Parent babyInfoUINode = view.createView();
        attachEventHandlers();
        Scene scene = new Scene(babyInfoUINode, 900, 600);
        return scene;
    }

    private void attachEventHandlers() {
        view.getSaveButton().setOnAction(e -> handleSave());
    }

    private void handleSave() {
        try {
            String name = view.getBabyNameField().getText();
            double weight = Double.parseDouble(view.getWeightField().getText());
            double height = Double.parseDouble(view.getHeightField().getText());

            if (name.isEmpty() || view.getBirthDatePicker().getValue() == null || view.getGenderGroup().getSelectedToggle() == null) {
                view.getStatusText().setText("Please fill all fields.");
                return;
            }
            
            String gender = (String) view.getGenderGroup().getSelectedToggle().getUserData();
            
            Baby baby = new Baby(name, weight, height, view.getBirthDatePicker().getValue(), gender);
            String userEmail = SessionManager.getInstance().getCurrentUser().getEmail();
            
            babyDao.save(userEmail, baby);
            SessionManager.getInstance().setCurrentBaby(baby);

            showWelcomeAndProceed(baby);

        } catch (NumberFormatException e) {
            view.getStatusText().setText("Please enter valid numbers for weight and height.");
        }
    }

    private void showWelcomeAndProceed(Baby baby) {
        Stage welcomeStage = new Stage();
        Text welcomeText = new Text("Welcome, " + baby.getName() + "!");
        welcomeText.setFont(Font.font("Arial", 24));
        
        String congratsMessage = "Congratulations on your new journey!";
        if ("Boy".equals(baby.getGender())) {
            congratsMessage = "Congratulations on your handsome prince!";
        } else if ("Girl".equals(baby.getGender())) {
            congratsMessage = "Congratulations on your beautiful princess!";
        }
        
        Text congratsText = new Text(congratsMessage);
        congratsText.setFont(Font.font("Arial", 18));
        
        Button continueButton = new Button("Let's Get Started");
        continueButton.setStyle("-fx-background-color: #007AFF; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 12;");
        continueButton.setOnAction(e -> {
            welcomeStage.close();
            SceneManager.showMainDashboard();
        });

        VBox layout = new VBox(20, welcomeText, congratsText, continueButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        
        Scene scene = new Scene(layout, 450, 250);
        welcomeStage.setScene(scene);
        welcomeStage.setTitle("Welcome!");
        welcomeStage.show();
    }
}