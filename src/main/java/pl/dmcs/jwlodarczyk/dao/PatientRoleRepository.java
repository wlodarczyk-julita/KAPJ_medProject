package pl.dmcs.jwlodarczyk.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.domain.PatientRole;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PatientRoleRepository extends JpaRepository<Patient, Long> {
    PatientRole findByRole(String role);
    void save(PatientRole patientRole);
}