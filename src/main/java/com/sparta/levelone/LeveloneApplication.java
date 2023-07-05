package com.sparta.levelone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class LeveloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeveloneApplication.class, args);
	}

}