package com.springimplant.SpringHelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class SpringHelloWorldApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(SpringHelloWorldApplication.class, args);
		
		
		System.out.println("Dependency Injection Demo");
		AnimalSpeak as=applicationContext.getBean(AnimalSpeak.class);
		Animal animal=applicationContext.getBean(Animal.class);
		as.setAnimal(animal);
		as.makeAnimalSpeak();
		
		
	}
}
