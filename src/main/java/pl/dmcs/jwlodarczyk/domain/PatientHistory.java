package pl.dmcs.jwlodarczyk.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "patient_history")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PatientHistoryID;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Temporal(TemporalType.DATE)
    private Date diagnosisDate;
    @NotBlank(message = "Treatment cannot be empty")
    private String treatment;
    private Boolean isCured = false;
    private String otherConfidentialMedicalInformation;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Disease disease;
}
