package com.devsu.cuentamovimientos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReqReporte {
    LocalDateTime startDate;
    LocalDateTime endDate;
    Long clientId;
}
