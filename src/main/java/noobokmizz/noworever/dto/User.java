package noobokmizz.noworever.dto;

//inner class 로 DTO 를 구현 및 관리하면 더 깔끔한 패키지를 만들고, DTO ClassName 을 정하는게 수월해짐

import lombok.Getter;
import lombok.Setter;

/** 귀찮아서 Over-Fetching 을 하지 말자! https://velog.io/@p4rksh **/
public class User {

    @Getter
    @Setter
    public static class Info {
        private String mem_userid;
        private String mem_email;
        private String mem_nickname;
        private String mem_phone;
        private int mem_sex;
        private String mem_birthday;
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
        private String mem_email_cert;
        private String mem_photo;
    }

    @Getter
    @Setter
    public static class RequestLogin {
        private String mem_userid;
        private String mem_password;
    }

    @Getter
    @Setter
    public static class RequestSignUp {
        private String mem_userid;
        private String mem_email;
        private String mem_nickname;
        private String mem_phone;
        private int mem_sex;
        private String mem_birthday;
        private String mem_password;
        private String mem_profile_content;
        private String mem_username;
        private int mem_autologin;
    }

    @Getter
    @Setter
    public static class Response {
        private Info info;
        private int returnCode;
        private String returnMessage;
    }
}
