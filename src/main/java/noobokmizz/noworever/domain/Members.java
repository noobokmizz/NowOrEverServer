package noobokmizz.noworever.domain;

import lombok.*;
import noobokmizz.noworever.repository.MemberRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.sql.Timestamp;

@Data // getter setter 를 자동 생성 -> Data Annotaion 쓰지마!
@Getter
@Setter
@Entity
// Entity -> 실제 테이블과 매핑(변경시 다른 여러 클래스에 영향), DTO -> View 와 통신하며 자주 변경
// => Entity 와 DTO 를 분리해주어야 한다
// => 데이터를 전송하기위해 Entity 를 사용해도 되지만,정의된 필드 외에 추가적인 필드가 필요한 경우 DTO 객체를 따로 선언해서 사용
@IdClass(MemberId.class)
public class Members {
    @Id
    private int mem_idnum;
    @Id
    private String mem_userid;

    private String mem_email;
    private String mem_nickname;
    private String mem_phone;
    private int mem_sex;
    private String mem_birthday;
    private Timestamp mem_register_datetime;
    private String mem_is_admin;
    private int mem_following;
    private int mem_followed;
    private String mem_password;
    private String mem_profile_content;
    private String mem_username;
    private int mem_autologin;
    private int mem_birthday_open;
    private int mem_sex_open;
    private int mem_receive_email;
    private int mem_receive_sns;
    private int mem_open_profile;
    private int mem_noti_allow;
    private int mem_denied;
    private String mem_email_cert;
    private Timestamp mem_lastlogin_datetime;
    private String mem_adminmemo;
    private String mem_photo;
}
