package pl.dmcs.jwlodarczyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorID;
    @NotBlank(message = "First name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 9, max = 9, message = "Telephone number must have 9 characters")
    private String telephone;
    @Past(message = "Date of birth must be in the past")
    private String dateOfBirth;
    @NotBlank(message = "Address cannot be empty")
    private String address;
    @NotBlank(message = "Specialization cannot be empty")
    private String specialization;
    @Size(min = 6, max = 6, message = "License Number must have 9 characters")
    private String licenseNumber;
    @OneToMany(mappedBy = "doctor")
    @Builder.Default
    private Set<Appointment> appointments = new HashSet<>();
}
