package bridgelabz.service;

import bridgelabz.exception.CliniqueException;
import bridgelabz.model.Appointment;
import bridgelabz.model.Doctor;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppointmentsService {

    // Variable
    public String appointmentFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Appointment.json";
    public String doctorFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Doctor.json";
    int count = 0;

    // Objects
    List<Appointment> list = new ArrayList();
    ObjectMapper mapper = new ObjectMapper();
    CliniqueManagementServiceImp main = new CliniqueManagementServiceImp(appointmentFilePath);
    DoctorService doctor = new DoctorService(doctorFilePath);
    File file;

    // Appointment
    public String appointment(String doctorId, String patientId, String date) throws IOException, CliniqueException, ParseException, ClassNotFoundException {
        count = doctor.searchDoctorEntry(doctorId);
        if (count == 0)
            throw new CliniqueException(CliniqueException.MyException.INVALID_ID, "This doctor are not present in clinique");
        compareDate(date); // Date in past then throw exception
        availabilityTime(doctorId);
        list = main.readFile(Appointment.class);
        int noOfAppointMent = (int) list.stream().filter(value -> value.getAppointment_Date().compareTo(date) == 0 && value.getDoctor_Id().compareTo(doctorId) == 0).count();
        if (noOfAppointMent < 5) {
            main.addRecord(new Appointment(noOfAppointMent + 1, doctorId, date, patientId), Appointment.class);
            return "Appointment fixed";
        }
        return "Appointment are not available";
    }

    // Date must be in future
    public void compareDate(String date) throws ParseException, CliniqueException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date appointmentDate = format.parse(date);
        Date currentDate = format.parse(format.format(cal.getTime()));
        if (currentDate.after(appointmentDate))
            throw new CliniqueException(CliniqueException.MyException.INVALID_APPOINTMENT_DATE, "This doctor are not present in clinique");
    }

    // Check doctor availability time
    public void availabilityTime(String doctorId) throws IOException, ClassNotFoundException {
        List<Doctor> doctorList = doctor.readFile(Doctor.class);
        final String[] availability = {null};
        doctorList.stream().forEach(value -> {
            if (value.getDoctor_Id().compareTo(doctorId) == 0) {
                availability[0] = value.getDoctor_Availability();
            }
        });
        switch (availability[0]) {
            case "AM":
                System.out.println("Dr. Available In 06am to 12am");
                break;
            case "PM":
                System.out.println("Dr. Available In 12pm to 6pm");
                break;
            case "BOTH":
                System.out.println("Dr. Available In Full Time");
                break;
        }
    }
}
