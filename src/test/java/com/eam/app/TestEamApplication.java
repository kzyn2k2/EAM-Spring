package com.eam.app;

import org.springframework.boot.SpringApplication;

public class TestEamApplication {

	public static void main(String[] args) {
		SpringApplication.from(EamApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
