package com.bridgelabz.service;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;

import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagementServiceImp implements CliniqueInterface {
    FileSystem fileSystem = new FileSystem();

    @Override
    public void addDoctor(Doctor doctor, String filePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readFile(filePath);
            readData.add(doctor);
            fileSystem.writeFile(readData, filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addPatient(Patient patient, String filePath) {
        try {
            ArrayList<Patient> fileData = fileSystem.readFile(filePath);
            fileData.add(patient);
            fileSystem.writeFile(fileData, filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
