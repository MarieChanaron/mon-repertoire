package fr.mariech.monrepertoire.controller;

import fr.mariech.monrepertoire.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("id") != null) {
            return "redirect:/contacts";
        } else {
            model.addAttribute("user", new User());
            return "index";
        }
    }
}
