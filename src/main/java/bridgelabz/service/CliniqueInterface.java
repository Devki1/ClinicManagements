package bridgelabz.service;

import bridgelabz.model.Appointment;
import bridgelabz.model.Doctor;
import bridgelabz.model.Patient;

import java.io.IOException;
import java.util.List;

public interface CliniqueInterface {

    public <T> String addRecord(T object, Class<?> className);

    public <T> int searchRecord(String searchValue, Class<?> className);

    public <T> List<T> readFile(Class<?> target) throws IOException, ClassNotFoundException;

    public <T> void saveRecord(List<T> list) throws IOException;
}



