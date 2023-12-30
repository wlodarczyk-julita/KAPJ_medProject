package pl.dmcs.jwlodarczyk.utils;

import java.time.LocalDate;
public class ValidationUtils {
    public static void validatePesel(String pesel) {
        if (!(pesel != null && pesel.length() == 11 && pesel.matches("\\d+"))) {
            throw new IllegalArgumentException("Invalid PESEL");
        }
    }
    public static void validateDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date of birth");
        }
    }
    public static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 9 || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid telephone number");
        }
    }
}
