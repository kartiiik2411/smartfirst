package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.model.SessionManager;
import com.thethinkers.smartfirst.util.SceneManager;
import com.thethinkers.smartfirst.view.MainDashboardView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

public class MainDashboardController {
    
    private MainDashboardView view;

    public Scene createScene() {
        this.view = new MainDashboardView();
        Parent dashboardUINode = view.createView();
        attachEventHandlers();
        
        Scene scene = new Scene(dashboardUINode, 1000, 700);
        return scene;
    }
    
    private void attachEventHandlers() {
        // Sidebar navigation
        view.getHomeBtn().setOnAction(e -> handleHomeNavigation());
        view.getCommunityBtn().setOnAction(e -> setCenterView(new CommunityController().getView()));
        view.getCoursesBtn().setOnAction(e -> setCenterView(new ParentingCoursesController().getView()));
        view.getMilestonesBtn().setOnAction(e -> setCenterView(createPlaceholderPage("Milestones", "Track and celebrate every achievement.")));

        // Logout
        view.getLogoutButton().setOnAction(e -> {
            SessionManager.getInstance().clearSession();
            SceneManager.showLoginScene();
        });
        
        // Initial Home View Card Buttons
        attachHomeCardEventHandlers();
    }
    
    private void attachHomeCardEventHandlers() {
        view.getBabyHealthBtn().setOnAction(e -> setCenterView(new BabyHealthController().getView()));
        view.getBudgetPlannerBtn().setOnAction(e -> setCenterView(new BudgetManagerController().getView()));
        view.getFamilyCareBtn().setOnAction(e -> setCenterView(createPlaceholderPage("Family & Caregivers", "Feature coming soon!")));
        view.getFuturePlanBtn().setOnAction(e -> setCenterView(createPlaceholderPage("Future Planning", "Feature coming soon!")));
    }
    
    private void handleHomeNavigation() {
        // Re-create the home view and re-attach handlers
        Node homeView = view.createHomeView();
        setCenterView(homeView);
        attachHomeCardEventHandlers();
    }

    private void setCenterView(Node node) {
        view.getRoot().setCenter(node);
    }
    
    private VBox createPlaceholderPage(String title, String content) {
        VBox page = new VBox(20);
        page.setPadding(new Insets(25));
        page.setAlignment(Pos.CENTER);
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");
        Label contentLabel = new Label(content);
        contentLabel.setStyle("-fx-font-size: 16px;");
        page.getChildren().addAll(titleLabel, contentLabel);
        return page;
    }
}