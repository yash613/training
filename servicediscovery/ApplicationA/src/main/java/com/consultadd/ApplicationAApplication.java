package com.consultadd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApplicationAApplication {

	@GetMapping("/applicationA")
	public  String getMessage(){
		return "Welcome to Application A";
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationAApplication.class, args);
	}

}
