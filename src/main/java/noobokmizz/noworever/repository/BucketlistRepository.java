package noobokmizz.noworever.repository;

import noobokmizz.noworever.domain.Bkcontents;

import java.util.List;
import java.util.Optional;

public interface BucketlistRepository {
    Bkcontents save(Bkcontents bkContents);
    List<Bkcontents> findAllByIdAndBkId(int mem_idnum, int bk_id);
}
