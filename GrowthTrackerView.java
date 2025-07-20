package com.thethinkers.smartfirst.view;

import com.thethinkers.smartfirst.model.Baby;
import com.thethinkers.smartfirst.model.SessionManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GrowthTrackerView {
    
    private TextField heightField;
    private TextField weightField;
    private Button calculateBtn = new Button("Check Growth");
    private Button whoInfoBtn = new Button("WHO Guidelines Info");
    private Text resultText = new Text();
    
    public Parent createView() {
        Baby currentBaby = SessionManager.getInstance().getCurrentBaby();

        heightField = new TextField(String.valueOf(currentBaby.getHeightCm()));
        weightField = new TextField(String.valueOf(currentBaby.getWeightKg()));
        
        Label title = new Label("Growth Tracker");
        title.getStyleClass().add("label-subtitle");

        GridPane form = new GridPane();
        form.setVgap(10);
        form.setHgap(10);
        form.setAlignment(Pos.CENTER);
        
        form.add(new Label("Current Height (cm):"), 0, 0);
        form.add(heightField, 1, 0);
        form.add(new Label("Current Weight (kg):"), 0, 1);
        form.add(weightField, 1, 1);
        
        resultText.getStyleClass().add("text-result");
        
        VBox layout = new VBox(20, title, form, calculateBtn, whoInfoBtn, resultText);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        
        calculateBtn.getStyleClass().add("button-primary");
        whoInfoBtn.getStyleClass().add("button-secondary");

        return layout;
    }
    

    public TextField getHeightField() { return heightField; }
    public TextField getWeightField() { return weightField; }
    public Button getCalculateBtn() { return calculateBtn; }
    public Button getWhoInfoBtn() { return whoInfoBtn; }
    public Text getResultText() { return resultText; }
}
