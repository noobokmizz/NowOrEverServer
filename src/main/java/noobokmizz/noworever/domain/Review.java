package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@IdClass(ReviewId.class)
public class Review {
    @Id
    private int mem_idnum;
    @Id
    private String lc_id;
    private String rv_comment;
    private int rv_starrate;
    private Timestamp rv_time;
    private String mem_userid;
}
