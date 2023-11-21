package com.devsu.cuentamovimientos.advice;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.response.RespBase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ValidationException.class })
	public ResponseEntity<Object> handleValidation(final ValidationException ex, final WebRequest request) {
		RespBase<Object> response = new RespBase<>();
		response.getStatus().setSuccess(Boolean.FALSE);
		response.getStatus().getError().setMessages(ex.getMessages());
		response.getStatus().getError().setCode(ex.getCode());
		response.getStatus().getError().setHttpCode(String.valueOf(ex.getHttpCode()));

		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.resolve(ex.getHttpCode()));
	}

}
