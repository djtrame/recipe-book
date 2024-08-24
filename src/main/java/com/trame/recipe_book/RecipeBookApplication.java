package com.trame.recipe_book;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Log
public class RecipeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApplication.class, args);
	}

}
