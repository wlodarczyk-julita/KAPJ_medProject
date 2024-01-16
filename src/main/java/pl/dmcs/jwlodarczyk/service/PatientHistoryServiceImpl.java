package pl.dmcs.jwlodarczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmcs.jwlodarczyk.dao.PatientHistoryRepository;
import pl.dmcs.jwlodarczyk.domain.PatientHistory;
import java.util.List;
import java.util.Optional;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private final PatientHistoryRepository patientHistoryRepository;

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository) {
        this.patientHistoryRepository = patientHistoryRepository;
    }

    @Override
    public List<PatientHistory> getAllPatientHistories() {
        return patientHistoryRepository.findAll();
    }

    @Override
    public Optional<PatientHistory> getPatientHistoryById(Long id) {
        return patientHistoryRepository.findById(id);
    }

    @Override
    public PatientHistory savePatientHistory(PatientHistory patientHistory) {
        return patientHistoryRepository.save(patientHistory);
    }

    @Override
    public void deletePatientHistory(Long id) {
        patientHistoryRepository.deleteById(id);
    }
}
