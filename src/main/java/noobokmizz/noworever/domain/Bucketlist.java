package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@Entity
@IdClass(BucketlistId.class)
public class Bucketlist {
    @Id
    private int bk_id; // 버킷리스트 id
    private String cs_id; // 버킷리스트 내의 속한 활동의 분류
    private String lc_id; // 버킷리스트 내의 활동의 id
    @Id
    private int mem_idnum; // 해당 버킷리스트를 소유한 회읜의 id
}
