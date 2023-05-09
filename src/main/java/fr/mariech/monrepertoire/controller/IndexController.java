package fr.mariech.monrepertoire.controller;

import fr.mariech.monrepertoire.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
