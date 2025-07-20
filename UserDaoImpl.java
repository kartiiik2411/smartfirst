package com.thethinkers.smartfirst.dao;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.thethinkers.smartfirst.model.User;
import com.thethinkers.smartfirst.services.FirebaseService;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance;
    private final Firestore db = FirebaseService.getDb();

    private UserDaoImpl() {}

    public static synchronized UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public void save(User user) {
        // We use the email as the document ID for easy lookup
        db.collection("users").document(user.getEmail()).set(user);
        System.out.println("User saved to Firestore: " + user.getEmail());
    }

    @Override
    public User findByEmail(String email) {
        try {
            DocumentSnapshot document = db.collection("users").document(email).get().get();
            if (document.exists()) {
                return document.toObject(User.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            return db.collection("users").get().get().getDocuments()
                .stream()
                .map(doc -> doc.toObject(User.class))
                .collect(Collectors.toList());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean userExists(String email) {
        return findByEmail(email) != null;
    }
}