package br.com.jeoas.angularboot.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeoas.angularboot.entity.Cliente;
import br.com.jeoas.angularboot.exception.ClienteNaoEncontradoException;
import br.com.jeoas.angularboot.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		cliente = clienteRepository.save(cliente);

		return cliente;
	}

	public Collection<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente consultar(Integer id) throws ClienteNaoEncontradoException {
		Optional<Cliente> optional = clienteRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		throw new ClienteNaoEncontradoException(id);
	}

	public List<Cliente> pesquisarClientesAdultos() {
		List<Cliente> clientes = clienteRepository.findMaiorIdade();
		return clientes;
	}

	public void remover(Integer id) throws ClienteNaoEncontradoException {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
		} else {
			throw new ClienteNaoEncontradoException(id);
		}
	}

	public Cliente atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		Optional<Cliente> optional = clienteRepository.findById(cliente.getId());

		if (optional.isPresent()) {
			Cliente clienteBanco = optional.get();
			clienteBanco.setNome(cliente.getNome());
			clienteBanco.setIdade(cliente.getIdade());
			clienteBanco = clienteRepository.save(clienteBanco);

			return clienteBanco;
		}

		throw new ClienteNaoEncontradoException(cliente.getId());
	}
}
