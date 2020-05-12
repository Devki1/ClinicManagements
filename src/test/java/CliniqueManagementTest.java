import bridgelabz.exception.CliniqueException;
import bridgelabz.model.Appointment;
import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;
import bridgelabz.service.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class CliniqueManagementTest {
    public static final String appointmentFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Appointment.json";
    public static final String doctorFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Doctor.json";
    public static final String patientFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Patient.json";
    CliniqueManagementServiceImp cliniqueManagementServiceImp;
    // Reference
    DoctorService doctor;
    PatientService patient;

    // file path
    //  public String appointmentFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Appointment.json";

    @Before
    public void setUp() {
        doctor = new DoctorService("/home/user/IdeaProjects/ClinicManagement/src/main/resources/Doctor.json");
        patient = new PatientService("/home/user/IdeaProjects/ClinicManagement/src/main/resources/Patient.json");
    }

    @Test
    public void givenDoctorInformation_WhenAddDoctor_ThenReturnSuccessMessage() throws CliniqueException {
        String result = doctor.addDoctorEntry(new Doctor("E421", "Ak singh", "8956561515", "balrampur", "BOTH", "Ortho"));
        Assert.assertEquals("Add Records Successfully", result);
    }

    @Test
    public void givenPatientsInformation_WhenAddPatients_ThenReturnSuccessMessage() throws CliniqueException {
        String result = patient.addPatientEntry(new Patient("1234", "Rahul", "8546973695", 52));
        Assert.assertEquals("Add Records Successfully", result);
    }

    //
    @Test
    public void givenPatientName_WhenSearch_ThenReturnNumberOfRecord() {
        int result = patient.searchPatientRecord("Rahul");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenPatientId_WhenSearch_ThenReturnNumberOfRecord() {
        int result = patient.searchPatientRecord("1234");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenPatientMobileNumber_WhenSearch_ThenReturnNumberOfRecord() {
        int result = patient.searchPatientRecord("8546973695");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenPatientAge_WhenSearch_ThenReturnNumberOfRecord() {
        int result = patient.searchPatientRecord("52");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenDoctorId_WhenSearch_ThenReturnNumberOfRecord() {
        int result = doctor.searchDoctorEntry("E421");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenDoctorName_WhenSearch_ThenReturnNumberOfRecord() {
        int result = patient.searchPatientRecord("Rahul");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenDoctorMobileNumber_WhenSearch_ThenReturnNumberOfRecord() {
        int result = patient.searchPatientRecord("8546973695");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenDoctorAddress_WhenSearch_ThenReturnNumberOfRecord() {
        int result = patient.searchPatientRecord("");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenDoctorIdAndDate_WhenFixAppointment_ThenReturnSuccessMessage() throws IOException, CliniqueException, ParseException, ClassNotFoundException, ParseException {
        AppointmentsService appoint = new AppointmentsService();
        String result = appoint.appointment("E421", "1234", "10/12/2020");
        Assert.assertEquals("Appointment fixed", result);
    }

    @Test
    public void givenDoctorId_WhenSearchDoctorPatient_ThenReturnSuccessMessage() throws IOException, CliniqueException, ParseException, ClassNotFoundException {
        DoctorService doctorService = new DoctorService(appointmentFilePath);
        int result = doctorService.doctorPatientReport("E421");
        Assert.assertEquals(2, result);
    }

    @Test
    public void givenDoctor_WhenSearchPopularDoctor_ThenReturnSuccessMessage() throws IOException, CliniqueException, ParseException, ClassNotFoundException {
        String doctorId = doctor.popularDoctor();
        int result = doctor.searchDoctorEntry(doctorId);
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenDoctor_WhenSearchPopularSpecialization_ThenReturnSuccessMessage() throws IOException, CliniqueException, ParseException, ClassNotFoundException {
        String specialization = doctor.popularSpecialization();
        Assert.assertEquals("DERMATOLOGISTS", specialization);
    }
}