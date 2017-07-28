package com.techandsolve.cargaperezosa.utils;

public enum MensajeErrorEnum {

	ERROR_ARCHIVO_FORMATO_INVALIDO("400"), 
	ERROR_CONVERSION_NUMBER("401"),
	ERROR_DIAS_TRABAJO("402"),
	ERROR_NUMERO_CAJAS("403"),
	ERROR_PESO_CAJAS("404"),
	ERROR_CAJAS_FALTANTES("405"),
	ERROR_DOCUMENTO_INVALIDO("406"),
	;
	private String code;

	private MensajeErrorEnum(String code) {
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
