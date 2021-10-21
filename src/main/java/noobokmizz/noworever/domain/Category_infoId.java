package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
public class Category_infoId implements Serializable {
    private String category;
    private int category_id;
}
