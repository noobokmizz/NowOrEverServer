package noobokmizz.noworever.domain;

import javax.persistence.Id;
import java.io.Serializable;

public class LocationId implements Serializable {
    @Id
    private String lc_id;
    @Id
    private String cs_activity;
}
