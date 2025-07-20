package com.thethinkers.smartfirst.view;

import com.thethinkers.smartfirst.model.SessionManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

public class MainDashboardView {
    
    private BorderPane root;
    private Button homeBtn = new Button("Home");
    private Button communityBtn = new Button("Community");
    private Button coursesBtn = new Button("Parenting Courses");
    private Button milestonesBtn = new Button("Milestones");
    private Button logoutButton = new Button("Logout");
    
    private Button babyHealthBtn;
    private Button budgetPlannerBtn;
    private Button familyCareBtn;
    private Button futurePlanBtn;

    public Parent createView() {
        root = new BorderPane();
        root.setTop(createTopBar());
        root.setLeft(createSidebar());
        root.setCenter(createHomeView());
        root.setBottom(createEmergencyButton());
        return root;
    }

    private HBox createTopBar() {
        String babyName = SessionManager.getInstance().getCurrentBaby().getName();
        Label welcomeLabel = new Label("Welcome, " + babyName + "!");
        welcomeLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #333;");

        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        logoutButton.setStyle("-fx-background-color: #FF3B30; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 15;");

        HBox topBar = new HBox(20, welcomeLabel, spacer, logoutButton);
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(10, 20, 10, 20));
        topBar.setStyle("-fx-background-color: white; -fx-border-color: #E0E0E0; -fx-border-width: 0 0 1 0;");
        return topBar;
    }

    private VBox createSidebar() {
        sidebarBtnStyler(homeBtn);
        sidebarBtnStyler(communityBtn);
        sidebarBtnStyler(coursesBtn);
        sidebarBtnStyler(milestonesBtn);

        VBox sidebar = new VBox(10, homeBtn, communityBtn, coursesBtn, milestonesBtn);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: #F4F7F9; -fx-border-color: #E0E0E0; -fx-border-width: 0 1 0 0;");
        return sidebar;
    }

    public ScrollPane createHomeView() {
        GridPane cardGrid = new GridPane();
        cardGrid.setHgap(25);
        cardGrid.setVgap(25);
        cardGrid.setPadding(new Insets(25));
        cardGrid.setAlignment(Pos.CENTER);

        babyHealthBtn = createCardButton("Baby Health", "Track growth, vaccinations, feeding, and more.");
        budgetPlannerBtn = createCardButton("Budget Planner", "Manage income, track expenses, and forecast costs.");
        familyCareBtn = createCardButton("Family & Caregivers", "Sync routines and tasks with family members.");
        futurePlanBtn = createCardButton("Future Planning", "Guidance for the days and years ahead.");

        cardGrid.add(babyHealthBtn, 0, 0);
        cardGrid.add(budgetPlannerBtn, 1, 0);
        cardGrid.add(familyCareBtn, 0, 1);
        cardGrid.add(futurePlanBtn, 1, 1);
        
        ScrollPane scrollPane = new ScrollPane(cardGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        return scrollPane;
    }
    
    private StackPane createEmergencyButton() {
        Button sosButton = new Button("SOS");
        sosButton.setShape(new Circle(35));
        sosButton.setMinSize(70, 70);
        sosButton.setMaxSize(70, 70);
        sosButton.setStyle("-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;");
        
        StackPane bottomPane = new StackPane(sosButton);
        bottomPane.setPadding(new Insets(20));
        StackPane.setAlignment(sosButton, Pos.BOTTOM_RIGHT);
        return bottomPane;
    }

    private void sidebarBtnStyler(Button button) {
        button.setPrefWidth(180);
        button.setAlignment(Pos.CENTER_LEFT);
        button.setStyle("-fx-background-color: transparent; -fx-font-size: 16px; -fx-text-fill: #333; -fx-padding: 10 15;");
    }

    private Button createCardButton(String title, String description) {
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #007AFF;");
        Label descLabel = new Label(description);
        descLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #555;");
        descLabel.setWrapText(true);
        
        VBox content = new VBox(10, titleLabel, descLabel);
        content.setAlignment(Pos.TOP_LEFT);
        
        Button button = new Button();
        button.setGraphic(content);
        button.setStyle("-fx-min-height: 180px; -fx-pref-width: 280px; -fx-background-color: white; -fx-background-radius: 12; -fx-alignment: top-left; -fx-padding: 20; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");
        return button;
    }
    
    public BorderPane getRoot() { return root; }
    public Button getHomeBtn() { return homeBtn; }
    public Button getCommunityBtn() { return communityBtn; }
    public Button getCoursesBtn() { return coursesBtn; }
    public Button getMilestonesBtn() { return milestonesBtn; }
    public Button getLogoutButton() { return logoutButton; }
    public Button getBabyHealthBtn() { return babyHealthBtn; }
    public Button getBudgetPlannerBtn() { return budgetPlannerBtn; }
    public Button getFamilyCareBtn() { return familyCareBtn; }
    public Button getFuturePlanBtn() { return futurePlanBtn; }
}