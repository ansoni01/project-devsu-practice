package com.devsu.cuentamovimientos.controller;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.request.ReqReporte;
import com.devsu.cuentamovimientos.response.RespReporte;
import com.devsu.cuentamovimientos.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public RespReporte generateReport(@RequestBody ReqReporte reqReporte) throws ValidationException {
        return reportService.generateReport(reqReporte);
    }
}
