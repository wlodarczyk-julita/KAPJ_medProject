package pl.dmcs.jwlodarczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {

    @RequestMapping(value = "/patients")
    public ModelAndView showAppUsers() {

	 /*  AppUser appUser = new AppUser();
	   appUser.setFirstName("rafal");
	   appUser.setLastName("kotas");
	   appUser.setEmail("rkotas@dmcs.pl");
	   appUser.setTelephone("123456789");*/

	 return new ModelAndView("patient", "patient", new pl.dmcs.jwlodarczyk.domain.Patient());
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String addAppUser(@ModelAttribute("appUser") pl.dmcs.jwlodarczyk.domain.Patient patient) {

        System.out.println("First Name: " + patient.getFirstName() +
                " Last Name: " + patient.getLastName() + " Tel.: " +
                patient.getTelephone() + " Email: " + patient.getEmail());

        return "redirect:appUsers.html";
    }

}

