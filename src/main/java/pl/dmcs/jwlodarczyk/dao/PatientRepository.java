package pl.dmcs.jwlodarczyk.dao;

import org.springframework.stereotype.Repository;
import pl.dmcs.jwlodarczyk.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAll();
    Optional<Patient> findByPatientID(long PatientID);
    void deleteByPatientID(long PatientID);
    boolean existsByTelephone(String telephone);
    boolean existsByPesel(String pesel);
    boolean existsByEmail(String email);
}
