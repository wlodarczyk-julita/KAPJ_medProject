package pl.dmcs.jwlodarczyk.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.jwlodarczyk.domain.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(long id);
    @Secured({"ROLE_ADMIN", "ROLE_DOCTOR"})
    void addPatient(Patient patient);
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_DOCTOR') OR (#patient.login == principal.username)")
    Patient updatePatient(long id, Patient patient);
    @Secured({"ROLE_ADMIN", "ROLE_DOCTOR"})
    void deletePatient(long id);
    Patient getPatientByLogin(String login);
}
