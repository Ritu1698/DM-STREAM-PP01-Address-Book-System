package com.bl.javastreams;

public class Contact {

    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String number;
    public String email;
    public Contact(String firstname, String lastname, String address, String city, String state, String zip, String number,
                   String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.number = number;
        this.email = email;
    }

    public Contact() {

    }

    public String getFirstname() {
        return firstname;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address book");
    }





}