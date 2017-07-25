package com.techandsolve.cargaperezosa;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;

import com.techandsolve.cargaperezosa.excepciones.ExcepcionAplicacion;


@Configuration
public class InterceptorExceptionAttribute {

	private static final String CODE_EXCEPTION = "code";

	/**
	 * Metodo que permite agregar el código a la respuesta error
	 * 
	 * @return Atributos
	 */
	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {

			@Override
			public Map<String, Object> getErrorAttributes(
					RequestAttributes requestAttributes,
					boolean includeStackTrace) {
				Map<String, Object> errorAttributes = super.getErrorAttributes(
						requestAttributes, includeStackTrace);
				Throwable error = getError(requestAttributes);
				if (error instanceof ExcepcionAplicacion) {
					errorAttributes.put(CODE_EXCEPTION,	((ExcepcionAplicacion) error).getCodigo());
				}
				return errorAttributes;
			}

		};
	}

}
