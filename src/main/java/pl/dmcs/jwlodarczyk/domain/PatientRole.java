package pl.dmcs.jwlodarczyk.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="patient-role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientRole {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long id;
    private String role;
}
