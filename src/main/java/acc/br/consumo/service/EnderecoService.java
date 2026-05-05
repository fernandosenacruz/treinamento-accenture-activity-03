package acc.br.consumo.service;

import acc.br.consumo.interfaces.CepService;
import acc.br.consumo.model.Endereco;
import acc.br.consumo.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

	private final CepService cepService;
	private final EnderecoRepository repository;

	public EnderecoService(CepService cepService, EnderecoRepository repository) {
		this.cepService = cepService;
		this.repository = repository;
	}

	public Endereco buscarESalvar(String cep) {
		Endereco endereco = cepService.buscaEnderecoPorCep(cep);

		if (endereco != null) {
			return repository.save(endereco);
		}

		return null;
	}

	public List<Endereco> listarTodos() {
		return repository.findAll();
	}
}