package com.banregio.next.prueba.app.exception;

import com.banregio.next.base.exception.NextError200;
import com.banregio.next.base.exception.NextError401;
import com.banregio.next.base.exception.NextError403;
import com.banregio.next.base.exception.NextError404;
import com.banregio.next.base.exception.NextError500;
import com.banregio.next.prueba.util.EjemploError;

/**
 * Excepcion de ejemplo, se recomienda extender de uno de las excepciones base, {@link NextError200},
 * {@link NextError401}, {@link NextError403}, {@link NextError404}, {@link NextError500}.
 * Como estandar se deberia crear una clase por cada tipo de excepción.
 * Se recomienda tambien mantener un Enumerador de errores, ejemplo {@link EjemploError}.
 * @author ${user}
 * @since ${date}
 */
public class TestEjemploException extends NextError200{

	private static final long serialVersionUID = 1L;
	
	public TestEjemploException() {
		super(EjemploError.ERROR_DE_EJEMPLO);
	}

}