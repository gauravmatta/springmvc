package com.springimplant.cloudfunction;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springimplant.cloudfunction.api.Book;

@SpringBootApplication
public class SpringCloudFunctionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionExampleApplication.class, args);
	}

    @Bean
    Function<String, String> reverse(){
		return (input) -> new StringBuilder(input).reverse().toString();
	}

    @Bean
    Supplier<Book> getBook(){
		return ()->new Book(101,"Core Java");
	}

    @Bean
    Consumer<String> printMsg(){
		return (input)->System.out.println(input);
	}

}
