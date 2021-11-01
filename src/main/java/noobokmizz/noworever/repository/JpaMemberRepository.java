package noobokmizz.noworever.repository;

import noobokmizz.noworever.domain.Members;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

//Repository 가 DAO 의 기능 수행?
//JPA 를 사용해서 자바 객체와 테이블을 맵핑
@Repository
public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Members save(Members members) {
        em.persist(members);
        return members;
    }

    @Override
    public Optional<Members> findById(String mem_userid) {
        return Optional.ofNullable(em.createQuery("select m from Members m where m.mem_userid = :mem_userid", Members.class)
                .setParameter("mem_userid", mem_userid)
                .getSingleResult());
    }

    @Override
    public Optional<Members> findByIdAndPW(String mem_userid, String mem_password){
        Members members = em.createQuery("select m from Members m where m.mem_userid = :mem_userid and m.mem_password = :mem_password and m.bk_share = :none", Members.class)
                .setParameter("mem_userid", mem_userid)
                .setParameter("mem_password", mem_password)
                .setParameter("none", 0)
                .getSingleResult();
        return Optional.ofNullable(members);
    }

    @Override
    public List<Members> findAll() {
        return em.createQuery("select m from Members as m", Members.class)
                .getResultList();
    }

    @Override
    public List<Members> findMaxBkId(){
        return em.createQuery("select m from Members m order by m.bk_id DESC", Members.class)
                .getResultList();
    }
}
