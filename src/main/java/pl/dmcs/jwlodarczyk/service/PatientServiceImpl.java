package pl.dmcs.jwlodarczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.jwlodarczyk.dao.PatientRepository;
import pl.dmcs.jwlodarczyk.dao.PatientRoleRepository;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.utils.Validation;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;
    private final PatientRoleRepository patientRoleRepository;
    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientRoleRepository patientRoleRepository) {
        this.patientRepository = patientRepository;
        this.patientRoleRepository = patientRoleRepository;
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
    public Patient getPatientByLogin(String login) {
        Optional<Patient> optionalPatient = patientRepository.findByLogin(login);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new EntityNotFoundException("Patient with login " + login + " not found");
        }
    }
    @Transactional
    public void addPatient(Patient patient) {
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
        patient.getRole().add(patientRoleRepository.findByRole("ROLE_PATIENT"));
        patient.setPassword(hashPassword(patient.getPassword()));
        patientRepository.save(patient);
    }
    private String hashPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
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
            updatedPatient.getRole().add(patientRoleRepository.findByRole("ROLE_PATIENT"));
            updatedPatient.setPassword(hashPassword(updatedPatient.getPassword()));
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
