package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class AdminView {

    private ListView<String> userListView = new ListView<>();

    public Parent createView() {
        Label title = new Label("Admin Panel - All Users");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        VBox layout = new VBox(10, title, userListView);
        layout.setPadding(new Insets(15));
        
        return layout;
    }
    

    public ListView<String> getUserListView() {
        return userListView;
    }
}