package com.techandsolve.cargaperezosa.controladores.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techandsolve.cargaperezosa.servicios.CargaPerezosaService;
import com.techandsolve.cargaperezosa.utils.UtilidadConversion;

@RestController
@RequestMapping(value = "/")
public class CargaPerezosaWeb {
	
	@Autowired
	private CargaPerezosaService cargarArchivo;
	
	@Autowired
	private UtilidadConversion convertirRespuesta;
	
	@RequestMapping(value = "/procesar",method=RequestMethod.GET)
	public String procesarArchivo2(){
		
		return "Hola mundo";
	}
	
	@RequestMapping(value = "/procesarArchivo", method = RequestMethod.POST, produces = "application/octet-stream")
	public byte[] procesarArchivo(
			@RequestParam("archivo") MultipartFile entity,
			@RequestParam("nombre") String documento) throws IOException {
		
		return convertirRespuesta.generarArchivoRespuesta(cargarArchivo
				.calcularNumeroViajes(entity.getInputStream(),documento));
//		ByteArrayResource bis = new ByteArrayResource(d);
		
//
//		HttpHeaders headers= new HttpHeaders();
//		headers.add("Content-Disposition", "attachment; filename=newfile.txt");
//		return ResponseEntity.ok()
//	            .headers(headers)
//	            .contentLength(bis.getByteArray().length)
//	            .contentType(MediaType.parseMediaType("application/octet-stream"))
//	            .body(bis);

	}

}
