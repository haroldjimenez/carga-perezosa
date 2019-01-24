package com.techandsolve.cargaperezosa.servicios;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techandsolve.cargaperezosa.entidades.Ejecuciones;
import com.techandsolve.cargaperezosa.repositorios.EjecucionesLog;
import com.techandsolve.cargaperezosa.utils.AdministadorExcepciones;
import com.techandsolve.cargaperezosa.utils.MensajeErrorEnum;

@Service
public class EjecucionesLogService {
	
	@Autowired
	private EjecucionesLog ejecuciones;
	
	@Autowired
	private AdministadorExcepciones excepcion;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void logear(String documento) {
		if(documento == null || documento.isEmpty())
			excepcion.lanzarExcepcion(MensajeErrorEnum.ERROR_DOCUMENTO_INVALIDO);
		Ejecuciones ejecucion = new Ejecuciones();
		ejecucion.setFechaEjecucion(new Date());
		ejecucion.setDocumentoIdentidad(documento);
		try {
			File file = new File("C:\\Users\\harojifa\\Pictures\\Penguins.jpg");
			ejecucion.setImagen(Files.readAllBytes(file.toPath()));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ejecuciones.save(ejecucion);
	}
	
	public List<Ejecuciones> consultar(){
		return ejecuciones.findAll();
	}

}
