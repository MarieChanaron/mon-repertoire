package fr.mariech.monrepertoire.service;

import fr.mariech.monrepertoire.entity.User;
import fr.mariech.monrepertoire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.caseSensitive;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        User userInserted = repository.save(user);
        return userInserted;
    }

    ExampleMatcher modelMatcher = ExampleMatcher.matching()
            .withIgnorePaths("id")
            .withMatcher("model", caseSensitive());

    public boolean checkUser(User user) {
        Example<User> valuesToCheck = Example.of(user, modelMatcher);
        boolean exists = repository.exists(valuesToCheck);
        return exists;
    }
}
