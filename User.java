package com.thethinkers.smartfirst.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String password;

    public User(String firstName, String lastName, String email, int age, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }

    public String getEmail() { 
        return email; 
    }

    public int getAge() { 
        return age; 
    }

    public String getPassword() { 
        return password; 
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, Email: %s, Age: %d", firstName, lastName, email, age);
    }
}