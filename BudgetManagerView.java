package com.thethinkers.smartfirst.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class BudgetManagerView {
    
    private TextField occupationField = new TextField();
    private TextField salaryField = new TextField();
    private Button getTipsBtn = new Button("Get Financial Tips");
    private Text tipsText = new Text();

    public Parent createView() {
        Label title = new Label("Smart Budget Planner");
        title.getStyleClass().add("label-title");

        occupationField.setPromptText("Your Occupation");
        salaryField.setPromptText("Monthly Salary (e.g., 60000)");

        tipsText.setWrappingWidth(500);
        TextFlow tipsFlow = new TextFlow(tipsText);

        VBox layout = new VBox(20, title, occupationField, salaryField, getTipsBtn, tipsFlow);
        layout.setPadding(new Insets(25));
        layout.setAlignment(Pos.CENTER);
        layout.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        
        getTipsBtn.getStyleClass().add("button-primary");

        return layout;
    }
    

    public TextField getSalaryField() { return salaryField; }
    public Button getGetTipsBtn() { return getTipsBtn; }
    public Text getTipsText() { return tipsText; }
}
