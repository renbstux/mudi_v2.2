package br.com.renbstux.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renbstux.mvc.mudi.model.Pedido;
import br.com.renbstux.mvc.mudi.model.StatusPedido;
import br.com.renbstux.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UserController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = repository.findAllByUser(principal.getName());
		model.addAttribute("pedidos", pedidos);
		return "usuario/home"; 
	}
	
	@GetMapping("pedido/{status}")
	public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
		List<Pedido> pedidos = repository.findByStatusUser(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "usuario/home"; 
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}

}
