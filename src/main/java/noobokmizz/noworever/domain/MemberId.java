package noobokmizz.noworever.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import noobokmizz.noworever.repository.MemberRepository;

import java.io.Serializable;

@Getter
@Setter
public class MemberId implements Serializable {
    private int mem_idnum;
    private String mem_userid;
}