package noobokmizz.noworever.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
// Entity -> 실제 테이블과 매핑(변경시 다른 여러 클래스에 영향), DTO -> View 와 통신하며 자주 변경
// => Entity 와 DTO 를 분리해주어야 한다
// => 데이터를 전송하기위해 Entity 를 사용해도 되지만,정의된 필드 외에 추가적인 필드가 필요한 경우 DTO 객체를 따로 선언해서 사용
public class Bkcontents {
    @EmbeddedId
    BkcontentsId bkcontentsId;

    public Bkcontents(){}
    public Bkcontents(BkcontentsId bkcontentsId){
        this.bkcontentsId = bkcontentsId;
    }
}
