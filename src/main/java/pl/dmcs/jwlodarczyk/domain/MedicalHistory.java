package pl.dmcs.jwlodarczyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medical_history")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalHistoryID;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Temporal(TemporalType.DATE)
    private LocalDate diagnosisDate;
    @NotBlank(message = "Treatment cannot be empty")
    private String treatment;
    private Boolean isCured = false;
    @Builder.Default //NullPointerException protection
    @ManyToMany
    @JoinTable(
            name = "DiseaseMedicalHistory",
            joinColumns = @JoinColumn(name = "medicalHistoryID"),
            inverseJoinColumns = @JoinColumn(name = "diseaseID"))
    private Set<Disease> disease = new HashSet<>();
}
