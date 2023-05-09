package fr.mariech.monrepertoire.repository;

import fr.mariech.monrepertoire.entity.Contact;
import fr.mariech.monrepertoire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT c FROM Contact c WHERE c.user.id = ?1")
    List<Contact> findAllByUser(User user);
}
