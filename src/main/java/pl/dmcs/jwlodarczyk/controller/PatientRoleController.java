package pl.dmcs.jwlodarczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.jwlodarczyk.domain.PatientRole;
import pl.dmcs.jwlodarczyk.service.PatientRoleService;
@Controller
public class PatientRoleController {

    private PatientRoleService patientRoleService;
    @Autowired
    public PatientRoleController(PatientRoleService patientRoleService) {
        this.patientRoleService = patientRoleService;
    }
    @RequestMapping(value="/patientRole")
    public String showUserRole(Model model) {
        model.addAttribute("patientRole", new PatientRole());
        return "patientRole";
    }
    @RequestMapping(value = "/addPatientRole", method = RequestMethod.POST)
    public String addUserRole(@ModelAttribute("patientRole") PatientRole patientRole, BindingResult result) {
        patientRoleService.addPatientRole(patientRole);
        return "redirect:patients.html";
    }
}

