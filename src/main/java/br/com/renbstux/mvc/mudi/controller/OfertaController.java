package br.com.renbstux.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	
	@GetMapping
	public String getFormularioDeOfertas() {
		return "oferta/home";
	}

}
