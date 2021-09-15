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
    public static class LoginResponse extends DefaultResponse {
        private Data data;
        private String msg;

        public LoginResponse(int status, Optional<Members> members, String msg) {
            super(status);
            Data data = new Data();
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
    }
}
