package com.example.demo;

import javax.validation.constraints.*;

public class Customer {
    private String id;
    @NotNull(message="Name is a required field")
    @NotBlank(message="Name cannot be blank")
    private String name;
    @Email(message="Enter a valid E-mail Id")
    private String mail_id;
    @ContactNumberConstraint
    private String number;

    public Customer(String name, String mail_id) {
        this.id=Integer.toString(CustomerService.count);
        this.name=name;
        this.mail_id = mail_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
