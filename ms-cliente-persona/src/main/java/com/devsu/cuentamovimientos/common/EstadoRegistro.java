package com.devsu.cuentamovimientos.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EstadoRegistro {

	ACTIVO("1"), 
	INACTIVO("0");
	private String codigo;

}
