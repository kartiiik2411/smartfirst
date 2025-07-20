package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BabyInfoView {
    private TextField babyNameField = new TextField();
    private TextField weightField = new TextField();
    private TextField heightField = new TextField();
    private DatePicker birthDatePicker = new DatePicker();
    private ToggleGroup genderGroup = new ToggleGroup();
    private Button saveButton = new Button("Save and Continue");
    private Text statusText = new Text();

    public Parent createView() {
        Label title = new Label("Tell Us About Your Baby");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        babyNameField.setPromptText("Baby's Name");
        weightField.setPromptText("Weight (kg)");
        heightField.setPromptText("Height (cm)");
        birthDatePicker.setPromptText("Date of Birth");
        statusText.setFill(Color.RED);

        RadioButton boyRadio = new RadioButton("Boy");
        boyRadio.setToggleGroup(genderGroup);
        boyRadio.setUserData("Boy");
        RadioButton girlRadio = new RadioButton("Girl");
        girlRadio.setToggleGroup(genderGroup);
        girlRadio.setUserData("Girl");
        HBox genderBox = new HBox(10, new Label("Gender:"), boyRadio, girlRadio);
        genderBox.setAlignment(Pos.CENTER_LEFT);

        String textFieldStyle = "-fx-font-size: 14px; -fx-pref-width: 300px; -fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #CCCCCC; -fx-padding: 10;";
        babyNameField.setStyle(textFieldStyle);
        weightField.setStyle(textFieldStyle);
        heightField.setStyle(textFieldStyle);
        birthDatePicker.setStyle(textFieldStyle);
        saveButton.setStyle("-fx-background-color: #007AFF; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 8; -fx-pref-width: 300px; -fx-padding: 12;");

        VBox form = new VBox(20, title, babyNameField, weightField, heightField, birthDatePicker, genderBox, saveButton, statusText);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(40));
        form.setMaxWidth(450);
        form.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 20, 0, 0, 5);");

        StackPane root = new StackPane(form);
        root.setStyle("-fx-background-color: #F4F7F9;");
        return root;
    }

    public TextField getBabyNameField() { return babyNameField; }
    public TextField getWeightField() { return weightField; }
    public TextField getHeightField() { return heightField; }
    public DatePicker getBirthDatePicker() { return birthDatePicker; }
    public ToggleGroup getGenderGroup() { return genderGroup; }
    public Button getSaveButton() { return saveButton; }
    public Text getStatusText() { return statusText; }
}