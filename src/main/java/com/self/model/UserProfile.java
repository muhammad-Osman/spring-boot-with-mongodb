package com.self.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "user_profile")
public class UserProfile {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String phoneNumber;
    private String address;
    private String city;
    private String country;

    public UserProfile() {
    }

    public UserProfile(String id, String phoneNumber, String address, String city, String country) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
