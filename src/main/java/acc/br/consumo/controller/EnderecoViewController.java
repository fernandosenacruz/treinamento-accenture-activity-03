package acc.br.consumo.controller;

import acc.br.consumo.service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnderecoViewController {

	private final EnderecoService service;

	public EnderecoViewController(EnderecoService service) {
		this.service = service;
	}

	@GetMapping("/enderecos")
	public String listar(Model model) {
		model.addAttribute("enderecos", service.listarTodos());
		return "enderecos";
	}

	@PostMapping("/buscar-cep")
	public String buscarCep(@RequestParam String cep) {
		service.buscarESalvar(cep);
		return "redirect:/enderecos";
	}
}