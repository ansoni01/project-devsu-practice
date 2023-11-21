package com.devsu.cuentamovimientos.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Exception para validaciones
 *
 * @author ttorres
 */
@Getter
@Setter
@SuppressWarnings("serial")
public class ValidationException extends Exception {

    private String code;
    private int httpCode;
    private List<String> messages = new ArrayList<String>();

    public ValidationException() {
        super();
    }

    public ValidationException(String code, int httpCode) {
        super();
        this.code = code;
        this.httpCode = httpCode;
    }

    public ValidationException add(String message) {
        this.messages.add(message);
        return this;
    }

}
