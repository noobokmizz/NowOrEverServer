package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationData {
    private String lc_id;
    private String lc_name;

    public LocationData(String lc_id, String lc_name){
        this.lc_id = lc_id;
        this.lc_name = lc_name;
    }
}
