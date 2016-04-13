package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
public class OrderForm {

    @NotEmpty(message = "Can't be empty")
    private String name;

    @NotEmpty(message = "Can't be empty")
    private String surname;

    @NotEmpty(message = "Can't be empty")
    private String postIndex;

    @NotEmpty(message = "Can't be empty")
    private String address;

    @Email(message = "Non valid e-mail")
    private String email;

    @Pattern(regexp = "[\\+7|8][8|9][0-9]{9}", message = "Non valid number")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
