package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ReviewId implements Serializable {
    private int mem_idnum;
    private String lc_id;
}
