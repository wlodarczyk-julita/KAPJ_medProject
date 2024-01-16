package pl.dmcs.jwlodarczyk.service;

import pl.dmcs.jwlodarczyk.domain.PatientHistory;

import java.util.List;
import java.util.Optional;

public interface PatientHistoryService {
    List<PatientHistory> getAllPatientHistories();
    Optional<PatientHistory> getPatientHistoryById(Long id);
    PatientHistory savePatientHistory(PatientHistory patientHistory);
    void deletePatientHistory(Long id);
}
