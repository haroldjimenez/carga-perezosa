package com.techandsolve.cargaperezosa.controladores.rest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techandsolve.cargaperezosa.entidades.Ejecuciones;
import com.techandsolve.cargaperezosa.repositorios.EjecucionesLog;

@RestController
@RequestMapping(value = "/")
public class ProcesarArchivo {
	
	@Autowired
	private EjecucionesLog ejecuciones;
	
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

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getInputStream()));
					
		String line;
		while ((line = bufferedReader.readLine()) != null)
		{
		  System.out.println(line);  
		}

		return "Hola mundo";
	}

}
