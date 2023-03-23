package br.fiap.app.exemplo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.fiap.app.exemplo.models.Categoria;
import br.fiap.app.exemplo.models.Produto;
import br.fiap.app.exemplo.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired //injeção de dependência
	private ProdutoRepository produtoRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/index");
		/*List<Produto> listaProduto = new ArrayList<Produto>();

		Produto produtoUm = new Produto(); 
		produtoUm.setId(new Long(1));
		produtoUm.setNome("Nike Lebrom");
		
		Produto produtoDois = new Produto();
		produtoDois.setId(new Long(2));
		produtoDois.setNome("Nike do Naldo");
		
		listaProduto.add(produtoUm);
		listaProduto.add(produtoDois);*/
		
		List<Produto> listaProduto = produtoRepository.findAll();
		
		model.addObject("produtos", listaProduto);
		return model;
	}
	
	
	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id") Integer idProduto) {
		model.addAttribute("idProduto", idProduto);
		return "produto/edit";
	}
	
	@GetMapping("/create")
	public String create() {		
		return "produto/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("produto") Produto objProduto) {
		//enviar para base de dados
		produtoRepository.save(objProduto);
		
		return "redirect:/produto";
	}
	
	@GetMapping("/categoria")
	@ResponseBody //converte para json
	public Categoria getCategoria() {
		Categoria categoria = new Categoria();
		categoria.setDescricao("Masculino");
		categoria.setId(1);
		
		return categoria;
	}

}
