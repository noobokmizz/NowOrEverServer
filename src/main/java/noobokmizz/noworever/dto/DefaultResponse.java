package noobokmizz.noworever.dto;

import lombok.*;

@Getter
@Setter
public class DefaultResponse {
    protected String status;

    public DefaultResponse(String status) {
        this.status = status;
    }

    @Getter
    @Setter
    public static class ResponseLoginUser extends DefaultResponse {
        private Data data;
        private String msg;

        public ResponseLoginUser(String status, Data data, String msg) {
            super(status);
            this.data = data;
            this.msg = msg;
        }
    }
}
