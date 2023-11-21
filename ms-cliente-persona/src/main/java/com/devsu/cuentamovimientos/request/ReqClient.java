package com.devsu.cuentamovimientos.request;

import com.devsu.cuentamovimientos.request.dto.PersonDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqClient {
    private Long clientId;
    @NotNull(message = "password es requerido")
    private String password;
    @NotNull(message = "status es requerido")
    private boolean status;
    @NotNull(message = "datos de persona es requerido")
    private PersonDTO person;
}
