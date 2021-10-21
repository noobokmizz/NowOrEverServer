package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@IdClass(Category_infoId.class)
public class Category_info {
    @Id
    private String category;
    @Id
    private int category_id;
    private String cl_activity;
    private String cm_activity;
    private String cs_activity;
}
