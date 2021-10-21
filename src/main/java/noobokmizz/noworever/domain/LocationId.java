package noobokmizz.noworever.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Embeddable
public class LocationId implements Serializable {
    private String lc_id;
    private int lc_category;

    public LocationId(){}
    public LocationId(String lc_id, int lc_category){
        this.lc_id = lc_id;
        this.lc_category = lc_category;
    }
}
