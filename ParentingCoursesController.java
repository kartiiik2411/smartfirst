package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.view.ParentingCoursesView;
import javafx.scene.Parent;

public class ParentingCoursesController {
    
    private ParentingCoursesView view;
    
    public Parent getView() {
        this.view = new ParentingCoursesView();
        Parent parentingCoursesUINode = view.createView();
        attachEventHandlers();
        return parentingCoursesUINode;
    }
    
    private void attachEventHandlers() {
        view.getUploadFileBtn().setOnAction(e -> 
            System.out.println("File Chooser for documents would open here.")
        );
        view.getUploadVideoBtn().setOnAction(e -> 
            System.out.println("File Chooser for videos would open here.")
        );
    }
}