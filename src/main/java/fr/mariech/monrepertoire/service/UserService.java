package fr.mariech.monrepertoire.service;

import fr.mariech.monrepertoire.entity.User;
import fr.mariech.monrepertoire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        User userInserted = repository.save(user);
        return userInserted;
    }
}
