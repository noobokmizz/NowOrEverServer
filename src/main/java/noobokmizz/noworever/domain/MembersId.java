package noobokmizz.noworever.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import noobokmizz.noworever.repository.MemberRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Getter
@Setter
public class MembersId implements Serializable {
    private int mem_idnum;
    private String mem_userid;
    private int bk_id;
}