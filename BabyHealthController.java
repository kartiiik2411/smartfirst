package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.view.BabyHealthView;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BabyHealthController {

    private BabyHealthView view;

    public Parent getView() {
        this.view = new BabyHealthView();
        Parent babyHealthUINode = view.createView();
        attachEventHandlers();
        return babyHealthUINode;
    }
    
    private void attachEventHandlers() {
        view.getGrowthTrackerBtn().setOnAction(e -> 
            view.getRoot().setCenter(new GrowthTrackerController().getView())
        );
        view.getVaccineAlertsBtn().setOnAction(e -> 
            showPlaceholder("Vaccination alerts coming soon!")
        );
        view.getRoutineLoggerBtn().setOnAction(e -> 
            showPlaceholder("Routine logger coming soon!")
        );
    }
    
    private void showPlaceholder(String message) {
        VBox placeholder = new VBox(new Label(message));
        placeholder.setAlignment(Pos.CENTER);
        view.getRoot().setCenter(placeholder);
    }
}