package com.ving.ecommerce.merchants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MerchantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantsApplication.class, args);
	}

}
