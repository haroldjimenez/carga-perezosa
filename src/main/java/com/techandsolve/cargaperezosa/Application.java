package com.techandsolve.cargaperezosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
//@EnableWebMvc





import com.techandsolve.cargaperezosa.utils.AdministadorExcepciones;
import com.techandsolve.cargaperezosa.utils.UtilidadConversion;
import com.techandsolve.cargaperezosa.validaciones.ValidacionCajas;
import com.techandsolve.cargaperezosa.validaciones.ValidacionDiasTrabajo;
import com.techandsolve.cargaperezosa.validaciones.ValidacionPesoCajas;
@SpringBootApplication
@PropertySource("mensajes.properties")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ValidacionDiasTrabajo getValidacionDiasTrabajo(){
		return new ValidacionDiasTrabajo();
	}
	
	@Bean
	public ValidacionCajas getValidacionCajas(){
		return new ValidacionCajas();
	}
	
	@Bean
	public ValidacionPesoCajas getValidacionPesoCajas(){
		return new ValidacionPesoCajas();
	}
	
	@Bean
	public AdministadorExcepciones getAdminExcepciones(){
		return new AdministadorExcepciones();
	}
	
	@Bean
	public UtilidadConversion getUtilidadConversion(){
		return new UtilidadConversion();
	}
	
	
	
}
