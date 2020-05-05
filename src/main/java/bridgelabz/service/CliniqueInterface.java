package com.bridgelabz.service;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;

public interface CliniqueInterface {
    public void addDoctor(Doctor doctor, String filePath);

    public void addPatient(Patient patient, String filePath);
}

