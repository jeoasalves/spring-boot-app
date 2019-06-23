package br.com.jeoas.angularboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AngularespringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularespringApplication.class, args);
	}

}
