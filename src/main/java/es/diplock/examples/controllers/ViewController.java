package es.diplock.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
// @RequestMapping("/")
public class ViewController {
    
    @GetMapping
    public String getMethodName() {
        return "pages/index";
    }

    @GetMapping("/about")
    public String getMethodName(@RequestParam(required = false) String param) {
        if (param == null) return "about";
        return "pages/about";
    }
    
}
