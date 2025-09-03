package com.dealerautocenter.dealer_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DealerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerManagementApplication.class, args);
	}

}
