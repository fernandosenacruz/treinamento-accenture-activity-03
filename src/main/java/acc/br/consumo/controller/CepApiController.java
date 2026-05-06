package acc.br.consumo.controller;

import acc.br.consumo.model.Endereco;
import acc.br.consumo.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
public class CepApiController {

	private final EnderecoService service;

	public CepApiController(EnderecoService service) {
		this.service = service;
	}

	@GetMapping("/{cep}")
	public ResponseEntity<?> buscar(@PathVariable String cep) {
		try {
			Endereco e = service.buscarESalvar(cep);
			return ResponseEntity.ok(e);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body("CEP inválido");
		}
	}
}
