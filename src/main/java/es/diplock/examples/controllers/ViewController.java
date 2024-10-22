package es.diplock.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.diplock.examples.service.subcategory.SubcategoryServiceImpl;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ViewController {

    private final SubcategoryServiceImpl subcategoryService;
    
    @GetMapping
    public String getMainPage() {
        return "pages/index";
    }

    @GetMapping("/about")
    public String getAboutpage() {
        return "pages/about";
    }
    
}
