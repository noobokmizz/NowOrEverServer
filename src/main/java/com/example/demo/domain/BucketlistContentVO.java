package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//idnum이 필요하므로 MemberIDnumVO를 상속받아 사용
public class BucketlistContentVO extends MemberIDnumVO{
    private String lc_id; // 원하는 장소가 있는경우, 없으면 NULL
    private String cs_id;

}
