package com.rjv;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rjv.dao.SalaireRepository;
import com.rjv.entities.Salaire;

@SpringBootApplication
public class FitatanamBolaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FitatanamBolaApplication.class, args);
		SalaireRepository sr = ctx.getBean(SalaireRepository.class);
		/*for (int i = 1; i < 100; i++) {
			sr.save(new Salaire("Salaire "+i, 77000, new Date()));
			sr.save(new Salaire("Salaire "+i, 60000, new Date()));
			sr.save(new Salaire("Salaire "+i, 20000, new Date()));
			sr.save(new Salaire("Salaire "+i, 9000, new Date()));
		}*/

		sr.findAll().forEach(s -> System.out.println(s.getMontant()));
	}

}
