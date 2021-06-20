package com.example.demo.model;

import java.util.Random;

public class LocationInfo {
    private String lc_id;
    private String lc_name;
    private String lc_addr;
    private String lc_addr_road;
    private String lc_x;
    private String lc_y;
    private String lc_photo;
    private String lc_call_number;
    private String lc_url;
    private String cs_activity;

    public LocationInfo(String lc_id, String lc_name, String lc_addr, String lc_addr_road, String lc_x, String lc_y, String lc_photo, String lc_call_number, String lc_url, String cs_activity) {
        this.lc_id = lc_id;
        this.lc_name = lc_name;
        this.lc_addr = lc_addr;
        this.lc_addr_road = lc_addr_road;
        this.lc_x = lc_x;
        this.lc_y = lc_y;
        this.lc_photo = lc_photo;
        this.lc_call_number = lc_call_number;
        this.lc_url = lc_url;
        this.cs_activity = cs_activity;
    }

    public String getLc_id() {
        return lc_id;
    }

    public String getLc_name() {
        return lc_name;
    }

    public String getLc_addr() {
        return lc_addr;
    }

    public String getLc_addr_road() {
        return lc_addr_road;
    }

    public String getLc_x() {
        return lc_x;
    }

    public String getLc_y() {
        return lc_y;
    }

    public String getLc_photo() {
        return lc_photo;
    }

    public String getLc_call_number() {
        return lc_call_number;
    }

    public String getLc_url() {
        return lc_url;
    }

    public String getCs_activity() {
        return cs_activity;
    }
}
