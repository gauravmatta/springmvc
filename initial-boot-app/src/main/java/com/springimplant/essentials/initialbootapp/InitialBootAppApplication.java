package com.springimplant.essentials.initialbootapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.essentials.initialbootapp.entities.Book;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class InitialBootAppApplication {
	
	private List<Book> books = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(InitialBootAppApplication.class, args);
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}
	
	@GetMapping
	public List<Book> getBooks() {
		return books;
	}

	@RestController
	@RequestMapping("/api")
	public class ApiController
	{
		@GetMapping("/greeting")
		public String getGreeting()
		{
			return "Hello World From API";
		}
	}
	
}
