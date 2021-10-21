package noobokmizz.noworever.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

        @ConstructorProperties({"mem_idnum", "bk_id", "bucketlistContentsList"})
        public BucketlistSingleConetents(int mem_idnum, int bk_id, BucketlistContents bucketlistContents){
            super(mem_idnum, bk_id);
            this.bucketlistContents = bucketlistContents;
        }
    }

    @Getter
    @Setter
    public static class BucketlistMultipleContetns extends Bucketlist {
        private List<BucketlistContents> bucketlistContentsList;

        @ConstructorProperties({"mem_idnum", "bk_id", "bucketlistContentsList"})
        public BucketlistMultipleContetns(int bk_id, int mem_idnum, List<BucketlistContents> bucketlistContentsList) {
            super(bk_id, mem_idnum);
            this.bucketlistContentsList = bucketlistContentsList;
        }

        public BucketlistMultipleContetns(int bk_id, int mem_idnum) {
            super(bk_id, mem_idnum);
        }
    }

    @Getter
    @Setter
    public static class BucketlistContents {
        private int category_id;
        private String lc_id;

        @ConstructorProperties({"category_id", "lc_id"})
        public BucketlistContents(int category_id, String lc_id){
            this.category_id = category_id;
            this.lc_id = lc_id;
        }
    }
}
