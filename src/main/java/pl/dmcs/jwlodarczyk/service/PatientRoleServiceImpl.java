package pl.dmcs.jwlodarczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.jwlodarczyk.dao.PatientRoleRepository;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.domain.PatientRole;

import java.util.List;
@Service
@Transactional
public class PatientRoleServiceImpl implements PatientRoleService {
    private PatientRoleRepository patientRoleRepository;
    @Autowired
    public PatientRoleServiceImpl(PatientRoleRepository patientRoleRepository) {
        this.patientRoleRepository = patientRoleRepository;
    }
    @Override
    public void addPatientRole(PatientRole patientRole) {
        patientRoleRepository.save(patientRole);
    }
    @Transactional
    public List<Patient> listPatientRole() {
        return patientRoleRepository.findAll();
    }
    @Transactional
    public Patient getPatientRole(long id) {
        return patientRoleRepository.getOne(id);
    }
}

