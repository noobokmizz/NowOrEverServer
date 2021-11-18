package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;
import noobokmizz.noworever.dto.Data;
import noobokmizz.noworever.dto.DefaultResponse;

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



    @Getter
    @Setter
    public static class ResponseLocation extends Location {
        private String rv_starrate;

        public ResponseLocation(String rv_starrate) {
            this.rv_starrate = rv_starrate;
        }
    }
}
