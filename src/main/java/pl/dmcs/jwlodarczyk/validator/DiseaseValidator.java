package pl.dmcs.jwlodarczyk.validator;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.dmcs.jwlodarczyk.domain.Disease;
import pl.dmcs.jwlodarczyk.utils.Validation;

public class DiseaseValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Disease.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "description", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "name", "error.field.required");
    }
}
