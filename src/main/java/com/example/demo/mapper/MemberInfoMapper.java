package com.example.demo.mapper;
import com.example.demo.model.BucketlistContent;
import com.example.demo.model.LocationInfo;
import com.example.demo.model.MemberInfo;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

// Java의 method와 SQL 을 mapping 하는 걸 관리하고 보관할 mapper Package 의 Interface


//스프링부트가 이 interface 를 mapper 로 인식하기위한 Annotation
@Mapper
public interface MemberInfoMapper {

    //MemberInfoController 의 5가지 API 를 SQL문에 mapping할 mapper 생성

    @Select("SELECT * FROM User_unique WHERE mem_email=#{mem_email}") //이 API에 mapping할 sql문
    MemberInfo getMemberInfo(@Param("mem_email") String mem_email); //전달된 mem_email 로 DB 테이블에서 조회를해서 MemberInfo 라는 객체를 리턴하는 API

    @Select("SELECT * FROM User_unique")
    List<MemberInfo> getMemberInfoList();

    @Insert("INSERT INTO member VALUES(#{mem_id}, #{mem_name}, #{mem_age}, #{mem_email}, #{mem_address}, #{mem_password})")
    int insertMemberInfo(@Param("mem_id") int mem_id, @Param("mem_name") String mem_name, @Param("mem_age") int mem_age,  @Param("mem_email") String mem_email, @Param("mem_address") String mem_address, @Param("mem_password") String password);

    @Update("UPDATE member SET mem_email=#{mem_email}, mem_password=#{mem_password} WHERE mem_email=#{mem_email}")
    int updateMemberInfo(@Param("mem_email") String mem_email, @Param("mem_password") String password);

    @Delete("DELETE FROM member WHERE mem_email=#{mem_email}")
    int deleteMemberInfo(@Param("mem_email") String mem_email);
    //mapping한 sql문에 의해서 적용된(또는 영향을 받은) 데이터의 개수를 리턴하기 때문에 반환형이 integer

    //UI에 있는 /api/user/login API 구현해보기
    @Select("SELECT User_unique.mem_idnum, mem_username, mem_birthday, mem_email, mem_password FROM User_inform, User_unique WHERE User_unique.mem_userid=#{mem_userid} AND mem_password=#{mem_password} GROUP BY User_unique.mem_userid")
    MemberInfo getLoginMemberInfo(@Param("mem_userid") String mem_userid, @Param("mem_password") String mem_password);

    //UI에 있는 /api/user/register API 구현해보기

    // User_unique 테이블에 삽입
    @Insert("INSERT INTO User_unique VALUES(#{mem_idnum}, #{mem_userid}, #{mem_email}, #{mem_nickname}, #{mem_phone}, #{mem_sex}, #{mem_birthday}, #{mem_register_datetime}, #{mem_is_admin}, #{mem_following}, #{mem_followed})")
    int getRegisterUserUnique(@Param("mem_idnum") int mem_idnum, @Param("mem_userid") String mem_userid, @Param("mem_email") String mem_email, @Param("mem_nickname") String nickname, @Param("mem_phone") String mem_phone, @Param("mem_sex") Byte mem_sex, @Param("mem_birthday") String mem_birthday, @Param("mem_register_datetime") Timestamp mem_register_datetime, @Param("mem_is_admin") Byte mem_is_admin, @Param("mem_following") int mem_following, @Param("mem_followed") int mem_followed);

    // User_inform 테이블에 삽입
    @Insert("INSERT INTO User_inform VALUES(#{mem_password}, #{mem_profile_content}, #{mem_username}, #{mem_autologin}, #{mem_birthday_open}, #{mem_sex_open}, #{mem_receive_email}, #{mem_receive_sns}, #{mem_open_profile}, #{mem_noti_allow}, #{mem_denied}, #{mem_email_cert}, #{mem_lastlogin_datetime}, #{mem_adminmemo}, #{mem_photo}, #{mem_idnum}, #{mem_userid})")
    int getRegisterUserInform(@Param("mem_password") String mem_password, @Param("mem_profile_content") String mem_profile_content, @Param("mem_username") String mem_username,  @Param("mem_autologin") Byte mem_autologin, @Param("mem_birthday_open") Byte mem_birthday_open, @Param("mem_sex_open") Byte mem_sex_open, @Param("mem_receive_email") Byte mem_receive_email, @Param("mem_receive_sns") Byte mem_receive_sns, @Param("mem_open_profile") Byte mem_open_profile, @Param("mem_noti_allow") Byte mem_noti_allow, @Param("mem_denied") Byte mem_denied, @Param("mem_email_cert") Byte mem_email_cert, @Param("mem_lastlogin_datetime") Timestamp mem_lastlogin_datetime, @Param("mem_adminmemo") String mem_adminmemo, @Param("mem_photo") String mem_photo, @Param("mem_idnum") int mem_idnum, @Param("mem_userid") String mem_userid);

    // 아이디가 mem_idnum인 유저가 소유한 버킷리스트의 id 가져오기
    @Select("SELECT bk_id FROM Bucketlist WHERE mem_idnum=#{mem_idnum}")
    int getBucktlistID(@Param("mem_idnum") int mem_idnum);

    // Bucketlist내의 목록 가져오기
    @Select("SELECT lc_id FROM BucketlistCont WHERE bk_id=#{bk_id}")
    List<String> getBucketlistContentList(@Param("bk_id") int bk_id);

    // Location 테이블에서 lc_id에 해당하는 활동을 가져옴
    @Select("SELECT * FROM Location WHERE lc_id=#{lc_id}")
    LocationInfo getLocationInfo(@Param("lc_id") String lc_id);

}
