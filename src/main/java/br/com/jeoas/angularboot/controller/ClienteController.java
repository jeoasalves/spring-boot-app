package br.com.jeoas.angularboot.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeoas.angularboot.bean.Cliente;
import br.com.jeoas.angularboot.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = GET, value = "/clientes", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> listarClientes() {
		Collection<Cliente> clientes = clienteService.listarClientes();
		return new ResponseEntity<Collection<Cliente>>(clientes, HttpStatus.OK);
	}

	@RequestMapping(method = GET, value = "/cliente/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> consultarCliente(@PathVariable Integer id) {
		log.info("consultando cliente");
		
		try {
			Cliente cliente = clienteService.consultarCliente(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} 

	@RequestMapping(method = POST, value = "/cliente", consumes = APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		log.info("cadastrando cliente");
		cliente = clienteService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@RequestMapping(method = DELETE, value = "/cliente/{id}")
	public ResponseEntity<Cliente> remover(@PathVariable Integer id) {
		log.info("removendo cliente");

		try {
			clienteService.removerCliente(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = PUT, value = "/cliente", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
		log.info("atualizando cliente");

		try {
			cliente = clienteService.atualizarCliente(cliente);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
