package com.thethinkers.smartfirst.model;

public class SessionManager {
    private static SessionManager instance;
    private User currentUser;
    private Baby currentBaby;

    private SessionManager() {}

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User getCurrentUser() { return currentUser; }
    public void setCurrentUser(User currentUser) { this.currentUser = currentUser; }
    public Baby getCurrentBaby() { return currentBaby; }
    public void setCurrentBaby(Baby currentBaby) { this.currentBaby = currentBaby; }
    
    public void clearSession() {
        this.currentUser = null;
        this.currentBaby = null;
    }
}