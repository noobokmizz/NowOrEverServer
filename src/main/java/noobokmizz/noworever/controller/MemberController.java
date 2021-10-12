package noobokmizz.noworever.controller;

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
    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    @ResponseBody  // http의 응답 body부에 이 데이터를 직접 넣겠다(api를 통해 데이터를 바로 내리겠다).
    public DefaultResponse signupMemberInfo(@RequestBody User.RequestSignUp requestSignUp) {
        return new DefaultResponse(memberService.join(requestSignUp));
    }

    /** 로그인 api **/
    @PostMapping("/user/login")
    @ResponseBody  // http의 응답 body부에 이 데이터를 직접 넣겠다(api를 통해 데이터를 바로 내리겠다).
    public DefaultResponse.ResponseLoginUser loginMemberInfo(@RequestBody User.RequestLogin requestLogin){
        DefaultResponse.ResponseLoginUser responseLogin = new DefaultResponse.ResponseLoginUser(0, null, "");
        try {
            responseLogin.setData(memberService.login(requestLogin));
            responseLogin.setStatus(1);
        }catch (Exception e){
            responseLogin.setMsg("No UserId / Password Found");
        }finally {
            return responseLogin;
        }
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
