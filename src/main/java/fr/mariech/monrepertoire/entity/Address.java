package fr.mariech.monrepertoire.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private int id;

    @Column(name = "street_address_1")
    private String streetAddress1;

    @Column(name = "street_address_2")
    private String streetAddress2;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "po_box")
    private String poBox;

    @Column(name = "country")
    private String country;

    @ManyToMany(mappedBy = "addresses")
    private List<Contact> contacts = new ArrayList<>();

    //Constructeurs, getters, setters


    public Address() {
    }

    public Address(int id, String streetAddress1, String streetAddress2, String postcode, String city, String region, String poBox, String country) {
        this.id = id;
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.postcode = postcode;
        this.city = city;
        this.region = region;
        this.poBox = poBox;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

