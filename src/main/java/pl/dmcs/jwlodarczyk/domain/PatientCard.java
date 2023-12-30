package pl.dmcs.jwlodarczyk.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient_card")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientCardId;
    @OneToOne
    private Patient patient;
    private String otherConfidentialMedicalInformation;
    //operations on the PatientCard entity affect the entities MedicalHistory
    @OneToMany(mappedBy = "patientCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicalHistory> medicalHistories = new HashSet<>();
}
