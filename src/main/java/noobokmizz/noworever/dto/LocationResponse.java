package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;
import noobokmizz.noworever.domain.Location;

@Getter
@Setter
public class LocationResponse {
    private Location location;
    private double rv_starrate;

    public LocationResponse(){}
    public LocationResponse(Location location, double rv_starrate){
        this.location = location;
        this.rv_starrate = rv_starrate;
    }
}
