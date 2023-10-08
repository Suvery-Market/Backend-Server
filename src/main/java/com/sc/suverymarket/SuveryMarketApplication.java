package com.sc.suverymarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SuveryMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuveryMarketApplication.class, args);
	}

}
