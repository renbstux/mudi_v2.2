package br.com.renbstux.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renbstux.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.renbstux.mvc.mudi.model.Oferta;
import br.com.renbstux.mvc.mudi.model.Pedido;
import br.com.renbstux.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(RequisicaoNovaOferta requisicao) {
		
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		
		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido);
		pedido.getOferta().add(nova);
		pedidoRepository.save(pedido);
		
		return nova;
	}
	

}
