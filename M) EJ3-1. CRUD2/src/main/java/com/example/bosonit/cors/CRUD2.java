package com.example.bosonit.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CRUD2 {

	public static void main(String[] args) {
		SpringApplication.run(CRUD2.class, args);
	}

}
