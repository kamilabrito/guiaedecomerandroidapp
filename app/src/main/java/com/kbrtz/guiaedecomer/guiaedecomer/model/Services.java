package com.kbrtz.guiaedecomer.guiaedecomer.model;

/**
 * Created by kamila.brito on 07/06/2016.
 */
public class Services {

    private int id;
    private boolean free;
    private String name;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
