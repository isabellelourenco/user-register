package br.com.peopleregister.peopleregister.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "user")
    private List<Phone> phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhoneList() {
        return phone;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phone = phoneList;
    }
}
