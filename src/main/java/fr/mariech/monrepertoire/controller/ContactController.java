package fr.mariech.monrepertoire.controller;

import fr.mariech.monrepertoire.entity.Contact;
import fr.mariech.monrepertoire.entity.User;
import fr.mariech.monrepertoire.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    public String contacts(Model model, HttpServletRequest request) {
        int userId = (Integer) request.getSession().getAttribute("id");
        User user = new User();
        user.setId(userId);
        List<Contact> contactList = service.fetchUserContacts(user);
        user.setContactList(contactList);
        model.addAttribute("contacts", user.getContactList());
        return "contacts";
    }

    @GetMapping("/add-contact")
    public String contactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add-contact";
    }

    @PostMapping("/add-contact")
    public String saveContact(@ModelAttribute Contact contact, Model model, HttpServletRequest request) {
        int userId = (Integer) request.getSession().getAttribute("id");
        User user = new User();
        user.setId(userId);
        contact.setUser(user);
        service.saveContact(contact);
        return "redirect:/contacts";
    }
}
