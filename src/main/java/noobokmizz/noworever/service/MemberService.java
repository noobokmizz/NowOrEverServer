/**
 * 원할한 유지보수와 커뮤니케이션을 위해,
 * Service Class 는 비즈니스에 가까운 용어를 써야함(비즈니스 의존성)
 *                      vs
 * Repository 는 더 개발스러운 용어들을 선택(데이터를 push, pop ...)
 *
 * 각자 역할에 맞게 네이밍 하는것이 중요!!
 */

package noobokmizz.noworever.service;

import noobokmizz.noworever.domain.Members;
import noobokmizz.noworever.dto.DefaultResponse;
import noobokmizz.noworever.dto.User;
import noobokmizz.noworever.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /** 회원 가입 **/
    public String join(User.RequestSignUp request){
        Members members = new Members();

        // column 값 설정 설정
        members.setMem_userid(request.getMem_userid());
        members.setMem_email(request.getMem_email());
        members.setMem_nickname(request.getMem_nickname());
        members.setMem_phone(request.getMem_phone());
        members.setMem_sex(request.getMem_sex());
        members.setMem_birthday(request.getMem_birthday());
        members.setMem_register_datetime(new Timestamp(System.currentTimeMillis())); // 현재 시간 삽입
        members.setMem_is_admin("not admin");
        members.setMem_following(0);
        members.setMem_followed(0);
        members.setMem_password(request.getMem_password());
        members.setMem_profile_content("nothing");
        members.setMem_username(request.getMem_username());
        members.setMem_autologin(request.getMem_autologin());

        members.setMem_birthday_open(1);
        members.setMem_sex_open(1);
        members.setMem_receive_email(1);
        members.setMem_receive_sns(1);
        members.setMem_open_profile(1);
        members.setMem_noti_allow(1);
        members.setMem_denied(1);
        members.setMem_email_cert("x");
        members.setMem_lastlogin_datetime(new Timestamp(System.currentTimeMillis())); // 현재 시간 삽입
        members.setMem_adminmemo("admin memo~");
        members.setMem_photo("no path");

        validateDuplicateUser(members);  // 중복된 회원이 있는지 검사
        // 회원가입 실패하는 예외 처리는 어떻게하지???

        memberRepository.save(members); // 테이블에 새로운 멤버 정보 삽입
       return members.getMem_userid();
    }

    /** 로그인 **/
    public Optional<DefaultResponse.Data> login(User.RequestLogin requestLogin){
        memberRepository.findByLoginId(requestLogin.getMem_userid(), requestLogin.getMem_password())
                .ifPresentOrElse(
                        (members -> {
                            DefaultResponse.Data data = new DefaultResponse.Data(
                                    members.getMem_idnum(),
                                    members.getMem_username(),
                                    members.getMem_birthday(),
                                    members.getMem_email(),
                                    members.getMem_password());
                            Optional.of(data);
                        }),
                        () -> {

                        })
    }


    /** 중복 회원 검증 **/
    private void validateDuplicateUser(Members members){
        memberRepository.findById(members.getMem_userid())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 id 입니다.");
                });
    }

    /** 전체 회원 조회 **/
    public List<Members> findMembers(){
        return memberRepository.findAll();
    }

    /** 특정 회원 조회 **/
    public Optional<Members> findOne(String userId){
        return memberRepository.findById(userId);
    }
}
