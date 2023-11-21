package com.devsu.cuentamovimientos.response.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class ClientDTO {
    private Long clientId;
    private String password;
    private boolean status;
    private PersonDTO person;
}
