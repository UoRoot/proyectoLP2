package es.diplock.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.diplock.examples.dtos.product.SaveProductDTO;
import es.diplock.examples.repositories.BrandRepository;
import es.diplock.examples.repositories.ColorRepository;
import es.diplock.examples.repositories.SizeRepository;
import es.diplock.examples.repositories.SubcategoryRepository;
import es.diplock.examples.service.product.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductServiceImpl productServiceImpl;
    private final SizeRepository sizeRepository;
    private final ColorRepository colorRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final BrandRepository brandRepository;

    
    @GetMapping("/productos")
    public String getProductsPage() {
        return "pages/productos";
    }

    @GetMapping("/productos/crear")
    public String showProductForm(Model model) {
        model.addAttribute("saveProductDTO", new SaveProductDTO());
        model.addAttribute("sizes", sizeRepository.findAll());
        model.addAttribute("colors", colorRepository.findAll());
        model.addAttribute("subcategories", subcategoryRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "crud";
    }


    @PostMapping("/productos")
    public String saveProduct(@Valid @ModelAttribute SaveProductDTO saveProductDTO,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sizes", sizeRepository.findAll());
            model.addAttribute("colors", colorRepository.findAll());
            model.addAttribute("subcategories", subcategoryRepository.findAll());
            model.addAttribute("brands", brandRepository.findAll());
            return "crud";
        }

        productServiceImpl.saveProduct(saveProductDTO);
        return "redirect:/products";
    }
}
