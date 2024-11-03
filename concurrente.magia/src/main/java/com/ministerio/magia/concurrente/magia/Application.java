package com.ministerio.magia.concurrente.magia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Sistema de Gestión Mágico en el Ministerio de Magia iniciado.");
	}
}
