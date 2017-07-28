package com.techandsolve.cargaperezosa.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.techandsolve.cargaperezosa.utils.AdministadorExcepciones;
import com.techandsolve.cargaperezosa.utils.MensajeErrorEnum;
import com.techandsolve.cargaperezosa.validaciones.ValidacionCajas;
import com.techandsolve.cargaperezosa.validaciones.ValidacionDiasTrabajo;
@Service
public class CargaPerezosaService {

	private static final Logger LOG = Logger.getLogger(CargaPerezosaService.class);

	@Autowired
	private ValidacionDiasTrabajo validacionDiasTrabajo;

	@Autowired
	private ValidacionCajas validacionNumeroCajas;
	
	@Autowired
	private ValidacionCajas validacionPesoCaja;
	
	@Autowired
	private EjecucionesLogService ejecuciones;
	
	@Autowired
	private AdministadorExcepciones adminExcepcion;

	@Autowired
	private Environment env;

	public Integer[] calcularNumeroViajes(InputStream archivo, String documento) throws IOException {
		ejecuciones.logear(documento);
		String line = null;
		BufferedReader bufferedReader = null;
		Integer[] dias = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(archivo));
			byte numeroCajas = 0;
			Byte[] cajas = null;

			dias = new Integer[obtenerDiasDeTrabajo(obtenerSiguienteLinea(bufferedReader))];
			numeroCajas = obtenerNumeroCajas(obtenerSiguienteLinea(bufferedReader));
			cajas = new Byte[numeroCajas];
			short dia = 0;
			while ((line = bufferedReader.readLine()) != null && dia <= dias.length) {

				if (numeroCajas == 0) {
					calcularMaximoNumeroViaje(dias, cajas, dia);
					numeroCajas = obtenerNumeroCajas(line);
					cajas = new Byte[numeroCajas];
					dia++;
				} else {
					cajas[numeroCajas - 1] = obtenerPesoCaja(line);
					numeroCajas--;
				}
			}
			if (dia <= dias.length) {
				if (numeroCajas != 0) {
					adminExcepcion.lanzarExcepcion(MensajeErrorEnum.ERROR_CAJAS_FALTANTES);
				}
				calcularMaximoNumeroViaje(dias, cajas, dia);
			}
		} catch (NumberFormatException e) {
			adminExcepcion.lanzarExcepcion(MensajeErrorEnum.ERROR_ARCHIVO_FORMATO_INVALIDO,
					line);
		} finally {
			if (bufferedReader != null)
				bufferedReader.close();
		}
		return dias;

	}

	private void calcularMaximoNumeroViaje(Integer[] dias, Byte[] cajas, short dia) {
		Arrays.sort(cajas);
		dias[dia] = calcularNumeroViajes(Arrays.stream(cajas).collect(Collectors.toList()));
	}

	private Short obtenerDiasDeTrabajo(String linea) throws IOException {
		Short dias = Short.valueOf(linea);
		validacionDiasTrabajo.validar(dias);
		return dias;
	}

	private Byte obtenerNumeroCajas(String linea) throws IOException {
		Byte cajas = Byte.valueOf(linea);
		validacionNumeroCajas.validar(cajas);
		return cajas;
	}
	
	private Byte obtenerPesoCaja(String linea) throws IOException {
		Byte cajas = Byte.valueOf(linea);
		validacionPesoCaja.validar(cajas);
		return cajas;
	}

	private String obtenerSiguienteLinea(BufferedReader bufferedReader)
			throws IOException {
		String line;
		if ((line = bufferedReader.readLine()) == null) {
			adminExcepcion.lanzarExcepcion(MensajeErrorEnum.ERROR_ARCHIVO_FORMATO_INVALIDO);
		}
		return line;
	}

	public static int calcularNumeroViajes(List<Byte> cajas) {
		int viajes = 0;
		int numeroCaja = 0;
		int pesoUltimaCaja = 0;
		for (int i = cajas.size() - 1; i > -1; i--) {
			if (pesoUltimaCaja == 0) {
				pesoUltimaCaja = cajas.get(i);
				cajas.remove(i);
			} else {
				cajas.remove(0);
			}
			numeroCaja++;
			if (pesoUltimaCaja * numeroCaja >= 50) {
				viajes++;
				pesoUltimaCaja = 0;
				numeroCaja = 0;
			}
		}
		return viajes;
	}

	

}
