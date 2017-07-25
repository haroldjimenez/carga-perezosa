package com.techandsolve.cargaperezosa.excepciones;

public class ExcepcionTecnica extends ExcepcionAplicacion  {
	
	private static final long serialVersionUID = 5563617251114775027L;

	public ExcepcionTecnica(Throwable exception) {
		this(null, exception);
	}
	
	public ExcepcionTecnica(String message){
		this(message, null);
	}
	
	public ExcepcionTecnica(String message, Throwable exception){
		super(message, exception);
	}
	
	public ExcepcionTecnica(String code, String message, Throwable exception){
		super(code, message, exception);
	}
}
