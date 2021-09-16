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
}
