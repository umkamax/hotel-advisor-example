package com.github.umkamax.hoteladvisor.model;

public class Address {
    private String zipcode;
    private String city;
    private String street;
    private String building;
    private String appartment;

    public Address(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public Address(String zipcode, String city, String street, String building, String appartment) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.building = building;
        this.appartment = appartment;
    }

    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAppartment() {
        return appartment;
    }
    public void setAppartment(String apartment) {
        this.appartment = appartment;
    }

}
