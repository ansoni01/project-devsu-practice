package com.devsu.cuentamovimientos.model;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.common.EstadoRegistro;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditEntity {

	@Column(nullable = false, name = "ESTADO_REGISTRO")
	protected String estadoRegistro;
	@Column(nullable = false, updatable = false, name = "USUARIO_CREACION")
	protected String usuarioCreacion;

	@Column(nullable = false, updatable = false, name = "FECHA_CREACION")
	@JsonSerialize(using = InstantSerializer.class)
	@JsonFormat(pattern = Constants.FORMATO_FECHA_AUDITORIA, timezone = Constants.FORMATO_TIMEZONE)
	protected Instant fechaCreacion;

	@Column(insertable = false, name = "USUARIO_MODIFICACION")
	protected String usuarioModificacion;
	@Column(insertable = false, name = "FECHA_MODIFICACION")
	protected Instant fechaModificacion;
	
	public void setCampoSegIns(String usuarioCreacion, Instant fechaCreacion){
		this.estadoRegistro = EstadoRegistro.ACTIVO.getCodigo();
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
	}
	public void setCampoSegUpd(String estadoRegistro, String usuarioModificacion, Instant fechaModificacion){
		this.estadoRegistro = estadoRegistro;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
	}
}
