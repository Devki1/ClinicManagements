package bridgelabz.service;

import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;

public interface CliniqueInterface {
    public void addDoctor(Doctor doctor, String filePath);

    public void addPatient(Patient patient, String filePath);

    boolean searchDoctorByName(String doctorName, String filePath);
}

