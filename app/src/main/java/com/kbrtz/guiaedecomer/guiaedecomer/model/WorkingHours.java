package com.kbrtz.guiaedecomer.guiaedecomer.model;

/**
 * Created by kamila.brito on 07/06/2016.
 */
public class WorkingHours {

    private int id;
    private String start_hour;
    private String finish_hour;
    private String week_day;

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public String getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFinish_hour() {
        return finish_hour;
    }

    public void setFinish_hour(String finish_hour) {
        this.finish_hour = finish_hour;
    }
}