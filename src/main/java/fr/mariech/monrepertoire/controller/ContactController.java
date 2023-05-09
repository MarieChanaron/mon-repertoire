package fr.mariech.monrepertoire.controller;

import fr.mariech.monrepertoire.entity.Contact;
import fr.mariech.monrepertoire.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("contacts", new ArrayList<Contact>());
        return "contacts";
    }
}
