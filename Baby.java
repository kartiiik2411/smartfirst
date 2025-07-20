package com.thethinkers.smartfirst.model;

import java.time.LocalDate;

public class Baby {
    private String name;
    private double weightKg;
    private double heightCm;
    private LocalDate dateOfBirth;
    private String gender;

    public Baby(String name, double weightKg, double heightCm, LocalDate dateOfBirth, String gender) {
        this.name = name;
        this.weightKg = weightKg;
        this.heightCm = heightCm;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getName() { return name; }
    public double getWeightKg() { return weightKg; }
    public double getHeightCm() { return heightCm; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getGender() { return gender; }
}