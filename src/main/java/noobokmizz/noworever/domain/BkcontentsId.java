package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class BkcontentsId implements Serializable {
    @Column(name = "location_lc_id")
    private String lc_id;
    @Column(name = "category_info_category")
    private String category;
    @Column(name = "members_mem_idnum")
    private int mem_idnum;
    @Column(name = "members_bk_id")
    private int bk_id;
}
