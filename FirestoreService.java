// package com.thethinkers.smartfirst.services;

// import com.thethinkers.smartfirst.model.Baby;
// import com.thethinkers.smartfirst.model.User;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class FirestoreService {
//     private static FirestoreService instance;
//     private final Map<String, User> users = new HashMap<>();
//     private final Map<String, Baby> babies = new HashMap<>(); 

//     private FirestoreService() {
//         users.put("smartfirst", new User("abc", "xyz", "smarst@user.com", 30, "smartfirst123"));
//     }

//     public static FirestoreService getInstance() {
//         if (instance == null) {
//             instance = new FirestoreService();
//         }
//         return instance;
//     }

//     public boolean saveUser(User user) {
//         if (users.containsKey(user.getEmail())) {
//             return false; 
//         }
//         users.put(user.getEmail(), user);
//         System.out.println("User saved (simulated): " + user);
//         return true;
//     }

//     public User getUser(String email) {
//         return users.get(email);
//     }

//     public boolean saveBaby(String userEmail, Baby baby) {
//         babies.put(userEmail, baby);
//         System.out.println("Baby data saved for " + userEmail + " (simulated): " + baby.getName());
//         return true;
//     }

//     public Baby getBaby(String userEmail) {
//         return babies.get(userEmail);
//     }
    

//     public List<User> getAllUsers() {
//         return new ArrayList<>(users.values());
//     }
// }