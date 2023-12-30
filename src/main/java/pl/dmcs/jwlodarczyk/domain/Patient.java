package pl.dmcs.jwlodarczyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientID;
    @NotBlank(message = "First name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 9, max = 9, message = "Telephone number must have 9 characters")
    private String telephone;
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Address cannot be empty")
    private String  address;
    @NotBlank(message = "PESEL cannot be empty")
    @Size(min=11, max=11, message = "PESEL must have 11 characters")
    private String pesel;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
    private PatientCard patientCard;
    @OneToMany(mappedBy = "patient")
    @Builder.Default
    private Set<Appointment> appointments = new HashSet<>();
}
