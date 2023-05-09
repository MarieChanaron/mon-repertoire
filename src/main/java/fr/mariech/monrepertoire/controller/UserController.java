package fr.mariech.monrepertoire.controller;

import fr.mariech.monrepertoire.entity.User;
import fr.mariech.monrepertoire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user, Model model) {
        if (user.getPassword().equals(user.getConfirmation())) {
            service.saveUser(user);
        } else {
            model.addAttribute("validate", false);
        }
        return "index";
    }

}
