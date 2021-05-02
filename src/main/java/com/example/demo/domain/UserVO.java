package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getter, setter를 자동생성해주는 어노테이션
@AllArgsConstructor // 생성자를 자동 생성해주는 어노테이션
public class UserVO { // 전달받은 json을 담을 클래스
    private String mem_email;
    private String mem_password;
}

