package bridgelabz.service;

import bridgelabz.model.Patient;

public class PatientService extends CliniqueManagementServiceImp {

    // Constructor
    public PatientService(String filePath) {
        super(filePath);
    }

    // Add patient
    public String addPatientEntry(Patient patients) {
        return super.addRecord(patients, Patient.class);
    }

    // search patient
    public int searchPatientRecord(String searchValue) {
        return super.searchRecord(searchValue, Patient.class);

    }
}