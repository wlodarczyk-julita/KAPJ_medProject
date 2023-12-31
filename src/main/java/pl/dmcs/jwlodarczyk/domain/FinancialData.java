package pl.dmcs.jwlodarczyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "financial_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FinancialData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long financialDataId;
    private String insuranceDetails;
    @NotBlank(message = "Billing address cannot be empty")
    private String billingAddress;
    private Boolean isInsured = false;
    @Positive
    private Float insuranceAmount = 0.0F;
    @OneToOne(mappedBy = "financialData")
    private Patient patient;
}
