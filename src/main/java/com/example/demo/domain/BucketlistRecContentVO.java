package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BucketlistRecContentVO extends MemberIDnumVO {
    private String cur_x;
    private String cur_y;
}
