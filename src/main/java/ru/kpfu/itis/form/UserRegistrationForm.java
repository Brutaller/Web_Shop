package ru.kpfu.itis.form;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserRegistrationForm {

    @Size(min = 6, max = 24, message = "Password must be from 6 to 24 symbols")
    private String password;

    @NotEmpty(message = "Can't be empty")
    private String name;

    @NotEmpty(message = "Can't be empty")
    private String surname;

    @NotEmpty(message = "Can't be empty")
    private String postIndex;

    @NotEmpty(message = "Can't be empty")
    private String address;

    @NotEmpty(message = "Can't be empty")
    private String username;

    @Email(message = "Non valid e-mail")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
