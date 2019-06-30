package br.com.jeoas.angularboot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.jeoas.angularboot.repository.ClienteRepository;


@Component
public class ImprimirClientesScheduler {

    private static final Logger log = LoggerFactory.getLogger(ImprimirClientesScheduler.class);

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Scheduled(cron = "*/10 * * * * *")
    public void executar() { 
        log.warn("Quantidade de clientes menores de idade: [" + clienteRepository.findMenorIdade().size() + "]");
        log.info("Quantidade de clientes adultos: [" + clienteRepository.findMaiorIdade().size() + "]");
    }
}
