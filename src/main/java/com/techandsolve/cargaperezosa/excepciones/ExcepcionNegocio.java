package com.techandsolve.cargaperezosa.excepciones;

public class ExcepcionNegocio extends ExcepcionAplicacion {
	
	private static final long serialVersionUID = -9042191248221387305L;

	public ExcepcionNegocio(Throwable exception) {
		this(null, exception);
	}
	
	public ExcepcionNegocio(String message){
		this(null,message, null);
	}
	
	public ExcepcionNegocio(String message, Throwable exception){
		this(null, message, exception);
	}
	
	public ExcepcionNegocio(String code, String message, Throwable exception){
		super(code, message, exception);
	}
	
	public ExcepcionNegocio(String code, String message){
		this(code, message,null);
	}
	
}
