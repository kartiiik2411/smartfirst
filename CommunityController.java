package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.view.CommunityView;
import javafx.scene.Parent;

public class CommunityController {
    
    private CommunityView view;

    public Parent getView() {
        this.view = new CommunityView();
        Parent communityUINode = view.createView();
        attachEventHandlers();
        return communityUINode;
    }

    private void attachEventHandlers() {
        view.getSendButton().setOnAction(e -> handleSend());
        view.getInputField().setOnAction(e -> handleSend());
    }
    
    private void handleSend() {
        String query = view.getInputField().getText().trim().toLowerCase();
        if(query.isEmpty()) return;
        
        view.getChatBox().getChildren().add(view.createUserMessage(query));
        view.getInputField().clear();

        // ** SIMULATED AI RESPONSE **
        String response = getAIResponse(query);
        view.getChatBox().getChildren().add(view.createBotMessage(response));
    }

    private String getAIResponse(String query) {
        if (query.contains("colic")) {
            return "Colic can be tough. Try the '5 S's': Swaddling, Side/Stomach position, Shushing, Swinging, and Sucking. If symptoms persist, it's always best to consult your pediatrician.";
        } else if (query.contains("teething")) {
            return "Teething symptoms include drooling, fussiness, and a tendency to chew on things. You can offer a cold (not frozen) teething ring or a clean, wet washcloth. Gently rubbing their gums can also provide relief.";
        } else if (query.contains("sleep")) {
            return "For sleep schedules, establishing a consistent bedtime routine is key. A warm bath, a quiet story, and a dim room can signal that it's time to sleep. For a 6-month-old, about 14 hours of sleep in a 24-hour period is typical.";
        } else {
            return "I'm designed to help with common parenting questions. Could you please rephrase? You can ask about topics like feeding, teething, or baby development.";
        }
    }
}