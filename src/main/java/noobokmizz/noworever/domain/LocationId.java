package noobokmizz.noworever.domain;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

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
