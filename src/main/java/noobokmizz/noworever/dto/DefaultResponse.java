package noobokmizz.noworever.dto;

import lombok.*;
import noobokmizz.noworever.domain.Members;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Getter
@Setter
public class DefaultResponse {
    protected int status;

    public DefaultResponse(int status) {
        this.status = status;
    }

    @Getter
    @Setter
    public static class ResponseLogin extends DefaultResponse {
        private Data data;
        private String msg;

        public ResponseLogin(int status, Data data, String msg) {
            super(status);
            this.data = data;
            this.msg = msg;
        }
    }


    @Getter
    @Setter
    public static class Data {
        private int mem_idnum;
        private String name;
        private String age;
        private String email;
        private String password;

        public Data(int mem_idnum, String name, String age, String email, String password) {
            this.mem_idnum = mem_idnum;
            this.name = name;
            this.age = age;
            this.email = email;
            this.password = password;
        }
    }


}
