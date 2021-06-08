package com.kjoshi.learning.ms.mswithkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsWithKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWithKafkaApplication.class, args);
	}

}
