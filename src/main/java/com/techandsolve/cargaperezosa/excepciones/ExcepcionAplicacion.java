package com.techandsolve.cargaperezosa.excepciones;

public abstract class ExcepcionAplicacion extends RuntimeException{
	
	private static final long serialVersionUID = -887924735188546958L;

	private String codigo;
	
	public ExcepcionAplicacion(Throwable exception) {
		this(null, exception);
	}
	
	public ExcepcionAplicacion(String message){
		this(message, null);
	}
	
	public ExcepcionAplicacion(String message, Throwable exception){
		this(null, message, exception);
	}
	
	public ExcepcionAplicacion(String code, String message, Throwable exception){
		super(message, exception);
		this.codigo = code;
	}
	
	public String getCodigo() {
		return codigo;
	}
}
