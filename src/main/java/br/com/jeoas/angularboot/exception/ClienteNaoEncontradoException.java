package br.com.jeoas.angularboot.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 148221790490989004L;

	public ClienteNaoEncontradoException(Integer id) {
		super("Cliente não foi encontrado. ID: [" + id + "]");
	}
}
