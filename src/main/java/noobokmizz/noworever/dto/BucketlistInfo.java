package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BucketlistInfo {
    private int bk_id;
    private String bk_name;

    public BucketlistInfo(int bk_id, String bk_name){
        this.bk_id = bk_id;
        this.bk_name = bk_name;
    }
}
