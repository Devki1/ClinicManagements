import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;
import bridgelabz.service.CliniqueManagementServiceImp;
import bridgelabz.service.FileSystem;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagementTest {
    public static final String doctorFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Doctor.json";
    public static final String patientFilePath = "/home/user/IdeaProjects/ClinicManagement/src/main/resources/Patient.json";
    CliniqueManagementServiceImp cliniqueManagementServiceImp;
    FileSystem fileSystem;
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        cliniqueManagementServiceImp = new CliniqueManagementServiceImp();
        fileSystem = new FileSystem();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void givenFile_AddDoctorDetails_ShouldReturnTrue() {
        try {
            Doctor doctorDetails1 = new Doctor("Deepak singh", 1011, "Dentist", "9am");
            Doctor doctorDetails2 = new Doctor("Ak singh", 2021, "Skin", "10am");
            Doctor doctorDetails3 = new Doctor("DK singh", 3321, "Neurology", "11am");
            Doctor doctorDetails4 = new Doctor("Sandeep singh", 4008, "Orthopaedics", "4pm");
            Doctor doctorDetails5 = new Doctor("MK sinha", 5004, "Dermatology", "8pm");

            cliniqueManagementServiceImp.addDoctor(doctorDetails1, doctorFilePath);
            cliniqueManagementServiceImp.addDoctor(doctorDetails2, doctorFilePath);
            cliniqueManagementServiceImp.addDoctor(doctorDetails3, doctorFilePath);
            cliniqueManagementServiceImp.addDoctor(doctorDetails4, doctorFilePath);
            cliniqueManagementServiceImp.addDoctor(doctorDetails5, doctorFilePath);
            ArrayList<Doctor> data = objectMapper
                    .readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>() {
                    });
            Assert.assertEquals(doctorDetails1.getName(), data.get(0).getName());
            Assert.assertEquals(doctorDetails2.getName(), data.get(1).getName());
            Assert.assertEquals(doctorDetails3.getName(), data.get(2).getName());
            Assert.assertEquals(doctorDetails4.getName(), data.get(3).getName());
            Assert.assertEquals(doctorDetails5.getName(), data.get(4).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFile_whenAddPatientDelail_shouldReturnTrue() {
        try {
            Patient patientDetails1 = new Patient("Raj kush", 1101, 9897636572L, 27);
            Patient patientDetails2 = new Patient("Amir khan", 2002, 9978987631L, 22);
            Patient patientDetails3 = new Patient("Rahul gupta", 3354, 7897635382L, 23);
            Patient patientDetails4 = new Patient("Danish khan", 4897, 8947038738L, 25);
            Patient patientDetails5 = new Patient("virat", 5148, 7004342412L, 23);
            cliniqueManagementServiceImp.addPatient(patientDetails1, patientFilePath);
            cliniqueManagementServiceImp.addPatient(patientDetails2, patientFilePath);
            cliniqueManagementServiceImp.addPatient(patientDetails3, patientFilePath);
            cliniqueManagementServiceImp.addPatient(patientDetails4, patientFilePath);
            cliniqueManagementServiceImp.addPatient(patientDetails5, patientFilePath);

            ArrayList<Patient> data = objectMapper
                    .readValue(new File(patientFilePath), new TypeReference<ArrayList<Patient>>() {
                    });
            Assert.assertEquals(patientDetails1.getName(), data.get(0).getName());
            Assert.assertEquals(patientDetails2.getName(), data.get(1).getName());
            Assert.assertEquals(patientDetails3.getName(), data.get(2).getName());
            Assert.assertEquals(patientDetails4.getName(), data.get(3).getName());
            Assert.assertEquals(patientDetails5.getName(), data.get(4).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFile_WhenSearchDoctorByName_ShouldReturnTrue() {
        String doctorName = "Deepak singh";
        Boolean isDoctorName = cliniqueManagementServiceImp.searchDoctorByName(doctorName, doctorFilePath);
        Assert.assertTrue(isDoctorName);
    }

    @Test
    public void givenFile_WhenSearchDoctorByid_ShouldReturnTrue() {
        int doctorId = 2021;
        boolean isDoctorId = cliniqueManagementServiceImp.searchDoctorById(doctorId, doctorFilePath);
        Assert.assertTrue(isDoctorId);
    }

    @Test
    public void givenFile_WhenFindDoctorBySpecialization_ShouldReturnTrue() {
        String doctorSpecialist = "Neurology";
        boolean isDoctorSpecialist = cliniqueManagementServiceImp.findDoctorSpecialization(doctorSpecialist, doctorFilePath);
        Assert.assertTrue(isDoctorSpecialist);
    }

    @Test
    public void givenFile_whenSearchDoctorByAvailability_shouldReturnTrue() {
        String doctorAvailability = "9am";
        boolean isDoctorAvailability = cliniqueManagementServiceImp
                .searchDoctorByAvailability(doctorAvailability, doctorFilePath);
        Assert.assertTrue(isDoctorAvailability);
    }

    @Test
    public void givenFile_whenSearchPatientByName_shouldReturnTrue() {
        String patientName = "Rahul gupta";
        boolean isPatientName = cliniqueManagementServiceImp.searchPatientByName(patientName, patientFilePath);
        Assert.assertTrue(isPatientName);
    }
}
