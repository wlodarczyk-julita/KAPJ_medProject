package pl.dmcs.jwlodarczyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clinic")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clinicId;
    @NotBlank(message = "Address name cannot be empty")
    private String address;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 9, max = 9, message = "Telephone number must have 9 characters")
    private String telephone;
    @OneToMany(mappedBy = "clinic")
    @Builder.Default
    private Set<Appointment> appointments = new HashSet<>();
}
