package com.example.demo.controller;
// controller : client app 의 API 요청을 처리하는 것

import com.example.demo.mapper.MemberInfoMapper;
import com.example.demo.model.MemberInfo;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

//Spring Framework 는 annotation 기반
//RestController 라는 annotation 을 선언하여 Spring Framework 이 알아서 이 클래스를 Controller 로 인식

@RestController
public class MemberInfoController { //강의에서 UserProfileController 클래스

    private MemberInfoMapper mapper;

    public MemberInfoController(MemberInfoMapper mapper){
        this.mapper = mapper;
        //MeberInfoConroller 생성자의 parameter를 MemberInfoMapper로 받겠다고 선언
        //스프링부트가 알아서 Mapper class를 만들고 그 객체를 MeberInfoController를 생성하면서 생서자로 전달달
   }

    //mem_email을 인자로 받아서 해당 데이터를 json 형태로 전달하는 API 생성
    @GetMapping("/user/{mem_email}") //API path 안에 있는 변수(중괄호 사이에 있는)를 이용
    public MemberInfo getMemberInfo(@PathVariable("mem_email") String mem_email){ //PathVariable Annotation 를 이용하여 전달할 변수를 알려줌
        return mapper.getMemberInfo(mem_email);
        //이 api 를 호출하면 MemberInfoMapper Interface 의 해당하는 함수를 호출하고 매핑된 SQL 문이 수행되서 해당되는 Data 를 MemberInfo 객체로 다시 반환
        //반환되는 java 객체를 json 형태로 전달
    }

    @GetMapping("/user/all")
    public List<MemberInfo> getMemberInfoList(){
        //return new ArrayList<MemberInfo>(memberMap.values());
        return mapper.getMemberInfoList();
    }

    //path 에는 대게 한가지~두가지 Parameter 사용하고,
    //RequestParam 이라는 Annotation 으로 http protocol parameter 로 데이터를 전송하는게 일반적
    @PostMapping("/user/{mem_email}") //데이터를 생성하는 API
    public void postMemberInfo(@PathVariable("mem_email") String mem_email, @RequestParam("mem_password") String mem_password){
        long seed = System.nanoTime(); //난수 seed 설정
        Random rand = new Random(seed);
        int mem_id = rand.nextInt(2147483646); //mem_id는 랜덤하게 생성
        mapper.insertMemberInfo(mem_id, mem_email, mem_password);
    }

    @PutMapping("/user/{mem_email}") //데이터를 수정하는 API
    public void putMemberInfo(@PathVariable("mem_email") String mem_email, @RequestParam("mem_password") String mem_password){
        mapper.updateMemberInfo(mem_email, mem_password);
    }

    @DeleteMapping("/user/{mem_email}") //데이터를 삭제할 API
    public void deleteMemberInfo(@PathVariable("mem_email") String mem_email){
        mapper.deleteMemberInfo(mem_email);
    }
}
