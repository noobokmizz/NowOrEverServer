package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BucketlistRecContentVO extends MemberIDnumVO {
    private double cur_x;
    private double cur_y;
}
