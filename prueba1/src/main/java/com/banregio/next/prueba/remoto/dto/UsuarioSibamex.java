package com.banregio.next.prueba.remoto.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de datos para intercambiar datos entre microservicios.
 * @author ${user}
 * @since ${date}
 */
@Getter
@Setter
public class UsuarioSibamex {
	private String numero;
	private String clave;
	private String status;
	private String activo;
	private String eMail;
	private String nombre;
}