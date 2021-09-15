package noobokmizz.noworever.repository;

import noobokmizz.noworever.domain.Members;


import java.util.List;
import java.util.Optional;

/**
 * 원할한 유지보수와 커뮤니케이션을 위해,
 * Service Class 는 비즈니스에 가까운 용어를 써야함(비즈니스 의존성)
 *                      vs
 * Repository 는 더 개발스러운 용어들을 선택(데이터를 push, pop ...)
 *
 * 각자 역할에 맞게 네이밍 하는것이 중요!!
 */

public interface MemberRepository {
    Members save(Members members);
    Optional<Members> findById(String mem_userid);
    Optional<Members> findByLoginId(String mem_userid, String mem_password);
    List<Members> findAll();
}
