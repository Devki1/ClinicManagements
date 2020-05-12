package bridgelabz.service;

import bridgelabz.model.Appointment;
import bridgelabz.model.Patient;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CliniqueManagementServiceImp implements CliniqueInterface {
    // Variables
    String filePath;

    // Objects
    File file;
    ObjectMapper mapper = new ObjectMapper();

    // Constructor
    public <T> CliniqueManagementServiceImp(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    // Add record
    @Override
    public <T> String addRecord(T object, Class<?> className) {
        try {
            List<T> list = new ArrayList<>();
            if (file.length() > 0)
                list = readFile(className);
            list.add(object);
            saveRecord(list);
            return "Add Records Successfully";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Search Record
    @Override
    public <T> int searchRecord(String searchValue, Class<?> className) {
        try {
            AtomicInteger count = new AtomicInteger();
            readFile(className).stream().forEach(value -> {
                if (value.toString().contains(searchValue)) {
                    System.out.println(value.toString());
                    count.getAndIncrement();
                }
            });
            return count.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Read file
    @Override
    public <T> List<T> readFile(Class<?> target) throws IOException, ClassNotFoundException {
        return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Class.forName(target.getName())));
    }

    // Save Records In File
    @Override
    public <T> void saveRecord(List<T> list) throws IOException {
        mapper.writeValue(file, list);
    }

}