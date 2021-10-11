package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@Entity
// Entity -> 실제 테이블과 매핑(변경시 다른 여러 클래스에 영향), DTO -> View 와 통신하며 자주 변경
// => Entity 와 DTO 를 분리해주어야 한다
// => 데이터를 전송하기위해 Entity 를 사용해도 되지만,정의된 필드 외에 추가적인 필드가 필요한 경우 DTO 객체를 따로 선언해서 사용
@IdClass(BkcontentsId.class)
public class Bkcontents {
    @Id @Column(name = "location_lc_id")
    private String lc_id;
    @Id @Column(name = "category_info_category")
    private String category;
    @Id @Column(name = "members_mem_idnum")
    private int mem_idnum;
    @Id @Column(name = "members_bk_id")
    private int bk_id;
    @Column(name = "members_mem_userid")
    private String mem_userid;
}
