package pl.dmcs.jwlodarczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.jwlodarczyk.dao.DiseaseRepository;
import pl.dmcs.jwlodarczyk.domain.Disease;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service("diseaseService")
@Transactional
public class DiseaseServiceImpl implements DiseaseService{
    private final DiseaseRepository diseaseRepository;
    @Autowired
    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }
    @Transactional
    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }
    @Transactional
    public Disease getDiseaseById(long id) {
        Optional<Disease> optionalDisease = diseaseRepository.findByDiseaseID(id);
        if (optionalDisease.isPresent()) {
            return optionalDisease.get();
        } else {
            throw new EntityNotFoundException("Disease with id " + id + " not found");
        }
    }
    @Transactional
    public void addDisease(Disease disease) {
        if (diseaseRepository.existsByName(disease.getName())) {
            throw new IllegalArgumentException("Disease with the same name already exists");
        }
        diseaseRepository.save(disease);
    }
    @Transactional
    public Disease updateDisease(long id, Disease updatedDisease) {
        Optional<Disease> optionalDisease = diseaseRepository.findByDiseaseID(id);
        if (optionalDisease.isPresent()) {
            Disease existingDisease = optionalDisease.get();
            existingDisease.setDescription(updatedDisease.getDescription());
            existingDisease.setName(updatedDisease.getName());
            existingDisease.setPatientHistories(updatedDisease.getPatientHistories());
            if (diseaseRepository.existsByName(updatedDisease.getName())) {
                throw new IllegalArgumentException("Disease with the same name already exists");
            } else {
                return diseaseRepository.save(existingDisease);
            }
        } else {
            throw new EntityNotFoundException("Disease with id " + id + " not found");
        }
    }
    @Transactional
    public void deleteDisease(long id) {
        diseaseRepository.deleteByDiseaseID(id);
    }
}
