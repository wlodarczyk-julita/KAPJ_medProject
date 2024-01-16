package pl.dmcs.jwlodarczyk.service;

import pl.dmcs.jwlodarczyk.domain.PatientHistory;
import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    public void generatePdf(PatientHistory patientHistory, HttpServletResponse response);
}
