package pl.dmcs.jwlodarczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RolePagesController {
    @RequestMapping(value = "/role/exampleOne")
    public String exampleOne() {
        return "views/exampleOne";
    }
}
