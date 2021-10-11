package noobokmizz.noworever.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data{
    private int mem_idnum;
    private String name;
    private String age;
    private String email;
    private String password;
    private BucketlistInfo bucketlist;

    public Data(int mem_idnum, String name, String age, String email, String password, int bk_id, String bk_name) {
        this.mem_idnum = mem_idnum;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.bucketlist = new BucketlistInfo(bk_id, bk_name);
    }
}