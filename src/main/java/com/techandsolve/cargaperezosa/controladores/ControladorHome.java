package com.techandsolve.cargaperezosa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorHome {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}