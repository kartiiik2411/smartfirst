package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.view.GrowthTrackerView;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

public class GrowthTrackerController {
    
    private GrowthTrackerView view;
    
    public Parent getView() {
        this.view = new GrowthTrackerView();
        Parent growthTrackerUINode = view.createView();
        attachEventHandlers();
        return growthTrackerUINode;
    }
    
    private void attachEventHandlers() {
        view.getCalculateBtn().setOnAction(e -> handleCalculation());
        view.getWhoInfoBtn().setOnAction(e -> showWHOInfo());
    }
    
    private void handleCalculation() {
        try {
            double height = Double.parseDouble(view.getHeightField().getText());
            double weight = Double.parseDouble(view.getWeightField().getText());
            view.getResultText().setText(String.format("Updated - H: %.1f cm, W: %.1f kg. Always consult your pediatrician for accurate growth assessment.", height, weight));
        } catch (NumberFormatException ex) {
            view.getResultText().setText("Please enter valid numbers.");
        }
    }
    
    private void showWHOInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WHO Growth Standards");
        alert.setHeaderText("About WHO Child Growth Standards");
        alert.setContentText("This feature should plot your baby's growth on charts provided by the World Health Organization (WHO). These charts are the international standard for assessing a child's physical growth. Connecting to a live data source or API would provide percentile rankings.");
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(480, 240);
        alert.showAndWait();
    }
}