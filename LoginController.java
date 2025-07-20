// File: LoginController.java

// Inside initialize() or as your actual login button action:

loginButton.setOnAction(event -> {
    String email = emailField.getText();
    String password = passwordField.getText();

    if (email.isEmpty() || password.isEmpty()) {
        statusLabel.setText("Both fields required.");
        return;
    }

    // Optionally clear previous status
    statusLabel.setText("");

    // This could be run in a background Task for UI responsiveness
    String result = AuthenticationService.getInstance().login(email, password);

    if ("ADMIN".equals(result)) {
        // Route to admin dashboard
        SceneManager.getInstance().showAdminDashboard();
    } else if ("USER".equals(result)) {
        // Route to user dashboard
        SceneManager.getInstance().showMainDashboard();
    } else {
        // result is an error message
        statusLabel.setText(result);
    }
});
