package com.devsu.cuentamovimientos.service.Impl;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.feign.client.ClientPersonApiClient;
import com.devsu.cuentamovimientos.model.Movement;
import com.devsu.cuentamovimientos.repository.AccountRepository;
import com.devsu.cuentamovimientos.repository.MovementRepository;
import com.devsu.cuentamovimientos.request.ReqReporte;
import com.devsu.cuentamovimientos.response.RespBase;
import com.devsu.cuentamovimientos.response.RespReporte;
import com.devsu.cuentamovimientos.response.dto.ClientDTO;
import com.devsu.cuentamovimientos.service.MovementService;
import com.devsu.cuentamovimientos.service.ReportService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private MovementService movementService;
    private final ModelMapper modelMapper;
    @Autowired
    private ClientPersonApiClient clientPersonApiClient;

    public ReportServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RespReporte generateReport(ReqReporte reqReporte) throws ValidationException {
        RespReporte oRespReporte = new RespReporte();
        List<Movement> lstMovement =  movementRepository.findByDateAndClientId(reqReporte.getStartDate(), reqReporte.getEndDate(),reqReporte.getClientId());
        oRespReporte.setMovement(lstMovement);
        oRespReporte.setAccount(lstMovement.size() > 0 ? lstMovement.get(0).getAccount() : null);
        if (lstMovement.size() > 0) {
            ClientDTO responseWS = null;
            try {
                responseWS = clientPersonApiClient.getClientPersonById(reqReporte.getClientId());
               /* if (Boolean.FALSE.equals(responseWS.getStatus().getSuccess())) {
                    ValidationException e = new ValidationException(Constants.COD_ERROR_SERVICE_CLIENT_PERSON, 400);
                    e.setMessages(Collections.singletonList("No se encontro datos del cliente"));
                    throw e;
                }*/
            }catch (Exception error) {
                logger.error(error.getMessage());
                ValidationException e = new ValidationException(Constants.COD_ERROR_SERVICE_CLIENT_PERSON_URI, 400);
                e.setMessages(Collections.singletonList(error.getMessage()));
                throw e;
            }
            oRespReporte.setPerson(responseWS);
        }


        return oRespReporte;
    }

}
