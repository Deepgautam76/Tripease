package com.deep.tripease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TripeaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripeaseApplication.class, args);
	}

}

// Transformer ans dto all not completed
// also use builder in transformer
// if you use the builder firstly annotated that class as @Builder
// syntax Customer.builder().(all attribute by . saprat).build()
