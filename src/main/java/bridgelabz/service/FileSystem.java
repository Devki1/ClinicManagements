package bridgelabz.service;

import bridgelabz.model.Appointment;
import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSystem {
    ObjectMapper objectMapper = new ObjectMapper();

    public <E> ArrayList<E> readFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<E>>() {
        });
    }

    public <E> void writeFile(ArrayList<E> list, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), list);
    }


    public ArrayList<Doctor> readFileDoctor(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Doctor>>() {
        });
    }

    public ArrayList<Patient> readPatientFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Patient>>() {
        });
    }

    public ArrayList<Appointment> readAppointmentFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Appointment>>() {
        });
    }
}
