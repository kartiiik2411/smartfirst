package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ParentingCoursesView {
    
    private Button uploadFileBtn = new Button("Upload a Document (Simulated)");
    private Button uploadVideoBtn = new Button("Upload a Video (Simulated)");

    public Parent createView() {
        Label quote = new Label("For the baby to grow well — with beauty, goodness, and a sharp mind.");
        quote.getStyleClass().add("label-quote");
        quote.setWrapText(true);

        Label info = new Label("This section will host expert videos and guides on parenting.");
        
        VBox layout = new VBox(25, quote, info, uploadFileBtn, uploadVideoBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));
        layout.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

        uploadFileBtn.getStyleClass().add("button-secondary");
        uploadVideoBtn.getStyleClass().add("button-secondary");

        return layout;
    }
    

    public Button getUploadFileBtn() { return uploadFileBtn; }
    public Button getUploadVideoBtn() { return uploadVideoBtn; }
}