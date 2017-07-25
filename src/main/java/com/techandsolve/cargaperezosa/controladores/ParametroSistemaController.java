/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techandsolve.cargaperezosa.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class ParametroSistemaController {

	@RequestMapping(value = "/buscarPorNombre",method=RequestMethod.GET)
	public String buscarPorNombre() {
		return "parametro";
	}
	
	
}
