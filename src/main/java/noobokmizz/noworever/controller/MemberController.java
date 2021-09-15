package noobokmizz.noworever.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import noobokmizz.noworever.domain.Members;
import noobokmizz.noworever.dto.DefaultResponse;
import noobokmizz.noworever.dto.User;
import noobokmizz.noworever.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    /** 회원가입 api **/
    @PostMapping("/user/register")
    public String signupMemberInfo(@RequestBody User.RequestSignUp requestSignUp) throws JsonProcessingException {
        memberService.join(requestSignUp); // 회원가입 서비스 실행
        // 에외처리 구현하기
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(new DefaultResponse(1));
    }

    /** 로그인 api **/
    @PostMapping("/user/login")
    public String loginMemberInfo(@RequestBody User.RequestLogin requestLogin){
         memberService.login(requestLogin);
         return "";
    }

    /** id 로 user 찾는 api **/
    @GetMapping("/user/{mem_userid}")
    public Optional<Members> getMemberInfo(@PathVariable("mem_userid") String mem_userid){
       Optional<Members> members = memberService.findOne(mem_userid);
       return members;
    }

    /** 전체 User 목록 반환 api **/
    @GetMapping("/user/all")
    public List<Members> getMemberInfoList(){
        List<Members> members = memberService.findMembers();
        return members;
    }
}
