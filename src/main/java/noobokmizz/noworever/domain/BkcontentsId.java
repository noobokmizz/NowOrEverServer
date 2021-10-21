package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class BkcontentsId implements Serializable {
    //@Column(name = "location_lc_id")
    private String lc_id;
    //@Column(name = "category_info_category")
    private int category_id;
    //@Column(name = "members_mem_idnum")
    private int mem_idnum;
    //@Column(name = "members_bk_id")
    private int bk_id;

    public BkcontentsId(){
    }
    public BkcontentsId(int mem_idnum, int bk_id, String lc_id, int category_id){
        this.mem_idnum = mem_idnum;
        this.bk_id = bk_id;
        this.lc_id = lc_id;
        this.category_id = category_id;
    }
}
