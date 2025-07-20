package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CommunityView {
    private VBox chatBox = new VBox(10);
    private TextField inputField = new TextField();
    private Button sendButton = new Button("Send");

    public Parent createView() {
        Label title = new Label("Community Help Hub (AI-Powered)");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");

        ScrollPane scrollPane = new ScrollPane(chatBox);
        scrollPane.setFitToWidth(true);
        scrollPane.vvalueProperty().bind(chatBox.heightProperty()); 
        
        chatBox.setPadding(new Insets(10));
        chatBox.getChildren().add(createBotMessage("Hello! I am your AI-powered parenting assistant. How can I help you today? Ask me about colic, teething, or sleep schedules!"));

        inputField.setPromptText("Ask a question...");
        inputField.setStyle("-fx-font-size: 14px; -fx-pref-width: 300px; -fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #CCCCCC; -fx-padding: 10;");
        
        sendButton.setStyle("-fx-background-color: #007AFF; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 10 15;");

        HBox inputBox = new HBox(10, inputField, sendButton);
        HBox.setHgrow(inputField, Priority.ALWAYS);
        inputBox.setAlignment(Pos.CENTER);
        
        VBox layout = new VBox(20, title, scrollPane, inputBox);
        layout.setPadding(new Insets(25));
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        return layout;
    }

    public HBox createBotMessage(String message) {
        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: #E5E5EA; -fx-background-radius: 15; -fx-padding: 10 15;");
        text.setStyle("-fx-fill: black;");
        HBox hbox = new HBox(textFlow);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }

    public HBox createUserMessage(String message) {
        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: #007AFF; -fx-background-radius: 15; -fx-padding: 10 15;");
        text.setStyle("-fx-fill: white;");
        HBox hbox = new HBox(textFlow);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        return hbox;
    }
    
    public VBox getChatBox() { return chatBox; }
    public TextField getInputField() { return inputField; }
    public Button getSendButton() { return sendButton; }
}