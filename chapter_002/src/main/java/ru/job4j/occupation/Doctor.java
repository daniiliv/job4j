package ru.job4j.occupation;

public class Doctor extends Occupation {
    public Diagnosis cure(Patient patient) {
        return new Diagnosis();
    }
}
