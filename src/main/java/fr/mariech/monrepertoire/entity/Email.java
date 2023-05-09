package fr.mariech.monrepertoire.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_email")
    private int id;

    @ManyToOne
    @JoinColumn(name = "professional_email")
    private Contact professionalEmail;

    @ManyToOne
    @JoinColumn(name = "personal_email")
    private Contact personalEmail;

    //Constructeurs, getters, setters

    public Email() {
    }

    public Email(int id, Contact professionalEmail, Contact personalEmail) {
        this.id = id;
        this.professionalEmail = professionalEmail;
        this.personalEmail = personalEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getProfessionalEmail() {
        return professionalEmail;
    }

    public void setProfessionalEmail(Contact professionalEmail) {
        this.professionalEmail = professionalEmail;
    }

    public Contact getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(Contact personalEmail) {
        this.personalEmail = personalEmail;
    }
}

