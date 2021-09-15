package noobokmizz.noworever.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaBucketlistRepository implements BucketlistRepository{
    private final EntityManager em;

    public JpaBucketlistRepository(EntityManager em){
        this.em = em;
    }
}
