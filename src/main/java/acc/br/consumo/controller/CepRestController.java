package acc.br.consumo.controller;

import acc.br.consumo.interfaces.CepService;
import acc.br.consumo.model.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepRestController {

	private final CepService cepService;

	public CepRestController(CepService cepService) {
		this.cepService = cepService;
	}

	@GetMapping("/{cep}")
	public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
		Endereco endereco = cepService.buscaEnderecoPorCep(cep);
		return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
	}
}
