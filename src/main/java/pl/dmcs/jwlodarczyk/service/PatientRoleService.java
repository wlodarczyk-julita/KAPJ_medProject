package pl.dmcs.jwlodarczyk.service;

import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.domain.PatientRole;

import java.util.List;

public interface PatientRoleService {
    void addPatientRole(PatientRole patientRole);
    List<Patient> listPatientRole();
    Patient getPatientRole(long id);
}

