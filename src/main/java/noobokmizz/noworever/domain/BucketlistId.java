package noobokmizz.noworever.domain;

import javax.persistence.Id;
import java.io.Serializable;

public class BucketlistId implements Serializable {
    @Id
    private int bk_id; // 버킷리스트 id
    @Id
    private int mem_idnum;
}
