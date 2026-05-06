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

		String cepNormalizado = normalizarCep(cep);

		return repository.findByCep(cepNormalizado)
				.orElseGet(() -> {
					Endereco endereco = cepService.buscaEnderecoPorCep(cepNormalizado);

					if (endereco == null || endereco.getCep() == null) {
						throw new RuntimeException("CEP inválido");
					}

					endereco.setCep(normalizarCep(endereco.getCep()));

					return repository.save(endereco);
				});
	}

	public List<Endereco> listarTodos() {
		return repository.findAll();
	}

	private String normalizarCep(String cep) {
		return cep.replaceAll("[^0-9]", "");
	}
}