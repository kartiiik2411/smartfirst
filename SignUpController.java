// File: SignUpController.java

// Inside the sign-up button handler:

signUpButton.setOnAction(e -> {
    // ... form validation ...
    boolean success = AuthenticationService.getInstance().signUp(
        emailField.getText(), passwordField.getText(), nameField.getText(),
        phoneField.getText(), Integer.parseInt(ageField.getText()), genderCombo.getValue()
    );

    if (success) {
        statusLabel.setText("Sign up successful! Please log in.");
    } else {
        statusLabel.setText("Sign up failed. Try a different email or check your details.");
    }
});
