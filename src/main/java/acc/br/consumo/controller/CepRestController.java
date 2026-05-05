package acc.br.consumo.controller;

import acc.br.consumo.model.Endereco;
import acc.br.consumo.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepRestController {

	private final EnderecoService service;

	public CepRestController(EnderecoService service) {
		this.service = service;
	}

	@GetMapping("/{cep}")
	public ResponseEntity<Endereco> buscar(@PathVariable String cep) {
		Endereco endereco = service.buscarESalvar(cep);
		return endereco != null ? ResponseEntity.ok(endereco)
				: ResponseEntity.notFound().build();
	}
}