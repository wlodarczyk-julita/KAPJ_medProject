package pl.dmcs.jwlodarczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.dmcs.jwlodarczyk.domain.Disease;
import pl.dmcs.jwlodarczyk.service.DiseaseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping(value = "/diseases")
public class DiseaseController {
    private final DiseaseService diseaseService;
    @Autowired
    public DiseaseController(DiseaseService diseaseService){
        this.diseaseService = diseaseService;
    }
//    @GetMapping
//    public ResponseEntity<List<Disease>> getAllDiseases() {
//        List<Disease> diseases = diseaseService.getAllDiseases();
//        return ResponseEntity.ok().body(diseases);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Disease> getDiseaseById(@PathVariable long id) {
//        Disease disease = diseaseService.getDiseaseById(id);
//        return ResponseEntity.ok().body(disease);
//    }
////    @PostMapping(value = "/add")
////    public ResponseEntity<Disease> addDisease(@RequestBody Disease disease) {
////        Disease savedDisease = diseaseService.addDisease(disease);
////        System.out.println("First Name: " + disease.getFirstName() +
////                " Last Name: " + disease.getLastName() + " Tel.: " +
////                disease.getTelephone() + " Email: " + disease.getEmail());
////        addDiseases(disease);
////       return ResponseEntity.ok().body(savedDisease);
////    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Disease> updateDisease(@PathVariable long id, @RequestBody Disease disease) {
//        Disease updatedDisease = diseaseService.updateDisease(id, disease);
//        return ResponseEntity.ok().body(updatedDisease);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteDisease(@PathVariable long id) {
//        diseaseService.deleteDisease(id);
//        return ResponseEntity.noContent().build();
//    }
//    public ModelAndView showDisease() {
//
//	 /*  Disease disease = new Disease();
//	   disease.setFirstName("rafal");
//	   disease.setLastName("kotas");
//	   disease.setEmail("rkotas@dmcs.pl");
//	   disease.setTelephone("123456789");*/
//
//	 return new ModelAndView("views/disease", "disease", new Disease());
//    }
//
//    @RequestMapping(value = "/diseases", method = RequestMethod.POST)
//    public String showDiseases(Model model, HttpServletRequest request) {
//        System.out.println("First Name: " + disease.getFirstName() +
//                " Last Name: " + disease.getLastName() + " Tel.: " +
//                disease.getTelephone() + " Email: " + disease.getEmail());
//        return "redirect:Disease.html";
//    }
//
//    @RequestMapping(value = "/diseases")
//    public String showDiseases(Model model, HttpServletRequest request) {
//        int diseaseId = ServletRequestUtils.getIntParameter(request, "diseaseId" , -1);
//        if (diseaseId > 0)
//            model.addAttribute("disease", diseaseService.getDiseaseById(diseaseId));
//        else
//            model.addAttribute("disease", new Disease());
//        model.addAttribute("diseaseList", diseaseService.getAllDiseases());
//        return "views/disease";
//    }
//
    @RequestMapping(value = "/addDisease", method = RequestMethod.POST)
    public String addDisease(@ModelAttribute("disease") Disease disease) {
        System.out.println("Name: " + disease.getName());
        if (disease.getDiseaseID()==0)
            diseaseService.addDisease(disease);
        else
            diseaseService.addDisease(disease);
        return "redirect:diseases.html";
    }
//
//    @RequestMapping("/delete/{diseaseId}")
//    public String deleteDisease(@PathVariable("diseaseId") Long diseaseId) {
//        diseaseService.deleteDisease(diseaseId);
//        return "redirect:/diseases.html";
//    }
}

