package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Location_info {
    private int lc_category;
    private List<LocationData> locationData;

    public Location_info(int lc_category){
        this.lc_category = lc_category;
    }
}
