package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;
import noobokmizz.noworever.domain.Location;

@Getter
@Setter
public class LocationResponse {
    private Location location;
    private double rv_starrate;
    private String category;

    public LocationResponse(){}
    public LocationResponse(Location location, double rv_starrate, String category){
        this.location = location;
        this.rv_starrate = rv_starrate;
        this.category = category;
    }
}
