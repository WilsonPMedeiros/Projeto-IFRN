package com.example.Sistemadegerencimantodeloja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class SistemaDeGerencimantoDeLojaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SistemaDeGerencimantoDeLojaApplication.class, args);
	}


	@PostConstruct
	public void init() {

		TimeZone.setDefault(TimeZone.getTimeZone("America/Fortaleza"));

		System.out.println("Date in UTC: " +  new Date().toString());
	}

}
