package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BucketlistRecContentVO extends MemberIDnumVO {
    private float cur_x;
    private float cur_y;
}
