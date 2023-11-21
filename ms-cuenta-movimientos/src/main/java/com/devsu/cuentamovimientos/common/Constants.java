package com.devsu.cuentamovimientos.common;

public class Constants {
    private Constants() {
        super();
    }
    public static final String FORMATO_FECHA_AUDITORIA = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATO_TIMEZONE = "UTC";
    public static final String COD_NO_EXIST_PERSONA = "COD001";
    public static final String COD_NO_EXIST_ACCOUNT = "COD010";
    public static final String COD_NO_SALDO_CERO = "COD09   ";
    public static final String COD_ERROR_SERVICE_CLIENT_PERSON = "COD011";
    public static final String COD_ERROR_SERVICE_CLIENT_PERSON_URI = "COD012";
    public static final String COD_EXIST_IDENTIFICATION = "COD002";
    public static final String COD_EXIST_ACCOUNT_NUMBER = "COD013";
    public static final String COD_EXIST_TYPE_ACCOUNT = "COD013";
    public static final String ENDPOINT_OBTENER_CLIENT_PERSON = "/clients/{id}";
    public static final String MARCA_ERROR = "{\"trace\":";
    public static final String ERROR_OPERACION = "OCURRIO UN ERROR EN LA OPERACION";
}
