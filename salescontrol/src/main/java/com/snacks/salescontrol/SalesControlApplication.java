package com.snacks.salescontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.snacks.salescontrol" })
public class SalesControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesControlApplication.class, args);
	}

}
