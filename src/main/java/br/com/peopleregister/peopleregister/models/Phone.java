package br.com.peopleregister.peopleregister.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="phone")
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    private String ddd;
    private String number;

    public Phone(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public Phone() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
