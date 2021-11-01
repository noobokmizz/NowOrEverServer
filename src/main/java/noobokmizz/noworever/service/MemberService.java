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
import noobokmizz.noworever.dto.Data;
import noobokmizz.noworever.dto.User;
import noobokmizz.noworever.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

// jpa 를 사용하려면 data 를 저장하거나 변경할때 항상 transactional 이 있어야함
// DB에 쿼리를 던진 후에 commit 을 해야 반영이 됨.
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /** 회원 가입 **/
    public String join(User.RequestSignUp request){

        try {
            validateDuplicateUser(request.getMem_userid());  // 중복된 회원이 있는지 검사
        }catch (Exception e){
            if(e.getMessage()=="이미 존재하는 id 입니다."){
                return e.getMessage();
            }
        }

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

        members.setBk_id(memberRepository.findMaxBkId().get(0).getBk_id()+1);
        members.setBk_name(request.getMem_username()+"의 버킷리스트");
        members.setBk_share(0);
        members.setBk_open_bucketlist(0);

        memberRepository.save(members); // 테이블에 새로운 멤버 정보 삽입

        return "1";
    }

    /** 로그인 **/
    public Data login(User.RequestLogin requestLogin){
        try {
            // 에러가 발생하지 않으면 로그인 성공
            Members members = memberRepository.findByIdAndPW(requestLogin.getMem_userid(), requestLogin.getMem_password())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회웝입니다."));

            Data data = new Data(
                    members.getMem_idnum(),
                    members.getMem_username(),
                    members.getMem_birthday(),
                    members.getMem_email(),
                    members.getMem_password(),
                    members.getBk_id(),
                    members.getBk_name()
            );
            return data;

        }catch (Exception e){
            throw e;
        }
    }

    /** 중복 회원 검증 **/
    private void validateDuplicateUser(String mem_userid){
        try {
            memberRepository.findById(mem_userid)
                    .ifPresent(u -> {
                        throw new IllegalStateException("이미 존재하는 id 입니다.");
                    });
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
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
