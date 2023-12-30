package pl.dmcs.jwlodarczyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "appointment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentID;
    @Temporal(TemporalType.DATE)
    private LocalDate appointmentDate;
    @Temporal(TemporalType.TIME)
    private LocalDateTime startTime;
    @Temporal(TemporalType.TIME)
    private LocalDateTime endTime;
    @NotBlank
    private String appointmentType;
    private String additionalNotes;
    @ManyToOne
    //@JoinColumn(name = "patientID", nullable = false)
    private Patient patient;
    @ManyToOne
    //@JoinColumn(name = "doctorID", nullable = false)
    private Doctor doctor;
    @ManyToOne
   // @JoinColumn(name = "clinicID", nullable = false)
    private Clinic clinic;
}
