package pl.dmcs.jwlodarczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.jwlodarczyk.service.PdfService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    private PdfService pdfService;
    private PatientHistoryService patientHistoryService;

    @Autowired
    public PdfController(PdfService pdfService, PatientHistoryService patientHistoryService) {
        this.pdfService = pdfService;
        this.patientHistoryService = patientHistoryService;
    }

    @RequestMapping(value = "/generatePdf-{appUserId}", method = RequestMethod.GET)
    public void generatePdf(@PathVariable Integer PatientHistoryID, HttpServletResponse response) {
        pdfService.generatePdf(patientHistoryService.getPatientHistory(PatientHistoryID), response);
    }
}
