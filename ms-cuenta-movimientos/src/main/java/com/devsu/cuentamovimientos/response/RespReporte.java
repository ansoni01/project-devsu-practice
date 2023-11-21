package com.devsu.cuentamovimientos.response;

import com.devsu.cuentamovimientos.model.Account;
import com.devsu.cuentamovimientos.model.Movement;
import com.devsu.cuentamovimientos.response.dto.ClientDTO;
import lombok.Data;

import java.util.List;

@Data
public class RespReporte {
     List<Movement> movement;
     Account account;
     ClientDTO person;
}
