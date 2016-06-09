package com.kbrtz.guiaedecomer.guiaedecomer.model;

import java.sql.Blob;
import java.util.List;

/**
 * Created by kamila.brito on 07/06/2016.
 */
public class Restaurant {

    private int id;
    private List <WorkingHours> working_hours;
    private List <Specials> specials;
    private Contact contact;
    private String name;
    private Blob header_photo;
    private String address;

    public List<WorkingHours> getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(List<WorkingHours> working_hours) {
        this.working_hours = working_hours;
    }

    public List<Specials> getSpecials() {
        return specials;
    }

    public void setSpecials(List<Specials> specials) {
        this.specials = specials;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getHeader_photo() {
        return header_photo;
    }

    public void setHeader_photo(Blob header_photo) {
        this.header_photo = header_photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
