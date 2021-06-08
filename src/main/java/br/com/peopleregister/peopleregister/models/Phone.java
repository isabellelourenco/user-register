package br.com.peopleregister.peopleregister.models;

import javax.persistence.*;

@Entity
@Table(name="phone")
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    private String ddd;
    private String number;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
