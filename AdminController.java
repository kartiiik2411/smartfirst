package com.thethinkers.smartfirst.controller;

import com.thethinkers.smartfirst.dao.UserDao;
import com.thethinkers.smartfirst.dao.UserDaoImpl;
import com.thethinkers.smartfirst.model.User;
import com.thethinkers.smartfirst.view.AdminView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AdminController {

    private AdminView view;

    private UserDao userDao = UserDaoImpl.getInstance();

    public Scene createScene() {
        this.view = new AdminView();
        Parent adminUINode = view.createView();
        populateUsers();
        return new Scene(adminUINode, 500, 500);
    }

    private void populateUsers() {
        ObservableList<String> userStrings = FXCollections.observableArrayList();
        
        
        for(User user : userDao.findAll()){
            userStrings.add(user.toString());
        }
        
        view.getUserListView().setItems(userStrings);
    }
}