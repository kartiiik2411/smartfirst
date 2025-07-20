package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BabyHealthView {
    
    private BorderPane view;
    private Button growthTrackerBtn = new Button("Growth Tracker");
    private Button vaccineAlertsBtn = new Button("Vaccination & Medication Alerts");
    private Button routineLoggerBtn = new Button("Routine Logger");
    
    public Parent createView() {
        view = new BorderPane();
        view.setPadding(new Insets(25));
        
        Label title = new Label("Baby Health & Routine Care");
        title.getStyleClass().add("label-title");
        BorderPane.setAlignment(title, Pos.TOP_CENTER);
        view.setTop(title);
        
        VBox options = new VBox(15);
        options.setAlignment(Pos.CENTER);
        
        styleOptionButton(growthTrackerBtn);
        styleOptionButton(vaccineAlertsBtn);
        styleOptionButton(routineLoggerBtn);

        options.getChildren().addAll(growthTrackerBtn, vaccineAlertsBtn, routineLoggerBtn);
        
        view.setCenter(options);
        view.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        
        return view;
    }
    
    private void styleOptionButton(Button button) {
        button.getStyleClass().add("button-secondary");
        button.setPrefWidth(300);
    }
    

    public BorderPane getRoot() { return view; }
    public Button getGrowthTrackerBtn() { return growthTrackerBtn; }
    public Button getVaccineAlertsBtn() { return vaccineAlertsBtn; }
    public Button getRoutineLoggerBtn() { return routineLoggerBtn; }
}