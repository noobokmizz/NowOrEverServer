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
    @Id
    private int mem_idnum; // 해당 버킷리스트를 소유한 회읜의 id
    private String bk_name;  // 버킷리스트 이름
    private int bk_open_bucketlist;  // 버킷리스트 공개 여부
    private int bk_share;  // 공동 버킷리스트 여부
}
