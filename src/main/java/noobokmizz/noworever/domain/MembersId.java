package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MembersId implements Serializable {
    private int mem_idnum;
    private String mem_userid;
    private int bk_id;
}