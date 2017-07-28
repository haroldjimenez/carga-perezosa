package com.techandsolve.cargaperezosa.controladores.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techandsolve.cargaperezosa.entidades.Ejecuciones;
import com.techandsolve.cargaperezosa.repositorios.EjecucionesLog;
import com.techandsolve.cargaperezosa.servicios.ProcesarArchivoService;

@RestController
@RequestMapping(value = "/")
public class ProcesarArchivo {
	
	@Autowired
	private EjecucionesLog ejecuciones;
	
	@Autowired
	private ProcesarArchivoService cargarArchivo;
	
	@RequestMapping(value = "/procesar",method=RequestMethod.GET)
	public String procesarArchivo2(){
		Ejecuciones ejecucion= new Ejecuciones();
		ejecucion.setFechaEjecucion(new Date());
		ejecucion.setDocumentoIdentidad("2134567890");
		ejecuciones.save(ejecucion);
		return "Hola mundo";
	}
	
	@RequestMapping(value = "/procesarArchivo",method=RequestMethod.POST,produces="text/plain")
	public String procesarArchivo(@RequestParam("archivo") MultipartFile entity,@RequestParam("nombre") String cosa) throws IOException{

		cargarArchivo.cargarArchivo(entity.getInputStream());

		return "Hola mundo";
	}

}
