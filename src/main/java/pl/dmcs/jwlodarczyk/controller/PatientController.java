package pl.dmcs.jwlodarczyk.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.service.PatientService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping(value = "/patients")
public class PatientController {
    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok().body(patients);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable long id) {
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok().body(patient);
    }
//    @PostMapping(value = "/add")
//    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
//        Patient savedPatient = patientService.addPatient(patient);
//        System.out.println("First Name: " + patient.getFirstName() +
//                " Last Name: " + patient.getLastName() + " Tel.: " +
//                patient.getTelephone() + " Email: " + patient.getEmail());
//        addPatients(patient);
//       return ResponseEntity.ok().body(savedPatient);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatient(id, patient);
        return ResponseEntity.ok().body(updatedPatient);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
    public ModelAndView showPatient() {

	 /*  Patient patient = new Patient();
	   patient.setFirstName("rafal");
	   patient.setLastName("kotas");
	   patient.setEmail("rkotas@dmcs.pl");
	   patient.setTelephone("123456789");*/

	 return new ModelAndView("views/patient", "patient", new Patient());
    }

//    @RequestMapping(value = "/patients", method = RequestMethod.POST)
//    public String showPatients(Model model, HttpServletRequest request) {
//        System.out.println("First Name: " + patient.getFirstName() +
//                " Last Name: " + patient.getLastName() + " Tel.: " +
//                patient.getTelephone() + " Email: " + patient.getEmail());
//        return "redirect:Patient.html";
//    }

    @RequestMapping(value = "/patients")
    public String showPatients(Model model, HttpServletRequest request) {
        int patientId = ServletRequestUtils.getIntParameter(request, "patientId" , -1);
        if (patientId > 0)
            model.addAttribute("patient", patientService.getPatientById(patientId));
        else
            model.addAttribute("patient", new Patient());
        model.addAttribute("patientList", patientService.getAllPatients());
        return "views/patient";
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        System.out.println("First Name: " + patient.getFirstName() +
                " Last Name: " + patient.getLastName() + " Tel.: " +
                patient.getTelephone() + " Email: " + patient.getEmail());

        if (patient.getPatientID()==0)
            patientService.addPatient(patient);
        else
            patientService.addPatient(patient);

        return "redirect:patients.html";
    }

    @RequestMapping("/delete/{patientId}")
    public String deleteUser(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
        return "redirect:/patients.html";
    }
}

