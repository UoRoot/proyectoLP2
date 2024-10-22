package es.diplock.examples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import es.diplock.examples.entities.User;
import es.diplock.examples.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService userService;

    @GetMapping("/login")
    public String getAuthPage(Model model) {
        model.addAttribute("user", new User());
        return "pages/auth";
    }
    
    @PostMapping("/login")
    public String postAuthLogin(@Valid @ModelAttribute User user, 
                              BindingResult result, 
                              HttpSession session,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "pages/auth";
        }
        
        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
        
        if (authenticatedUser == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid credentials");
            return "redirect:/auth/login";
        }
        
        // Guardar usuario en sesión
        session.setAttribute("authenticatedUser", authenticatedUser);
        
        // Redireccionar a la URL original o a /admin por defecto
        String redirectUrl = (String) session.getAttribute("redirectUrl");
        if (redirectUrl != null) {
            session.removeAttribute("redirectUrl");
            return "redirect:" + redirectUrl;
        }
        
        return "redirect:/admin";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}