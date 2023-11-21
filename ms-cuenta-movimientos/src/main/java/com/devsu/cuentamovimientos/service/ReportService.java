package com.devsu.cuentamovimientos.service;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Movement;
import com.devsu.cuentamovimientos.request.ReqMovement;
import com.devsu.cuentamovimientos.request.ReqReporte;
import com.devsu.cuentamovimientos.response.RespReporte;

import java.util.List;

public interface ReportService {
    RespReporte generateReport(ReqReporte reqReporte) throws ValidationException;
}
