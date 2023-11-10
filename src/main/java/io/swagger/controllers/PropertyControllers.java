package io.swagger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PropertyControllers {
    @GetMapping("/properties")
    public String getMainPage(){
        return "properties";
    }
}
