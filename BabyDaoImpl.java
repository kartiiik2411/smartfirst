package com.thethinkers.smartfirst.dao;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.thethinkers.smartfirst.model.Baby;
import com.thethinkers.smartfirst.services.FirebaseService;

import java.util.concurrent.ExecutionException;

public class BabyDaoImpl implements BabyDao {
    private static BabyDaoImpl instance;
    private final Firestore db = FirebaseService.getDb();

    private BabyDaoImpl() {}

    public static synchronized BabyDaoImpl getInstance() {
        if (instance == null) {
            instance = new BabyDaoImpl();
        }
        return instance;
    }

    @Override
    public void save(String userEmail, Baby baby) {
        // We save the baby info in a "babies" collection, using the parent's email as the ID
        db.collection("babies").document(userEmail).set(baby);
        System.out.println("Baby data saved to Firestore for user: " + userEmail);
    }

    @Override
    public Baby findByUserEmail(String userEmail) {
        try {
            DocumentSnapshot document = db.collection("babies").document(userEmail).get().get();
            if (document.exists()) {
                return document.toObject(Baby.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}