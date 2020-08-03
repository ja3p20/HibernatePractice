package com.learning.hibernatetutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HibernateTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateTutorialApplication.class, args);
	}

}
