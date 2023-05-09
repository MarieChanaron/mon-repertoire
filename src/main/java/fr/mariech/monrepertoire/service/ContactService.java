package fr.mariech.monrepertoire.service;

import fr.mariech.monrepertoire.entity.Contact;
import fr.mariech.monrepertoire.entity.Job;
import fr.mariech.monrepertoire.entity.User;
import fr.mariech.monrepertoire.repository.ContactJdbcRepository;
import fr.mariech.monrepertoire.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactJdbcRepository jdbcRepository;

    public List<Contact> fetchUserContacts(User user) {
        List<Contact> contacts = jdbcRepository.fetchByUser(user);
        for (Contact contact : contacts) {
            Job job = new Job("position", "company"); // for the test
            //Job job = jdbcRepository.fetchJob(contact.getId());
            contact.setJob(job);
        }
        return contacts;
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }
}
