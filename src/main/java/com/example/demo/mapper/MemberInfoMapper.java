package com.example.demo.mapper;
import com.example.demo.model.MemberInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Java의 method와 SQL 을 mapping 하는 걸 관리하고 보관할 mapper Package 의 Interface


//스프링부트가 이 interface 를 mapper 로 인식하기위한 Annotation
@Mapper
public interface MemberInfoMapper {

    //MemberInfoController 의 5가지 API 를 SQL문에 mapping할 mapper 생성

    @Select("SELECT * FROM member WHERE mem_email=#{mem_email}") //이 API에 mapping할 sql문
    MemberInfo getMemberInfo(@Param("mem_email") String mem_email); //전달된 mem_email 로 DB 테이블에서 조회를해서 MemberInfo 라는 객체를 리턴하는 API

    @Select("SELECT * FROM member")
    List<MemberInfo> getMemberInfoList();

    @Insert("INSERT INTO member VALUES(#{mem_id}, #{mem_name}, #{mem_age}, #{mem_email}, #{mem_address}, #{mem_password})")
    int insertMemberInfo(@Param("mem_id") int mem_id, @Param("mem_name") String mem_name, @Param("mem_age") int mem_age,  @Param("mem_email") String mem_email, @Param("mem_address") String mem_address, @Param("mem_password") String password);

    @Update("UPDATE member SET mem_email=#{mem_email}, mem_password=#{mem_password} WHERE mem_email=#{mem_email}")
    int updateMemberInfo(@Param("mem_email") String mem_email, @Param("mem_password") String password);

    @Delete("DELETE FROM member WHERE mem_email=#{mem_email}")
    int deleteMemberInfo(@Param("mem_email") String mem_email);
    //mapping한 sql문에 의해서 적용된(또는 영향을 받은) 데이터의 개수를 리턴하기 때문에 반환형이 integer

    //UI에 있는 /api/user/login API 구현해보기
    @Select("SELECT * FROM member WHERE mem_email=#{mem_email} AND mem_password=#{mem_password}")
    MemberInfo getLoginMemberInfo(@Param("mem_email") String mem_email, @Param("mem_password") String mem_password);

    //UI에 있는 /api/user/register API 구현해보기
    @Insert("INSERT INTO member VALUES(#{mem_id}, #{mem_name}, #{mem_age}, #{mem_email}, #{mem_address}, #{mem_password})")
    int getRegisterMemberInfo(@Param("mem_id") int mem_id, @Param("mem_name") String mem_name, @Param("mem_age") int mem_age,  @Param("mem_email") String mem_email, @Param("mem_address") String mem_address, @Param("mem_password") String password);
}
