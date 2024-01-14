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
    @Column(unique = true)
    private String telephone;
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Address cannot be empty")
    private String  address;
    @NotBlank(message = "PESEL cannot be empty")
    @Size(min=11, max=11, message = "PESEL must have 11 characters")
    @Column(unique = true)
    private String pesel;
    @OneToMany(mappedBy = "patient")
    @Builder.Default
    private Set<PatientHistory> patientHistories = new HashSet<>();
    @OneToMany(mappedBy = "patient")
    @Builder.Default
    private Set<Appointment> appointments = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    private FinancialData financialData;

    @NotNull
    @Column(unique = true)
    private String login;
    @NotNull
    private String password;
    private boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<PatientRole> role = new HashSet<PatientRole>(0);
}
