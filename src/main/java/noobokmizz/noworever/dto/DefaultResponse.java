package noobokmizz.noworever.dto;

import lombok.*;

@Getter
@Setter
public class DefaultResponse {
    protected int status;

    public DefaultResponse(int status) {
        this.status = status;
    }

    @Getter
    @Setter
    public static class ResponseLoginUser extends DefaultResponse {
        private Data data;
        private String msg;

        public ResponseLoginUser(int status, Data data, String msg) {
            super(status);
            this.data = data;
            this.msg = msg;
        }
    }
}
