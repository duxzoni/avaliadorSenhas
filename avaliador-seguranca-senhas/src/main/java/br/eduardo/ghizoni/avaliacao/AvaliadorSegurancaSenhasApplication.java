package br.eduardo.ghizoni.avaliacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AvaliadorSegurancaSenhasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliadorSegurancaSenhasApplication.class, args);
	}
}
