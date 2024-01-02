package pl.dmcs.jwlodarczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.jwlodarczyk.dao.PatientRepository;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.utils.Validation;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;
    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Transactional
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Transactional
    public Patient getPatientById(long id) {
        Optional<Patient> optionalPatient = patientRepository.findByPatientID(id);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new EntityNotFoundException("Patient with id " + id + " not found");
        }
    }
    @Transactional
    public Patient addPatient(Patient patient) {
        Validation.validatePesel(patient.getPesel());
        Validation.validateDateOfBirth(patient.getDateOfBirth());
        Validation.validatePhoneNumber(patient.getTelephone());
        Validation.validatePhoneNumber(patient.getTelephone());
        if (patientRepository.existsByTelephone(patient.getTelephone())) {
            throw new IllegalArgumentException("Patient with the same phone number already exists");
        }
        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new IllegalArgumentException("Patient with the same email already exists");
        }
        if (patientRepository.existsByPesel(patient.getPesel())) {
            throw new IllegalArgumentException("Patient with the same pesel already exists");
        }
        return patientRepository.save(patient);
    }
    @Transactional
    public Patient updatePatient(long id, Patient updatedPatient) {
        Optional<Patient> optionalPatient = patientRepository.findByPatientID(id);
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setFirstName(updatedPatient.getFirstName());
            existingPatient.setLastName(updatedPatient.getLastName());
            existingPatient.setEmail(updatedPatient.getEmail());
            existingPatient.setTelephone(updatedPatient.getTelephone());
            existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
            existingPatient.setAddress(updatedPatient.getAddress());
            existingPatient.setPesel(updatedPatient.getPesel());
            existingPatient.setAppointments(updatedPatient.getAppointments());
            return patientRepository.save(existingPatient);
        } else {
            throw new EntityNotFoundException("Patient with id " + id + " not found");
        }
    }
    @Transactional
    public void deletePatient(long id) {
        patientRepository.deleteByPatientID(id);
    }
}
