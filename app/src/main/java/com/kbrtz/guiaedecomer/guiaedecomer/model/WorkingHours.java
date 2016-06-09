package com.kbrtz.guiaedecomer.guiaedecomer.model;

import java.util.Date;

/**
 * Created by kamila.brito on 07/06/2016.
 */
public class WorkingHours {

    private int id;
    private String hours;
    private String week_day;

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}