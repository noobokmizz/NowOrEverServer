package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BucketlistCont {
    private int bk_id;
    private int cs_id;
    private int lc_id;

    public BucketlistCont(int bk_id, int cs_id, int lc_id) {
        this.bk_id = bk_id;
        this.cs_id = cs_id;
        this.lc_id = lc_id;
    }
}
