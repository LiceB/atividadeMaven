package br.fiap.app.exemplo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fiap.app.exemplo.models.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("cliente/index");
		List<Cliente> listaCliente = new ArrayList<Cliente>();

		Cliente ClienteUm = new Cliente(); 
		ClienteUm.setNome("Alice");
		ClienteUm.setIdade(new Integer(20));
		ClienteUm.setDocumento(new Integer(123));
		
		Cliente ClienteDois = new Cliente();
		ClienteDois.setNome("Ester");
		ClienteDois.setIdade(new Integer(24));
		ClienteDois.setDocumento(new Integer(456));
		
		listaCliente.add(ClienteUm);
		listaCliente.add(ClienteDois);
		
		model.addObject("clientes", listaCliente);
		return model;
	}
}
