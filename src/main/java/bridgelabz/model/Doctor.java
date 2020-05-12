package bridgelabz.model;

public class Doctor {
    private String doctor_Id;
    private String doctor_Name;
    private String doctor_MobileNumber;
    private String doctor_Address;
    private String doctor_Availability;
    private String doctor_Specialist;

    // Default constructor
    public Doctor() {
    }


    // Constructor to assign doctor properties
    public Doctor(String doctor_Id, String doctor_Name, String doctor_MobileNumber, String doctor_Address,
                  String doctor_Availability, String doctor_Specialist) {
        this.doctor_Id = doctor_Id;
        this.doctor_Name = doctor_Name;
        this.doctor_Address = doctor_Address;
        this.doctor_Availability = doctor_Availability;
        this.doctor_Specialist = doctor_Specialist;
        this.doctor_MobileNumber = doctor_MobileNumber;
    }
    // Getter method

    public String getDoctor_Id() {
        return doctor_Id;
    }

    public String getDoctor_Name() {
        return doctor_Name;
    }

    public String getDoctor_MobileNumber() {
        return doctor_MobileNumber;
    }

    public String getDoctor_Address() {
        return doctor_Address;
    }

    public String getDoctor_Availability() {
        return doctor_Availability;
    }

    public String getDoctor_Specialist() {
        return doctor_Specialist;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_Id='" + doctor_Id + '\'' +
                ", doctor_Name='" + doctor_Name + '\'' +
                ", doctor_MobileNumber='" + doctor_MobileNumber + '\'' +
                ", doctor_Address='" + doctor_Address + '\'' +
                ", doctor_Availability='" + doctor_Availability + '\'' +
                ", doctor_Specialist='" + doctor_Specialist + '\'' +
                '}';
    }
}