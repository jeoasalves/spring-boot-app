package br.com.jeoas.angularboot.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeoas.angularboot.entity.Cliente;
import br.com.jeoas.angularboot.exception.ServiceException;
import br.com.jeoas.angularboot.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> listarClientes() {
		Collection<Cliente> clientes = clienteService.listarClientes();
		return new ResponseEntity<Collection<Cliente>>(clientes, OK);
	}

	@RequestMapping(method = GET, value = "/clientes/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> consultarCliente(@PathVariable Integer id) {
		log.info("consultando cliente");
		
		try {
			Cliente cliente = clienteService.consultarCliente(id);
			return new ResponseEntity<Cliente>(cliente, OK);
		} catch (ServiceException ex) {
			return new ResponseEntity<>(NOT_FOUND);
		}
	} 

	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		log.info("cadastrando cliente");
		cliente = clienteService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(cliente, OK);
	}

	@RequestMapping(method = DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> remover(@PathVariable Integer id) {
		log.info("removendo cliente");

		try {
			clienteService.removerCliente(id);
			return new ResponseEntity<>(OK);
		} catch (ServiceException ex) {
			return new ResponseEntity<>(NOT_FOUND);
		}
	} 

	@RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
		log.info("atualizando cliente");

		try {
			cliente = clienteService.atualizarCliente(cliente);
			return new ResponseEntity<>(cliente, OK);
		} catch (ServiceException ex) {
			return new ResponseEntity<>(NOT_FOUND);
		}
	}
}
