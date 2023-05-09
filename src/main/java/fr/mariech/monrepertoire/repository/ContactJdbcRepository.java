package fr.mariech.monrepertoire.repository;

import fr.mariech.monrepertoire.entity.Contact;
import fr.mariech.monrepertoire.entity.Job;
import fr.mariech.monrepertoire.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ContactJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final class ContactMapper implements RowMapper<Contact> {
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getInt("id_contact"));
            contact.setTitle(rs.getString("title"));
            contact.setFirstName(rs.getString("firstname"));
            contact.setLastName(rs.getString("lastname"));
            return contact;
        }
    }

    /*
    public List<Contact> fetchByUser(User user) {
        List<Contact> contacts = new ArrayList<>();
        String sqlQuery = "SELECT * FROM `db-repertoire`.contact WHERE user = ?;";
        ContactMapper contactMapper = new ContactMapper();
        contacts = this.jdbcTemplate.query(sqlQuery, contactMapper, user.getId());
        return contacts;
    }
     */

    /*
    public List<Contact> fetchByUser(User user) {
        String sqlQuery = "SELECT id_contact, title, firstname, lastname FROM `db-repertoire`.contact WHERE user = 7";
        Stream<Contact> stream = jdbcTemplate.queryForStream(sqlQuery, (rs, rowNum) ->
                new Contact(
                    rs.getInt("id_contact"),
                    rs.getString("title"),
                    rs.getString("firstname"),
                    rs.getString("lastname")
                ));
        return stream.collect(Collectors.toList());
    }
     */

    public List<Contact> fetchByUser(User user) {
        String sqlQuery = "SELECT id_contact, title, firstname, lastname FROM `db-repertoire`.contact WHERE user = ?";
        List<Contact> contacts = new ArrayList<>();
        try (Stream<Contact> stream = this.jdbcTemplate.queryForStream(sqlQuery, new ContactMapper(), user.getId());) {
            contacts = stream.collect(Collectors.toList());
        }
        return contacts;
    }

}
