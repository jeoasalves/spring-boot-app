package br.com.jeoas.angularboot.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeoas.angularboot.entity.Cliente;
import br.com.jeoas.angularboot.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Collection<Cliente>> listar() {
		log.info("listando clientes");
		Collection<Cliente> clientes = clienteService.listar();
		return new ResponseEntity<Collection<Cliente>>(clientes, OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> consultar(@PathVariable Integer id) {
		log.info("consultando cliente");

		Cliente cliente = clienteService.consultar(id);
		return new ResponseEntity<Cliente>(cliente, OK);
	}

	@GetMapping(value = "/adultos")
	public ResponseEntity<List<Cliente>> pesquisarClientesAdultos() {
		log.info("pesquisando clientes adultos");

		List<Cliente> clientes = clienteService.pesquisarClientesAdultos();
		return new ResponseEntity<List<Cliente>>(clientes, OK);
	}

	@PostMapping
	private ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		log.info("salvando cliente");
		cliente = clienteService.salvar(cliente);
		return new ResponseEntity<Cliente>(cliente, OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Cliente> remover(@PathVariable Integer id) {
		log.info("removendo cliente");

		clienteService.remover(id);
		return new ResponseEntity<>(OK);
	}

	@PutMapping
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
		log.info("atualizando cliente");

		cliente = clienteService.atualizar(cliente);
		return new ResponseEntity<>(cliente, OK);
	}
}
