// File: AuthenticationService.java

public class AuthenticationService {
    // ... [current Singleton setup and fields]

    public boolean signUp(String email, String password, String name, String phone, int age, String gender) {
        if (email.equals("admin@smartfirst.com")) {
            // Prevent admin sign-up via the parent sign-up form!
            return false;
        }
        // Only proceed if Firebase Auth registration is successful
        boolean firebaseSignup = FirebaseService.getInstance().signUpWithEmailAndPassword(email, password);
        if (firebaseSignup) {
            // Now save to your UserDao (Firestore)
            User user = new User(email, password, name, phone, age, gender);
            return UserDaoImpl.getInstance().addUser(user);
        } else {
            // Firebase sign-up failed; do not add to Firestore
            return false;
        }
    }

    public String login(String email, String password) {
        // For admin
        if (email.equals("admin@smartfirst.com") && password.equals("admin")) {
            return "ADMIN";
        }

        // Try Firebase Auth
        boolean success = FirebaseService.getInstance().signInWithEmailAndPassword(email, password);
        if (success) {
            User user = UserDaoImpl.getInstance().getUserByEmail(email);
            if (user != null) {
                SessionManager.getInstance().setCurrentUser(user);
                return "USER";
            }
        }
        // Return detailed message for the controller to show
        return "Invalid email or password. Please check your credentials.";
    }
}
