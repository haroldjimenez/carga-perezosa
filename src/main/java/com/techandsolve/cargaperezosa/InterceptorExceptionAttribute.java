package com.techandsolve.cargaperezosa;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.techandsolve.cargaperezosa.excepciones.ExcepcionAplicacion;

@ControllerAdvice
public class InterceptorExceptionAttribute extends
		ResponseEntityExceptionHandler {

	// private static final String CODE_EXCEPTION = "code";
	//
	// /**
	// * Metodo que permite agregar el código a la respuesta error
	// *
	// * @return Atributos
	// */
	// @Bean
	// public ErrorAttributes errorAttributes() {
	// return new DefaultErrorAttributes() {
	//
	// @Override
	// public Map<String, Object> getErrorAttributes(
	// RequestAttributes requestAttributes,
	// boolean includeStackTrace) {
	// Map<String, Object> errorAttributes = super.getErrorAttributes(
	// requestAttributes, includeStackTrace);
	// Throwable error = getError(requestAttributes);
	// if (error instanceof ExcepcionAplicacion) {
	// errorAttributes.put(CODE_EXCEPTION, ((ExcepcionAplicacion)
	// error).getCodigo());
	// }
	// return errorAttributes;
	// }
	//
	// };
	// }
	@ExceptionHandler(ExcepcionAplicacion.class)
    public ResponseEntity<String> handleException(ExcepcionAplicacion e) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders)
                .body("Error Message");
    } 
//	@ExceptionHandler(value = { ExcepcionAplicacion.class })
//	protected ResponseEntity<RespuestaError> handleConflict(RuntimeException ex,
//			WebRequest request) {
//		
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE);
//		return handleExceptionInternal(ex, httpHeaders,
//				HttpStatus.INTERNAL_SERVER_ERROR, request);
//	}
//
//	private ResponseEntity<RespuestaError> handleExceptionInternal(RuntimeException ex,
//			HttpHeaders httpHeaders, HttpStatus conflict, WebRequest request) {
//		RespuestaError apiError = new RespuestaError(HttpStatus.BAD_REQUEST,
//				ex.getLocalizedMessage(), ex.getMessage());
//		return new ResponseEntity<RespuestaError>(apiError, httpHeaders,
//				apiError.getStatus());
//	}

}
