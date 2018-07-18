package com.github.umkamax.hoteladvisor.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;

    private List<Address> addresses = new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String middleName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddressList() {
        return Collections.unmodifiableList(addresses);
    }
    public void setAddressList(List<Address> addresses) {
        this.addresses = new ArrayList<>(addresses);
    }
    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
