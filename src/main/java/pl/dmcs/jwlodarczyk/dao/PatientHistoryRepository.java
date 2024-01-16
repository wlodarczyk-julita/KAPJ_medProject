package pl.dmcs.jwlodarczyk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.jwlodarczyk.domain.PatientHistory;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

}
