package bridgelabz.model;

public class Patient {
    private String patientId;
    private String patientName;
    private String patientMobileNumber;
    private int patientAge;

    // Default constructor
    public Patient() {
    }


    // Constructor to assign patient properties
    public Patient(String patientId, String patientName, String patientMobileNumber, int patientAge) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientMobileNumber = patientMobileNumber;
    }

    // Getter methods
    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientMobileNumber() {
        return patientMobileNumber;
    }

    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientMobileNumber='" + patientMobileNumber + '\'' +
                ", patientAge=" + patientAge +
                '}';
    }
}