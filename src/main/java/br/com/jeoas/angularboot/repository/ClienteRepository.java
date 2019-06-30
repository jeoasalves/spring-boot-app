package br.com.jeoas.angularboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jeoas.angularboot.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("select c from Cliente c where c.idade >= 18")
	public List<Cliente> findMaiorIdade();
	
	@Query("select c from Cliente c where c.idade < 18")
	public List<Cliente> findMenorIdade();
	
}
