package bridgelabz.service;

import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;

public interface CliniqueInterface {
    public void addDoctor(Doctor doctor, String filePath);

    public void addPatient(Patient patient, String filePath);

    boolean searchDoctorByName(String doctorName, String filePath);

    public boolean searchDoctorById(int doctorId, String doctorfilePath);

    boolean findDoctorSpecialization(String doctorSpecialist, String doctorFilePath);

    public boolean searchDoctorByAvailability(String doctorAvailability, String doctorfilePath);
}
