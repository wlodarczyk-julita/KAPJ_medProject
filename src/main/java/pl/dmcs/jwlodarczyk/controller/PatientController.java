package pl.dmcs.jwlodarczyk.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.service.PatientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/patients")
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
    @PostMapping(value = "/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        System.out.println("First Name: " + patient.getFirstName() +
                " Last Name: " + patient.getLastName() + " Tel.: " +
                patient.getTelephone() + " Email: " + patient.getEmail());
        addPatients(patient);
       return ResponseEntity.ok().body(savedPatient);
    }
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

	 /*  AppUser appUser = new AppUser();
	   appUser.setFirstName("rafal");
	   appUser.setLastName("kotas");
	   appUser.setEmail("rkotas@dmcs.pl");
	   appUser.setTelephone("123456789");*/

	 return new ModelAndView("patient", "patient", new Patient());
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String addPatients(@ModelAttribute("patient") Patient patient) {
        System.out.println("First Name: " + patient.getFirstName() +
                " Last Name: " + patient.getLastName() + " Tel.: " +
                patient.getTelephone() + " Email: " + patient.getEmail());
        return "redirect:Patient.html";
    }
}

