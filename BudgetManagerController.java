package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.view.BudgetManagerView;
import javafx.scene.Parent;

public class BudgetManagerController {
    
    private BudgetManagerView view;
    
    public Parent getView() {
        this.view = new BudgetManagerView();
        Parent budgetManagerUINode = view.createView();
        attachEventHandlers();
        return budgetManagerUINode;
    }
    
    private void attachEventHandlers() {
        view.getGetTipsBtn().setOnAction(e -> provideTips());
    }
    
    private void provideTips() {
        try {
            double salary = Double.parseDouble(view.getSalaryField().getText());
            if (salary < 50000) {
                view.getTipsText().setText("With a salary under ₹50,000, focus on these tips:\n\n" +
                    "1. Prioritize essentials: diapers, formula, and health check-ups come first.\n" +
                    "2. Buy in bulk when on sale, especially for non-perishables like wipes.\n" +
                    "3. Look for second-hand baby gear like strollers and cribs; they are often in great condition.\n" +
                    "4. Explore government schemes for child welfare.");
            } else {
                view.getTipsText().setText("With a salary over ₹50,000, consider these strategies:\n\n" +
                    "1. Allocate a fixed percentage of your income to a 'Baby Fund' (15-20% is a good start).\n" +
                    "2. Start a long-term savings plan or investment for your child's education early.\n" +
                    "3. Invest in quality gear that will last longer or can be used for a second child.\n" +
                    "4. Consider health insurance for your baby to cover unforeseen medical expenses.");
            }
        } catch (NumberFormatException ex) {
            view.getTipsText().setText("Please enter a valid number for your salary.");
        }
    }
}