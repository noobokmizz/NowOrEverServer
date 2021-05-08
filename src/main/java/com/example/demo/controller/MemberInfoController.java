package com.example.demo.controller;
// controller : client app 의 API 요청을 처리하는 것

import com.example.demo.domain.SignupVO;
import com.example.demo.domain.UserVO;
import com.example.demo.mapper.MemberInfoMapper;
import com.example.demo.model.MemberInfo;
import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.lang.reflect.Member;
import java.util.*;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//Spring Framework 는 annotation 기반
//RestController 라는 annotation 을 선언하여 Spring Framework 이 알아서 이 클래스를 Controller 로 인식

@RestController
@Log
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
    public void postMemberInfo(@PathVariable("mem_email") String mem_email, @RequestParam("mem_name") String mem_name, @RequestParam("mem_age") int mem_age, @RequestParam("mem_address") String mem_address, @RequestParam("mem_password") String mem_password){
        long seed = System.nanoTime(); //난수 seed 설정
        Random rand = new Random(seed);
        int mem_id = rand.nextInt(2147483646); //mem_id는 랜덤하게 생성
        mapper.insertMemberInfo(mem_id, mem_name, mem_age ,mem_email, mem_address ,mem_password);
    }

    @PutMapping("/user/{mem_email}") //데이터를 수정하는 API
    public void putMemberInfo(@PathVariable("mem_email") String mem_email, @RequestParam("mem_password") String mem_password){
        mapper.updateMemberInfo(mem_email, mem_password);
    }

    @DeleteMapping("/user/{mem_email}") //데이터를 삭제할 API
    public void deleteMemberInfo(@PathVariable("mem_email") String mem_email){
        mapper.deleteMemberInfo(mem_email);
    }

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public JSONObject getLoginMemberInfo(@RequestBody UserVO userVO){
        System.out.println(userVO);
        System.out.print("mem_email : ");
        System.out.println(userVO.getMem_email());
        System.out.print("mem_password : ");
        System.out.println(userVO.getMem_password());
        MemberInfo memberInfo = mapper.getLoginMemberInfo(userVO.getMem_email(), userVO.getMem_password());
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();

        if (memberInfo == null){ //존재하지 않는 email 을 입력했을때
            jsonObject.put("status", 0);
            jsonObject.put("data",data);
            jsonObject.put("msg","No UserId / Password Found");

            return jsonObject;
        }


        jsonObject.put("status", 1); //status pair 만드는 부분

        data.put("name", memberInfo.getMem_name());
        data.put("age", memberInfo.getMem_age());
        data.put("email", memberInfo.getMem_email());
        data.put("address", memberInfo.getMem_address());
        data.put("password", memberInfo.getMem_password());

        //JSONArray req_array = new JSONArray();
        //req_array.add(data); // <String,Array> 이므로 JSONArray 이용
        jsonObject.put("data", data); //member pair 만드는 부분

        jsonObject.put("msg",""); //msg pair 만드는 부분

        return jsonObject; //json 리턴
    }

    @RequestMapping(value = "/api/user/register", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public JSONObject getSignupMemberInfo(@RequestBody SignupVO signupVO){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 1);

        System.out.println(signupVO.getMem_email());
        long seed = System.nanoTime(); //난수 seed 설정
        Random rand = new Random(seed);
        int mem_id = rand.nextInt(2147483646); //mem_id는 랜덤하게 생성
        String mem_address = "temporarily address";
        mapper.getRegisterMemberInfo(mem_id, signupVO.getMem_name(), signupVO.getMem_age(), signupVO.getMem_email(), mem_address, signupVO.getMem_password());

        return jsonObject;
    }
}