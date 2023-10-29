package com.sc.surveymarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMongoAuditing
@EnableMongoRepositories
@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SurveyMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyMarketApplication.class, args);
	}

}
