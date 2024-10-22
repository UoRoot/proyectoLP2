package es.diplock.examples.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.diplock.examples.dtos.product.ProductDTO;
import es.diplock.examples.dtos.product.ProductSearchCriteriaDTO;
import es.diplock.examples.entities.Category;
import es.diplock.examples.repositories.CategoryRepository;
import es.diplock.examples.service.product.ProductServiceImpl;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class ViewController {

    private final CategoryRepository categoryRepository;
    private final ProductServiceImpl productServiceImpl;

    @GetMapping
    public String getMainPage(Model model) {
        Page<ProductDTO> products = productServiceImpl.findAllProducts(new ProductSearchCriteriaDTO());
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "pages/index";
    }

}
