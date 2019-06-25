package br.com.jeoas.angularboot.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeoas.angularboot.entity.Cliente;
import br.com.jeoas.angularboot.exception.ServiceException;
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

	public Cliente consultar(Integer id) throws ServiceException {
		Optional<Cliente> optional = clienteRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		throw new ServiceException();
	}
	
	
	public void remover(Integer id) throws ServiceException {
		if(clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
		}else {
			throw new ServiceException();
		}
	} 

	public Cliente atualizar(Cliente cliente) throws ServiceException {
		Optional<Cliente> optional = clienteRepository.findById(cliente.getId());
		
		if(optional.isPresent()) {
			Cliente clienteBanco = optional.get();
			clienteBanco.setNome(cliente.getNome());
			clienteBanco = clienteRepository.save(clienteBanco);
		
			return clienteBanco; 
		}
 		
		throw new ServiceException();
	}
}

