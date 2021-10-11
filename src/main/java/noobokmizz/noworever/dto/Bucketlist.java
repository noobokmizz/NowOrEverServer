package noobokmizz.noworever.dto;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.List;

@Getter
@Setter
public class Bucketlist {
    private int mem_idnum;
    private int bk_id;

    // ConstructorProperties Annotation : Jackson 으로 파싱한 JSON 속성값을 생성자로 전달
    @ConstructorProperties({"mem_idnum", "bk_id"})
    public Bucketlist(int mem_idnum, int bk_id){
        this.mem_idnum = mem_idnum;
        this.bk_id = bk_id;
    }

    @Getter
    @Setter
    public static class BucketlistSingleConetents extends Bucketlist {
        private BucketlistContents bucketlistContents;

        public BucketlistSingleConetents(int mem_idnum, int bk_id, BucketlistContents bucketlistContents){
            super(mem_idnum, bk_id);
            this.bucketlistContents = bucketlistContents;
        }
    }

    @Getter
    @Setter
    public static class BucketlistMultipleContetns extends Bucketlist {
        private List<BucketlistContents> bucketlistContentsList;

        public BucketlistMultipleContetns(int bk_id, int mem_idnum) {
            super(bk_id, mem_idnum);
        }
    }

    @Getter
    @Setter
    public static class BucketlistContents {
        private String category;
        private String lc_id;

        public BucketlistContents(String category, String lc_id){
            this.category = category;
            this.lc_id = lc_id;
        }
    }
}
