package br.com.renbstux.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renbstux.mvc.mudi.interceptor.AccessInterceptor;
import br.com.renbstux.mvc.mudi.interceptor.AccessInterceptor.Acesso;

@RequestMapping("acessos")
@RestController
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return AccessInterceptor.acessos;
	}

}
