package bridgelabz.service;

import bridgelabz.model.Appointment;
import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;

import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagementServiceImp implements CliniqueInterface {
    FileSystem fileSystem = new FileSystem();

    // This method is used to add doctor information
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

    // This method is used to add patient information
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

    // This method is used to search doctor by name.
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

    // This method is used to search doctor by Id.
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

    // This method is used to find specialist doctor.
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

    // This method is used to search popular doctor.
    @Override
    public void popularDoctor(Doctor doctor1, String doctorFilePath) throws IOException {
        ArrayList<Doctor> doctorArrayList = fileSystem.readFileDoctor(doctorFilePath);
        for (Doctor doctor : doctorArrayList) {
            if (doctor.getName().equalsIgnoreCase(doctor1.getName()))
                System.out.println("Popular doctor is : Dr." + doctor.getName());
        }
    }

    // This method is used to search doctor availability.
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

    // This method is used to search patient by name.
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

    // This method is used to search patient by id.
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

    // This method is used to search patient by mobile number.
    @Override
    public boolean searchPatientByMobileNumber(Long patientMobileNumber, String patientFilePath) {
        try {
            ArrayList<Patient> readData = fileSystem.readPatientFile(patientFilePath);
            for (Patient patientData : readData) {
                if (patientData.getMobileNumber() == patientMobileNumber) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // This method is used to add appointment.
    @Override
    public void addAppointment(Appointment appointment, String filePath) {
        try {
            ArrayList<Appointment> readData = fileSystem.readFile(filePath);
            readData.add(appointment);
            fileSystem.writeFile(readData, filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // This method is used to fixedAppointment.
    @Override
    public void fixedAppointment(Appointment appointmentDoctorName, String appointmentFilePath) throws IOException {
        ArrayList<Appointment> readData = fileSystem.readAppointmentFile(appointmentFilePath);
        for (Appointment appointmentDoctor : readData) {
            if (appointmentDoctor.getDoctorName().equals(appointmentDoctor.getDoctorName()))
                System.out.println("Doctor name is : Dr." + appointmentDoctor.getDoctorName());
            if (appointmentDoctor.getPatientName().equals(appointmentDoctor.getPatientName())) ;
            System.out.println("Patient name is : " + appointmentDoctor.getPatientName());
            if (appointmentDoctor.getDate().equals(appointmentDoctor.getDate())) ;
            System.out.println("Date is : " + appointmentDoctor.getDate());
        }
    }
}

