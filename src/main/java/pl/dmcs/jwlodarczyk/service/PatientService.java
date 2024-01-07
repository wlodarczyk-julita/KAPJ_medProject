package pl.dmcs.jwlodarczyk.service;

import pl.dmcs.jwlodarczyk.domain.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(long id);
    void addPatient(Patient patient);
    Patient updatePatient(long id, Patient patient);
    void deletePatient(long id);
}
