package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Recommend_location {
    @Id
    private String lc_id;
    private String recommend1;
    private String recommend2;
    private String recommend3;
}
