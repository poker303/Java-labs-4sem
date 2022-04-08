package ru.itmo.kotiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.itmo.kotiki.dao", "ru.itmo.kotiki.model", "ru.itmo.kotiki.service", "ru.itmo.kotiki.controller"})
public class WebKotikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebKotikiApplication.class, args);
	}

}
