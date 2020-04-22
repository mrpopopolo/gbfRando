package fr.pops.gbfRando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "fr.pops.gbfRando.presentation",
	"fr.pops.gbfRando.business.entity",
	"fr.pops.gbfRando.business.service",
	"fr.pops.gbfRando.persistence",
	"fr.pops.gbfRando.configuration" })
@SpringBootApplication
public class GbfRandoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GbfRandoApplication.class, args);
	}

}
