package pl.dmcs.jwlodarczyk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.jwlodarczyk.domain.Disease;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    List<Disease> findAll();
    Optional<Disease> findByDiseaseID(long DiseaseID);
    void deleteByDiseaseID(long DiseaseID);
    boolean existsByName(String name);
}
