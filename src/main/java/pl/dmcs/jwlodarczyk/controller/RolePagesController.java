package pl.dmcs.jwlodarczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RolePagesController {
    @RequestMapping(value = "/exampleOne")
    public String exampleOne() {
        return "views/exampleOne";
    }
    @RequestMapping(value = "/exampleTwo")
    public String exampleTwo() {
        return "views/exampleTwo";
    }
    @RequestMapping(value = "/exampleThree")
    public String exampleThree() {
        return "views/exampleThree";
    }
}
