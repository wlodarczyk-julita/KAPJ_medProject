package pl.dmcs.jwlodarczyk.service;

import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.domain.PatientHistory;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
public class PdfServiceImpl implements PdfService{
    public void generatePdf(PatientHistory patientHistory, HttpServletResponse response) {
        try {
            Patient patient = patientHistory.getPatient();
            OutputStream o = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + patient.getLogin() + ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("Pdf example - KAPJ"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table = new PdfPTable(2);
            table.addCell("Patient first name");
            table.addCell(String.valueOf(patient.getFirstName()));
            table.addCell("Patient last name");
            table.addCell(String.valueOf(patient.getLastName()));
            table.addCell("Pesel");
            table.addCell(String.valueOf(patient.getPesel()));
            table.addCell("Name");
            table.addCell(patientHistory.getName());
            table.addCell("Treatment");
            table.addCell(patientHistory.getTreatment());
            table.addCell("Diagnosis Date");
            table.addCell(String.valueOf(patientHistory.getDiagnosisDate()));
            table.addCell("Disease");
            table.addCell(String.valueOf(patientHistory.getDisease()));
            table.addCell("Confidential Medical Information");
            table.addCell(patientHistory.getOtherConfidentialMedicalInformation());
            pdf.add(table);
            pdf.close();
            o.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
