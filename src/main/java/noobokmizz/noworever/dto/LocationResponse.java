package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;
import noobokmizz.noworever.domain.Location;
import noobokmizz.noworever.domain.Recommend_location;

import java.util.List;

@Getter
@Setter
public class LocationResponse {
    private Location location;
    private String rv_starrate;
    private String category;
    private List<Location> recommendList;

    public LocationResponse(){}
    public LocationResponse(Location location, String rv_starrate, String category, List<Location> locationList){
        this.location = location;
        this.rv_starrate = rv_starrate;
        this.category = category;
        this.recommendList = locationList;
    }
}
