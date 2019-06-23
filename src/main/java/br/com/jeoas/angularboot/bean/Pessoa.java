package br.com.jeoas.angularboot.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = false)
@AllArgsConstructor
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 2320088904054772081L;
	private String nome;
	private String rg;
	private String cpf;
	private Integer idade;
}
