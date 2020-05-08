package bridgelabz.service;

import bridgelabz.model.Appointment;
import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;

import java.io.IOException;

public interface CliniqueInterface {
    public void addDoctor(Doctor doctor, String filePath);

    public void addPatient(Patient patient, String filePath);

    boolean searchDoctorByName(String doctorName, String filePath);

    public boolean searchDoctorById(int doctorId, String doctorfilePath);

    boolean findDoctorSpecialization(String doctorSpecialist, String doctorFilePath);

    public boolean searchDoctorByAvailability(String doctorAvailability, String doctorfilePath);

    public boolean searchPatientByName(String patientName, String patientFilePath);

    public boolean searchPatientById(int patientId, String patientfilePath);

    public boolean searchPatientByMobileNumber(Long patientMobileNumber, String patientFilePath);

    public void fixedAppointment(Appointment appointmentDoctorName, String appointmentFilePath) throws IOException;

    public void addAppointment(Appointment appointment, String filePath);

    public void popularDoctor(Doctor doctor1, String doctorFilePath) throws IOException;


}
