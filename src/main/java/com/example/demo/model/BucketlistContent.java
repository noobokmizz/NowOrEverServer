package com.example.demo.model;

import lombok.Data;
import lombok.Getter;

import java.util.Random;

@Data
@Getter
public class BucketlistContent {
    // BucketlistContent의 칼럼을 그대로 매핑
    private int bk_id; // 버킷리스트 id
    private String cs_id; // 버킷리스트 내의 속한 활동의 분류
    private String lc_id; // 버킷리스트 내의 활동의 id
    private int mem_idnum; // 해당 버킷리스트를 소유한 회읜의 id

    public BucketlistContent (int bk_id, String cs_id, String lc_id, int mem_idnum) {
        super();
        long seed = System.nanoTime(); //난수 seed 설정
        Random rand = new Random(seed);
        this.bk_id = bk_id;
        this.cs_id = cs_id;
        this.lc_id = lc_id;
        this.mem_idnum = mem_idnum;
    }

    public int getBk_id() {
        return bk_id;
    }

    public void setBk_id(int bk_id) {
        this.bk_id = bk_id;
    }

    public String getCs_id() {
        return cs_id;
    }

    public void setCs_id(String cs_id) {
        this.cs_id = cs_id;
    }

    public String getLc_id() {
        return lc_id;
    }

    public void setLc_id(String lc_id) {
        this.lc_id = lc_id;
    }

    public int getMem_idnum() {
        return mem_idnum;
    }

    public void setMem_idnum(int mem_idnum) {
        this.mem_idnum = mem_idnum;
    }
}
