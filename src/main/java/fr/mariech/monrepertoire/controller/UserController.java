package fr.mariech.monrepertoire.controller;

import fr.mariech.monrepertoire.entity.User;
import fr.mariech.monrepertoire.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String logUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        boolean userExists = service.checkUser(user);
        if (userExists) {
            request.getSession().setAttribute("login", user.getUserName());
            int id = service.findUserByUsername(user.getUserName()).getId();
            request.getSession().setAttribute("id", id);
            return "redirect:/contacts";
        } else {
            request.getSession().setAttribute("login", "bad-credentials");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user, Model model) {
        if (user.getPassword().equals(user.getConfirmation())) {
            service.saveUser(user);
        } else {
            model.addAttribute("validate", false);
        }
        return "index";
    }

    @GetMapping("/user")
    public String getContact(Model model, HttpServletRequest request) {
        return "user-details";
}

}
