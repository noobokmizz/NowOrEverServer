package noobokmizz.noworever.repository;

import noobokmizz.noworever.domain.*;
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
        return em.createQuery("select b from Bkcontents b where b.bkcontentsId.mem_idnum = :mem_idnum and b.bkcontentsId.bk_id = :bk_id", Bkcontents.class)
                .setParameter("mem_idnum", mem_idnum)
                .setParameter("bk_id", bk_id)
                .getResultList();
    }

    @Override
    public Optional<Bkcontents> findByPK(BkcontentsId bkcontentsId){
        return Optional.ofNullable(em.find(Bkcontents.class, bkcontentsId));
    }

    @Override
    public void delete(Bkcontents bkcontents) {
        em.remove(bkcontents);
    }

    @Override
    public Optional<Location> findByPK(LocationId locationId) {
        return Optional.ofNullable(em.find(Location.class, locationId));
    }

    @Override
    public List<Category_info> findAllCategory() {
        return em.createQuery("select c from Category_info as c ", Category_info.class)
                .getResultList();
    }

    @Override
    public List<Location> findByLc_category(int lc_category) {
        return em.createQuery("select l from Location l where l.locationId.lc_category = :lc_category and l.locationId.lc_id not like '-%'", Location.class)
                .setParameter("lc_category", lc_category)
                .getResultList();
    }

    @Override
    public Optional<Category_info> findByPK(Category_infoId category_infoId) {
        return Optional.ofNullable(em.find(Category_info.class, category_infoId));
    }

    @Override
    // 특정 장소의 리뷰 목록 반환
    public List<Review> findByLcId(String lc_id) {
        return em.createQuery("select r from Review r where r.lc_id = :lc_id", Review.class)
                .setParameter("lc_id", lc_id)
                .getResultList();
    }

}