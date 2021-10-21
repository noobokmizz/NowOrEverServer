package noobokmizz.noworever.repository;

import noobokmizz.noworever.domain.*;
import noobokmizz.noworever.dto.Bucketlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BucketlistRepository {
    Bkcontents save(Bkcontents bkContents);
    List<Bkcontents> findAllByIdAndBkId(int mem_idnum, int bk_id);
    Optional<Bkcontents> findByPK(BkcontentsId bkcontentsid);
    void delete(Bkcontents bkcontents);
    Optional<Location> findByPK(LocationId locationId);
}
