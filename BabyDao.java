package com.thethinkers.smartfirst.dao;

import com.thethinkers.smartfirst.model.Baby;

public interface BabyDao {
    void save(String userEmail, Baby baby);
    Baby findByUserEmail(String userEmail);
}