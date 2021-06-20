package com.example.demo.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CategoryList {
    private String cs_id;
    private String cs_activity;
    private String cs_attr1;
    private String cl_activity;
    private String cm_activity;

    public CategoryList(String cs_id, String cs_activity, String cs_attr1, String cl_activity, String cm_activity) {
        this.cs_id = cs_id;
        this.cs_activity = cs_activity;
        this.cs_attr1 = cs_attr1;
        this.cl_activity = cl_activity;
        this.cm_activity = cm_activity;
    }

    public String getCs_id() {
        return cs_id;
    }

    public String getCs_activity() {
        return cs_activity;
    }

    public String getCs_attr1() {
        return cs_attr1;
    }

    public String getCl_activity() {
        return cl_activity;
    }

    public String getCm_activity() {
        return cm_activity;
    }
}

