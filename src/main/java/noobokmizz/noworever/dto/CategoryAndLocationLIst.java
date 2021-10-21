package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;
import noobokmizz.noworever.domain.Category_info;

import java.util.List;

@Getter
@Setter
public class CategoryAndLocationLIst {
    private List<Category_info> category_info;
    private List<Location_info> location_info;
}
