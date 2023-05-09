package fr.mariech.monrepertoire.service;

import fr.mariech.monrepertoire.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;
}
