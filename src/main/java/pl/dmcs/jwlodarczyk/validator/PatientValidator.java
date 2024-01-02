package pl.dmcs.jwlodarczyk.validator;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.utils.Validation;

import java.time.LocalDate;

public class PatientValidator implements Validator {

    private final EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class<?> clazz) {
        return Patient.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "address", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "pesel", "error.field.required");

        Patient patient = (Patient) target;

        if (errors.getErrorCount() == 0) {
            Validation.validatorEmail(patient.getEmail(), errors, emailValidator);
            Validation.validatorDateOfBirth(patient.getDateOfBirth(), errors);
            Validation.validatorPhoneNumber(patient.getTelephone(), errors);
            Validation.validatorPesel(patient.getPesel(), errors);
        }
    }
}
