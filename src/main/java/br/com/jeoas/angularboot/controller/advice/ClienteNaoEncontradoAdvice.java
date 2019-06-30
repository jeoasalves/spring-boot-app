package br.com.jeoas.angularboot.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.jeoas.angularboot.exception.ClienteNaoEncontradoException;

@ControllerAdvice
public class ClienteNaoEncontradoAdvice {

	@ResponseBody
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String clienteNaoEncontradoHandler(ClienteNaoEncontradoException ex) {
		return ex.getMessage();
	}

}
