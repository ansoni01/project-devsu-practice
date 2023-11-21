package com.devsu.cuentamovimientos.util;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.response.RespBase;

public class ParametrosUtil {
    public static <T> RespBase<T> setearResponse(RespBase<T> response, Boolean status, String mensaje) {
        response.getStatus().setSuccess(status);
        response.getStatus().getError().getMessages().add(mensaje);
        return response;
    }

    @SuppressWarnings("unchecked")
    public static String formatearErrorWS(String message) {
        String mensajeError = "";
        try {
            int inicio = message.indexOf(Constants.MARCA_ERROR);
            String cadenaJSON = message.substring(inicio, message.length() - 1);
            RespBase<Object> prueba = JsonUtil.convertirCadenaJsonPostAObjeto(cadenaJSON, RespBase.class);
            mensajeError = prueba.getStatus().getError().getMessages().toString();
        } catch (Exception e) {
            mensajeError = Constants.ERROR_OPERACION;
        }
        return mensajeError;
    }
}
