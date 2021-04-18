package com.example.demo.model;
// model : 사용자 데이터(또는 어떤 데이터 형태)를 처리하기 위한 데이터에 해당하는 클래스
// 그러한 model 들을 담아두기위한 model 이라는 이름의 패키지를 생성
// 그안에 MemberInfo 라는 클래스 생성

import java.util.Random;

public class MemberInfo { // 강의에서 UserProfile 클래스
    private int mem_id;
    private String mem_email;
    private String mem_password;
    // 안드로이드 앱 개발에선 클래스의 멤버 변수를 public 으로 선언고 외부 클래스에서 바로 멤버변수로 접근하는 것이 일반적이지만
    // 서버 어플리케이션을 개발할때는 멤버 변수를 private 으로 선언하고 Getter,Setter 함수를 정의하는게 일반적인 관례

    public MemberInfo(String mem_email, String mem_password){
        super();
        long seed = System.nanoTime(); //난수 seed 설정
        Random rand = new Random(seed);
        this.mem_id = rand.nextInt(2147483646); //mem_id는 랜덤하게 생성
        this.mem_email = mem_email;
        this.mem_password = mem_password;
    }

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_email() {
        return mem_email;
    }

    public void setMem_email(String mem_email) {
        this.mem_email = mem_email;
    }

    public String getMem_password() {
        return mem_password;
    }

    public void setMem_password(String mem_password) {
        this.mem_password = mem_password;
    }
}
