package com.example.BMISpring;


import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmiSpringApplication {

	public static void main(String[] args) {
		Application.launch(BmiApplication.class, args);
	}

}
