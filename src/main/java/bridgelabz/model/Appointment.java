package bridgelabz.model;

public class Appointment {
    private String doctorName;
    private String patientName;
    private String date;

    public Appointment() {

    }

    public Appointment(String docName, String patientName, String date) {
        this.doctorName = docName;
        this.patientName = patientName;
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
