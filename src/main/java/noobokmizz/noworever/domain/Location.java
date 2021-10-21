package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@Entity
public class Location {
    @EmbeddedId
    private LocationId locationId;
    private String lc_name;
    private String lc_addr;
    private String lc_addr_road;
    private String lc_x;
    private String lc_y;
    private String lc_call_number;
    private String lc_url;
}
