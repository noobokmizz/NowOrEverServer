package noobokmizz.noworever.repository;

import noobokmizz.noworever.domain.Bkcontents;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaBucketlistRepository implements BucketlistRepository{
    private final EntityManager em;

    public JpaBucketlistRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Bkcontents save(Bkcontents bkContents) {
        em.persist(bkContents);
        return bkContents;
    }

    @Override
    /**
     * query.getResultList()
     * 결과를 컬렉션으로 반환한다. 결과가 없으면 빈 컬렉션이 반환된다. 1건이면 1건만 들어간 컬렉션이 반환된다.
     *
     * query.getSingleResult()
     * 결과가 정확히 1건 일때 사용한다.
     **/
    public List<Bkcontents> findAllByIdAndBkId(int mem_idnum, int bk_id) {
        return em.createQuery("select b from Bkcontents b where b.mem_idnum = :mem_idnum and b.bk_id = :bk_id", Bkcontents.class)
                .setParameter("mem_idnum", mem_idnum)
                .setParameter("bk_id", bk_id)
                .getResultList();
    }
}