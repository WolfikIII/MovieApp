package com.example.movieapp.entities;

import javax.persistence.*;

@Entity
@Table(name="Uzytkownik")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Login", length = 100, nullable = false, unique = true)
    private String login;
    @Column(name="Hasło", length = 100, nullable = false)
    private String password;
    @Column(name="Email", length = 100, nullable = false, unique = true)
    private String email;
    public UserEntity (long id, String login, String password, String email){
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public UserEntity(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
