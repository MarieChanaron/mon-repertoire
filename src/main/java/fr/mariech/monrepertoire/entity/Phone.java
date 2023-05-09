package fr.mariech.monrepertoire.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone")
    private Integer id;

    @Column(name = "professional_mobile_phone")
    private String professionalMobilePhone;

    @Column(name = "professional_landline_phone")
    private String professionalLandlinePhone;

    @Column(name = "personal_mobile_phone")
    private String personalMobilePhone;

    @Column(name = "personal_landline_phone")
    private String personalLandlinePhone;

    /*
    @ManyToOne
    @JoinColumn(name = "contact", referencedColumnName = "id_contact")
    private Contact contact;
     */

    // getters and setters

    public Phone() {
    }

    public Phone(Integer id, String professionalMobilePhone, String professionalLandlinePhone, String personalMobilePhone, String personalLandlinePhone) {
        this.id = id;
        this.professionalMobilePhone = professionalMobilePhone;
        this.professionalLandlinePhone = professionalLandlinePhone;
        this.personalMobilePhone = personalMobilePhone;
        this.personalLandlinePhone = personalLandlinePhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessionalMobilePhone() {
        return professionalMobilePhone;
    }

    public void setProfessionalMobilePhone(String professionalMobilePhone) {
        this.professionalMobilePhone = professionalMobilePhone;
    }

    public String getProfessionalLandlinePhone() {
        return professionalLandlinePhone;
    }

    public void setProfessionalLandlinePhone(String professionalLandlinePhone) {
        this.professionalLandlinePhone = professionalLandlinePhone;
    }

    public String getPersonalMobilePhone() {
        return personalMobilePhone;
    }

    public void setPersonalMobilePhone(String personalMobilePhone) {
        this.personalMobilePhone = personalMobilePhone;
    }

    public String getPersonalLandlinePhone() {
        return personalLandlinePhone;
    }

    public void setPersonalLandlinePhone(String personalLandlinePhone) {
        this.personalLandlinePhone = personalLandlinePhone;
    }

}