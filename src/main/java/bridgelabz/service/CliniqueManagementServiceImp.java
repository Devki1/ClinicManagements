package bridgelabz.service;

import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;

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


    @Override
    public boolean searchDoctorByName(String doctorName, String filePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readFileDoctor(filePath);
            for (Doctor doctorData : readData) {
                if (doctorData.getName().equals(doctorName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean searchDoctorById(int doctorId, String doctorfilePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readFileDoctor(doctorfilePath);
            for (Doctor doctor : readData) {
                if (doctor.getId() == doctorId) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean findDoctorSpecialization(String doctorSpecialist, String doctorFilePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readFileDoctor(doctorFilePath);
            for (Doctor doctor : readData) {
                if (doctor.getSpecialization().equals(doctorSpecialist)) {
                    return true;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean searchDoctorByAvailability(String doctorAvailability, String doctorfilePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readFileDoctor(doctorfilePath);
            for (Doctor doctorsData : readData) {
                if (doctorsData.getAvailability().equals(doctorAvailability)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean searchPatientByName(String patientName, String patientFilePath) {
        try {
            ArrayList<Patient> readData = fileSystem.readPatientFile(patientFilePath);
            for (Patient patientData : readData) {
                if (patientData.getName().equals(patientName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean searchPatientById(int patientId, String patientFilePath) {
        try {
            ArrayList<Patient> readData = fileSystem.readPatientFile(patientFilePath);
            for (Patient patientData : readData) {
                if (patientData.getId() == patientId) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}