package com.devsu.cuentamovimientos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class RespBase<T> {

    private Trace trace;
    private Status status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;

    public RespBase() {
        super();
        trace = new Trace();
        status = new Status();
    }

    public RespBase<T> ok(T payload) {
        RespBase<T> response = new RespBase<>();
        response.setPayload(payload);
        response.getStatus().setSuccess(Boolean.TRUE);
        return response;
    }

    @Getter
    @Setter
    @ToString
    public static class Trace {

        private String traceId;
    }

    @Getter
    @Setter
    @ToString
    public static class Status {

        private Boolean success;
        private Error error;

        public Status() {
            super();
            error = new Error();
        }

        @Getter
        @Setter
        @ToString
        public static class Error {

            private String code;
            private String httpCode;
            private List<String> messages;

            public Error() {
                super();
                messages = new ArrayList<>();
            }
        }
    }
}
