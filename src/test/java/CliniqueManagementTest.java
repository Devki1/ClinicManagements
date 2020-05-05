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
    CliniqueManagementServiceImp cliniqueManager;
    FileSystem fileSystem;
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        cliniqueManager = new CliniqueManagementServiceImp();
        fileSystem = new FileSystem();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void givenFile_AddDoctorDetails_ShouldReturnTrue() {
        try {
            Doctor doctor = new Doctor("Deepak", 1, "ortho", "9AM");
            cliniqueManager.addDoctor(doctor, doctorFilePath);
            ArrayList<Doctor> data = objectMapper.readValue(new File(doctorFilePath), new TypeReference<ArrayList<Doctor>>() {
            });
            Assert.assertEquals(doctor.getName(), data.get(data.size() - 1).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFile_AddPatientDetails_ShouldReturnTrue() {
        try {
            Patient patient = new Patient("Rahul", 1, 9918457869L, 46);
            cliniqueManager.addPatient(patient, patientFilePath);
            ArrayList<Patient> data = objectMapper.readValue(new File(patientFilePath), new TypeReference<ArrayList<Patient>>() {
            });
            Assert.assertEquals(patient.getName(), data.get(data.size() - 1).getName());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

